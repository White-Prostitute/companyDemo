package util;
import javax.sound.midi.*;

public class MediaUtil {
    public static void play() throws Exception{
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        Sequence sequence = new Sequence(Sequence.PPQ, 4);
        Track track = sequence.createTrack();
        ShortMessage noteOn = new ShortMessage(ShortMessage.NOTE_ON, 0, 50, 93);
        ShortMessage noteOff = new ShortMessage(ShortMessage.NOTE_OFF, 0, 50, 0);
        MidiEvent noteOnEvent = new MidiEvent(noteOn, 0);
        MidiEvent noteOffEvent = new MidiEvent(noteOff, 8);
        MidiEvent noteOnEvent1 = new MidiEvent(noteOn, 16);
        MidiEvent noteOffEvent1 = new MidiEvent(noteOff, 24);
        track.add(noteOnEvent);
        track.add(noteOffEvent);
        track.add(noteOnEvent1);
        track.add(noteOffEvent1);
        sequencer.setSequence(sequence);
        sequencer.start();
        Thread.sleep(12000);
        sequencer.stop();
        sequencer.close();
    }


}
