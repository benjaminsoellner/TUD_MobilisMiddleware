package de.tudresden.inf.rn.mobilis.mapdraw;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.google.android.maps.GeoPoint;

public class GeoPath extends DrawingObject {

	private ArrayList<GeoPoint> geoPoints;
	
	public GeoPath(ArrayList<GeoPoint> geoPoints, Paint paint) {
		super(paint);
		this.geoPoints = geoPoints;
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO enable / disable bezier curve rendering in options
		Path path = PathBuilder.getPath(
				GeoHelper.getScreenPoints(geoPoints, DrawingObjectsStorage.getInstance().getMapView()), 
				PathBuilder.PATH_TYPE_LINEAR, 100);
		canvas.drawPath(path, paint);
	}

	public ArrayList<GeoPoint> getGeoPoints() {
		return geoPoints;
	}
}
