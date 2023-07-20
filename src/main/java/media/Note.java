package media;

import media.enums.NoteDurationEnum;

public class Note {

    //音高
    private int midi;

    //时长
    private NoteDurationEnum durationEnum;

    //音量
    private int volume;

    //升降音
    private int offset;

    public int getMidi() {
        return midi+ 12 * offset;
    }

    public void setMidi(int midi) {
        this.midi = midi;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public NoteDurationEnum getDurationEnum() {
        return durationEnum;
    }

    public void setDurationEnum(NoteDurationEnum durationEnum) {
        this.durationEnum = durationEnum;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
