package game;

import static helpers.Main.*;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFinder;


public class Jogo extends BasicGameState implements Mover {

	private Image voltar, background_menu, blob, squime1;
	private Button botaoVoltar, buttonBlob, buttonSquime;
	
	private PropertyBasedMap propertyBasedMap;
	private TiledMap map;
	private int x, y;
	private ArrayList<Ally> allyList;
	private PathFinder pathFinder;
	
	private int pathIndex;
	
	public Jogo() {
		
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		x = 14;
		y = 0;
		allyList = new ArrayList<Ally>();
		map = new TiledMap("maps/map4.tmx");
		propertyBasedMap = new PropertyBasedMap(map, 1);
		pathFinder = new AStarPathFinder(propertyBasedMap, 3000, false);
		pathIndex = 1;
		voltar = new Image("res/voltar.png");
		blob = new Image("res/bigBlob.png");
		squime1 = new Image("res/squime.png");
		background_menu = new Image("res/menu_background.png");
		botaoVoltar = new Button(container, voltar, WIDTH/1.16f, (HEIGHT*0.90f), WIDTH/10, (HEIGHT*0.09f));
		buttonBlob = new Button(container, blob, 1125, 0, 64,64);
		buttonSquime = new Button(container, squime1, 1225, 0, 64,64);
	}
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		map.render(0, 0);
		background_menu.draw(1125, 0, 192, 600);
		blob.draw(1125, 0, 64,64);
		squime1.draw(1225, 0, 64,64);
		voltar.draw(WIDTH/1.12f, (HEIGHT*0.90f), WIDTH/10, (HEIGHT*0.09f));
		for(Ally a: allyList){
			a.sprite.draw();
			x = 14;
			y = 0;
		}
		
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
		map.getLayerIndex("map");
		
		if(container.getInput().isMousePressed(0)){
			if(botaoVoltar.isMouseOver()){
				game.enterState(1);
			}
			
			if(buttonBlob.isMouseOver()){
				allyList.add(new Ally());
				System.out.println("blob");
				
			}
			
			if(buttonSquime.isMouseOver()){
				allyList.add(new Squime());
				System.out.println("squime");
			}
		}
			move(69,28);
	}
	
	
	public void move(int tileX, int tileY) throws SlickException{
		for(Ally a: allyList){
		Path path = pathFinder.findPath(a, x, y, tileX, tileY);
		System.out.println(allyList);
		if(path != null && pathIndex < path.getLength()){
			if(path.getStep(pathIndex).getX()> path.getStep(pathIndex-1).getX()){
				a.sprite = a.walkRight;
			
			}else if(path.getStep(pathIndex).getX() < path.getStep(pathIndex-1).getX()){
				a.sprite = a.walkLeft;
				
			}else if(path.getStep(pathIndex).getY() < path.getStep(pathIndex-1).getY()){
					a.sprite = a.walkUp;
				
			}else if(path.getStep(pathIndex).getY() > path.getStep(pathIndex-1).getY()){
					a.sprite = a.walkDown;
			
			}else{
				a.sprite = a.walkDown;
				pathIndex = 1;
				path = null;
				
			}
			x = path.getX(pathIndex);
			y = path.getY(pathIndex);
			
		}
		else{
			path = null;
			a.sprite.stop();
			
		}
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pathIndex++;
		break;
		}
	}

	public int getID() {
		return 2;
	}
}
