package cs3500.music.model;

/**
 * To represent a Note
 */
// C C♯ D D♯ E F F♯ G G♯ A A♯ B
public enum NoteEnum {
  C("C"),
  CSHARP("C#"),
  D("D"),
  DSHARP("D#"),
  E("E"),
  F("F"),
  FSHARP("F#"),
  G("G"),
  GSHARP("G#"),
  A("A"),
  ASHARP("A#"),
  B("B");

  private String val;

  /**
   * The constructor
   * @param val is the val of the note
   */
  NoteEnum(String val) {this.val = val;}

  /**
   * Gets the value of this note
   * @return the val of this note
   */
  public String getVal() {
    return this.val;
  }

  /**
   * Gets a formatted string version of this note with a given colsize
   * @param colSize is the total string length of the column to be produced
   * @return a formatted string version of this note
   */
  public String getValFormatted(int colSize, int octave) {
    String noteString = val + octave;
    String formattedNote;
    int sizeLeft = colSize - noteString.length();

    formattedNote = noteString;

    for (int i = 0; i < sizeLeft/2; i++) {
      formattedNote += " ";
    }
    sizeLeft -= sizeLeft/2;

    for (int i = 0; i < sizeLeft; i++) {
      formattedNote = " " + formattedNote;
    }

    return formattedNote;
  }
}
