package media.scale.major;

import media.scale.AbstractScale;

public abstract class AbstractMajor extends AbstractScale implements Major{
    AbstractMajor(int tonic){
        super(interval, tonic);
    }
}
