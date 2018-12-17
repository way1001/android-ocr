package com.rw.zx.androidocr;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class CameraFragmentActivity extends FragmentActivity {
    CameraFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_fragment_layout);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.camera_fragment, fragment = new CameraFragment(), "test");
        transaction.commit();
    }

    public void onClick(View v) {
        fragment.onClick(v);
    }
}
