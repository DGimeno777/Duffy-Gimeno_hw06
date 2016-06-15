package cs3500.music.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Danny on 6/14/2016.
 */
public class MMController implements ActionListener {

  private MMModel model;

  public MMController(MMModel model) {
    super();
    this.model = model;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    model.goNext();
  }
}
