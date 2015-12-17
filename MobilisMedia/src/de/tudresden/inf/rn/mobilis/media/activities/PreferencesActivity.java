package de.tudresden.inf.rn.mobilis.media.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import de.tudresden.inf.rn.mobilis.media.R;

public class PreferencesActivity extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

    	// Load the preferences page layout from an XML resource
    	this.addPreferencesFromResource(R.xml.preferences);
	}
}
