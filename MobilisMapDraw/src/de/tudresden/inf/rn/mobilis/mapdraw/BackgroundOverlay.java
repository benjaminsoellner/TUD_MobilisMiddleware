package de.tudresden.inf.rn.mobilis.mapdraw;


import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.android.maps.MapView;

import de.tudresden.inf.rn.mobilis.mapdraw.overlaymgr.ManagedOverlay;
import de.tudresden.inf.rn.mobilis.mapdraw.overlaymgr.OverlayManager;

public class BackgroundOverlay extends ManagedOverlay {
	
	private static final String TAG = "BackgroundOverlay";
	
	public BackgroundOverlay(OverlayManager overlayManager, String name, Drawable defaultMarker, int showAtLevel) {
		super(overlayManager, name, defaultMarker, showAtLevel);
		overlayManager.addOverlay(this, false, false);
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
		Log.i(TAG, "draw background");
		canvas.drawRGB(255, 255, 255);
	}

	
}
