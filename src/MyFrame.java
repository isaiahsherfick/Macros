import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
    public MyFrame(String title)
    {
        super(title);
	Container pane = getContentPane();

        //Set layout manager
        setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        //Create Swing components
        JButton ns = new JButton("Navy Seal");
        JButton ram = new JButton("Rick And Morty");
        JButton ah = new JButton("Attack Helicopter");
        ns.setAlignmentX(Component.CENTER_ALIGNMENT);
        ram.setAlignmentX(Component.CENTER_ALIGNMENT);
        ah.setAlignmentX(Component.CENTER_ALIGNMENT);
	ns.setPreferredSize(new Dimension(100,100));
	ram.setPreferredSize(new Dimension(100,100));
	ah.setPreferredSize(new Dimension(100,100));

        //Add components to content pane

        pane.add(ns);
        pane.add(ram);
        pane.add(ah);
        pack();
        setVisible(true);
    }
}