package media.scale;

public abstract class AbstractScale implements Scale{

    private final int[] interval;

    private final int tonic;

    protected AbstractScale(int[] interval, int tonic){
        this.interval = interval;
        this.tonic = tonic;
    }

    @Override
    public int convert(int note) {
        return note > 0 ? tonic + interval[note-1] : 0;
    }
}
