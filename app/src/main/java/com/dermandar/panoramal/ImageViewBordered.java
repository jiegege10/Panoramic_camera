package com.dermandar.panoramal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

public class ImageViewBordered extends ImageView {
	
	private Paint mPaint;
	private int mBorderThickness = 24;
	private boolean mIsDrawBorder = true;

	public ImageViewBordered(Context context) {
		super(context);
		mPaint = new Paint();
		mPaint.setColor(Color.WHITE);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setStrokeWidth(mBorderThickness);
	}
	
	public void setIsDrawBorder(boolean isDrawBorder) {
		mIsDrawBorder = isDrawBorder;
	}
	
	public void setBorderThickness(int borderThickness) {
		mBorderThickness = borderThickness;
		if(mPaint != null) {
			mPaint.setStrokeWidth(mBorderThickness);
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(mIsDrawBorder) {
			//horizontal lines
			canvas.drawLine(0f, 0f, getWidth(), 0f, mPaint);
			canvas.drawLine(0f, getHeight(), getWidth(), getHeight(), mPaint);
			//vertical lines
			canvas.drawLine(0f, 0f, 0f, getHeight(), mPaint);
			canvas.drawLine(getWidth(), 0f, getWidth(), getHeight(), mPaint);
		}
	}
}
