package com.example.nameless.vruum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    private FireAuth fireAuth = new FireAuth(this);

    private AppCompatEditText inputEmail;
    private AppCompatEditText inputPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.input_email);
        inputPass = findViewById(R.id.input_password);


    }

    @Override
    protected void onResume() {
        super.onResume();

    }



    public void loginBasic(View view) {
        fireAuth.login(inputEmail.getText().toString(),inputPass.getText().toString());

    }

    public void googleLogin(View view) {
    }

    public void facebookLogin(View view) {
    }
}
