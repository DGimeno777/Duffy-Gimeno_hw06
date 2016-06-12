package cs3500.music.tests;

import org.junit.Test;

import cs3500.music.model.Note;
import cs3500.music.model.NoteEnum;
import cs3500.music.model.Octave;

import static org.junit.Assert.assertEquals;

public class OctaveTest {

  @Test
  public void testGetNum() {
    Octave o1 = new Octave(3, 10);
    Octave o2 = new Octave(5, 1);

    assertEquals(o1.getNum(), 3);
    assertEquals(o2.getNum(), 5);
  }


  @Test
  public void testAddRemoveNote() {
    Octave o1 = new Octave(3, 10);

    o1.addNote(new Note(NoteEnum.CSHARP, 3, 9, 1));
    o1.addNote(new Note(NoteEnum.B, 3, 0, 10));
    o1.addNote(new Note(NoteEnum.CSHARP, 3, 3, 3));
    assertEquals(o1.getNotes().toString(), "[Note: B Oct: 3 Beat: 0 Length: 10, Note: C# Oct: 3" +
            " Beat: 3 Length: 3, Note: C# Oct: 3 Beat: 9 Length: 1]");
    o1.addNote(new Note(NoteEnum.B, 3, 0, 10));
    assertEquals(o1.getNotes().toString(), "[Note: B Oct: 3 Beat: 0 Length: 10, Note: B Oct: 3" +
            " Beat: 0 Length: 10, Note: C# Oct: 3 Beat: 3 Length: 3," +
            " Note: C# Oct: 3 Beat: 9 Length: 1]");
    o1.removeNote(new Note(NoteEnum.B, 3, 0, 10));
    assertEquals(o1.getNotes().toString(), "[Note: B Oct: 3 Beat: 0 Length: 10, Note: C# Oct: 3" +
            " Beat: 3 Length: 3, Note: C# Oct: 3 Beat: 9 Length: 1]");
  }
}
