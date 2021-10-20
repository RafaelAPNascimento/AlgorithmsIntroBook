import javax.crypto.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Drafts {


    public static void main(String[] args) {

    }

    class Inventory {

        private List<Supply> supplies = new ArrayList<>();

        int getQuantity(Supply supply) {
            if (supply == null) {
                throw new NullPointerException("supply must not be null");
            }

            int quantity = 0;
            for (Supply supplyInStock : supplies) {
                if (supply.equals(supplyInStock)) {
                    quantity++;
                }
            }

            return quantity;
        }

        int getQuantity1(Supply supply) {

            Objects.requireNonNull(supply, "supply must not be null");

            return Collections.frequency(supplies, supply);
        }
    }


    class Supply {}
}
