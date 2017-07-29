package com.aaronjeromemiller.actionbar.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aaronjeromemiller.actionbar.MainActivity;
import com.aaronjeromemiller.actionbar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by aaronmiller on 7/28/17.
 */

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private String email, password, fullName;
    private Context mContext;
    private ProgressBar mProgressBar;
    private TextView mPleaseWait;
    private EditText mEmail, mPassword, mFullName;
    private Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.d(TAG, "onCreate: started");
        initWidgets();
        setupFirebaseAuth();
        init();
    }

    private void initWidgets(){
        Log.d(TAG, "initWidgets: attempting initialization of widgits");
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mPleaseWait = (TextView) findViewById(R.id.loading_please_wait);
        mEmail = (EditText) findViewById(R.id.input_email_signup);
        mFullName = (EditText) findViewById(R.id.name_signup);
        mPassword = (EditText) findViewById(R.id.input_password_signup);
        btnRegister = (Button) findViewById(R.id.btn_register);
        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);
        mContext = RegisterActivity.this;
    }

    private boolean isStringNull(String string) {
        Log.d(TAG, "isStringNull: Checking if string is null");

        if (string.equals("")) {
            return true;
        }
        else {
            Log.d(TAG, "isStringNull: String is null");
            return false;
        }
    }

       /*
********************************** FIREBASE ***********************************
 */
    private void init() {
        //initialize the button
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Attempting to login");

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                Log.d(TAG, "init: "+email);

                if(isStringNull(email) && isStringNull(password)){
                    Toast.makeText(mContext, "You must fill out all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPleaseWait.setVisibility(View.VISIBLE);

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }

            }
        });

        TextView linkSignUp = (TextView) findViewById(R.id.link_singup);
        linkSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG, "linkSignup: register a account clicked");
                Intent intent =  new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //if the user is logged in then go to MainActivity
        if(mAuth.getCurrentUser() != null){
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    //setup firebase authentication
    private void setupFirebaseAuth() {
        Log.d(TAG, "setupFireBaseAuth: setting up firebase auth");
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                //check if user logged in
                //checkCurrentUser(user);
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        //checkCurrentUser(mAuth.getCurrentUser());
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
