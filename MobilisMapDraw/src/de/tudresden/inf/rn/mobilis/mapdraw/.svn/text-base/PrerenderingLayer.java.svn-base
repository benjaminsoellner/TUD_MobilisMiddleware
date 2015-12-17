package de.tudresden.inf.rn.mobilis.mapdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class PrerenderingLayer extends View {

	private static final String TAG = "PrerenderingLayer";
	private Path prerenderedPath;
	private Paint currentPaint;
	
	public PrerenderingLayer(Context context) {
		super(context);
		currentPaint = PaintFactory.getDefaultPaint();
	}

	public Path getPrerenderedPath() {
		return prerenderedPath;
	}

	public void setPrerenderedPath(Path prerenderedPath) {
		this.prerenderedPath = prerenderedPath;
	}

	public Paint getCurrentPaint() {
		return currentPaint;
	}

	public void setCurrentPaint(Paint currentPaint) {
		this.currentPaint = currentPaint;
	}
	
	@Override
	public void draw(Canvas canvas) {

		super.draw(canvas);
		
		// draw the path, which is currently edited
		if (prerenderedPath != null) {
//			Log.i(TAG, "draw prerendered path");
			canvas.drawPath(prerenderedPath, currentPaint);	
		}

	}
	
	public void clear() {
		prerenderedPath = null;
	}
}
