package de.tudresden.inf.rn.mobilis.media.core;

import de.tudresden.inf.rn.mobilis.media.services.TransferService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class ApplicationManager {
	
	private static ApplicationManager instance;

	private Context applicationContext;
	private SharedPreferences preferences;
	
	
	public static ApplicationManager getInstance() {
		return ApplicationManager.instance;
	}
	
	private ApplicationManager(Context applicationContext) {
		this.applicationContext = applicationContext;
		this.preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
	}
	
	public static void setApplicationContext(Context c) {
		ApplicationManager.instance = new ApplicationManager(c.getApplicationContext());
	}
	
	public ClassLoader getClassLoader() {
		return this.applicationContext.getClassLoader();
	}
	
	public SharedPreferences getPreferences() {
		return this.preferences;
	}
	
	public void initialize() {
		this.launchServices();
	}
	
	public void launchServices() {
		Context ac = this.applicationContext;
		if (this.preferences.getBoolean("service_autostart", false)) {
			Log.i(ApplicationManager.class.getName(), "Autostarting services...");
			ac.startService(new Intent(ac, TransferService.class));
		} else Log.i(ApplicationManager.class.getName(), "Autostarting services disabled.");
	}	
}
