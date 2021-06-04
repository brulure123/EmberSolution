package com.zedlab.embersolutionofficial.Controllers.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zedlab.embersolutionofficial.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignFragment extends Fragment {

    private View fragment_sign;
    private Button mLoginBtn;
    private Button mSignUpBtn;


    public SignFragment() {
        // Required empty public constructor
    }

    public static SignFragment newInstance() {
        return new SignFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment_sign = inflater.inflate(R.layout.fragment_sign, container, false);
        initComponent();
        return fragment_sign;
    }

    private void initComponent() {
        mLoginBtn = fragment_sign.findViewById(R.id.fragment_sign_connecting_btn);
        mSignUpBtn = fragment_sign.findViewById(R.id.fragment_sign_signup_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(fragment_sign).navigate(R.id.action_signFragment_to_loginFragment);
            }
        });
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(fragment_sign).navigate(R.id.action_signFragment_to_signUpFragment);
            }
        });
    }
}