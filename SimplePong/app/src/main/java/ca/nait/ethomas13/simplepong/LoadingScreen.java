package ca.nait.ethomas13.simplepong;

import ca.youcode.nait.games.Game;
import ca.youcode.nait.games.Graphics;
import ca.youcode.nait.games.Screen;

/**
 * Created by ethomas13 on 3/19/2019.
 */

public class LoadingScreen extends Screen
{

    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float v) {
        Graphics g = game.getGraphics();

        Assets.ball = g.newPixmap("ball.png", Graphics.PixmapFormat.RGB565);
        Assets.background =
                g.newPixmap("background.jpg", Graphics.PixmapFormat.RGB565);
        Assets.paddle =
                g.newPixmap("paddle.png", Graphics.PixmapFormat.RGB565);
        Assets.gameOver =
                g.newPixmap("gameover.png", Graphics.PixmapFormat.RGB565);
        game.setScreen(new GameScreen(game));
    }

    @Override
    public void present(float v)
    {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
