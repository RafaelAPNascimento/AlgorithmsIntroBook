import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Drafts {

    public static void main(String[] args) throws Exception {

        System.out.println(getAlphaNumericString(15));
    }

    static void test() throws UnsupportedEncodingException {

        String x = "N��o existe inten����o de venda dispon��vel (estado 1 - registrada ou estado 2 - venda comunicada com origem Renave) para ve��culo com pl";
        System.out.println(x);
        System.out.println(URLDecoder.decode(x, "UTF-8"));

    }

    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }



}
