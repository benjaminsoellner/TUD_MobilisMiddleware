package de.tudresden.inf.rn.mobilis.android;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesClient extends PreferenceActivity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences page layout from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

}
