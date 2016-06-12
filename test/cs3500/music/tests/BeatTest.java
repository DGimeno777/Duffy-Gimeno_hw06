package cs3500.music.tests;

import org.junit.Test;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.NoteEnum;

import static org.junit.Assert.assertEquals;

public class BeatTest {

  @Test
  public void testAddRemoveNote() {
    Beat b1 = new Beat(0);
    b1.addNote(new Note(NoteEnum.A, 4, 0, 3));
    b1.addNote(new Note(NoteEnum.D, 3, 0, 5));
    assertEquals(b1.getNotes().toString(),
            "[Note: A Oct: 4 Beat: 0 Length: 3, Note: D Oct: 3 Beat: 0 Length: 5]");

    b1.addNote(new Note(NoteEnum.D, 3, 0, 5));
    assertEquals(b1.getNotes().toString(),
            "[Note: A Oct: 4 Beat: 0 Length: 3, Note: D Oct: 3 Beat: 0 Length: 5, Note: D Oct: 3" +
                    " Beat: 0 Length: 5]");

    b1.removeNote(new Note(NoteEnum.D, 3, 0, 5));
    assertEquals(b1.getNotes().toString(),
            "[Note: A Oct: 4 Beat: 0 Length: 3, Note: D Oct: 3 Beat: 0 Length: 5]");

    b1.addNote(new Note(NoteEnum.DSHARP, 5, 0, 2));
    assertEquals(b1.getNotes().toString(),
            "[Note: A Oct: 4 Beat: 0 Length: 3, Note: D Oct: 3 Beat: 0 Length: 5, Note: D#" +
                    " Oct: 5 Beat: 0 Length: 2]");

    b1.removeNote(new Note(NoteEnum.A, 4, 0, 3));
    assertEquals(b1.getNotes().toString(),
            "[Note: D Oct: 3 Beat: 0 Length: 5, Note: D# Oct: 5 Beat: 0 Length: 2]");
  }

  @Test
  public void getBeatNum() {
    Beat b1 = new Beat(0);
    Beat b2 = new Beat(3);
    Beat b3 = new Beat(8);

    assertEquals(b1.getBeatNum(), 0);
    assertEquals(b2.getBeatNum(), 3);
    assertEquals(b3.getBeatNum(), 8);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddError1() {
    Beat b = new Beat(1);
    b.addNote(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddError2() {
    Beat b = new Beat(1);
    b.addNote(new Note(NoteEnum.GSHARP, 4, 3, 5));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveError1() {
    Beat b = new Beat(1);
    b.removeNote(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveError2() {
    Beat b = new Beat(1);
    b.removeNote(new Note(NoteEnum.GSHARP, 4, 3, 5));
  }
}
