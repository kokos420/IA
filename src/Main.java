import java.io.IOException;
import java.lang.reflect.GenericDeclaration;
import java.util.Locale;
import java.util.Scanner;
import static java.lang.System.exit;

class Main {
    public static void main(String[] args) {

    }


    public void selection() {
                    System.out.println("Welcome:");
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("1) Create Class");
                    System.out.println("2) Edit Class");
                    System.out.println("3) Exit");

                    System.out.println("Please enter you selection:");
                    int input = scanner.nextInt();

                    switch(input) {
                        case 1:
                            // code block
                            break;
                        case 2:
                            // code block
                            break;
                        case 3:
                            String isSure = scanner.nextLine();
                            isSure.toLowerCase(Locale.ROOT);
                            switch (isSure) {
                                case "yes":
                                    return;
                                case "no":
                                    selection();
                                default:
                                    selection();
                            }

                }
            }
    }

