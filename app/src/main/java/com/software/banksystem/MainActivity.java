package com.software.banksystem;

import static com.software.banksystem.Const.MAIN_URL;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.software.banksystem.databinding.ActivityMainBinding;
/**
 * @fileName MainActivity.java
 * @version v1.0
 * @author 김성민
 * @projectName BankSystem
 * @description
 *  이 클래스는 은행 시스템 앱의 메인 액티비티를 나타냅니다.
 *  다양한 은행 거래를 수행할 수 있는 메인 화면을 관리합니다.
 *
 *  주요 기능은 사용자의 잔액을 표시하고, 새로운 계좌를 만들거나 돈을 투자하거나 계좌에 돈을 추가하거나
 *  자금을 인출할 수 있는 옵션을 제공하는 것입니다.
 *
 *  @see BaseActivity
 *  기반 액티비티로부터 상속받아 화면 레이아웃을 설정하고, 필요한 초기화 작업을 수행합니다.
 *
 *  @note
 *  - 데이터 바인딩을 사용하여 레이아웃과의 바인딩을 처리합니다.
 *  - 사용자 정보와 거래 내역을 표시하고, 각종 거래 화면으로 이동하는 기능을 제공합니다.
 *  - 서버로부터 잔액 정보를 받아와 화면에 표시합니다.
 *  - 사용자의 거래 내역 및 잔액 정보는 API를 통해 관리합니다.
 */

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