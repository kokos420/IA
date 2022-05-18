import java.util.Locale;
import java.util.Scanner;

public class Selection {
   Scanner scanner = new Scanner(System.in);
   boolean isDone = false;
   String isSure;
   Classroom c;
   public Selection() {

   }

   public void selection() {
      System.out.println("Welcome:");

      System.out.println("1) Create Class");
      System.out.println("2) Edit Class");
      System.out.println("3) Reset");
      System.out.println("4) Exit");

      System.out.println("Please enter you selection:");
      int input = scanner.nextInt();

      switch (input) {
         case 1:  //creates a classroom//
            createClass();
         case 2: //opens a classroom and allows the user to edit it//
            //TODO open class from file and display it//
         case 3:
            System.out.println("Are you sure?");
            isSure = scanner.nextLine();
            isSure = scanner.nextLine();
            isSure.toLowerCase(Locale.ROOT);
            switch (isSure) {
               case "yes":
                  Main.fileName = null;
                  Main.studentsG = null;

               case "no":
                  selection();
               default:
                  selection();
            }
         case 4:       //ends the program if the user wants to//
            System.out.println("Are you sure?");
            isSure = scanner.nextLine();
            isSure = scanner.nextLine();
            isSure.toLowerCase(Locale.ROOT);
            switch (isSure) {
               case "yes":
                  System.exit(0);
               case "no":
                  selection();
               default:
                  selection();
            }
      }
   }

   public void createClass() {
      System.out.println("enter the text file name with the list of students:");
      Main.fileName = scanner.next();

      System.out.println("enter the x size of the classroom");
      int x = scanner.nextInt();

      System.out.println("enter the y size of the classroom");
      int y = scanner.nextInt();

      c = new Classroom(Main.fileName, x, y);
      c.readInStudents();
      Main.studentsG = c.returnStudents();

      c.printList();
      while (isDone == false) {
         classMenu();
      }


   }

   public void classMenu() {
      System.out.println("What would you like to do:");

      System.out.println("1) Sort Class");
      System.out.println("2) Save Class");
      System.out.println("3) Exit");

      System.out.println("Please enter you selection:");
      int input = scanner.nextInt();
      switch (input) {
         case 1:
            c.sort();
         case 2:
            //TODO priority save class to computer//

         case 3:
            String isSure = scanner.nextLine();
            isSure.toLowerCase(Locale.ROOT);
            isSure = scanner.nextLine();
            switch (isSure) {
               case "yes":
                  isDone = true;
               case "no":
                  classMenu();
               default:
                  classMenu();
            }
      }
   }
}
