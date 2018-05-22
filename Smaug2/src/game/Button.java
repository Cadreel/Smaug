package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

public class Button extends MouseOverArea {
	
	public Button(GUIContext container, Image image, float x, float y, int i, float f) {
		super(container, image, (int) x, (int) y, i, (int) f);
	}
	
}
