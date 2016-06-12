package cs3500.music.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * To represent an IMusicModel
 */
public abstract class AMusicModel {

  protected HashMap<Integer, Octave> octaves;
  protected int beats;

  /**
   * The constructor
   * @param beats is the number of beats
   */
  public AMusicModel(int beats) {
    if (beats <= 0) {
      throw new IllegalArgumentException("Invalid number of beats given.");
    }
    this.octaves = new HashMap<Integer, Octave>();
    this.beats = beats;
  }
  /**
   * Adds the given note to the IMusicModel
   * @param n is the note to be added
   */
  public void addNote(Note n) {
    if (n == null || n.getBeat() >= beats || n.getOctave() > 10 || n.getOctave() < 1 ||
            n.getLength() + n.getBeat() > beats || n.getBeat() < 0) {
      throw new IllegalArgumentException("Invalid input given.");
    }

    if (octaves.containsKey(n.getOctave())) {
      Octave newOctave = octaves.get(n.getOctave());
      newOctave.addNote(n);
      octaves.replace(n.getOctave(), newOctave);
    }
    else {
      Octave newOctave = new Octave(n.getOctave(), this.beats);
      newOctave.addNote(n);
      octaves.put(n.getOctave(), newOctave);
    }
  }

  /**
   * Change?
   * make the return value a boolean of whether or not the note was removed
   */
  /**
   * Removes the given note to the AMusicModel
   * @param n is the note to be added
   */
  public void removeNote(Note n) {
    if (n == null || n.getBeat() >= beats || n.getOctave() < 1 ||
            n.getLength() + n.getBeat() > beats) {
      throw new IllegalArgumentException("Invalid input given.");
    }

    if (octaves.containsKey(n.getOctave())) {
      Octave newOctave = octaves.get(n.getOctave());
      newOctave.removeNote(n);
      octaves.replace(n.getOctave(), newOctave);
      if (octaves.get(n.getOctave()).getNotes().size() == 0) {
        octaves.remove(n.getOctave());
      }
    }
  }

  /**
   * Combines this AMusicModel and the given one to create an AMusicModel with notes from this
   * AMusicModel then of the given MusicModel
   * @param in is the AMusicModel to be combined with
   * @return a new AMusicModel that is consecutive
   */
  public AMusicModel makeMusicModelConsecutive(AMusicModel in) {
    AMusicModel newMM = new StandardMusicModel(this.beats + in.beats);

    for (Iterator<Integer> i = this.octaves.keySet().iterator();
         i.hasNext();) {
      int currInt = i.next();
      Octave currOctave = this.octaves.get(currInt);
      ArrayList<Note> currOctaveNotes = currOctave.getNotes();
      for (int t = 0; t < currOctaveNotes.size(); t++) {
        Note tempNote = currOctaveNotes.get(t);
        Note putNote = new Note(tempNote.getNoteType(), tempNote.getOctave(),
                tempNote.getBeat(), tempNote.getLength());
        newMM.addNote(putNote);
      }
    }

    for (Iterator<Integer> i = in.octaves.keySet().iterator();
         i.hasNext();) {
      int currInt = i.next();
      Octave currOctave = in.octaves.get(currInt);
      ArrayList<Note> currOctaveNotes = currOctave.getNotes();

      for (int t = 0; t < currOctaveNotes.size(); t++) {
        Note tempNote = currOctaveNotes.get(t);
        Note putNote = new Note(tempNote.getNoteType(), tempNote.getOctave(),
                tempNote.getBeat() + this.beats, tempNote.getLength());
        newMM.addNote(putNote);
      }
    }
    return newMM;
  }

  /**
   * Combines this AMusicModel and the given one to create a AMusicModel with notes from this
   * AMusicModel inline with those of the given AMusicModel
   * @param in is the AMusicModel to be combined with
   * @return a new AMusicModel that is simultaneous
   */
  public AMusicModel makeMusicModelSimultaneous(AMusicModel in) {
    AMusicModel newMM;
    if (this.beats > in.beats) {
      newMM = new StandardMusicModel(this.beats);
    }
    else {
      newMM = new StandardMusicModel(in.beats);
    }

    for (Iterator<Integer> i = this.octaves.keySet().iterator();
         i.hasNext();) {
      int currInt = i.next();
      Octave currOctave = this.octaves.get(currInt);
      ArrayList<Note> currOctaveNotes = currOctave.getNotes();
      for (int t = 0; t < currOctaveNotes.size(); t++) {
        Note tempNote = currOctaveNotes.get(t);
        Note putNote = new Note(tempNote.getNoteType(), tempNote.getOctave(),
                tempNote.getBeat(), tempNote.getLength());
        newMM.addNote(putNote);
      }
    }

    for (Iterator<Integer> i = in.octaves.keySet().iterator();
         i.hasNext();) {
      int currInt = i.next();
      Octave currOctave = in.octaves.get(currInt);
      ArrayList<Note> currOctaveNotes = currOctave.getNotes();
      for (int t = 0; t < currOctaveNotes.size(); t++) {
        Note tempNote = currOctaveNotes.get(t);
        Note putNote = new Note(tempNote.getNoteType(), tempNote.getOctave(),
                tempNote.getBeat(), tempNote.getLength());
        newMM.addNote(putNote);
      }
    }
    return newMM;
  }
}
