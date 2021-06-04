package com.zedlab.embersolutionofficial.Controllers.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zedlab.embersolutionofficial.Controllers.Adapters.RatingAdapter;
import com.zedlab.embersolutionofficial.Models.Entity.RatingData;
import com.zedlab.embersolutionofficial.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private static final String IDENTIFIER_ID = "identifier";

    private View fragment_home;
    private RecyclerView featuredRecycler;
    private RatingAdapter ratingAdapter;
    private ImageView mSignLuncher;
    private ImageView mCallLuncher;
    private ImageView mHelpLuncher;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment_home = inflater.inflate(R.layout.fragment_home, container, false);
        initComponent();
        return fragment_home;
    }

    private void initComponent(){
        // Hooks
        featuredRecycler = fragment_home.findViewById(R.id.featured_recycler);
        featuredRecycler();
        mSignLuncher = fragment_home.findViewById(R.id.fragment_home_to_sign);
        mCallLuncher = fragment_home.findViewById(R.id.fragment_home_to_call);
        mHelpLuncher = fragment_home.findViewById(R.id.fragment_home_to_help);

        if(getActivity().toString().equals("com.zedlab.embersolutionofficial.Controllers.Activities.UserScreenActivity")){
            RelativeLayout relative_layout = fragment_home.findViewById(R.id.fragment_home_relative_layout);
            relative_layout.setVisibility(View.GONE);
            LinearLayout linearLayout = fragment_home.findViewById(R.id.call_and_help_button);
            linearLayout.setVisibility(View.GONE);
            LinearLayout userDashboard = fragment_home.findViewById(R.id.fragment_home_user_dashboard);
            userDashboard.setVisibility(View.VISIBLE);
        }

        // Adding Listeners
        mSignLuncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(fragment_home).navigate(R.id.action_homeFragment_to_signFragment);
            }
        });
        mCallLuncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:+243975442523");
                startActivity(new Intent(Intent.ACTION_DIAL, uri));
            }
        });
        mHelpLuncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(fragment_home).navigate(R.id.action_homeFragment_to_helpFragment);
            }
        });
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<RatingData> ratingDataArrayList = new ArrayList<>();
        ratingDataArrayList.add(new RatingData(R.drawable.delivery, (float) 2.5, "Daniel Kieffer", "Pas Vraiment un truck de ouf mais c'est déjà bon"));
        ratingDataArrayList.add(new RatingData(R.drawable.bank, (float) 2.5, "Daniel K", "Pas Vraiment un truck de ouf mais c'est déjà bon"));
        ratingDataArrayList.add(new RatingData(R.drawable.flame, (float) 2.5, "John Doe", "Pas Vraiment un truck de ouf mais c'est déjà bon"));
        ratingDataArrayList.add(new RatingData(R.drawable.delivery, (float) 2.5, "Jane Doe", "Pas Vraiment un truck de ouf mais c'est déjà bon"));

        ratingAdapter = new RatingAdapter(ratingDataArrayList);
        featuredRecycler.setAdapter(ratingAdapter);
    }
}