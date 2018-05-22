package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import static helpers.Main.*;
import game.Button;

public class Menu extends BasicGameState {

	private Image menu, campanha, opcao, sair, miniMenu;
	private Button botaoCampanha, botaoOpcao, botaoSair;
	
	public Menu() {
		
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		campanha = new Image("res/campanha.png");
		botaoCampanha = new Button(container, campanha, WIDTH/2.4f, (HEIGHT*0.60f), (int) (WIDTH/5.3f), (HEIGHT*0.09f));
		opcao = new Image("res/opcoes.png");
		botaoOpcao = new Button(container, opcao,WIDTH/2.4f, (HEIGHT*0.70f), (int) (WIDTH/5.3f), (HEIGHT*0.09f));
		sair = new Image("res/sair.png");
		botaoSair = new Button(container, sair,WIDTH/2.4f, (HEIGHT*0.80f), (int) (WIDTH/5.3f), (HEIGHT*0.09f));
		miniMenu = new Image("res/miniMenu2.png");
		menu = new Image("res/menu2.png");
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		menu.draw(0, 0, WIDTH, HEIGHT);
		campanha.draw(WIDTH/2.4f, (HEIGHT*0.60f), WIDTH/5.3f, (HEIGHT*0.09f));
		opcao.draw(WIDTH/2.4f, (HEIGHT*0.70f), WIDTH/5.3f, (HEIGHT*0.09f));
		sair.draw(WIDTH/2.4f, (HEIGHT*0.80f), WIDTH/5.3f, (HEIGHT*0.09f));
		miniMenu.draw(WIDTH/2.5f, (HEIGHT*0.45f), WIDTH/4.5f, (HEIGHT*0.5f));
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isMousePressed(0)){
			if(botaoCampanha.isMouseOver()){
					game.enterState(2);
				}
			if(botaoOpcao.isMouseOver()){
					game.enterState(4);
				}
			if(botaoSair.isMouseOver()){
					System.exit(0);
				}
		}
	}
	public int getID() {
		return 1;
	}

}
