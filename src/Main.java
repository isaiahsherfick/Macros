import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                addALabel("Pick your pasta!", pane);
            } else {
                addALabel(" ", pane);
            }
        }

        addALabel("Navy Seal", pane);
        ActionListener nsListener = event ->
        {
            NavySeal ns = new NavySeal(15);
            ns.pastePasta();
        };
        addAButton("Paste Pasta", nsListener, pane);

        addALabel(" ", pane);

        addALabel("Attack Helicopter", pane);
        ActionListener ahListener = event ->
        {
            AttackHelicopter ah = new AttackHelicopter(15);
            ah.pastePasta();
        };
        addAButton("Paste Pasta", ahListener, pane);

        addALabel(" ", pane);

        addALabel("Rick And Morty", pane);
        ActionListener ramListener = event ->
        {
            RickAndMorty ram = new RickAndMorty(15);
            ram.pastePasta();
        };
        addAButton("Paste Pasta", ramListener, pane);

    }

    private static void addAButton(String text, ActionListener actionListener, Container container)
    {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    private static void addALabel(String text, Container container)
    {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Pasta Paster");
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocation(new Point(600,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
