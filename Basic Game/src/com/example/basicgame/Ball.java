package com.example.basicgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

public class Ball extends GameObject {
	
	private int color; 
	private PointF position, speed; 
	private Paint paint;
	
	public Ball() {
		color = Color.parseColor("white");
		paint = new Paint(); 
		paint.setColor(color);
		position = new PointF(20, 20);
		speed = new PointF(25,38);
	}

	@Override
	void draw(Canvas canvas) {
		canvas.drawCircle(position.x, position.y, 10, paint);
	}

	@Override
	void step(long timediff, int width, int height) {
		position.x += (speed.x * timediff) / 100;  
		position.y += (speed.y * timediff) / 100; 
		
		if (position.x <= 0 || position.x >= width) speed.x = -speed.x; 
		if (position.y <= 0 || position.y >= height) speed.y = -speed.y;
	}
	
	void testPaddle(Paddle paddle) {
		if(position.x >= paddle.position.left &&
		position.x <= paddle.position.right && 
		position.y >= paddle.position.top && 
		position.y <= paddle.position.bottom) {
			speed.y = - Math.abs(speed.y);
		}
	}

}
