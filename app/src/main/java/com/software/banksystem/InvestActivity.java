package com.software.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.software.banksystem.databinding.ActivityInvestBinding;
/**
 * @fileName InvestActivity.java
 * @version v1.0
 * @author 김성민
 * @projectName BankSystem
 * @description
 *  이 클래스는 은행 시스템 앱의 투자 화면 액티비티를 나타냅니다.
 *  사용자가 계좌에 자금을 투자할 수 있는 화면을 관리합니다.
 *
 *  주요 기능은 사용자에게 투자 옵션을 제공하고, 투자할 금액을 입력받아 처리하는 것입니다.
 *
 */
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