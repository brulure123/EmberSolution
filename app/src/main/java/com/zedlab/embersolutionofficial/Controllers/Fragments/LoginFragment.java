package com.zedlab.embersolutionofficial.Controllers.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputLayout;
import com.zedlab.embersolutionofficial.Controllers.Activities.UserScreenActivity;
import com.zedlab.embersolutionofficial.R;

public class LoginFragment extends Fragment {

    private CheckBox mRememberMeChkbx;
    private View fragmentLogin;
    private Button mConnexionBtn;
    private Button mCreateCountBtn;
    private Button mPasswordForgetBtn;
    private TextInputLayout mEmailAddressTxt;
    private TextInputLayout mPasswordTxt;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private final View.OnClickListener onClickConnectionBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(validateEmail()){
                String email = mEmailAddressTxt.getEditText().getText().toString();
                String password = mPasswordTxt.getEditText().getText().toString();

                //Setting authentication to firebase an go to the user screen activity
                if(true){
                    startActivity(new Intent(getContext(), UserScreenActivity.class));
                    requireActivity().finish();
                }
            }
        }
    };

    private final View.OnClickListener navigateToSignUp = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Navigation.findNavController(fragmentLogin).navigate(R.id.action_loginFragment_to_signUpFragment);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentLogin = inflater.inflate(R.layout.fragment_login, container, false);
        initComponent();
        return fragmentLogin;
    }

    public void initComponent(){
        // Hooks
        mEmailAddressTxt = fragmentLogin.findViewById(R.id.fragment_login_email_adresse_txt);
        mPasswordTxt = fragmentLogin.findViewById(R.id.fragment_login_password_txt);
        mPasswordForgetBtn = fragmentLogin.findViewById(R.id.fragment_login_forget_password_btn);
        mConnexionBtn = fragmentLogin.findViewById(R.id.fragment_login_connection_btn);
        mCreateCountBtn = fragmentLogin.findViewById(R.id.fragment_login_create_btn);
        mRememberMeChkbx = fragmentLogin.findViewById(R.id.fragment_login_remember_me_chkbx);

        // Setting Listerners
        mConnexionBtn.setOnClickListener(onClickConnectionBtn);
        mCreateCountBtn.setOnClickListener(navigateToSignUp);
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

}