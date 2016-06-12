package cs3500.music.tests;

import org.junit.Test;

import cs3500.music.model.AMusicModel;
import cs3500.music.model.Note;
import cs3500.music.model.NoteEnum;
import cs3500.music.model.StandardMusicModel;

import static org.junit.Assert.assertEquals;

/**
 * Created by Danny on 6/10/2016.
 */
public class StandardMusicModelTest {

  @Test
  public void testAddRemove() {
    AMusicModel mm1 = new StandardMusicModel(10);
    AMusicModel mm2 = new StandardMusicModel(15);
    mm1.addNote(new Note(NoteEnum.A, 1, 4, 1));
    mm1.addNote(new Note(NoteEnum.E, 2, 3, 3));
    mm1.addNote(new Note(NoteEnum.DSHARP, 2, 5, 5));
    assertEquals(mm1.toString(), "   E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1   "
            +
            "E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            "0                                                                                   "
            +
            "                                     \n" +
            "1                                                                                  " +
            "                                      \n" +
            "2                                                                                  " +
            "                                      \n" +
            "3                                                              X                   " +
            "                                      \n" +
            "4                           X                                  |                   " +
            "                                      \n" +
            "5                                                              |                   " +
            "                                   X  \n" +
            "6                                                                                  " +
            "                                   |  \n" +
            "7                                                                                  " +
            "                                   |  \n" +
            "8                                                                                  " +
            "                                   |  \n" +
            "9                                                                                  " +
            "                                   |  ");
    mm2.addNote(new Note(NoteEnum.DSHARP, 2, 3, 5));
    mm2.addNote(new Note(NoteEnum.B, 1, 1, 1));
    mm2.addNote(new Note(NoteEnum.CSHARP, 1, 0, 15));
    assertEquals(mm2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1" +
            "   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                               X                                " +
            "                                        \n" +
            " 1                                     X         |                                " +
            "                                        \n" +
            " 2                                               |                                " +
            "                                        \n" +
            " 3                                               |                                " +
            "                                     X  \n" +
            " 4                                               |                                " +
            "                                     |  \n" +
            " 5                                               |                                " +
            "                                     |  \n" +
            " 6                                               |                                " +
            "                                     |  \n" +
            " 7                                               |                                " +
            "                                     |  \n" +
            " 8                                               |                                " +
            "                                        \n" +
            " 9                                               |                                " +
            "                                        \n" +
            "10                                               |                                " +
            "                                        \n" +
            "11                                               |                                " +
            "                                        \n" +
            "12                                               |                                " +
            "                                        \n" +
            "13                                               |                                " +
            "                                        \n" +
            "14                                               |                                " +
            "                                        ");
    mm1.removeNote(new Note(NoteEnum.A, 1, 4, 1));
    assertEquals(mm1.toString(), "   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n"
            +
            "0                                                            \n" +
            "1                                                            \n" +
            "2                                                            \n" +
            "3  X                                                         \n" +
            "4  |                                                         \n" +
            "5  |                                                      X  \n" +
            "6                                                         |  \n" +
            "7                                                         |  \n" +
            "8                                                         |  \n" +
            "9                                                         |  ");
  }

