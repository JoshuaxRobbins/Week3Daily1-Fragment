package com.example.josh.week3daily1.fragments;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.example.josh.week3daily1.R;

public class MyPreferenceFragment extends PreferenceFragmentCompat {
    public static String TAG = MyPreferenceFragment.class.getSimpleName();
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        setPreferencesFromResource(R.xml.preferences, null);
    }
}
