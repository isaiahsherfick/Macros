import java.awt.*;
import java.awt.event.KeyEvent;

public class PastaTyper
{
    private String pasta;
    private Robot robot;

    public PastaTyper(String pasta)
    {
        this.pasta = pasta;
        try
        {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void pastePasta()
    {
        for (int i = 0; i < pasta.length(); i++)
        {
            char letter = pasta.charAt(i);
            int currentChar = (int) letter;
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(currentChar);
            robot.delay(5);
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

            if (i % 50 == 0)
            {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        }
    }

    public void setPasta(String pasta)
    {
        this.pasta = pasta;
    }

    public String getPasta()
    {
        return pasta;
    }

    public static void main(String[] args)
    {
        PastaTyper p = new PastaTyper("What the fuck did you just fucking say about me, you little bitch? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You're fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little \"clever\" comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn't, you didn't, and now you're paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You're fucking dead, kiddo.");
        p.pastePasta();
    }
}
