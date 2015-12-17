package de.tudresden.inf.rn.mobilis.media.views;

import android.os.Messenger;
import android.os.RemoteException;
import de.tudresden.inf.rn.mobilis.media.R;
import de.tudresden.inf.rn.mobilis.media.services.IRepositoryService;

public class RepositoryItemDeleteCommand extends RepositoryItemCommand {

	protected IRepositoryService service; 
	protected Messenger resultMessenger;
	protected int resultCode;
	
	public RepositoryItemDeleteCommand(String repository, String uid,
			IRepositoryService service, Messenger resultMessenger, int resultCode) {
		super(repository, uid);
		this.service         = service;
		this.resultMessenger = resultMessenger;
		this.resultCode      = resultCode;
	}
	

	public int getIconRessource() {
		return R.drawable.list_delete;
	}

	public int getNameRessource() {
		return R.string.command_delete;
	}
	

	public void doCommand() {
		try {
			this.service.delete(this.repository, new String[] { this.uid },
					this.resultMessenger, this.resultCode);
		} catch (RemoteException e) { }
	}

}
