package draft;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Drafts {

    public static void main(String[] args) {

        String crm = "10AL";
        crm = crm.substring(0, crm.length() - 2);
        System.out.println(crm);
    }

    private static void test() throws Exception {
        try {
            ByteArrayInputStream b = new ByteArrayInputStream(null);
            b.close();
        }
        catch (IOException e) {
            throw e;
        }
    }

    private static boolean isMinGreaterThanThePreviousMax(BigDecimal max, BigDecimal min) {

        int precision = max.stripTrailingZeros().precision();

        if (precision <= 0) {
            return min.subtract(max).compareTo(BigDecimal.ONE) == 0;
        }
        else {
            // Trabalhando com 2 casas decimais
            max = max.setScale(2, RoundingMode.HALF_UP);

            //Verificando se o número passado possui 1 ou 2 casas decimais
            // final String str = max.toString();
//            double diff = 0.01;
//
//            if (str.substring(str.length() - 1).equals("0")) {
//                diff = 0.1;
//            }

            min = min.subtract(max).setScale(2, RoundingMode.HALF_UP);

            BigDecimal diff = new BigDecimal(0.01).setScale(2, RoundingMode.HALF_UP);

            return min.compareTo(diff) == 0;
        }
    }
}