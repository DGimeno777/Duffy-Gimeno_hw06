package cs3500.music.model;

import java.util.ArrayList;

/**
 * To represent an Octave
 */
public class Octave {

  private ArrayList<Beat> beats;
  private int octaveNum;

  /**
   * The constructor
   * @param octaveNum is the number octave
   * @param numBeats is the number of beats
   */
  public Octave(int octaveNum, int numBeats) {
    this.octaveNum = octaveNum;
    this.beats = new ArrayList<Beat>();

    for (int i = 0; i < numBeats; i++) {
      this.beats.add(new Beat(i));
    }
  }

  /**
   * gets the num of the octave
   * @return the num of this octave
   */
  public int getNum() {
    return this.octaveNum;
  }

  /**
   * Gets all of the notes in this Octave
   * @return the notes present in this octave
   */
  public ArrayList<Note> getNotes() {
    ArrayList<Note> getNotes = new ArrayList<Note>();

    for (int i = 0; i < beats.size(); i++) {
      ArrayList<Note> tempLengths = this.beats.get(i).getNotes();
      for (int j = 0; j < tempLengths.size(); j++) {
        getNotes.add(tempLengths.get(j));
      }
    }

    return getNotes;
  }

  /**
   * Adds the given Note to this octave
   * @param n is the note to be added
   */
  public void addNote(Note n) {

    if (n == null || n.getOctave() != this.octaveNum ||
            n.getBeat() < 0 || n.getBeat() >= this.beats.size() ||
            n.getBeat() + n.getLength() > this.beats.size()) {
      throw new IllegalArgumentException("Invalid input given.");
    }

    this.beats.get(n.getBeat()).addNote(n);
  }

  /**
   * Removes a note from this octave at the given index
   * @param n is the note to be removed
   */
  public void removeNote(Note n) {
    if (n == null || n.getOctave() != this.octaveNum) {
      throw new IllegalArgumentException("Invalid input given.");
    }

    boolean found = false;
    ArrayList<Note> beatNotes = this.beats.get(n.getBeat()).getNotes();

    for (int i = 0; i < beatNotes.size(); i++) {
      if (beatNotes.get(i).toString().equals(n.toString())) {
        beats.get(n.getBeat()).removeNote(n);
        found = true;
        break;
      }
    }

    if (!found) {
      throw new IllegalArgumentException("No note to remove.");
    }
  }
}
