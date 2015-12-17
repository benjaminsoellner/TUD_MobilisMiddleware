package de.tudresden.inf.rn.mobilis.mapdraw;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import android.graphics.Canvas;

import com.google.android.maps.MapView;

/**
 * Singleton class for storing all drawable objects. DrawingOverlay and CachingLayer fetching these from here for rendering.
 * @author Dirk Hering
 */
public class DrawingObjectsStorage {
	
	private static DrawingObjectsStorage instance;
	private Set<DrawingObject> drawnObjects = Collections.synchronizedSet(new HashSet<DrawingObject>());
	private MapView mapView;

	public static DrawingObjectsStorage getInstance() {
		if (instance == null) {
			instance = new DrawingObjectsStorage();
		}
		return instance;
	}

	public void clear() {
		drawnObjects.clear();
	}
	
	public void addDrawingObject(DrawingObject drawingObject) {
		drawnObjects.add(drawingObject);
	}

	public MapView getMapView() {
		return mapView;
	}

	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}
	
	/**
	 * Defers a drawing call to all stored DrawingObjects.
	 * @param canvas the Canvas to draw on
	 */
	public void draw(Canvas canvas) {
		synchronized(drawnObjects) {
			for (DrawingObject d : drawnObjects) {
				d.draw(canvas);
			}
		}
		
		// Measuring Feedthrough
//		Monitoring mon = Monitoring.get();
//		System.out.println("Redraw End - isFromRemote:" + mon.isFromRemote());
//		if (mon.isFromRemote()) mon.endTimer(true);
	}
}
