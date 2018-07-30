package com.qcloud.textinputlayout_textinputedittext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.Window;

public class SecondActivity extends Activity {

    private CollapsingToolbarLayout mToolbarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        mToolbarLayout = findViewById(R.id.collapsing_toolbar);
        mToolbarLayout.setTitle("实名认证");
        mToolbarLayout.setExpandedTitleColor(Color.WHITE);
        mToolbarLayout.setCollapsedTitleTextColor(Color.RED);
    }

    public static void openActivity(Context context){
        context.startActivity(new Intent(context,SecondActivity.class));
    }
}
