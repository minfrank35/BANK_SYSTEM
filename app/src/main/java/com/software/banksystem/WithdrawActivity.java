package com.software.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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
    private String withDrawMoney;
    private Customer customerData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_with_draw;
    }

    private String callApiWithDraw(Customer customerData, String withDrawMoney) {
        JSONObject reqJson = new JSONObject();
        try {
            reqJson.put("customerData", customerData.toString());
            reqJson.put("withDrawMoney", withDrawMoney);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ApiUtil apiUtil = new ApiUtil(WITHDRAW_URL, new ApiUtil.OnResponse() {
            @Override
            public void onFail(String res) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WithdrawActivity.this);
                builder.setTitle("Failure").show();
            }

            @Override
            public void onSuccess(String res)  {
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(res);
                    JSONObject jsonObj = (JSONObject) obj;
                    if ("0000".equals(jsonObj.optString("rsCode"))) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WithdrawActivity.this);
                        builder.setTitle("이체가 성공하였습니다.").show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WithdrawActivity.this);
                        builder.setTitle("이체가 실패하였습니다.").show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        return apiUtil.requestPost(reqJson.toString());
    }

}