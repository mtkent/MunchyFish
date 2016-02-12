import objectdraw.*;
import java.applet.AudioClip;
import java.awt.*;

/**
 * Molly Boyle
 * Sara Gong
 * Marina Kent
 * Ali Smith
 */

public class TheFish {

	private Image fishy;
	private VisibleImage fishImage;
	private DrawingCanvas canvas;
	private boolean alive;
	private Location start;
	private int score;
	private static final int GROWTH_RATE_WIDTH = 6;
	private static final int GROWTH_RATE_HEIGHT = 3;

	public TheFish(Image f, Location s, DrawingCanvas c, int width, int height) {
		fishy = f;
		canvas = c;
		start = s;

		fishImage = new VisibleImage(fishy, start, canvas);
		fishImage.setSize(width, height);

	}

	public boolean overlaps(VisibleImage angryFish) {
		return fishImage.overlaps(angryFish);
	}

	public double getWidth() {
		return fishImage.getWidth();
	}

	public void moveTo(double x, double y) {
		fishImage.moveTo(x, y);
	}

	public void kill() {
		fishImage.removeFromCanvas();

	}

	public void reincarnate() {
		score = 0;
		fishImage = new VisibleImage(fishy, start, canvas);
		fishImage.setSize(50, 25);
		fishImage.moveTo(start);
	}

	public void removeFromCanvas() {
		fishImage.removeFromCanvas();
	}

	public TheFish setFish(TheFish fish) {
		return fish;
	}

	public void grow() {
		fishImage.setSize(fishImage.getWidth() + GROWTH_RATE_WIDTH,
				fishImage.getHeight() + GROWTH_RATE_HEIGHT);
		score = score + 5;
	}

	public int getScore() {
		return score;
	}

}
