import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameView extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;
    private ComponentRetriever componentRetriever;

    // Konstruktor som tar en ComponentRetriever som parameter
    public FrameView(ComponentRetriever componentRetriever) {
        this.componentRetriever = componentRetriever;
    }

    public void initFrame(String title, UpdateFrame updateFrame) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));




        //Fungerar just nu inte att uppdatera fönstret
        this.add(updateFrame);
        updateFrame.setDoubleBuffered(true);
        updateFrame.setPreferredSize(new Dimension(X, Y-240));
        updateFrame.setBackground(Color.green);



        ArrayList<JComponent> controllerComponents = componentRetriever.getPanels();

        drawComponents(controllerComponents);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void drawComponents(ArrayList<JComponent> components) {
        for (JComponent panel : components) {
            this.add(panel);
        }
    }
}
