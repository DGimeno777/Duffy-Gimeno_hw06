package cs3500.music.tests;

import org.junit.Test;
import cs3500.music.model.Note;
import cs3500.music.model.NoteEnum;
import static org.junit.Assert.assertEquals;

public class NoteTest {

  Note n1 = new Note(NoteEnum.A, 3, 5, 2);
  Note n2 = new Note(NoteEnum.FSHARP, 2, 1, 7);
  Note n3 = new Note(NoteEnum.G, 5, 5, 5);

  @Test
  public void testToString() {
    assertEquals(n1.toString(), "Note: A Oct: 3 Beat: 5 Length: 2");
    assertEquals(n2.toString(), "Note: F# Oct: 2 Beat: 1 Length: 7");
    assertEquals(n3.toString(), "Note: G Oct: 5 Beat: 5 Length: 5");
  }

  @Test
  public void testGetNoteType() {
    assertEquals(n1.getNoteType(), NoteEnum.A);
    assertEquals(n2.getNoteType(), NoteEnum.FSHARP);
    assertEquals(n3.getNoteType(), NoteEnum.G);
  }

  @Test
  public void testGetLength() {
    assertEquals(n1.getLength(), 2);
    assertEquals(n2.getLength(), 7);
    assertEquals(n3.getLength(), 5);
  }

  @Test
  public void testGetOctave() {
    assertEquals(n1.getOctave(), 3);
    assertEquals(n2.getOctave(), 2);
    assertEquals(n3.getOctave(), 5);
  }

  @Test
  public void testGetBeat() {
    assertEquals(n1.getBeat(), 5);
    assertEquals(n2.getBeat(), 1);
    assertEquals(n3.getBeat(), 5);
  }
}
