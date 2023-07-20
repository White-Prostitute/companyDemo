package media.builder;

import media.Note;
import media.major.Major;

import java.util.List;

public interface NoteBuilder {

    List<Note> build(List<?> list, Major major);


}
