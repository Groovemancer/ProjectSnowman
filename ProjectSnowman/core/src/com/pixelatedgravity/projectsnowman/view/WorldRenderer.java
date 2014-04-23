package com.pixelatedgravity.projectsnowman.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.pixelatedgravity.projectsnowman.model.World;

public class WorldRenderer {
	
	private static final float CAMERA_WIDTH = 12f;
	private static final float CAMERA_HEIGHT = 8f;
	private static final float UNIT_SCALE = 1 / 8f;
	
	private OrthographicCamera camera;
	private World world;
	private SpriteBatch spriteBatch;
	private OrthogonalTiledMapRenderer mapRenderer;
	
	public WorldRenderer(World world) {
		this.world = world;
		spriteBatch = new SpriteBatch();
		
		// Initialize the Tiled Map Renderer, passing the tiledmap retrieved from world, and setting unit size
		// Unit Size = 1 unit per 8 pixel(s) = 1 / 8
		mapRenderer = new OrthogonalTiledMapRenderer(world.getMap(), UNIT_SCALE);

		// Width/Height = number of units displayed in the camera, i.e. 12 units x 8 units
		// 12 x 8 = 96 x 64 pixels camera resolution
		camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		camera.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0f);
		camera.update();
	}
	
	public void render(float delta) {
		// Update camera, in case there's some changes made else where
		camera.update();
		
		// Set up camera for tiled map render, then render
		mapRenderer.setView(camera);
		mapRenderer.render();

		spriteBatch.begin();
			
			// Stuff to render goes here...
		
		spriteBatch.end();
	}
	
	public void dispose() {
		spriteBatch.dispose();
		mapRenderer.dispose();
	}

}
