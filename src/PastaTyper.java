import java.awt.*;
import java.awt.event.KeyEvent;

public class PastaTyper
{
    protected String pasta;
    protected Robot robot;

    public PastaTyper(String pasta)
    {
        this.pasta = pasta;
        try
        {
            this.robot = new Robot();
        } catch (AWTException e)
        {
            e.printStackTrace();
        }
    }

    public void pastePasta()
    {
        int x = 0;
        for (int i = 0; i < pasta.length(); i++)
        {
            char letter = pasta.charAt(i);
            int currentChar = (int) letter;
            robot.delay(20);
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
                }
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            x += 1;
            if (x >= 50 && letter == ' ')
            {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.delay(500);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                x = 0;
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
}
