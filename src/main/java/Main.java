import media.MediaPlayer;
import media.Note;
import media.builder.MediaBuilder;
import media.builder.NotesCsvLoader;
import media.builder.SimpleQuarterNoteBuilder;
import media.scale.major.*;
import media.scale.minor.CusMinor;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
//        byte[] bytes = new byte[]{62, 59, 43, 50, 62, 57, 54, 57, 62, 55};
//        List<Note> notes = NotesCsvLoader.loadFromPath("/Users/mac/Downloads/spring-demo/spring-demo/src/main/resources/music/test.csv",
//                new CScale());
        List<Note> notes = NotesCsvLoader.loadFromResource("/music/little_start.csv",new CusMinor(60));
        Sequence sequence = MediaBuilder.build(notes);
        MediaPlayer.play(sequence);

    }


    //小星星
    public static void test1() throws InvalidMidiDataException {
        Integer[] a = new Integer[]{
                1,1,5,5,6,6,5,0,
                4,4,3,3,2,2,1,0,
//                5,5,4,4,3,3,2,0,
//                5,5,4,4,3,3,2,0
        };
        List<Integer> list = Arrays.asList(a);
        SimpleQuarterNoteBuilder builder = SimpleQuarterNoteBuilder.getBuilder();
        List<Note> noteInC = builder.build(list, new CMajor());
        List<Note> noteInD = builder.build(list, new DMajor());
        List<Note> noteInE = builder.build(list, new EMajor());

        List<Note> notes = new ArrayList<>();
        notes.addAll(noteInC);
        notes.addAll(noteInD);
        notes.addAll(noteInE);
        Sequence sequence = MediaBuilder.build(notes);
        MediaPlayer.play(sequence);
    }

}
