package media.major;

import java.util.HashMap;
import java.util.Map;

//C大调
public class CMajor implements Major{

    private static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 60);
        map.put(2, 62);
        map.put(3, 64);
        map.put(4, 65);
        map.put(5, 67);
        map.put(6, 69);
        map.put(7, 71);
    }

    @Override
    public int convert(int note) {
        if(!map.containsKey(note)){
            throw new IllegalArgumentException("invalid note number");
        }
        return map.get(note);
    }
}
