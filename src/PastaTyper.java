import java.awt.*;
import java.awt.event.KeyEvent;

public class PastaTyper
{
    protected String pasta;
    protected Robot robot;
    private int wordsBeforeNewLine;
    private Character newLine;

    public PastaTyper(String pasta)
    {
        this.pasta = pasta;
        this.newLine = '\n';
        this.wordsBeforeNewLine= 20;
        try
        {
            this.robot = new Robot();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
    }

    public PastaTyper(String pasta, Character newLine)
    {
        this.pasta = pasta;
        this.newLine = newLine;
        this.wordsBeforeNewLine= 20;
        try
        {
            this.robot = new Robot();
        }
        catch(AWTException e)
        {
            e.printStackTrace();
        }
    }


    public PastaTyper(String pasta, int wordsBeforeNewLine)
    {
        this.pasta = pasta;
        this.newLine = '\n';
        this.wordsBeforeNewLine= wordsBeforeNewLine;
        try
        {
            this.robot = new Robot();
        }
        catch(AWTException e)
        {
            e.printStackTrace();
        }
    }

    public PastaTyper(String pasta, Character newLine, int wordsBeforeNewLine)
    {
        this.pasta = pasta;
        this.newLine = newLine;
        this.wordsBeforeNewLine = wordsBeforeNewLine;
        try
        {
            this.robot = new Robot();
        }
        catch(AWTException e)
        {
            e.printStackTrace();
        }
    }

    public void inputNewLine()
    {
        if (newLine.equals('\n'))
        {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        else
        {
            try
            {
                if (Character.isUpperCase(newLine))
                {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(newLine));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(newLine));
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            catch (IllegalArgumentException e)
            {
                switch (newLine)
                {
                    case '!':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                        break;
                    case '?':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_SLASH);
                        robot.keyRelease(KeyEvent.VK_SLASH);
                        break;
                    case '"':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_QUOTE);
                        robot.keyRelease(KeyEvent.VK_QUOTE);
                        break;
                    case '\'':
                        robot.keyPress(KeyEvent.VK_QUOTE);
                        robot.keyRelease(KeyEvent.VK_QUOTE);
                        break;
                    case ':':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SEMICOLON);
                        break;
                    case ';':
                        robot.keyPress(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SEMICOLON);
                        break;
                    case '-':
                        robot.keyPress(KeyEvent.VK_MINUS);
                        break;
                    case '(':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_9);
                        robot.keyRelease(KeyEvent.VK_9);
                        break;
                    case ')':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_0);
                        robot.keyRelease(KeyEvent.VK_0);
                        break;
                }
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
        }
    }

    public void pastePasta()
    {
        try
        {
            Thread.sleep(1500);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        int words = 0;
        for (int i = 0; i < pasta.length(); i++)
        {
            char letter = pasta.charAt(i);
            int currentChar = (int)letter;
            robot.delay(15);
            try
            {
                if (Character.isUpperCase(letter))
                {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(currentChar));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(currentChar));
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            catch (IllegalArgumentException e)
            {
                switch (letter)
                {
                    case '!':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                        break;
                    case '?':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_SLASH);
                        robot.keyRelease(KeyEvent.VK_SLASH);
                        break;
                    case '"':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_QUOTE);
                        robot.keyRelease(KeyEvent.VK_QUOTE);
                        break;
                    case '\'':
                        robot.keyPress(KeyEvent.VK_QUOTE);
                        robot.keyRelease(KeyEvent.VK_QUOTE);
                        break;
                    case ':':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SEMICOLON);
                        break;
                    case ';':
                        robot.keyPress(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SEMICOLON);
                        break;
                    case '-':
                        robot.keyPress(KeyEvent.VK_MINUS);
                        break;
                    case '(':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_9);
                        robot.keyRelease(KeyEvent.VK_9);
                        break;
                    case ')':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_0);
                        robot.keyRelease(KeyEvent.VK_0);
                        break;
                }
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            if (letter == ' ')
            {
                words += 1;
            }
            if (words >= wordsBeforeNewLine)
            {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                inputNewLine();
                words = 0;
            }
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void setPasta(String pasta)
    {
        this.pasta = pasta;
    }

    public String getPasta()
    {
        return pasta;
    }

    public void setWords(int wordsBeforeNewLine)
    {
        this.wordsBeforeNewLine = wordsBeforeNewLine;
    }

    public int getWords()
    {
        return wordsBeforeNewLine;
    }
}
