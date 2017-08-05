package com.aaronjeromemiller.actionbar.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.aaronjeromemiller.actionbar.R;
import com.aaronjeromemiller.actionbar.models.User;
import com.aaronjeromemiller.actionbar.models.UserAccountSettings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by aaronmiller on 7/31/17.
 */

public class FirebaseMethods {

    private static final String TAG = "FirebaseMethods";

    //firsbase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private String userID;

    private Context mContext;

    public FirebaseMethods(Context context) {
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();
        mContext = context;

        if(mAuth.getCurrentUser() != null){
            userID = mAuth.getCurrentUser().getUid();
        }
    }

    public boolean doesUsernameExist(String username, DataSnapshot dataSnapshot){
        Log.d(TAG, "doesUsernameExist: checking if the "+ username +"is in database");

        User user = new User();

        for(DataSnapshot ds: dataSnapshot.child(userID).getChildren()){
            Log.d(TAG, "doesUsernameExist: datasnapshot " + ds);

            user.setUsername(ds.getValue(User.class).getUsername());
            Log.d(TAG, "doesUsernameExist: username " + user.getUsername ());

            if(StringManipulation.expandUsername(user.getUsername()).equals(username));
                Log.d(TAG, "doesUsername exist: found a match");
                return true;
        }

        return false;
    }

    public void registerEmail(final String email, String password, final String username){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(mContext, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else if (task.isSuccessful()){
                            userID = mAuth.getCurrentUser().getUid();
                            Log.d(TAG, "onComplete: AuthState Changed");
                        }

                    }
                });
    }

    public void addNewUser(String email, String username, String foodPreference, String profilePhoto, String description){

        User user = new User(userID, email, 1, username );

        mDatabaseReference.child(mContext.getString(R.string.dbname_users))
                .child(userID)
                .setValue(user);

        UserAccountSettings settings = new UserAccountSettings(
                description,
                username,
                "",
                0,
                "",
                username);

        mDatabaseReference.child(mContext.getString(R.string.dbname_user_account_settings))
                .child(userID)
                .setValue(settings);
    }



}
