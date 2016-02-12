import objectdraw.*;
import java.applet.AudioClip;
import java.awt.*;

/**
 * Molly Boyle
 * Sara Gong
 * Marina Kent
 * Ali Smith
 */
public class SquareFishy extends WindowController {

	private static final double WIDTH = 800;
	private static final double HEIGHT = 600;
	private TheFish theFish;
	private boolean fishAlive, reincarnate, gameOn, visible; 
	private int pauseTime, currentScore, highScore;
	private VisibleImage background, bubble, button, author, yellow, pink,
			green, purple, grey, title;
	private OtherFish angryFish;
	private Location lastMouse, start;
	private Ocean ocean;
	private Image secondsmallestPic, angryFishPic, angryFishL, smallestFishPic,
			fishPic, yellowPic, yellowFishPic, pinkFishPic, pinkPic,
			purpleFishPic, purplePic, greenFishPic, greenPic, greyFishPic,
			greyPic, bubblePic, dopeBubble;
	private Text score;
	private double width;
	private AudioClip bread;
	private AudioClip munch;
	private Bubbles bubbles;

	
	public void begin() {

		Image backgroundPic = getImage("background.png");
		background = new VisibleImage(backgroundPic, 0, 0, canvas);
		Image titlePic = getImage("title.png");
		title = new VisibleImage(titlePic, 0, 0, canvas);
		title.moveTo((canvas.getWidth() - title.getWidth()) / 2, 20);

		dopeBubble = getImage("dopebubble.png");
		bubblePic = getImage("bubble.png");
		bubble = new VisibleImage(bubblePic, 0, 0, 100, 100, canvas);
		bubble.moveTo((canvas.getWidth() - bubble.getWidth()) / 2, 10);
		bubble.sendBackward();

		smallestFishPic = getImage("smallestfish.png");
		angryFishPic = getImage("angryfishright.png");
		angryFishL = getImage("angryfishleft.png");
		secondsmallestPic = getImage("secondsmallestfish.png");
		Image startButtonPic = getImage("start.png");

		button = new VisibleImage(startButtonPic, 0, 0, canvas);
		button.moveTo((canvas.getWidth() - button.getWidth()) / 2,
				((canvas.getHeight() - button.getHeight()) / 2) - 40);

		Image authorPic = getImage("author.png");

		author = new VisibleImage(authorPic, 0, 0, 150, 150, canvas);
		author.moveTo(0, canvas.getHeight() - author.getHeight());

		yellowPic = getImage("yellow.png");
		yellowFishPic = getImage("biggestfish.png");
		yellow = new VisibleImage(yellowPic, 0, 0, 100, 100, canvas);
		yellow.moveTo((canvas.getWidth() - yellow.getWidth()) / 2,
				((canvas.getHeight() - yellow.getHeight()) / 2) + 90);

		pinkPic = getImage("pink.png");
		pinkFishPic = getImage("secondbiggestfish.png");
		pink = new VisibleImage(pinkPic, 0, 0, 100, 100, canvas);
		pink.moveTo(((canvas.getWidth() - pink.getWidth()) / 2) - 125,
				((canvas.getHeight() - pink.getHeight()) / 2) + 90);

		purplePic = getImage("purple.png");
		purpleFishPic = getImage("middlefish.png");
		purple = new VisibleImage(purplePic, 0, 0, 100, 100, canvas);
		purple.moveTo(((canvas.getWidth() - purple.getWidth()) / 2) - 250,
				((canvas.getHeight() - purple.getHeight()) / 2) + 90);

		greenPic = getImage("green.png");
		greenFishPic = getImage("secondsmallestfish.png");
		green = new VisibleImage(greenPic, 0, 0, 100, 100, canvas);
		green.moveTo(((canvas.getWidth() - green.getWidth()) / 2) + 125,
				((canvas.getHeight() - green.getHeight()) / 2) + 90);

		greyPic = getImage("grey.png");
		greyFishPic = getImage("smallestfish.png");
		grey = new VisibleImage(greyPic, 0, 0, 100, 100, canvas);
		grey.moveTo(((canvas.getWidth() - grey.getWidth()) / 2) + 250,
				((canvas.getHeight() - grey.getHeight()) / 2) + 90);

		bread = this.getAudio("breadfish.wav");
		munch = this.getAudio("Bite-SoundBible.com-2056759375.wav");

		gameOn = false;
		visible = false;
		fishPic = smallestFishPic;

	}

	public void onMouseMove(Location point) {

		if (gameOn) {
			theFish.moveTo(point.getX() - theFish.getWidth() / 2, point.getY());

			lastMouse = point;
			currentScore = theFish.getScore();
			score.setText("Score: " + currentScore);
			score.moveTo((canvas.getWidth() - score.getWidth()) / 2, 50);
		}
	}

	public void onMousePress(Location point) {
		if (button.contains(point)) {
			startGame();
			munch.play();
		}
		if (yellow.contains(point)) {
			fishPic = yellowFishPic;
			munch.play();
		}
		if (pink.contains(point)) {
			fishPic = pinkFishPic;
			munch.play();
		}
		if (purple.contains(point)) {
			fishPic = purpleFishPic;
			munch.play();
		}
		if (green.contains(point)) {
			fishPic = greenFishPic;
			munch.play();
		}
		if (grey.contains(point)) {
			fishPic = greyFishPic;
			munch.play();
		}

	}

	public void startGame() {

		bread.loop();
		gameOn = true;
		yellow.removeFromCanvas();
		pink.removeFromCanvas();
		purple.removeFromCanvas();
		green.removeFromCanvas();
		grey.removeFromCanvas();
		button.removeFromCanvas();
		author.removeFromCanvas();
		title.removeFromCanvas();

		start = new Location(canvas.getWidth() / 2, canvas.getHeight() / 2);
		theFish = new TheFish(fishPic, start, canvas, 50, 25);
		ocean = new Ocean(angryFishPic, angryFishL, bubblePic, canvas, theFish);

		score = new Text("Score: " + currentScore, 0, 0, canvas);
		score.setFontSize(16);
		score.moveTo((canvas.getWidth() - score.getWidth()) / 2, 50);

		bubbles = new Bubbles(dopeBubble, canvas);

	}
}
