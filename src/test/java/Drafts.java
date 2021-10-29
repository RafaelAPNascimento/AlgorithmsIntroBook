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
        List<String> ls = null;

        
    }

    static class Transmission {

        public static final int MESSAGE_LENGTH = 1;
        public static final int ID_LENGTH = 1;
        Transmission(int i1, String i2) {}
    }

    static class TransmissionParser {

        static Transmission parse(String rawMessage) {
            if (rawMessage != null
                    && rawMessage.length() != Transmission.MESSAGE_LENGTH) {

                throw new IllegalArgumentException(
                        String.format("Expected %d, but got %d characters in '%s'",
                                Transmission.MESSAGE_LENGTH, rawMessage.length(),
                                rawMessage));
            }
            String rawId = rawMessage.substring(0, Transmission.ID_LENGTH);
            String rawContent = rawMessage.substring(Transmission.ID_LENGTH);
            try {
                int id = Integer.parseInt(rawId);
                String content = rawContent.trim();
                return new Transmission(id, content);
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        String.format("Expected number, but got '%s' in '%s'",
                                rawId, rawMessage), e);
            }
        }

        static IllegalArgumentException toIllegalEx(String msg, Throwable cause) {
            throw new IllegalArgumentException(msg, cause);
        }
    }
}
