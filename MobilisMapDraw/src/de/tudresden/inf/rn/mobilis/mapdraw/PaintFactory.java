package de.tudresden.inf.rn.mobilis.mapdraw;

import android.graphics.Paint;

public class PaintFactory {

	public static Paint getDefaultPaint() {
		Paint paint = new Paint();
		paint.setARGB(255, 0, 0, 255);
		paint.setStrokeWidth(3);
		paint.setAntiAlias(false);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		return paint;
	}

}
