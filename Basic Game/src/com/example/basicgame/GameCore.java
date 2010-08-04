package com.example.basicgame;

import android.graphics.Canvas;
import android.graphics.Color;

public class GameCore {

	private int backColor; 
	private int width, height; 
	private long last = 0, timediff; 
	private Ball ball = new Ball(); 
	private Paddle paddle = new Paddle();
	
	public GameCore() {
		backColor = Color.parseColor("black");
	}
	
	public void draw(Canvas canvas) {
		canvas.drawColor(backColor);
		paddle.draw(canvas);
		ball.draw(canvas);
	}
	
	public void step(long now) {
		if(last == 0) last = now;
		timediff = now - last; 
		paddle.step(timediff, width, height);		
		ball.step(timediff, width, height);
		ball.testPaddle(paddle);
		last = now; 
	}

	public void resize(int width, int height) {
		this.width = width;
		this.height = height; 
	}

	public void touch(float x, float y) {
		paddle.touch(x, y);
	}
}
