package com.example.logbook2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Console;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    EditText edtName;
    Button btnLogin;

    TextInputEditText edtPassword;

    CheckBox cbSaveAccount;

    final String SHARE_PRE_NAME = "account";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        refView();
        sharedPreferences = getSharedPreferences(SHARE_PRE_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if(!username.isEmpty() && !password.isEmpty()){
                    if(cbSaveAccount.isChecked()){
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.commit();
                    }
//                    Log.d(TAG, password);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void refView() {
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);

        cbSaveAccount = findViewById(R.id.cbSaveAccount);
    }
}