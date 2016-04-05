package com.example.xusoku.bledemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xusoku.bledemo.adpter.base.CommonFragmentAdapter;

/**
 * Created by xusoku on 2016/4/5.
 */
public class aa  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CommonFragmentAdapter aa= new CommonFragmentAdapter(getSupportFragmentManager(), null);
    }
}
