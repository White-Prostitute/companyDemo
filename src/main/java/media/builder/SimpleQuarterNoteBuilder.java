package media.builder;

import media.Note;
import media.enums.NoteDurationEnum;
import media.major.Major;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuarterNoteBuilder implements NoteBuilder{

    private static final int DEFAULT_VOLUME = 100;

    static SimpleQuarterNoteBuilder builder;

    public static SimpleQuarterNoteBuilder getBuilder(){
        if(builder == null){
            builder = new SimpleQuarterNoteBuilder();
        }
        return builder;
    }

    @Override
    public List<Note> build(List<?> list, Major major) {
        List<Note> res = new ArrayList<>();
        for (Object o : list) {
            if(o instanceof Integer){
                Note note = new Note();
                note.setMidi(major.convert((Integer) o));
                note.setVolume(DEFAULT_VOLUME);
                note.setDurationEnum(NoteDurationEnum.EIGHTH);
                res.add(note);
            }else{
                throw new IllegalArgumentException("only receive number");
            }
        }
        return res;
    }
}
