package com.software.banksystem;

import static com.software.banksystem.Const.MAIN_URL;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.software.banksystem.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private String money;
    private Customer customerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        customerData = getIntent().getParcelableExtra("customer");
        callLeftMoneyApi(customerData);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    private void initListener() {
        binding.clMakeAccount.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AccountMakingActivity.class);
            startActivity(intent);
        });

        binding.clInvestMoney.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InvestActivity.class);
            startActivity(intent);
        });

        binding.clAddMoney.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WithdrawActivity.class);
            startActivity(intent);
        });

        binding.clWithdraw.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WithdrawActivity.class);
            startActivity(intent);
        });
    }

    private String callLeftMoneyApi(Customer customerData) {
        ApiUtil apiUtil = new ApiUtil(MAIN_URL, new ApiUtil.OnResponse() {
            @Override
            public void onFail(String res) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Failure").show();
            }

            @Override
            public void onSuccess(String res) {
                binding.tvMoney.setText();
                binding.tvMoney.setText();
            }
        });
        return apiUtil.requestPost(customerData.toString());
    }
}