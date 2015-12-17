/**
 * 
 */
package de.tudresden.inf.rn.mobilis.magnetizer.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import de.tudresden.inf.rn.mobilis.magnetizer.Const;
import de.tudresden.inf.rn.mobilis.mxa.ConstMXA;
import de.tudresden.inf.rn.mobilis.mxa.ConstMXA.RosterItems;

/**
 * The view to show the roster entries. Doesn't bind to the service, as
 * FriendsList is accessed by a ContentProvider.
 * 
 * TODO check if the roster is stale or has already been updated by the service.
 * 
 * @author koren
 * 
 */
public class FriendsList extends ListActivity {

	Cursor mFriendsCursor;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get a cursor with all roster entries
		mFriendsCursor = getContentResolver().query(RosterItems.CONTENT_URI,
				null, null, null, RosterItems.DEFAULT_SORT_ORDER);
		startManagingCursor(mFriendsCursor);

		ListAdapter adapter = new SimpleCursorAdapter(this,
		// Use a template that displays a text view
				android.R.layout.simple_list_item_2,
				// Give the cursor to the list adapter
				mFriendsCursor,
				// Map the NAME column in the roster database to...
				new String[] { RosterItems.NAME, RosterItems.PRESENCE_MODE },
				// The "text1" view defined in the XML template
				new int[] { android.R.id.text1, android.R.id.text2 });
		setListAdapter(adapter);
	}

	// ==========================================================
	// Interface methods
	// ==========================================================

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mFriendsCursor.moveToPosition(position);
		String selectedId = mFriendsCursor.getString(mFriendsCursor
				.getColumnIndex(ConstMXA.RosterItems.XMPP_ID));
		Intent i = new Intent();
		i.putExtra(Const.SELECTED_XMPPID, selectedId);

		// check if the calling activity is waiting for a result (that is when
		// the activity was called by startActivityForResult())
		if (getCallingPackage() != null) {
			// return XMPP ID to calling activity
			setResult(RESULT_OK, i);
			finish();
		} else {
			// start activity for conversation
			i.setClass(FriendsList.this, ChatScreen.class);
			i.putExtra(Const.SELECTED_XMPPID, selectedId);
			startActivity(i);
		}
	}
}
