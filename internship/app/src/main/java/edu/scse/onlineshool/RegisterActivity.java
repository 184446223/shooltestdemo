package edu.scse.onlineshool;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.sql.Connection;
import java.sql.PreparedStatement;

import edu.scse.onlineshool.ui.dashboard.DBUtils;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private Button resisterbutton;
    private EditText userEditText;
    private EditText passEditText;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        resisterbutton=findViewById(R.id.bt_register_submit);
        userEditText=findViewById(R.id.et_register_username);
        passEditText=findViewById(R.id.et_register_auth_code);
        checkBox=findViewById(R.id.cb_protocol);
        checkBox.setChecked(true);
        findViewById(R.id.ib_navigation_back).setOnClickListener(this);
        findViewById(R.id.bt_register_submit).setOnClickListener(this);
        userEditText.addTextChangedListener(this);
        passEditText.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_navigation_back:
                finish();
                break;
            case R.id.bt_register_submit:
                userRegister();
        }
    }

    private void userRegister(){
        final String username = userEditText.getText().toString().trim();
        final String passwd = passEditText.getText().toString().trim();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
                upload(username,passwd);
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this, MainActivity.class);
                RegisterActivity.this.startActivity(intent);
                RegisterActivity.this.finish();
                Looper.loop();
            }
        }).start();
    }
    private void upload(String username,String passwd){
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn = DBUtils.getConn();
            String sql = "insert into users(username,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,passwd);
            ps.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try{
                conn.close();
                ps.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
    @Override
    public void afterTextChanged(Editable s) {
        String username = userEditText.getText().toString().trim();
        String pwd = passEditText.getText().toString().trim();

        if (!TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(username)&&checkBox.isChecked()) {
            resisterbutton.setBackgroundResource(R.drawable.bg_login_submit);
            resisterbutton.setTextColor(getResources().getColor(R.color.white));
        } else {
            resisterbutton.setBackgroundResource(R.drawable.bg_login_submit_lock);
            resisterbutton.setTextColor(getResources().getColor(R.color.account_lock_font_color));
        }
    }
}