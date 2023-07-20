package media.major;

import java.util.HashMap;
import java.util.Map;

public class EMajor implements Major{

    private static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 64);
        map.put(2, 66);
        map.put(3, 68);
        map.put(4, 69);
        map.put(5, 71);
        map.put(6, 73);
        map.put(7, 75);
        map.put(8, 76);
    }

    @Override
    public int convert(int note) {
        if(!map.containsKey(note)){
            throw new IllegalArgumentException("invalid note number");
        }
        return map.get(note);
    }
}