  @Test
  public void testMakeMusicModelConsecutive() {
    AMusicModel mm1 = new StandardMusicModel(10);
    AMusicModel mm2 = new StandardMusicModel(15);
    mm1.addNote(new Note(NoteEnum.A, 1, 4, 1));
    mm1.addNote(new Note(NoteEnum.E, 2, 3, 3));
    mm1.addNote(new Note(NoteEnum.DSHARP, 2, 5, 5));
    assertEquals(mm1.toString(), "   E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1   "
            +
            "E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            "0                                                                                   "
            +
            "                                     \n" +
            "1                                                                                  " +
            "                                      \n" +
            "2                                                                                  " +
            "                                      \n" +
            "3                                                              X                   " +
            "                                      \n" +
            "4                           X                                  |                   " +
            "                                      \n" +
            "5                                                              |                   " +
            "                                   X  \n" +
            "6                                                                                  " +
            "                                   |  \n" +
            "7                                                                                  " +
            "                                   |  \n" +
            "8                                                                                  " +
            "                                   |  \n" +
            "9                                                                                  " +
            "                                   |  ");
    mm2.addNote(new Note(NoteEnum.DSHARP, 2, 3, 5));
    mm2.addNote(new Note(NoteEnum.B, 1, 1, 1));
    mm2.addNote(new Note(NoteEnum.CSHARP, 1, 0, 15));
    assertEquals(mm2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1" +
            "   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                               X                                " +
            "                                        \n" +
            " 1                                     X         |                                " +
            "                                        \n" +
            " 2                                               |                                " +
            "                                        \n" +
            " 3                                               |                                " +
            "                                     X  \n" +
            " 4                                               |                                " +
            "                                     |  \n" +
            " 5                                               |                                " +
            "                                     |  \n" +
            " 6                                               |                                " +
            "                                     |  \n" +
            " 7                                               |                                " +
            "                                     |  \n" +
            " 8                                               |                                " +
            "                                        \n" +
            " 9                                               |                                " +
            "                                        \n" +
            "10                                               |                                " +
            "                                        \n" +
            "11                                               |                                " +
            "                                        \n" +
            "12                                               |                                " +
            "                                        \n" +
            "13                                               |                                " +
            "                                        \n" +
            "14                                               |                                " +
            "                                        ");
    AMusicModel mm1then2 = mm1.makeMusicModelConsecutive(mm2);
    assertEquals(mm1then2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1" +
            "  D#1" +
            "   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                                                                 " +
            "                                       \n" +
            " 1                                                                                 " +
            "                                       \n" +
            " 2                                                                                 " +
            "                                       \n" +
            " 3                                                              X                  " +
            "                                       \n" +
            " 4                           X                                  |                  " +
            "                                       \n" +
            " 5                                                              |                  " +
            "                                    X  \n" +
            " 6                                                                                 " +
            "                                    |  \n" +
            " 7                                                                                 " +
            "                                    |  \n" +
            " 8                                                                                 " +
            "                                    |  \n" +
            " 9                                                                                 " +
            "                                    |  \n" +
            "10                                               X                                 " +
            "                                       \n" +
            "11                                     X         |                                 " +
            "                                       \n" +
            "12                                               |                                 " +
            "                                       \n" +
            "13                                               |                                 " +
            "                                    X  \n" +
            "14                                               |                                 " +
            "                                    |  \n" +
            "15                                               |                                 " +
            "                                    |  \n" +
            "16                                               |                                 " +
            "                                    |  \n" +
            "17                                               |                                 " +
            "                                    |  \n" +
            "18                                               |                                 " +
            "                                       \n" +
            "19                                               |                                 " +
            "                                       \n" +
            "20                                               |                                 " +
            "                                       \n" +
            "21                                               |                                 " +
            "                                       \n" +
            "22                                               |                                 " +
            "                                       \n" +
            "23                                               |                                 " +
            "                                       \n" +
            "24                                               |                                 " +
            "                                       ");
    AMusicModel combineConsecutives = mm1then2.makeMusicModelConsecutive(mm1then2);
    assertEquals(combineConsecutives.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1" +
            "  C#1   D1  D#1   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                                                                 " +
            "                                       \n" +
            " 1                                                                                 " +
            "                                       \n" +
            " 2                                                                                 " +
            "                                       \n" +
            " 3                                                              X                  " +
            "                                       \n" +
            " 4                           X                                  |                  " +
            "                                       \n" +
            " 5                                                              |                  " +
            "                                    X  \n" +
            " 6                                                                                 " +
            "                                    |  \n" +
            " 7                                                                                 " +
            "                                    |  \n" +
            " 8                                                                                 " +
            "                                    |  \n" +
            " 9                                                                                 " +
            "                                    |  \n" +
            "10                                               X                                 " +
            "                                       \n" +
            "11                                     X         |                                 " +
            "                                       \n" +
            "12                                               |                                 " +
            "                                       \n" +
            "13                                               |                                 " +
            "                                    X  \n" +
            "14                                               |                                 " +
            "                                    |  \n" +
            "15                                               |                                 " +
            "                                    |  \n" +
            "16                                               |                                 " +
            "                                    |  \n" +
            "17                                               |                                 " +
            "                                    |  \n" +
            "18                                               |                                 " +
            "                                       \n" +
            "19                                               |                                 " +
            "                                       \n" +
            "20                                               |                                 " +
            "                                       \n" +
            "21                                               |                                 " +
            "                                       \n" +
            "22                                               |                                 " +
            "                                       \n" +
            "23                                               |                                 " +
            "                                       \n" +
            "24                                               |                                 " +
            "                                       \n" +
            "25                                                                                 " +
            "                                       \n" +
            "26                                                                                 " +
            "                                       \n" +
            "27                                                                                 " +
            "                                       \n" +
            "28                                                              X                  " +
            "                                       \n" +
            "29                           X                                  |                  " +
            "                                       \n" +
            "30                                                              |                  " +
            "                                    X  \n" +
            "31                                                                                 " +
            "                                    |  \n" +
            "32                                                                                 " +
            "                                    |  \n" +
            "33                                                                                 " +
            "                                    |  \n" +
            "34                                                                                 " +
            "                                    |  \n" +
            "35                                               X                                 " +
            "                                       \n" +
            "36                                     X         |                                 " +
            "                                       \n" +
            "37                                               |                                 " +
            "                                       \n" +
            "38                                               |                                 " +
            "                                    X  \n" +
            "39                                               |                                 " +
            "                                    |  \n" +
            "40                                               |                                 " +
            "                                    |  \n" +
            "41                                               |                                 " +
            "                                    |  \n" +
            "42                                               |                                 " +
            "                                    |  \n" +
            "43                                               |                                 " +
            "                                       \n" +
            "44                                               |                                 " +
            "                                       \n" +
            "45                                               |                                 " +
            "                                       \n" +
            "46                                               |                                 " +
            "                                       \n" +
            "47                                               |                                 " +
            "                                       \n" +
            "48                                               |                                 " +
            "                                       \n" +
            "49                                               |                                 " +
            "                                       ");
    AMusicModel simulsame = mm1.makeMusicModelSimultaneous(mm1then2);
    assertEquals(simulsame.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1" +
            "  D#1   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                                                                 " +
            "                                       \n" +
            " 1                                                                                 " +
            "                                       \n" +
            " 2                                                                                 " +
            "                                       \n" +
            " 3                                                              X                  " +
            "                                       \n" +
            " 4                           X                                  |                  " +
            "                                       \n" +
            " 5                                                              |                  " +
            "                                    X  \n" +
            " 6                                                                                 " +
            "                                    |  \n" +
            " 7                                                                                 " +
            "                                    |  \n" +
            " 8                                                                                 " +
            "                                    |  \n" +
            " 9                                                                                 " +
            "                                    |  \n" +
            "10                                               X                                 " +
            "                                       \n" +
            "11                                     X         |                                 " +
            "                                       \n" +
            "12                                               |                                 " +
            "                                       \n" +
            "13                                               |                                 " +
            "                                    X  \n" +
            "14                                               |                                 " +
            "                                    |  \n" +
            "15                                               |                                 " +
            "                                    |  \n" +
            "16                                               |                                 " +
            "                                    |  \n" +
            "17                                               |                                 " +
            "                                    |  \n" +
            "18                                               |                                 " +
            "                                       \n" +
            "19                                               |                                 " +
            "                                       \n" +
            "20                                               |                                 " +
            "                                       \n" +
            "21                                               |                                 " +
            "                                       \n" +
            "22                                               |                                 " +
            "                                       \n" +
            "23                                               |                                 " +
            "                                       \n" +
            "24                                               |                                 " +
            "                                       ");
    mm1then2.removeNote(new Note(NoteEnum.E, 2, 3, 3));
    assertEquals(mm1then2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1" +
            "  D#1   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                                                                " +
            "                                        \n" +
            " 1                                                                                " +
            "                                        \n" +
            " 2                                                                                " +
            "                                        \n" +
            " 3                                                                                " +
            "                                        \n" +
            " 4                           X                                                    " +
            "                                        \n" +
            " 5                                                                                " +
            "                                     X  \n" +
            " 6                                                                                " +
            "                                     |  \n" +
            " 7                                                                                " +
            "                                     |  \n" +
            " 8                                                                                " +
            "                                     |  \n" +
            " 9                                                                                " +
            "                                     |  \n" +
            "10                                               X                                " +
            "                                        \n" +
            "11                                     X         |                                " +
            "                                        \n" +
            "12                                               |                                " +
            "                                        \n" +
            "13                                               |                                " +
            "                                     X  \n" +
            "14                                               |                                " +
            "                                     |  \n" +
            "15                                               |                                " +
            "                                     |  \n" +
            "16                                               |                                " +
            "                                     |  \n" +
            "17                                               |                                " +
            "                                     |  \n" +
            "18                                               |                                " +
            "                                        \n" +
            "19                                               |                                " +
            "                                        \n" +
            "20                                               |                                " +
            "                                        \n" +
            "21                                               |                                " +
            "                                        \n" +
            "22                                               |                                " +
            "                                        \n" +
            "23                                               |                                " +
            "                                        \n" +
            "24                                               |                                " +
            "                                        ");
    assertEquals(mm1.toString(), "   E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1   "
            +
            "E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            "0                                                                                   "
            +
            "                                     \n" +
            "1                                                                                  " +
            "                                      \n" +
            "2                                                                                  " +
            "                                      \n" +
            "3                                                              X                   " +
            "                                      \n" +
            "4                           X                                  |                   " +
            "                                      \n" +
            "5                                                              |                   " +
            "                                   X  \n" +
            "6                                                                                  " +
            "                                   |  \n" +
            "7                                                                                  " +
            "                                   |  \n" +
            "8                                                                                  " +
            "                                   |  \n" +
            "9                                                                                  " +
            "                                   |  ");
  }

