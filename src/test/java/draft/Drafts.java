package draft;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Drafts {

    public static void main(String[] args) {

        List<String> l = new ArrayList<>(10);

        System.out.println(l.size());

        for (int i = 0; i < 10; i++)
            l.add(null);

        System.out.println(l.size());
        System.out.println(l.get(8));

        l.forEach(s -> System.out.println(s));
    }


}