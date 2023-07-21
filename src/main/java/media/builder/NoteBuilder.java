package media.builder;

import media.Note;
import media.scale.Scale;

import java.util.List;

public interface NoteBuilder {

    List<Note> build(List<?> list, Scale scale);


}
