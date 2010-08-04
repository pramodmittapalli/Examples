package com.example.basicgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Paddle extends GameObject {

	private Paint paint; 
	private int color; 
	
	public RectF position; 
	
	public Paddle() {
		paint = new Paint(); 
		color = Color.parseColor("#55FF55FF");
		paint.setColor(color);
		position = new RectF(10, 300, 110, 320);
	}
	
	@Override
	void draw(Canvas canvas) {
		canvas.drawRect(position, paint);
	}

	@Override
	void step(long time, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	public void touch(float x, float y) {
		position.left = x-50; 
		position.right = x+50;
	}

}
