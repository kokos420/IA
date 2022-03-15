import java.util.Scanner;
public class CreateClassMenu {
    private static String[] options = {"1- Select file", "2- Sort the students" , "3- Create", "4- Exit"
    };

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public int getOption() {
        Scanner myScanner = new Scanner(System.in);
        int userOption = myScanner.nextInt();
        return userOption;
    }

    public void selectOption() {
        printMenu(options);
        System.out.println("Enter your option:");

        switch (getOption()) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
        }
    }
}
