package com.zedlab.embersolutionofficial.Controllers.Helper;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class FirebaseUtils {
    private static FirebaseAuth mAuth;

    public static FirebaseUser checkIfUserAuthState() {
        mAuth = FirebaseAuth.getInstance();
        return mAuth.getCurrentUser();
    }

}