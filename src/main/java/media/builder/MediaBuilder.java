package media.builder;

import media.Note;

import javax.sound.midi.*;
import java.util.List;

public class MediaBuilder {

    public static Sequence build(List<Note> notes) throws InvalidMidiDataException {
        Sequence sequence = new Sequence(Sequence.PPQ, 4);
        Track track = sequence.createTrack();
        int tick = 0;
        for (Note note : notes) {
            System.out.print(note.getMidi() + " ");
            ShortMessage noteOn = new ShortMessage(ShortMessage.NOTE_ON, 0, note.getMidi(), note.getVolume());
            ShortMessage noteOff = new ShortMessage(ShortMessage.NOTE_OFF, 0, note.getMidi(), 0);
            MidiEvent noteOnEvent = new MidiEvent(noteOn, tick);
            MidiEvent noteOffEvent = new MidiEvent(noteOff, tick+note.getDurationEnum().getDuration());
            tick += note.getDurationEnum().getDuration();
            track.add(noteOnEvent);
            track.add(noteOffEvent);
        }
        return sequence;
    }

}
