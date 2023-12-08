package com.software.banksystem;

import static com.software.banksystem.Const.MAIN_URL;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.software.banksystem.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @fileName MainActivity.java
 * @version v1.0
 * @author 김성민
 * @projectName BankSystem
 * @description
 *  이 클래스는 은행 시스템 앱의 메인 액티비티를 나타냅니다.
 *  다양한 은행 거래를 수행할 수 있는 메인 화면을 관리합니다.
 *
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
            public void onSuccess(String res)  {
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(res);
                    JSONObject jsonObj = (JSONObject) obj;
                    money = (String) jsonObj.get("money");
                    binding.tvMoney.setText(money);
                } catch (ParseException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return apiUtil.requestPost(customerData.toString());
    }
}