package com.aaronjeromemiller.actionbar.Login;

import android.content.Context;
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

import com.aaronjeromemiller.actionbar.R;
import com.aaronjeromemiller.actionbar.Utils.FirebaseMethods;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by aaronmiller on 7/28/17.
 */

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseMethods mFirebaseMethods;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private String email, password, fullName, username;
    private Context mContext;
    private ProgressBar mProgressBar;
    private TextView mPleaseWait;
    private EditText mEmail, mPassword, mFullName, mUsername;
    private Button btnRegister;

    private String append = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = RegisterActivity.this;
        mFirebaseMethods = new FirebaseMethods(mContext);
        Log.d(TAG, "onCreate: started");

        setupFirebaseAuth();
        initWidgets();
        init();
    }

    private void init() {
        //initialize the button
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Attempting to login");

                email = mEmail.getText().toString();
                password = mPassword.getText().toString();
                fullName = mFullName.getText().toString();

                if(checkInputs(email, password, fullName)){
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPleaseWait.setVisibility(View.VISIBLE);

                    mFirebaseMethods.registerEmail(email, password, fullName);
                }

            }
        });
    }


    private void initWidgets(){
        Log.d(TAG, "initWidgets: attempting initialization of widgits");
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mPleaseWait = (TextView) findViewById(R.id.login_loading_text);
        mEmail = (EditText) findViewById(R.id.input_email_signup);
        mFullName = (EditText) findViewById(R.id.name_signup);
        mUsername = (EditText) findViewById(R.id.username_signup);
        mPassword = (EditText) findViewById(R.id.input_password_signup);
        btnRegister = (Button) findViewById(R.id.btn_register);

        username = mUsername.getText().toString();
        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);
        mContext = RegisterActivity.this;
    }

    private boolean checkInputs(String email, String password, String fullName){
        Log.d(TAG, "checkInptus: checking inputs or null value");
        if(email.equals("")||password.equals("")||fullName.equals("")){
            Toast.makeText(mContext, "All fields must be filled out.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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


    //setup firebase authentication
    private void setupFirebaseAuth() {
        Log.d(TAG, "setupFireBaseAuth: setting up firebase auth");
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                //check if user logged in
                //checkCurrentUser(user);
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                    mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        //success
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //1st check: Make sure the username is not already in use
                            if(mFirebaseMethods.doesUsernameExist(username, dataSnapshot)){
                                //Change this and tell them to choose a different username
                                append = mDatabaseReference.push().getKey().substring(0, 23);
                                Log.d(TAG, "onDataChange: username already exists. Appending random string to name" + append);
                            }
                            username = username + append;
                            //add new "user" to the database

                            //add new "user_account" setting to the database

                        }
                        //error
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
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
