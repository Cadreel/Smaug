package helpers;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import game.Intro;
import game.Jogo;
import game.Menu;
import game.MenuOptions;

public class Main extends StateBasedGame {
	public static final int WIDTH = 1280, HEIGHT = 600;
	public AppGameContainer screen;
	
	public Main() throws SlickException {
		super("PLANET INVASION: TOWER ATTACK!");
		
		screen =  new AppGameContainer(this);
		screen.setDisplayMode((int)WIDTH, (int)HEIGHT, false);
		screen.setAlwaysRender(true);
		screen.setShowFPS(true);
		screen.start();
	}

	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Intro());
		this.addState(new Menu());
		this.addState(new Jogo());
		this.addState(new MenuOptions());
		this.enterState(2);
		
	}
	
	public static void main(String[] args){
		try {
			new Main();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
