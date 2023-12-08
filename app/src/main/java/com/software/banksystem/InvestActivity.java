package com.software.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.software.banksystem.databinding.ActivityInvestBinding;

public class InvestActivity extends BaseActivity<ActivityInvestBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_invest;
    }
}