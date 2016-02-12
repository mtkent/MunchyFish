import objectdraw.*;
import java.awt.*;

/**
 * Molly Boyle
 * Sara Gong
 * Marina Kent
 * Ali Smith
 */

public class Ocean extends ActiveObject {

	private double pausetime;

	private Image angryFishPic, angryFishL, bubble;
	private DrawingCanvas canvas;
	private TheFish theFish;
	private double speed;
	private double size;
	private OtherFish p, pl;
	private Bubbles bubbles;

	public Ocean(Image a, Image b, Image bub, DrawingCanvas c, TheFish f) {
		angryFishPic = a;
		bubble = bub;
		angryFishL = b;
		canvas = c;
		theFish = f;

		start();

	}

	public void run() {
		while (true) {
			p = new OtherFish(angryFishPic, canvas, theFish, 3.0, -2
					* theFish.getWidth());
			pl = new OtherFish(angryFishL, canvas, theFish, -3.0,
					canvas.getWidth());
			bubbles = new Bubbles(bubble, canvas);

			pausetime = 2300 + theFish.getWidth();
			pause(pausetime);

		}

	}

}
