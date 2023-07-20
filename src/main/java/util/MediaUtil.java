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

    public static void test1() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        Sequence sequence = new Sequence(Sequence.PPQ, 4);
        Track track = sequence.createTrack();
        for (int i = 0; i < 30; i++) {
            ShortMessage noteOn = new ShortMessage(ShortMessage.NOTE_ON, 0, 30+i, 93+i);
            ShortMessage noteOff = new ShortMessage(ShortMessage.NOTE_OFF, 0, 30+i, 0);
            MidiEvent noteOnEvent = new MidiEvent(noteOn, 2*i*2);
            MidiEvent noteOffEvent = new MidiEvent(noteOff, 2*(2*i+1));
            track.add(noteOnEvent);
            track.add(noteOffEvent);
        }
        sequencer.setSequence(sequence);
        sequencer.start();
        while (sequencer.isRunning()){
            Thread.sleep(1000);
        }
        sequencer.stop();
        sequencer.close();
    }

    public static void playWithArrayData(byte[] bytes) throws Exception{
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        Sequence sequence = new Sequence(Sequence.PPQ, 36);
        Track track = sequence.createTrack();
        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i] == -128)continue;
            byte b = (byte) Math.abs(bytes[i]);
            ShortMessage noteOn = new ShortMessage(ShortMessage.NOTE_ON, 0, b, 100);
            ShortMessage noteOff = new ShortMessage(ShortMessage.NOTE_OFF, 0, b, 0);
            MidiEvent noteOnEvent = new MidiEvent(noteOn, 16*i*2);
            MidiEvent noteOffEvent = new MidiEvent(noteOff, 16*i*2+32);
            track.add(noteOnEvent);
            track.add(noteOffEvent);
        }

        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        Instrument[] instruments = synth.getAvailableInstruments();
        synth.loadInstrument(instruments[0]);

        sequencer.setSequence(sequence);
        sequencer.start();
        while (sequencer.isRunning()){
            Thread.sleep(1000);
        }
        sequencer.stop();
        sequencer.close();
    }

}
