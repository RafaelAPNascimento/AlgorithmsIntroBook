import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Drafts {

    public static void main(String[] args) throws Exception {

        test();
    }

    static void test() {

        String s = " {\"timestamp\":\"2021-04-14T15:39:01.143\",\"status\":406,\"error\":\"Not Acceptable\",\"mensagem\":\"VE═CULO J┴ POSSUI INTENÃ├O DE VENDA\",\"codigo\":507,\"path\":\"/SevDocumento/rest/registra/intencao/venda/\"}";
        s = s.replaceAll("[^\\x20-\\x7e]", "");
        System.out.println(s);
    }



}
