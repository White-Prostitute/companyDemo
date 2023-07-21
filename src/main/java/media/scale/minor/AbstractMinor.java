package media.scale.minor;

import media.scale.AbstractScale;

public abstract class AbstractMinor extends AbstractScale implements Minor {
    protected AbstractMinor(int tonic) {
        super(interval, tonic);
    }
}
