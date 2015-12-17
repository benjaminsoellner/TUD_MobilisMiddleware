package de.tudresden.inf.rn.mobilis.media.views;

import android.content.Context;
import android.content.Intent;
import de.tudresden.inf.rn.mobilis.media.ConstMMedia;
import de.tudresden.inf.rn.mobilis.media.R;


public class RepositoryItemReplaceCommand extends RepositoryItemCommand {

	private Context context;

	public RepositoryItemReplaceCommand(String repository, String uid, Context c) {
		super(repository, uid);
		this.context = c;
	}

	public int getIconRessource() {
		return R.drawable.list_upload;
	}

	public int getNameRessource() {
		return R.string.command_replace;
	}

	public void doCommand() {
		Intent i = new Intent(ConstMMedia.intent.SEND);
		i.putExtra(ConstMMedia.intent.extra.STR_REPOSITORY, this.repository);
		i.putExtra(ConstMMedia.intent.extra.STR_REPOSITORYITEM_UID,
				new String[] { this.uid });
		this.context.startActivity(i);
	}
	
}
