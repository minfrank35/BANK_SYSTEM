package com.software.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.software.banksystem.databinding.ActivityHelpBinding;

public class HelpActivity extends BaseActivity<ActivityHelpBinding> {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_help;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}