import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.GenericDeclaration;
import java.util.Locale;
import java.util.Scanner;
import static java.lang.System.exit;
import static java.lang.System.setErr;
import java.util.ArrayList;


class Main {

    public static String fileName;
    public static ArrayList<Student> students;
    public static String className;

    public static void main(String[] args) {
       Database db = new Database("test.txt",16);
       db.swapRecord(1,2);




       /* Selection menu = new Selection();
        menu.selection(); */
    }


    public static void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    }

