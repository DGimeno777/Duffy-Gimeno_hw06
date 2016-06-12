package cs3500.music.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * To represent a BeatViewerString
 */
public class BeatViewerString {

  private ArrayList<BeatString> beatStrings;
  private int octaveLow;
  private int octaveHigh;

  /**
   * The constructor
   * @param beats is the number of beats
   * @param octaveLow is the lowest octave to be shown
   * @param octaveHigh is the highest octave to be shown
   */
  public BeatViewerString(int beats, int octaveLow, int octaveHigh) {
    if (beats <= 0 || octaveLow < 1 || octaveHigh > 10 || octaveHigh < octaveLow) {
      throw new IllegalArgumentException("Not enough beats");
    }
    this.octaveLow = octaveLow;
    this.octaveHigh = octaveHigh;
    beatStrings = new ArrayList<BeatString>();
    for (int i = 0; i < beats; i++) {
      beatStrings.add(new BeatString(octaveLow, octaveHigh));
    }
  }

  /**
   * Adds a note of given length to given beat if the space required is valid
   * Note: Throws an exception if there is already a note present
   * @param n is the note to add
   */
  public void addNote(Note n) {
    if (n == null || n.getBeat() + n.getLength() > this.beatStrings.size() ||
            n.getLength() <= 0 || n.getBeat() < 0 || n.getBeat() >= this.beatStrings.size()) {
      throw new IllegalArgumentException("Invalid input given.");
    }

    if (PlayType.START.getPrintWeight() >
            beatStrings.get(n.getBeat()).getNotePlayType(n.getNoteType().getValFormatted(5,
                    n.getOctave())).getPrintWeight()) {

      beatStrings.get(n.getBeat()).setNote(n.getNoteType().getValFormatted(5, n.getOctave()),
              PlayType.START);
    }
    for (int i = n.getBeat() + 1; i < n.getBeat() + n.getLength(); i++) {
      if (PlayType.CONTINUE.getPrintWeight() >
              beatStrings.get(i).getNotePlayType(n.getNoteType().getValFormatted(5,
                      n.getOctave())).getPrintWeight()) {

        beatStrings.get(i).setNote(n.getNoteType().getValFormatted(5, n.getOctave()),
                PlayType.CONTINUE);
      }
    }
  }

  @Override
  public String toString() {
    String theReturn = "";
    NoteEnum[] noteVals = NoteEnum.values();
    int colSize = ((int) Math.log10(beatStrings.size()-1)) + 1;

    /** Adds the number column to the beginning of the Note row */
    for(int i = 0; i < colSize; i++) {
      theReturn += " ";
    }

    /** Adds the Notes as Strings to the Note row */
    for (int i = this.octaveLow; i <= this.octaveHigh; i++) {
      for (int t = 0; t < noteVals.length; t++) {
        theReturn += noteVals[t].getValFormatted(5, i);
      }
    }

    theReturn += "\n";

    /** Adds the Beats to the string */
    for (int i = 0; i < beatStrings.size(); i++) {
      theReturn += padFrontToWidth(i, colSize) +
              beatStrings.get(i).toString();
      if (i != beatStrings.size() - 1) {
        theReturn += "\n";
      }
    }

    return theReturn;
  }

  /**
   * Pads the front of a given int to the given column size
   * @param beatNum
   * @param colSize
   * @return
   */
  private String padFrontToWidth(int beatNum, int colSize) {
    String paddedString = "";

    for (int i = 0; i < colSize - (beatNum + "").length(); i++) {
      paddedString += " ";
    }

    paddedString += beatNum;

    return paddedString;
  }

  /**
   * To represent a BeatString
   */
  protected class BeatString {
    private HashMap<String, PlayType> notes;
    private int octaveLow;
    private int octaveHigh;

    /**
     * The constructor
     * @param octaveLow is the lowest octave to be represented
     * @param octaveHigh is the highest octave to be represented
     */
    protected BeatString(int octaveLow, int octaveHigh) {
      this.notes = new HashMap<String, PlayType>();
      this.octaveLow = octaveLow;
      this.octaveHigh = octaveHigh;

      NoteEnum[] noteVals = NoteEnum.values();
      for (int i = octaveLow; i <= octaveHigh; i++) {
        for (int t = 0; t < noteVals.length; t++) {
          this.notes.put(noteVals[t].getValFormatted(5, i), PlayType.EMPTY);
        }
      }
    }

    /**
     * Sets the given note of the beat to the given playtype
     * @param pt is the playtype to set the note to
     */
    private void setNote(String noteRep, PlayType pt) {
      if (noteRep == null || pt == null) {
        throw new IllegalArgumentException("Null input given");
      }

      notes.replace(noteRep, pt);
    }

    /**
     * Returns the char representation of the given note in this beat
     * @return a char representing the given note in this beat
     */
    private PlayType getNotePlayType(String noteRep) {
      return notes.get(noteRep);
    }

    @Override
    public String toString() {
      String theReturn = "";

      NoteEnum[] noteVals = NoteEnum.values();
      for (int i = octaveLow; i <= this.octaveHigh; i++) {
        for (int t = 0; t < noteVals.length; t++) {
          if (this.notes.containsKey(noteVals[t].getValFormatted(5, i))) {
            theReturn += "  " + this.notes.get(noteVals[t].getValFormatted(5, i)).getVal() + "  ";
          }
          else {
            theReturn += "     ";
          }
        }
      }

      return theReturn;
    }
  }
}
