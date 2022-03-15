import java.util.Scanner;
import static java.lang.System.exit;

class Main {
        public static void main(String[] args) {
            printMenu(options);
            Scanner scanner = new Scanner(System.in);

            int userOption = scanner.nextInt();

            switch (userOption) {
                case 1:
                    createClass();
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
            }
        }

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("Enter your choice");
    }

    public static String[] options = {"1- Create Class",
            "2- Edit Classes",
            "3- Exit",
    };

    public static void createClass() {
            CreateClassMenu menu = new CreateClassMenu();
            menu.selectOption();
    }
    public static void editCLass() {

    }
}
