package com.codingblocks.chatter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

import timber.log.Timber;


public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Timber.d("SettingsFragment onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(view);
        Timber.d("SettingsFragment view bound with ButterKnife");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Timber.d("SettingsFragment onDestroyView");
    }
}
