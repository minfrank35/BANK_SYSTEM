package com.software.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.software.banksystem.databinding.ActivityWithDrawBinding;
/**
 * @fileName WithdrawActivity.java
 * @version v1.0
 * @author 조민수
 * @projectName BankSystem
 * @description
 *  이 클래스는 은행 시스템 앱의 자금 인출 화면 액티비티를 나타냅니다.
 *  사용자가 계좌에서 자금을 인출할 수 있는 화면을 관리합니다.
 *
 *  주요 기능은 사용자에게 자금 인출 옵션을 제공하고, 인출할 금액을 입력받아 처리하는 것입니다.
 *
 */
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