package de.tudresden.inf.rn.mobilis.commons.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import de.tudresden.inf.rn.mobilis.media.R;

public class CommandListAdapter extends BaseAdapter {

	private static class ViewHolder {
		public ImageView icon;
		public TextView text1;
	}
	
	public List<Command> backingList = new ArrayList<Command>();
	private Context context;
	
	public CommandListAdapter(Context c) {
		this.context = c;
	}
	
	public void addCommand(Command c) {
		this.backingList.add(c);
	}
	
	public int getCount() {
		return this.backingList.size();
	}

	public Command getItem(int position) {
		return this.backingList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View target, ViewGroup parent) {
		ViewHolder holder;
		if (target == null) {
			target = View.inflate(this.context, R.layout.list_command, null);
			holder = new ViewHolder();
			holder.icon  = (ImageView) ((ViewGroup)target).findViewById(android.R.id.icon);
			holder.text1 = (TextView)  ((ViewGroup)target).findViewById(android.R.id.text1);
			target.setTag(holder);
		} else
			holder = (ViewHolder)target.getTag();
		Command   c = this.getItem(position);
		Resources r = this.context.getResources(); 
		holder.icon.setImageDrawable( r.getDrawable(c.getIconRessource()) );
		holder.text1.setText( r.getString(c.getNameRessource()) );
		return target;
	}

}
