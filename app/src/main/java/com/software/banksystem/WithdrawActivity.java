package com.software.banksystem;

import static com.software.banksystem.Const.MAIN_URL;
import static com.software.banksystem.Const.WITHDRAW_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;

import com.software.banksystem.databinding.ActivityWithDrawBinding;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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