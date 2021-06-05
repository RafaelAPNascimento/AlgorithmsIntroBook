import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Drafts {

    public static void main(String[] args) throws Exception {

        test();
    }

    static void test() throws UnsupportedEncodingException {

        String x = "N��o existe inten����o de venda dispon��vel (estado 1 - registrada ou estado 2 - venda comunicada com origem Renave) para ve��culo com pl";
        System.out.println(x);
        System.out.println(URLDecoder.decode(x, "UTF-8"));


    }



}
