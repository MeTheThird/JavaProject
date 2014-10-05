package BrickBreaker;

import java.util.ArrayList;

import zen.core.Zen;

public class BrickBreaker {

	public static void main(String[] args) {
		Zen.create(500, 800);

		
		//setup steps
		Paddle p = new Paddle();
		Ball b = new Ball();
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		
		int brickX = 50;
		while (brickX < 500) {
			Brick br = new Brick(brickX, 200);
			bricks.add(br);
			brickX = brickX + 50;
		}

		
		while(true) {
			drawBackground();
			
			// Draw/move paddle and ball
			p.draw();
			b.draw();
			p.move();
			b.move();
			
			// Draw every brick.
			for (Brick br : bricks) {
				br.draw();
			}
			
			if (b.isTouching(p)) {
				b.dy = -b.dy;
			}
			
			
			Zen.buffer(33);
		}
	}

	private static void drawBackground() {
		Zen.setBackground("yellow");
	}

}
