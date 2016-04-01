package com.example.xusoku.bledemo.views;

import android.content.Context;
import android.view.MotionEvent;


public abstract class BaseGestureDetector
{
    protected final Context mContext;
    protected boolean mGestureInProgress;

    protected MotionEvent mPrevEvent;
    protected MotionEvent mCurrEvent;

    protected float mCurrFocusX;
    protected float mCurrFocusY;
    protected float mCurrPressure;
    protected float mPrevPressure;
    protected long mTimeDelta;

    /**
     * This value is the threshold ratio between the previous combined pressure
     * and the current combined pressure. When pressure decreases rapidly
     * between events the position values can often be imprecise, as it usually
     * indicates that the user is in the process of lifting a pointer off of the
     * device. This value was tuned experimentally.
     */
    protected static final float PRESSURE_THRESHOLD = 0.67f;

    public BaseGestureDetector(Context context)
    {
        mContext = context;
    }

    /**
     * All gesture detectors need to be called through this method to be able to
     * detect gestures. This method delegates work to handler methods
     * (handleStartProgressEvent, handleInProgressEvent) implemented in
     * extending classes.
     *
     * @param event
     * @return
     */
    public boolean onTouchEvent(MotionEvent event)
    {
        final int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        if (!mGestureInProgress) {
            handleStartProgressEvent(actionCode, event);
        }
        else {
            handleInProgressEvent(actionCode, event);
        }
        return true;
    }

    /**
     * Called when the current event occurred when NO gesture is in progress
     * yet. The handling in this implementation may set the gesture in progress
     * (via mGestureInProgress) or out of progress
     *
     * @param actionCode
     * @param event
     */
    protected abstract void handleStartProgressEvent(int actionCode, MotionEvent event);

    /**
     * Called when the current event occurred when a gesture IS in progress. The
     * handling in this implementation may set the gesture out of progress (via
     * mGestureInProgress).
     *
     * @param actionCode
     * @param event
     */
    protected abstract void handleInProgressEvent(int actionCode, MotionEvent event);


    protected void updateStateByEvent(MotionEvent curr)
    {
        final MotionEvent prev = mCurrEvent;

        // Reset mCurrEvent
        if (mCurrEvent != null) {
            mCurrEvent.recycle();
            mCurrEvent = null;
        }
        mCurrEvent = MotionEvent.obtain(curr);

        // Focus
        final boolean pointerUp = curr.getActionMasked() == MotionEvent.ACTION_UP;
        final int skipIndex = pointerUp ? curr.getActionIndex() : -1;
        final int count = curr.getPointerCount();
        final int div = pointerUp ? count - 1 : count;
        float sumX = 0, sumY = 0;
        for (int i = 0; i < count; i++) {
            if (skipIndex == i) {
                continue;
            }
            sumX += curr.getX(i);
            sumY += curr.getY(i);
        }
        mCurrFocusX = sumX / div;
        mCurrFocusY = sumY / div;

        // Pressure
        mPrevPressure = prev.getPressure(prev.getActionIndex());

        if (prev != null) {
            // Delta time
            mTimeDelta = curr.getEventTime() - prev.getEventTime();

            // Pressure
            mCurrPressure = curr.getPressure(curr.getActionIndex());
        }
    }

    /**
     * Get the X coordinate of the current gesture's focal point.
     * If a gesture is in progress, the focal point is between
     * each of the pointers forming the gesture.
     * <p/>
     * If {@link #isInProgress()} would return false, the result of this
     * function is undefined.
     *
     * @return X coordinate of the focal point in pixels.
     */
    public float getFocusX()
    {
        return mCurrFocusX;
    }

    /**
     * Get the Y coordinate of the current gesture's focal point.
     * If a gesture is in progress, the focal point is between
     * each of the pointers forming the gesture.
     * <p/>
     * If {@link #isInProgress()} would return false, the result of this
     * function is undefined.
     *
     * @return Y coordinate of the focal point in pixels.
     */
    public float getFocusY()
    {
        return mCurrFocusY;
    }

    protected void resetState()
    {
        if (mPrevEvent != null) {
            mPrevEvent.recycle();
            mPrevEvent = null;
        }
        if (mCurrEvent != null) {
            mCurrEvent.recycle();
            mCurrEvent = null;
        }
        mGestureInProgress = false;
    }


    /**
     * Returns {@code true} if a gesture is currently in progress.
     *
     * @return {@code true} if a gesture is currently in progress, {@code false} otherwise.
     */
    public boolean isInProgress()
    {
        return mGestureInProgress;
    }

    /**
     * Return the time difference in milliseconds between the previous accepted
     * GestureDetector event and the current GestureDetector event.
     *
     * @return Time difference since the last move event in milliseconds.
     */
    public long getTimeDelta()
    {
        return mTimeDelta;
    }

    /**
     * Return the event time of the current GestureDetector event being
     * processed.
     *
     * @return Current GestureDetector event time in milliseconds.
     */
    public long getEventTime()
    {
        return mCurrEvent.getEventTime();
    }

}
