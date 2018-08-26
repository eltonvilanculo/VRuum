package com.example.nameless.vruum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class LoginActivity extends AppCompatActivity {
    private FireAuth fireAuth = new FireAuth(this);

    private AppCompatEditText inputEmail;
    private AppCompatEditText inputPass;
    private GoogleSignInOptions gso;

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

   /* private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }*/

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

*/
}