  @Test
  public void testMakeMusicModelSimultaneous() {
    AMusicModel mm1 = new StandardMusicModel(10);
    AMusicModel mm2 = new StandardMusicModel(15);
    mm1.addNote(new Note(NoteEnum.A, 1, 4, 1));
    mm1.addNote(new Note(NoteEnum.E, 2, 3, 3));
    mm1.addNote(new Note(NoteEnum.DSHARP, 2, 5, 5));
    assertEquals(mm1.toString(), "   E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1   "
            +
            "E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            "0                                                                                   "
            +
            "                                     \n" +
            "1                                                                                  " +
            "                                      \n" +
            "2                                                                                  " +
            "                                      \n" +
            "3                                                              X                   " +
            "                                      \n" +
            "4                           X                                  |                   " +
            "                                      \n" +
            "5                                                              |                   " +
            "                                   X  \n" +
            "6                                                                                  " +
            "                                   |  \n" +
            "7                                                                                  " +
            "                                   |  \n" +
            "8                                                                                  " +
            "                                   |  \n" +
            "9                                                                                  " +
            "                                   |  ");
    mm2.addNote(new Note(NoteEnum.DSHARP, 2, 3, 5));
    mm2.addNote(new Note(NoteEnum.B, 1, 1, 1));
    mm2.addNote(new Note(NoteEnum.CSHARP, 1, 0, 15));
    assertEquals(mm2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1" +
            "   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                               X                                " +
            "                                        \n" +
            " 1                                     X         |                                " +
            "                                        \n" +
            " 2                                               |                                " +
            "                                        \n" +
            " 3                                               |                                " +
            "                                     X  \n" +
            " 4                                               |                                " +
            "                                     |  \n" +
            " 5                                               |                                " +
            "                                     |  \n" +
            " 6                                               |                                " +
            "                                     |  \n" +
            " 7                                               |                                " +
            "                                     |  \n" +
            " 8                                               |                                " +
            "                                        \n" +
            " 9                                               |                                " +
            "                                        \n" +
            "10                                               |                                " +
            "                                        \n" +
            "11                                               |                                " +
            "                                        \n" +
            "12                                               |                                " +
            "                                        \n" +
            "13                                               |                                " +
            "                                        \n" +
            "14                                               |                                " +
            "                                        ");
    AMusicModel mm1and2 = mm1.makeMusicModelSimultaneous(mm2);
    assertEquals(mm1and2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1" +
            "  D#1   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                               X                               " +
            "                                         \n" +
            " 1                                     X         |                               " +
            "                                         \n" +
            " 2                                               |                               " +
            "                                         \n" +
            " 3                                               |              X                " +
            "                                      X  \n" +
            " 4                           X                   |              |                " +
            "                                      |  \n" +
            " 5                                               |              |                " +
            "                                      X  \n" +
            " 6                                               |                               " +
            "                                      |  \n" +
            " 7                                               |                               " +
            "                                      |  \n" +
            " 8                                               |                               " +
            "                                      |  \n" +
            " 9                                               |                               " +
            "                                      |  \n" +
            "10                                               |                               " +
            "                                         \n" +
            "11                                               |                               " +
            "                                         \n" +
            "12                                               |                               " +
            "                                         \n" +
            "13                                               |                               " +
            "                                         \n" +
            "14                                               |                               " +
            "                                         ");
    mm1and2.addNote(new Note(NoteEnum.CSHARP, 2, 4, 9));
    mm1and2.removeNote(new Note(NoteEnum.B, 1, 1, 1));
    assertEquals(mm1and2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1" +
            "  D#1   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                               X                               " +
            "                                         \n" +
            " 1                                               |                               " +
            "                                         \n" +
            " 2                                               |                               " +
            "                                         \n" +
            " 3                                               |              X                " +
            "                                      X  \n" +
            " 4                           X                   |              |                " +
            "                            X         |  \n" +
            " 5                                               |              |                " +
            "                            |         X  \n" +
            " 6                                               |                               " +
            "                            |         |  \n" +
            " 7                                               |                               " +
            "                            |         |  \n" +
            " 8                                               |                               " +
            "                            |         |  \n" +
            " 9                                               |                               " +
            "                            |         |  \n" +
            "10                                               |                               " +
            "                            |            \n" +
            "11                                               |                               " +
            "                            |            \n" +
            "12                                               |                               " +
            "                            |            \n" +
            "13                                               |                               " +
            "                                         \n" +
            "14                                               |                               " +
            "                                         ");

    assertEquals(mm2.toString(), "    E1   F1  F#1   G1  G#1   A1  A#1   B1   C1  C#1   D1  D#1" +
            "   E2   F2  F#2   G2  G#2   A2  A#2   B2   C2  C#2   D2  D#2 \n" +
            " 0                                               X                                " +
            "                                        \n" +
            " 1                                     X         |                                " +
            "                                        \n" +
            " 2                                               |                                " +
            "                                        \n" +
            " 3                                               |                                " +
            "                                     X  \n" +
            " 4                                               |                                " +
            "                                     |  \n" +
            " 5                                               |                                " +
            "                                     |  \n" +
            " 6                                               |                                " +
            "                                     |  \n" +
            " 7                                               |                                " +
            "                                     |  \n" +
            " 8                                               |                                " +
            "                                        \n" +
            " 9                                               |                                " +
            "                                        \n" +
            "10                                               |                                " +
            "                                        \n" +
            "11                                               |                                " +
            "                                        \n" +
            "12                                               |                                " +
            "                                        \n" +
            "13                                               |                                " +
            "                                        \n" +
            "14                                               |                                " +
            "                                        ");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddError1() {
    AMusicModel mm = new StandardMusicModel(1);
    mm.addNote(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddError2() {
    AMusicModel mm = new StandardMusicModel(1);
    mm.addNote(new Note(NoteEnum.CSHARP, 11, 0, 1));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddError3() {
    AMusicModel mm = new StandardMusicModel(5);
    mm.addNote(new Note(NoteEnum.A, -3, 3, 4));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveError1() {
    AMusicModel mm = new StandardMusicModel(1);
    mm.addNote(new Note(NoteEnum.CSHARP, 11, 0, 1));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveError2() {
    AMusicModel mm = new StandardMusicModel(5);
    mm.addNote(new Note(NoteEnum.A, -3, 3, 4));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveError3() {
    AMusicModel mm = new StandardMusicModel(1);
    mm.addNote(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInitError1() {
    AMusicModel mm = new StandardMusicModel(0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInitError2() {
    AMusicModel mm = new StandardMusicModel(-13);
  }
}
