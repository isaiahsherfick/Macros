import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {

        SwingUtilities.invokeLater(() ->
        {
            JFrame frame = new MyFrame("Pasta Paster");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
        });

    }
}