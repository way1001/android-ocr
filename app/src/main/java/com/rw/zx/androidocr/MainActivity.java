package com.rw.zx.androidocr;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_3 = (TextView)findViewById(R.id.setting);

        //获取assets文件夹里的字体文件
        Typeface font = Typeface.createFromAsset(getAssets(), "font/fa-solid-900.ttf");

        //给指定的TextView加载字体
        tv_3.setTypeface(font);
    }
}
