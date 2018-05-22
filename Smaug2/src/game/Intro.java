package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import static helpers.Main.*;

public class Intro extends BasicGameState {
	
	private Image intro;
	
	public static long nextSecond = System.currentTimeMillis() + 10000;
	public static int framesInLastSecond = 0;
	public static int framesInCurrentSecond = 0;

	public Intro() {
		
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		
		intro = new Image("res/ultimateam.png");
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		intro.draw(0, 0, WIDTH, HEIGHT);
		g.drawString("Aperte Enter para iniciar", 400, 500);
		
		
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input entrada = container.getInput();
		if(entrada.isKeyPressed(Input.KEY_ENTER)){
			game.enterState(1);
		}
		long currentTime = System.currentTimeMillis();
		if(currentTime > nextSecond){
			nextSecond += 1000;
			framesInLastSecond = framesInCurrentSecond;
			framesInCurrentSecond = 0;
			game.enterState(1);
		}
		framesInCurrentSecond++;
	}
	
	public int getID() {
		return 0;
	}

}
