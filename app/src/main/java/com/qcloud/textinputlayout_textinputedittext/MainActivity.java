package com.qcloud.textinputlayout_textinputedittext;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilAccount;
    private TextInputLayout tilPassword;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tilAccount = findViewById(R.id.til_account);
        tilPassword = findViewById(R.id.til_password);
        btn = findViewById(R.id.btn_submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = tilAccount.getEditText().getText().toString();
                String password = tilPassword.getEditText().getText().toString();

                tilAccount.setErrorEnabled(false);
                tilPassword.setErrorEnabled(false);

                if (validateAccount(account) && validatePassword(password)){
                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    SecondActivity.openActivity(MainActivity.this);
                }
            }
        });
    }

    private void showError(TextInputLayout textInputLayout,String error){
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }

    private boolean validateAccount(String account){
        if (account.equals("")){
            showError(tilAccount,"用户名不能为空");
            return false;
        }
        return true;
    }

    private boolean validatePassword(String password){
        if (password.equals("")){
            showError(tilPassword,"密码不能为空");
            return false;
        }

        if (password.length() < 6 || password.length() > 18){
            showError(tilPassword,"密码长度为6-18位");
            return false;
        }
        return true;
    }
}
