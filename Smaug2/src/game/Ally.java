package game;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFinder;

public class Ally implements Mover {
	
	public Animation walkDown, walkLeft, walkRight, walkUp, sprite;
	public int x, y, tileX, tileY, pathIndex, xAtual, yAtual;
	private PathFinder pathFinder;
	Path path;
	private PropertyBasedMap propertyBasedMap;
	private TiledMap map;
	private int cdTime;
	private boolean spawnar;
	Rectangle hitbox;
	
	public Ally(int xInicial, int yInicial, int tileX, int tileY) throws SlickException {
		
		x = xInicial;
		y = yInicial;
		this.tileX = tileX;
		this.tileY = tileY;
		hitbox = new Rectangle(x * 16, y * 16, 48, 48);
		
		cdTime = 0;
		map = new TiledMap("maps/map4.tmx");
		propertyBasedMap = new PropertyBasedMap(map, 1);		
		pathFinder = new AStarPathFinder(propertyBasedMap, 3000, false);
		
		Image [] up = {new Image("sprites/up1.png"), new Image("sprites/up2.png"),new Image("sprites/up3.png"), new Image("sprites/up4.png")};
		Image [] down = {new Image("sprites/down1.png"), new Image("sprites/down2.png"),new Image("sprites/down3.png"), new Image("sprites/down4.png")};
		Image [] left = {new Image("sprites/left1.png"), new Image("sprites/left2.png"),new Image("sprites/left3.png"), new Image("sprites/left4.png")};
		Image [] right = {new Image("sprites/right1.png"), new Image("sprites/right2.png"),new Image("sprites/right3.png"), new Image("sprites/right4.png")};
	
		this.walkUp = new Animation(up, 250, true);
		this.walkDown = new Animation(down, 250, true);
		this.walkLeft = new Animation(left, 250, true);
		this.walkRight = new Animation(right, 250, true);
		
		this.sprite = walkDown;
		
		pathIndex = 1;
	}

	public void update(int delta) {
		cdTime += delta;
		if (cdTime >= 10000) {
			spawnar = true;
		}
		if (spawnar && cdTime >= 250) {	
			path = pathFinder.findPath(this, x, y, tileX, tileY);
			if(path != null && pathIndex < path.getLength()){
				if(path.getStep(pathIndex).getX()> path.getStep(pathIndex-1).getX()){
					this.sprite = this.walkRight;
				
				}else if(path.getStep(pathIndex).getX() < path.getStep(pathIndex-1).getX()){
					this.sprite = this.walkLeft;
					
				}else if(path.getStep(pathIndex).getY() < path.getStep(pathIndex-1).getY()){
						this.sprite = this.walkUp;
					
				}else if(path.getStep(pathIndex).getY() > path.getStep(pathIndex-1).getY()){
						this.sprite = this.walkDown;
				
				}else{
					this.sprite = this.walkDown;
					pathIndex = 1;
					path = null;
				}
				xAtual = path.getX(pathIndex);
				System.out.print(path.getX(pathIndex) + " ");
				yAtual = path.getY(pathIndex);
				System.out.println(path.getY(pathIndex));
			}
			else{
				path = null;
				this.sprite.stop();
			}
			pathIndex++;
			hitbox.setY(yAtual * 16);
			hitbox.setX(xAtual * 16);
			cdTime = 0;
		}
	}
	
	public void draw() {
		sprite.draw(xAtual*16, yAtual*16, 48, 48);
	}
	
}
