import objectdraw.*;
import java.applet.AudioClip;
import java.awt.*;

/**
 * Molly Boyle
 * Sara Gong
 * Marina Kent
 * Ali Smith
 */

public class OtherFish extends ActiveObject {
	private TheFish ourFish;
	private Image angryFish;
	private DrawingCanvas canvas;
	private double speed;
	private double savedTime, currentTime, actualTime, travel;
	private static final double PAUSETIME = 30;
	private VisibleImage piranha;
	private RandomDoubleGenerator angryFishSize, angryFishPlace;
	private double angryFishWidth, angryFishY;
	private boolean alive;

	public OtherFish(Image a, DrawingCanvas c, TheFish o, double s, double x) {
		angryFish = a;
		canvas = c;
		ourFish = o;
		speed = s;

		angryFishPlace = new RandomDoubleGenerator(0, canvas.getHeight());
		angryFishY = angryFishPlace.nextValue();
		piranha = new VisibleImage(angryFish, x, angryFishY, canvas);
		angryFishSize = new RandomDoubleGenerator(ourFish.getWidth() - 20,
				ourFish.getWidth() + 30);
		angryFishWidth = angryFishSize.nextValue();
		piranha.setSize(angryFishWidth, angryFishWidth / 2);

		start();
	}

	private void moveTo(double x, double y) {
		piranha.moveTo(x, y);
	}

	public void run() {
		while (piranha.getX() <= canvas.getWidth()) {
			savedTime = System.currentTimeMillis();
			pause(PAUSETIME);
			currentTime = System.currentTimeMillis();
			actualTime = currentTime - savedTime;
			travel = (speed / PAUSETIME) * actualTime;
			piranha.move(travel, 0);
			if (ourFish.overlaps(piranha)
					&& ourFish.getWidth() < piranha.getWidth()) {
				ourFish.kill();
				moveTo(canvas.getWidth() + 10, 50);
				pause(PAUSETIME * 20);
				ourFish.reincarnate();
			} else if (ourFish.overlaps(piranha)
					&& ourFish.getWidth() >= piranha.getWidth()) {

				ourFish.grow();
				moveTo(canvas.getWidth() + 10, 50);
			}
		}
		piranha.removeFromCanvas();
	}

}
