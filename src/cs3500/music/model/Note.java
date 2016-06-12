package cs3500.music.model;

/**
 * Created by Danny on 6/9/2016.
 */
public class Note {
  private int length;
  private NoteEnum note;
  private int octave;
  private int beat;

  public Note(NoteEnum note, int octave, int beat, int length) {
    if (note == null) {
      throw new IllegalArgumentException();
    }

    this.note = note;
    this.length = length;
    this.octave = octave;
    this.beat = beat;
  }

  public NoteEnum getNoteType() {
    return this.note;
  }

  public int getLength() {
    return this.length;
  }

  public int getOctave() {
    return this.octave;
  }

  public int getBeat() {
    return this.beat;
  }

  public String toString() {
    return "Note: " + this.note.getVal() + " Oct: " + this.octave + " Beat: " + this.beat
            + " Length: " + this.length;
  }
}
