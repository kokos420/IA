import java.util.Locale;
import java.util.Scanner;

public class Selection {
   public Selection() {

   }

   public void selection() {
      System.out.println("Welcome:");
      Scanner scanner = new Scanner(System.in);

      System.out.println("1) Create Class");
      System.out.println("2) Edit Class");
      System.out.println("3) Reset");
      System.out.println("4) Exit");

      System.out.println("Please enter you selection:");
      int input = scanner.nextInt();

      switch (input) {
         case 1:  //creates a classroom//
            System.out.println("enter the text file name with the list of students:");
            Main.fileName = scanner.next();

            System.out.println("enter the x size of the classroom");
            int x = scanner.nextInt();

            System.out.println("enter the y size of the classroom");
            int y = scanner.nextInt();

            Classroom c = new Classroom(Main.fileName, x, y);
            c.readInStudents();
            Main.students = c.returnStudents();

            //TODO this menu//

         case 2: //opens a classroom and allows the user to edit it//
            // code block
            break;
         case 3:
            String isSure = scanner.nextLine();
            isSure.toLowerCase(Locale.ROOT);
            switch (isSure) {
               case "yes":
                  //Reset all current values//
               case "no":
                  selection();
               default:
                  selection();
            }
         case 4:       //ends the program if the user wants to//
            isSure = scanner.nextLine();
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
