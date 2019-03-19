package ca.nait.ethomas13.simplepong;

import ca.youcode.nait.games.Game;
import ca.youcode.nait.games.Graphics;
import ca.youcode.nait.games.Screen;

/**
 * Created by ethomas13 on 3/19/2019.
 */

public class GameOverScreen extends Screen
{

    public GameOverScreen(Game game) {
        super(game);
    }

    @Override
    //where you would do your math (like a final score or ranking)
    public void update(float v) {

    }

    @Override
    public void present(float v) {
        //g represents the drawing surface
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.gameOver, 100, 50);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        Assets.background.dispose();
        Assets.ball.dispose();
        Assets.gameOver.dispose();
        Assets.paddle.dispose();
    }

}
