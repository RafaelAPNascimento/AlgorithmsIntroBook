import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Drafts {

    public static void main(String[] args) throws DatatypeConfigurationException {

       int a = 1;
       int c = ++a;
        System.out.println(c);
    }

    private Collection<? extends Object> x;

    static <T> Collection<T> getIt(T[] arr) {

        Collection c = Arrays.asList(arr);
        return c;
    }
}


