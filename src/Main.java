import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Reader reader = new Reader(new Scanner(System.in));
        reader.read( );

        System.out.println(reader.getN());

    }
}