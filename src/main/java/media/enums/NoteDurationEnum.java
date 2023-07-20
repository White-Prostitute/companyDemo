package media.enums;

public enum NoteDurationEnum {

    QUARTER(8),EIGHTH(4),SIXTEEN(2);

    final int duration;

    NoteDurationEnum(int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return this.duration;
    }

}
