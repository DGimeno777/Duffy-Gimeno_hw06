package cs3500.music.model;

import java.util.ArrayList;

/**
 * To represent a Beat
 */
public class Beat {

  private ArrayList<Note> notes;
  private int num;

  /**
   * The constructor
   * @param beatNum is the beatnum
   */
  public Beat(int beatNum) {
    this.notes = new ArrayList<Note>();
    this.num = beatNum;
  }

  /**
   * Adds the given Note to the Beat
   * @param n is the note to be added
   */
  public void addNote(Note n) {
    if (n == null || n.getBeat() != this.num) {
      throw new IllegalArgumentException("Null input given.");
    }

    notes.add(n);
  }

  /**
   * Removes the given note from this beat
   * NOTE: will complete successfully if note is not found
   * @param n is the note to be removed
   */
  public void removeNote(Note n) {
    if (n == null || n.getBeat() != this.num) {
      throw new IllegalArgumentException("Invalid index.");
    }

    for (int i = 0; i < this.notes.size(); i++) {
      if (n.toString().equals(notes.get(i).toString())) {
        this.notes.remove(i);
        break;
      }
    }
  }

  /**
   * Gets the number of this beat
   * @return the number of this beat
   */
  public int getBeatNum() {
    return num;
  }

  /**
   * Gets all of the notes in this beat
   * @return the notes in this beat
   */
  public ArrayList<Note> getNotes() {
    return this.notes;
  }
}
