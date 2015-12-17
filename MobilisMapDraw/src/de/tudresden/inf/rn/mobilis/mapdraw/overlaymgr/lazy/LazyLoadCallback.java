package de.tudresden.inf.rn.mobilis.mapdraw.overlaymgr.lazy;

import com.google.android.maps.GeoPoint;

import de.tudresden.inf.rn.mobilis.mapdraw.overlaymgr.ManagedOverlay;
import de.tudresden.inf.rn.mobilis.mapdraw.overlaymgr.ManagedOverlayItem;

import java.util.List;




public interface LazyLoadCallback {

	public List<ManagedOverlayItem> lazyload(GeoPoint topLeft, GeoPoint bottomRight, ManagedOverlay overlay) throws LazyLoadException;

}


