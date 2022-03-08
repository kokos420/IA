import java.util.Scanner;
import static java.lang.System.exit;

public class Menu {

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("Enter your choice");
    }

    private static String[] options = {"1- Create Class",
            "2- Edit Classes",
            "3- Exit",
    };

    public static void main(String[] args) {
        printMenu(options);
        Scanner scanner = new Scanner(System.in);

        int userOption = scanner.nextInt();


    }

    private static void createClass() {

    }
    private static void editCLass() {

    }
}