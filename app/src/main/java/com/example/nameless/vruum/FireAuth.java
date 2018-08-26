package com.example.nameless.vruum;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by Nameless on 8/26/2018.
 */

public class FireAuth {
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    private Activity activity;

    public FireAuth(Activity activity) {
        this.activity = activity;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }

    public Task<AuthResult> login(final String email, final String password) {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(activity, " Successfull ", Toast.LENGTH_SHORT).show();
                            firebaseUser = firebaseAuth.getCurrentUser();
                            startActivity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    public Task<AuthResult> signIn(final String email, final String password) {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            firebaseUser = firebaseAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    void startActivity() {
        Intent intent = new Intent(activity, MainActivity.class);
        if (firebaseUser.isAnonymous()) {
            activity.startActivity(intent);
        } else {
            intent.putExtra("FIRE_USERNAME", firebaseUser.getDisplayName());
            intent.putExtra("FIRE_EMAIL", firebaseUser.getEmail());
            activity.startActivity(intent);
        }
    }
}
