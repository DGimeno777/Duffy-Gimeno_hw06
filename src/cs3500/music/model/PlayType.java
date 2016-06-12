package cs3500.music.model;

/**
 * To represent a PlayType (how a note should be played)
 */
public enum PlayType {
  START('X', 2), CONTINUE('|', 1), EMPTY(' ', 0);

  private char val;
  private int printWeight;

  /**
   * The constructor
   * @param val is the char val
   * @param printWeight is the printweight of this Playtype
   */
  PlayType(char val, int printWeight) {
    this.val = val;
    this.printWeight = printWeight;
  }

  /**
   * Gets the val of this playtype
   * @return the val
   */
  public char getVal() {
    return this.val;
  }

  /**
   * gets the printweight of this playtype
   * @return the printweight
   */
  public int getPrintWeight() {
    return this.printWeight;
  }
}
