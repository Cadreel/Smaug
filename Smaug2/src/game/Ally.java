package game;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.Mover;

public class Ally implements Mover {
	
	public Animation walkDown, walkLeft, walkRight, walkUp, sprite;
	
	public Ally() throws SlickException {
		
		Image [] up = {new Image("sprites/up1.png"), new Image("sprites/up2.png"),new Image("sprites/up3.png"), new Image("sprites/up4.png")};
		Image [] down = {new Image("sprites/down1.png"), new Image("sprites/down2.png"),new Image("sprites/down3.png"), new Image("sprites/down4.png")};
		Image [] left = {new Image("sprites/left1.png"), new Image("sprites/left2.png"),new Image("sprites/left3.png"), new Image("sprites/left4.png")};
		Image [] right = {new Image("sprites/right1.png"), new Image("sprites/right2.png"),new Image("sprites/right3.png"), new Image("sprites/right4.png")};
	
		this.walkUp = new Animation(up, 250, true);
		this.walkDown = new Animation(down, 250, true);
		this.walkLeft = new Animation(left, 250, true);
		this.walkRight = new Animation(right, 250, true);
		
		this.sprite = walkDown;
	}

	
	public void draw(int x, int y, int width, int height) {
		sprite.draw(x, y, width, height);
		
	}
	
}
