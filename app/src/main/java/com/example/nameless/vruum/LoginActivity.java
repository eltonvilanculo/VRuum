package com.example.nameless.vruum;

import android.content.Intent;
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

    void startActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        if (fireAuth.getFirebaseUser().isAnonymous()){
            startActivity(intent);
        }
        else {
            intent.putExtra("FIRE_USERNAME",fireAuth.getFirebaseUser().getDisplayName());
            intent.putExtra("FIRE_EMAIL",fireAuth.getFirebaseUser().getEmail());
        }
    }

    public void loginBasic(View view) {
        startActivity();
    }

    public void googleLogin(View view) {
    }

    public void facebookLogin(View view) {
    }
}
