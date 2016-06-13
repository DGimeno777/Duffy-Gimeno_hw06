package cs3500.music.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * To represent a StandardMusicModel
 */
public class StandardMusicModel extends AMusicModel{

  /**
   * The constructor
   * @param beats is the number of beats
   */
  public StandardMusicModel(int beats) {
    super(beats);
  }

  /**
   * Gets the highest octave present in this musicmodel
   * @return the highest octave present
   */
  protected int getHighestOctave() {
    int high = 1;

    for (Iterator<Integer> i = this.octaves.keySet().iterator(); i.hasNext();) {
      int curr = i.next();
      if (curr > high) {
        high = curr;
      }
    }

    return high;
  }

  /**
   * Gets the lowest octave present in this musicmodel
   * @return the lowest octave present
   */
  protected int getLowestOctave() {
    int low = 10;

    for (Iterator<Integer> i = this.octaves.keySet().iterator(); i.hasNext();) {
      int curr = i.next();
      if (curr < low) {
        low = curr;
      }
    }

    return low;
  }

  @Override
  public String toString() {
    AMusicModelViewer bvs = new AMusicModelViewer(this.beats, this.getLowestOctave(),
            this.getHighestOctave());
    for (Iterator<Integer> i = this.octaves.keySet().iterator();
         i.hasNext();) {
      int currInt = i.next();
      Octave currOctave = this.octaves.get(currInt);
      ArrayList<Note> currOctaveNotes = currOctave.getNotes();

      for (int t = 0; t < currOctaveNotes.size(); t++) {
        Note tempNote = currOctaveNotes.get(t);
        Note putNote = new Note(tempNote.getNoteType(), tempNote.getOctave(),
                tempNote.getBeat(), tempNote.getLength());
        bvs.addNote(putNote);
      }
    }

    return bvs.toString();
  }
}
