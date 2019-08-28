//Filename Booter.java
//Author Isaiah Sherfick
//Part of my WoW Classic booting program to skip login queue
//Last modified on 28 Aug 2019


import java.awt.*;
import java.awt.event.InputEvent;

public class Booter
{
    private int timeToWaitBeforeBootingInMilliseconds;
    private Robot r;

    //Constructor for the Booter class
    /**
     * @param timeToWaitBeforeBootingInMinutes the time the bot should wait before logging in to WoW
     */
    Booter(int timeToWaitBeforeBootingInMinutes)
    {
        this.timeToWaitBeforeBootingInMilliseconds = timeToWaitBeforeBootingInMinutes * 60000;
        try
        {
            this.r = new Robot();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
    }

    //Boots World Of Warcraft
    public void bootWoW()
    {
        //Wait the specified amount of time before doing anything
        int secondsToWait = timeToWaitBeforeBootingInMilliseconds / 1000;

        for (int i = secondsToWait; i > 0; i--)
        {
            System.out.printf("\nBooting WoW in %d seconds...",i);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }



        //Move the mouse to the location of the "Launch Game" button
        //Assuming the Blizzard launcher is maximized and running on a 1920x1080 monitor
        r.mouseMove(380, 960);

        //Click the "Launch Game" button
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //Wait ten seconds for the game to boot
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //Move the mouse to the location of the top server on the server listing
        //Assuming the game is running at 1920x1080 resolution
        r.mouseMove(700,270);

        //Click the server
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //Wait a second
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //Move the mouse to the location of the "Okay" button on the server listing
        //Assuming the game is running at 1920x1080 resolution
        r.mouseMove(1120, 855);

        //Click the "Okay" button
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
