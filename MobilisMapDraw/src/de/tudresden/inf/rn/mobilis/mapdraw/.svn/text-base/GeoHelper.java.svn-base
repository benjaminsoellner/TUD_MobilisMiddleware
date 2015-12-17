package de.tudresden.inf.rn.mobilis.mapdraw;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Projection;

public class GeoHelper {

	public static ArrayList<GeoPoint> getGeoPoints(List<Point> screenPoints, MapView mapView) {
		ArrayList<GeoPoint> geoPoints = new ArrayList<GeoPoint>();
		Projection projection = mapView.getProjection();
		for (Point p : screenPoints) {
			geoPoints.add(projection.fromPixels(p.x, p.y));
		}
		return geoPoints;
	}
	
	public static ArrayList<Point> getScreenPoints(List<GeoPoint> geoPoints, MapView mapView) {
		ArrayList<Point> screenPoints = new ArrayList<Point>();
		Projection projection = mapView.getProjection();
		for (GeoPoint p : geoPoints) {
			screenPoints.add(projection.toPixels(p, null));
		}
		return screenPoints;
	}
	
}
