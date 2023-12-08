package com.software.banksystem;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.software.banksystem.databinding.ActivityHelpBinding;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    private String bankPhoneNumber;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_help;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.tvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callGetPhoneNumberApi();
            }
        });
    }

    private String callGetPhoneNumberApi() {
        ApiUtil apiUtil = new ApiUtil(Const.MAIN_URL, new ApiUtil.OnResponse() {
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
                    bankPhoneNumber = (String) jsonObj.get("bankPhoneNumber");
                    Intent dialIntent = new Intent(Intent.ACTION_CALL);
                    dialIntent.setData(Uri.parse(bankPhoneNumber));
                    startActivity(dialIntent);
                } catch (ParseException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return apiUtil.requestPost(null);
    }
}