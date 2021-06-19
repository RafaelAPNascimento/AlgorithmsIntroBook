import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Drafts {

    public static void main(String[] args) throws Exception {

        t1();
    }

    static void t1() {
        int min = 2, max = 50;
        int n = ThreadLocalRandom.current().nextInt(min, max + 1);

        

        System.out.println(n);
    }

    static void test() throws UnsupportedEncodingException {

        String x = "N��o existe inten����o de venda dispon��vel (estado 1 - registrada ou estado 2 - venda comunicada com origem Renave) para ve��culo com pl";
        System.out.println(x);
        System.out.println(URLDecoder.decode(x, "UTF-8"));

    }




}
