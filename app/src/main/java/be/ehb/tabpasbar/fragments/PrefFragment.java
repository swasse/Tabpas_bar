package be.ehb.tabpasbar.fragments;


import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import be.ehb.tabpasbar.R;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class PrefFragment extends PreferenceFragmentCompat {

    public static PrefFragment newInstance(){
        return new PrefFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
