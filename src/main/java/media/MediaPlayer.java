package media;

import javax.sound.midi.*;

public class MediaPlayer {

    public static void play(Sequence sequence){
        try (Sequencer sequencer = MidiSystem.getSequencer()) {
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();
            while (sequencer.isRunning()){
                Thread.sleep(1000);
            }
            sequencer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
