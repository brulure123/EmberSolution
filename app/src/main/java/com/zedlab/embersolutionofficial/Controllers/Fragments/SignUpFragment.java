package com.zedlab.embersolutionofficial.Controllers.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.zedlab.embersolutionofficial.Controllers.Activities.UserScreenActivity;
import com.zedlab.embersolutionofficial.Models.Entity.User;
import com.zedlab.embersolutionofficial.R;

import java.util.concurrent.TimeUnit;

public class SignUpFragment extends Fragment {

    private View signUpFragment;
    private TextInputLayout mFullNameTxt;
    private TextInputLayout mPhoneNumberTxt;
    private TextInputLayout mEmailAddressTxt;
    private TextInputLayout mPasswordTxt;
    private Button mConnexionBtn;
    private Button mSignUpBtn;
    private String RDCPHONENUMBER;

    private final View.OnClickListener onClickConnexionBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setUser();
        }
    };

    private View.OnClickListener navigateToLoginPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(signUpFragment).navigate(R.id.action_signUpFragment_to_loginFragment);
        }
    };

    private String codeBySystem;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        signUpFragment = inflater.inflate(R.layout.fragment_sign_up, container, false);
        initComponent();
        return signUpFragment;
    }

    private void initComponent() {
        // Hooks
        mFullNameTxt = signUpFragment.findViewById(R.id.fragment_sign_up_fullname_txt);
        mPhoneNumberTxt = signUpFragment.findViewById(R.id.fragment_sign_up_phone_number_txt);
        mEmailAddressTxt = signUpFragment.findViewById(R.id.fragment_sign_up_email_address_txt);
        mPasswordTxt = signUpFragment.findViewById(R.id.fragment_sign_up_password_txt);
        mConnexionBtn = signUpFragment.findViewById(R.id.fragment_sign_up_connection_btn);
        mSignUpBtn = signUpFragment.findViewById(R.id.fragment_sign_up_create_btn);

        // Setting Listeners
        mConnexionBtn.setOnClickListener(onClickConnexionBtn);
        mSignUpBtn.setOnClickListener(navigateToLoginPage);
    }

    /*
Validation functions
 */
    private boolean validateFullName() {
        String val = mFullNameTxt.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            mFullNameTxt.setError("Ce champ ne peut pas être vide.");
            return false;
        } else {
            mFullNameTxt.setError(null);
            mFullNameTxt.setEnabled(false);
            return true;
        }
    }

    private boolean validateEmail(){
        String val = mEmailAddressTxt.getEditText().getText().toString().trim();
        String checkspaces = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            mEmailAddressTxt.setError("Ce champ ne peut pas être vide !");
            return false;
        }
        else if(!val.matches(checkspaces)){
            mEmailAddressTxt.setError("Adresse email invalide !");
            return false;
        }
        else {
            mEmailAddressTxt.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String val = mPasswordTxt.getEditText().getText().toString().trim();
        String checkpassword = "^(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        if (val.isEmpty()) {
            mPasswordTxt.setError("Ce champ ne peut pas être vide !");
            return false;
        }
        else if(!val.matches(checkpassword)){
            mPasswordTxt.setError("Mot de passe Invalide !");
            return false;
        }
        else {
            mPasswordTxt.setError(null);
            return true;
        }
    }

    private boolean validatePhoneNumber(){
        String number = mPhoneNumberTxt.getEditText().getText().toString().trim();
        RDCPHONENUMBER = "+243";
        if(number.isEmpty()){
            mPhoneNumberTxt.setError("Ce champ ne peut pas être vide !");
            return false;
        }else if(number.length() != 10){
            mPhoneNumberTxt.setError("Le numero contient dix lettres");
            return false;
        }else {
            if(number.charAt(0) == '0'){
                for(int i=1; i < number.length(); i++){
                    RDCPHONENUMBER += number.charAt(i);
                }
                mPhoneNumberTxt.setError(null);
                return true;
            }
            else{
                mPhoneNumberTxt.setError("Le numero doit commencer par 0");
                return false;
            }
        }
    }

    private User setUser(){
        if(!validateFullName() | !validateEmail() | !validatePassword() | validatePhoneNumber()){
            return null;
        }

        User user = new User();
        user.setFullName(mFullNameTxt.getEditText().getText().toString().trim());
        user.setEmailAddress(mEmailAddressTxt.getEditText().getText().toString().trim());
        user.setPassword(mPasswordTxt.getEditText().getText().toString().trim());
        user.setPhoneNumber(RDCPHONENUMBER);
        sendVerificationCodeToUser(RDCPHONENUMBER);
        return user;
    }

    private void sendVerificationCodeToUser(String phoneNo){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNo,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallback);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem = s;
                    System.out.println(s);
                    Toast.makeText(getActivity(), "Test Work", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String code = phoneAuthCredential.getSmsCode();
                    Toast.makeText(getActivity(), "Test Work", Toast.LENGTH_SHORT).show();
                    if(code!=null){
                        System.out.println(code);
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(requireActivity(), UserScreenActivity.class));
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                System.out.println("Doesn't work ! ");
                            }
                        }
                    }
                });
    }
}