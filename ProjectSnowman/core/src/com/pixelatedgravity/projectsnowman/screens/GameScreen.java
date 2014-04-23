package com.pixelatedgravity.projectsnowman.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.pixelatedgravity.projectsnowman.model.World;
import com.pixelatedgravity.projectsnowman.view.WorldRenderer;

public class GameScreen implements Screen {
	
	private WorldRenderer renderer;
	private World world;

	@Override
	public void show() {
		world = new World();
		renderer = new WorldRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		renderer.dispose();
		world.dispose();
	}

}
