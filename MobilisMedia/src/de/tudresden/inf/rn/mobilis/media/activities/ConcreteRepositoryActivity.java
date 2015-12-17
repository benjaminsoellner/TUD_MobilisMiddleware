package de.tudresden.inf.rn.mobilis.media.activities;

import android.content.res.Resources;
import de.tudresden.inf.rn.mobilis.media.R;

public class ConcreteRepositoryActivity extends RepositoryActivity {

	@Override
	protected void registerSubActivities() {
		final Resources r = this.getResources();
		this.registerSubActivity(new RepositoryActivity.SubActivity(
				RepositoryMapActivity.class,
				R.drawable.tab_repository_map_light,
				R.drawable.tab_repository_map_dark,
				r.getString(R.string.repository_map_caption)
			));
		this.registerSubActivity(new RepositoryActivity.SubActivity(
				RepositoryListActivity.class,
				R.drawable.tab_repository_list_light,
				R.drawable.tab_repository_list_dark,
				r.getString(R.string.repository_list_caption)
			));
	}
	
}
