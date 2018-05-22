package game;

import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class PropertyBasedMap implements TileBasedMap{

	private TiledMap map;
	private int blockingPropertyName;
	Ally ally;
	
	public PropertyBasedMap(TiledMap map, int blockingPropertyName){
		this.map = map;
		this.blockingPropertyName = blockingPropertyName;
	}
	
	public int getHeightInTiles() {
		return map.getHeight() ;
	}

	public int getWidthInTiles() {
		return map.getWidth();
	}

	public void pathFinderVisited(int arg0, int arg1) {
		
	}

	public boolean blocked(PathFindingContext ctx, int x, int y) {
		return  map.getTileId(x, y, blockingPropertyName)== 0;
	}

	public float getCost(PathFindingContext ctx, int x, int y) {
		return 1.0f;
	}
	
}
