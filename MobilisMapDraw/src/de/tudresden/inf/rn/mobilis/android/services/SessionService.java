package de.tudresden.inf.rn.mobilis.android.services;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

public class SessionService implements MobilisAndroidService {

	// own instance
	private static SessionService instance;
	
	private Context context;
	private SharedPreferences preferences;
    private Handler mainThreadHandler;
    private Dialog currentProgressDialog;

	// Mobilis services
	private GroupMemberService mMemberService;
	private ChattingService mChattingService;
	private GroupManagementService mGroupService;
	private CollabEditingService mCollabEditingService;

	private SessionService() {
		mainThreadHandler = new Handler();
		mMemberService = new GroupMemberService();
		mChattingService = new ChattingService();
		mGroupService = new GroupManagementService();
		mCollabEditingService = new CollabEditingService();
	}

	public void initIntentReceiver() {
	    mMemberService.initIntentReceiver();
	    mChattingService.initIntentReceiver();
	    mGroupService.initIntentReceiver();
	    mCollabEditingService.initIntentReceiver();
	}
	
	public void unregisterIntentReceiver() {
	    mMemberService.unregisterIntentReceiver();
	    mChattingService.unregisterIntentReceiver();
	    mGroupService.unregisterIntentReceiver();
	    mCollabEditingService.unregisterIntentReceiver();
	}
	
	/**
     * Get the Singleton Instance of the SessionService.
     * 
     * @return
     */
    public static SessionService getInstance() {
		if (instance == null) {
			instance = new SessionService();
		}
		return instance;
    }
    
	public Context getContext() {
		return context;
	}
	
	public void setContext(Context context) {
		this.context = context;
	}

	public SharedPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(SharedPreferences preferences) {
		this.preferences = preferences;
	}

    public Handler getMainThreadHandler() {
		return mainThreadHandler;
	}

	public Dialog getCurrentProgressDialog() {
		return currentProgressDialog;
	}

	public void setCurrentProgressDialog(Dialog currentProgressDialog) {
		this.currentProgressDialog = currentProgressDialog;
	}
    
	public GroupMemberService getGroupMemberService() {
        return mMemberService;
    }

    public ChattingService getChattingService() {
        return mChattingService;
    }

    public GroupManagementService getGroupManagementService() {
        return mGroupService;
    }
    
    public CollabEditingService getCollabEditingService() {
    	return mCollabEditingService;
    }
}
