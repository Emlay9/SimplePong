package ca.nait.ethomas13.simplepong;

import java.util.List;

import ca.youcode.nait.games.Game;
import ca.youcode.nait.games.Graphics;
import ca.youcode.nait.games.Input;
import ca.youcode.nait.games.Screen;

/**
 * Created by ethomas13 on 3/19/2019.
 */

public class GameScreen extends Screen
{
    int ballDiameter = 32;
    int paddleWidth = 96;
    int paddleHeight = 15;

    int spriteX = 6, spriteY = 6, xIncrement = 5, yIncrement = 5;
    int paddleX = 100, paddleY = 450, paddleIncrement = 5;
    boolean bSpriteAlive = true;


    public GameScreen(Game game)
    {
        super(game);
    }

    @Override
    public void update(float v)
    {
        //check if the ball collides with the paddle
        //if true, make the ball go the reverse direction in the y axis
        if(collision())
        {
            yIncrement *= -1;
        }
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int nEvents = touchEvents.size();
        for(int c = 0; c < nEvents; c++)
        {
            Input.TouchEvent event = touchEvents.get(c);
            if(event.type == Input.TouchEvent.TOUCH_DRAGGED){
                //48 is half the paddles length, so we assume they're always dragging it from the middle
                paddleX = event.x - 48;
            }
        }
        spriteX += xIncrement;
        spriteY += yIncrement;

        //check if the ball is hitting the wall
        if(spriteX < 0 || spriteX > 288)
        {
            xIncrement *= -1;
        }
        if (spriteY < 0 )
        {
            yIncrement *= -1;
        }
        //if it's at the bottom it's dead
        if (spriteY + ballDiameter > 480)
        {
            bSpriteAlive = false;
        }
    }

    private boolean collision()
    {
        boolean bCollide = false;
        //the sprite(ball) width is always calculated from the top left

        //check if the ball is between the paddle on the x axis (first 2 conditions)
        // check if the ball is below the paddle
        if (spriteX + ballDiameter > paddleX && spriteX < paddleX + paddleWidth
                && spriteY + ballDiameter > paddleY
                && spriteY + ballDiameter < paddleY + paddleHeight)
        {
            bCollide = true;
        }
        return bCollide;
    }

    @Override
    public void present(float v)
    {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.paddle, paddleX, paddleY);
        if (bSpriteAlive)
        {
            g.drawPixmap(Assets.ball, spriteX, spriteY);
        }
        else
        {
            game.setScreen(new GameOverScreen(game));
        }
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {

    }
}
