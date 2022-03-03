package draft;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Drafts {

    public static void main(String[] args) {

        Stream<String> words = Stream.of("Hello", "World");

        List<String> ls =
            words.map(w -> w.split(""))
                .flatMap(arr -> Arrays.stream(arr))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(ls);
    }
}


