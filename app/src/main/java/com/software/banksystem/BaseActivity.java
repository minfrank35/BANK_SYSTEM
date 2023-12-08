package com.software.banksystem;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
/**
 * @fileName BaseActivity.java
 * @version v1.0
 * @author 김성민
 * @projectName BankSystem
 * @description
 *  이 추상 클래스는 액티비티들의 기본 템플릿을 제공하는 베이스 액티비티입니다.
 *  ViewDataBinding을 사용하여 레이아웃과의 데이터 바인딩을 처리하며, 상속받은 액티비티 클래스들은
 *  이 클래스를 기반으로 화면을 구성하게 됩니다.
 *
 *  @param <T> ViewDataBinding 클래스를 상속받은 제네릭 타입으로, 데이터 바인딩을 위해 사용됩니다.
 *
 *  주요 기능은 액티비티의 레이아웃을 설정하고, 데이터 바인딩을 초기화하는 것입니다.
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    protected T binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutResId());
    }

    @LayoutRes
    protected abstract int getLayoutResId();
}