package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import static helpers.Main.*;

public class MenuOptions extends BasicGameState {

	private Image background, voltar, bigBlob, exit;
	private Button botaoVoltar, botaoIdioma;
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Image("res/menu2.png");
		voltar = new Image("res/voltar.png");
		botaoVoltar = new Button(container, voltar, WIDTH/1.4f, (HEIGHT*0.90f), WIDTH/4, (HEIGHT*0.09f));
//		bigBlob = drawSprite("bigBlob");
		botaoIdioma = new Button(container, bigBlob, WIDTH/2.2f, (HEIGHT*0.50f),250,150);
		exit = new Image("res/exit.png");
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw(0, 0, WIDTH, HEIGHT);
		voltar.draw(WIDTH/1.4f, (HEIGHT*0.90f), WIDTH/5, (HEIGHT*0.09f));
//		bigBlob.draw(WIDTH/3.3f, (HEIGHT*0.35f),570,395);
		if(botaoIdioma.isMouseOver()){
			exit.draw(0,0);
//		}
	}
}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isMousePressed(0)){
			if(botaoVoltar.isMouseOver()){
				game.enterState(1);
			}
			}
		}
		

	public int getID() {
		return 4;
	}

}
