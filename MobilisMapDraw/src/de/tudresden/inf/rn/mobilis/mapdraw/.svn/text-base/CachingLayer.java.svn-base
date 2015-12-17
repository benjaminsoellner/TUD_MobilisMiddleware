package de.tudresden.inf.rn.mobilis.mapdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class CachingLayer extends View {

	private static final String TAG = "CachingLayer";
	private boolean rendersPaths;
	private DrawingObjectsStorage drawingObjects;

	public CachingLayer(Context context) {
		super(context);
		rendersPaths = true;
		drawingObjects = DrawingObjectsStorage.getInstance();
		// view-specific settings for caching into a bitmap
		setWillNotCacheDrawing(false);
		setDrawingCacheEnabled(true);
	}
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		
		if (rendersPaths) {
//			Log.i(TAG, "draw from cache");
			drawingObjects.draw(canvas);
		}
	}

	public boolean isRendersPaths() {
		return rendersPaths;
	}

	public void setRendersPaths(boolean rendersPaths) {
		this.rendersPaths = rendersPaths;
	}
}
