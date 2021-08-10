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
import java.util.Base64;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Drafts {


    public static void main(String[] args) throws Exception {

        //String regex = "/(^\\d{11})|(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$)/";
        String regex = "(^\\d{11}|^\\d{14})";
        Pattern cpfCnpj = Pattern.compile(regex);

        String doc = "51277965000167";
        System.out.println(cpfCnpj.matcher(doc).matches());

    }

    public String codificaSenha(String senha) throws Exception {
        Path pub = Path.of("/home/rafael/WindowsRemoteWorkstation/iirgd/key-pair/public/publicKey");
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.getPublic(pub));
        return Base64.getEncoder().encodeToString(cipher.doFinal(senha.getBytes("UTF-8")));
        //return Base64.encodeBase64String(cipher.doFinal(senha.getBytes("UTF-8")));
    }

    // https://docs.oracle.com/javase/8/docs/api/java/security/spec/X509EncodedKeySpec.html
    private PublicKey getPublic(Path pub) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        byte[] keyBytes = Files.readAllBytes(pub);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public String decodificaSenha(String senha) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {

        Path pK = Path.of("/home/rafael/WindowsRemoteWorkstation/iirgd/key-pair/private/privateKey");
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, getPrivate(pK));
        return new String(cipher.doFinal(Base64.getDecoder().decode(senha)), "UTF-8");
        //return new String(cipher.doFinal(Base64.decodeBase64(senha)), UTF_8);
    }

    // https://docs.oracle.com/javase/8/docs/api/java/security/spec/PKCS8EncodedKeySpec.html
    private PrivateKey getPrivate(Path filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException  {
        byte[] keyBytes = Files.readAllBytes(filename);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);


    }
}
