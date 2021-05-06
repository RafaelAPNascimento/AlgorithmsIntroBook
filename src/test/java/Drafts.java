import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Drafts {

    public static void main(String[] args) throws Exception {

        test();
    }

    static void test() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.computeIfPresent(1, (k, v) -> "B");
        System.out.println(map.get(1));
    }



}
