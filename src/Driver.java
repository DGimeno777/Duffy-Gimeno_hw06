import java.awt.*;

import cs3500.music.view.ConcreteGuiViewPanel;
import cs3500.music.view.GuiViewFrame;

/**
 * Created by Danny on 6/12/2016.
 */
public class Driver {
  public static void main(String[] args) {

    GuiViewFrame frame = new GuiViewFrame();


    ConcreteGuiViewPanel gui = new ConcreteGuiViewPanel();


    frame.setVisible(true);

  }
}
