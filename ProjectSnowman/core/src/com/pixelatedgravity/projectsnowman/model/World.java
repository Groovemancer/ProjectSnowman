package com.pixelatedgravity.projectsnowman.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class World {
	
	private final String testMap = "maps/test_map01.tmx"; // Located in the android project's assets folder
	
	private TiledMap map;
	
	public World() {
		map = loadMap(testMap);	// Load the test map
	}
	
	public World(String mapFile) {
		map = loadMap(mapFile);
	}

	private TiledMap loadMap(String mapFile) {
		return new TmxMapLoader().load(mapFile);
	}
	
	public TiledMap getMap() {
		return map;
	}
	
	public void dispose() {
		map.dispose();
	}

}
