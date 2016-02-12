import objectdraw.*;
import java.awt.*;

/**
 * Molly Boyle
 * Sara Gong
 * Marina Kent
 * Ali Smith
 */

public class Bubbles extends ActiveObject {
	private VisibleImage bubble;
	private RandomDoubleGenerator bubbleSizeG;
	private RandomDoubleGenerator bubblexG;
	private DrawingCanvas canvas;
	private double bubbleSize;
	private double bubbleX;

	public Bubbles(Image a, DrawingCanvas c) {
		canvas = c;
		bubbleSizeG = new RandomDoubleGenerator(10, 30);
		bubblexG = new RandomDoubleGenerator(0, canvas.getWidth());
		bubbleSize = bubbleSizeG.nextValue();
		bubbleX = bubblexG.nextValue();
		bubble = new VisibleImage(a, bubbleX, canvas.getHeight(), bubbleSize,
				bubbleSize, canvas);

		start();
	}

	public void run() {
		while (bubble.getY() + bubble.getHeight() > 0) {
			bubble.move(0, -1);
			pause(30);
		}
	}
}
