package media.major;

import java.util.HashMap;
import java.util.Map;

public class GMajor implements Major{

    private static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 55);
        map.put(2, 57);
        map.put(3, 59);
        map.put(4, 60);
        map.put(5, 62);
        map.put(6, 64);
        map.put(7, 66);
        map.put(8, 67);
    }

    @Override
    public int convert(int note) {
        if(!map.containsKey(note)){
            throw new IllegalArgumentException("invalid note number");
        }
        return map.get(note);
    }
}
