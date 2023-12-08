package com.software.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.software.banksystem.databinding.ActivityHelpBinding;
/**
 * @fileName HelpActivity.java
 * @version v1.0
 * @author 김성민
 * @projectName BankSystem
 * @description
 *  이 클래스는 은행 시스템 앱의 도움말 화면 액티비티를 나타냅니다.
 *  사용자에게 문의를 받고 답변하는 기능을 제공하는 것입니다.
 *  주요 기능은 도움말 화면을 표시하고, 사용자에게 앱의 다양한 기능에 대한 설명을 제공하는 것입니다.
 *
 */
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