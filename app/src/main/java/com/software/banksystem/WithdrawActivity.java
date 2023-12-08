package com.software.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.software.banksystem.databinding.ActivityWithDrawBinding;

public class WithdrawActivity extends BaseActivity<ActivityWithDrawBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_with_draw;
    }
}