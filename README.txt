Daniel Gimeno
OOD hw05 README

abstract class AMusicModel:
- This is abstract class for a MusicModel in my program. It has pre-implemented methods for add,
  remove, combining to simultaneous, and combining to consecutive as well as imperative instance
  variables for octaves and the number of beats . I decided to use an abstract class instead of an
  interface due to the makeSimultaneous and makeConsecutive methods which were easier and clearer
  to make with known variables in the abstract class.

- The octaves instance variable is a hashmap of key Integer and value Octave (class that I'll
  review later). I decided to use a HashMap because I wasn't sure how many Octaves would be wanted
  and this way I could add them when needed and delete them just as easily to not have them
  displayed when the last note of an octave was removed.

- The beats instance variable is the number of beats in the AMusicModel. 

class StandardMusicModel:
- This is the standard MusicModel that can be used for making an AMusicModel. It has an implemented
  toString method that will present all of the current notes. It also had protected methods
  getLowestOctave and getHighestOctave that are used by the toString to determine what octaves
  need to be drawn.

- The toString method in this class is primarily done using a BeatViewerString object. Since
  drawing is a fairly complicated process, I wanted a way to make it so that anyone could put notes
  into a new BeatViewerString object (more on this later) and be able to get a string
  representation of a MusicModel. The toString method of StandardMusicModel lets you skip making a
  new object on the side and does it for you in its own method.

class Note:
- This is the Note class for any type of Note that you would want to put into your MusicModel. The
  class is fairly simple having a NoteEnum (the tone of the note), which octave the note is in,
  what beat the note is in, and the length of the note. I decided to have all of these stored so
  that there was no confusion on where a note was from or where it was supposed to be going instead
  of the entirely mechanical sense of just a tone and a length.

- I also decided to implement my own toString for this class and used it a couple times as a
  equals(Note) method when comparing the strings of two Notes to see if they were the same.

class Octave:
- The Octave class is a collection of Beats that ultimately store Notes. I mainly use it as a go
  between with Beats and MusicModel to keep the amount of data being stored lower. Since we don't
  know the number of octaves that are necessary (possibly infinite) it's good to have a class like
  octave to sort out what data is necessary to store and what doesn't need to be created.

- The Octave class has addNote and removeNote methods as well as a getNotes method. The addNote and
  removeNote are fairly straightforward reasoning-wise. The reason I made the getNotes function was
  that Octave acts as a go between with the Beat class (that actually contains Notes) and the
  MusicModel class.

class Beat:
- The Beat class is similar to the Octave class but instead of having all of the beats it contains
  the notes for just one of them. It has add and remove methods and a getBeatNum and getNotes for
  objects that want to access its information.
 
enum PlayType:
- The PlayType enum is used to represent the types of plays a Note can be. The types are empty
  (not being played), start (the start of the note), and continue (if the note is being continued)
  and storing them as characters.

- The PlayType enum also has a printweight value that is used by the BeatViewerString.

enum NoteEnum:
- The NoteEnum enum is a collection of the tones that a note can have.

- It also has a getValFormatted method that shows the value of the NoteEnum buffered to the given
  value with the given octave.

class BeatViewerString:
- I made this mainly so that someone using this library could make a String representation for any
  type of AMusicModel and all that needed to be done is create a new variable.

- While this does use more data than a toString just using the data of the MusicModel, it makes it
  way easier for anyone who wants a String representation of a MusicModel. The one catch is that
  it does not have a removeNote method, but the BeatViewerString was not created to be used this
  way. It was made so that someone with all of the notes they want can make one, input the notes,
  and get a string representation.

- The BeatViewer string also has a personal BeatString class that is used for storage purposes and
  helps to break the toString creationg process into smaller steps.
