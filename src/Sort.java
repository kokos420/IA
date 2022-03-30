import java.util.ArrayList;
import java.util.Scanner;

public class Sort {
    private ArrayList<Student> students;

    public Sort(ArrayList<Student> al) {
        this.students = al;
    }

    public ArrayList manual() {
        boolean done = false;
        String doneS;
        Classroom c = new Classroom("test.txt", 10, 10);
        c.readInStudents();
        Scanner scanner = new Scanner(System.in);
        Student temp;

        int toSwitch;
        int switchWith;

        while(done == false) {
            c.printList();

            System.out.println("Which student would you like to switch? (enter the position) ");
            toSwitch = scanner.nextInt();
            System.out.println("Which student would you like to switch with? (enter the position) ");
            switchWith = scanner.nextInt();

            temp = students.get(toSwitch);
            students.set(toSwitch , students.get(switchWith));
            students.set(switchWith, temp);

            System.out.println("Are you finished? (enter y or n) ");
            doneS = scanner.nextLine();
            doneS = scanner.nextLine();

            //TODO change done to whatever it needs to be//

        }
        return students;
    }

    public ArrayList alphabetical() {   //bubble sorts the students//
        int sortedCount = 0;
        Student temp;
        boolean swapped = true;
        while (swapped == true) {
            swapped = false;
            for (int i = 0; i < students.size() - 1 - sortedCount; i++ ) {
                if (students.get(i).returnInitials() > students.get(i + 1).returnInitials()) {
                    temp = students.get(i);
                    students.set(i , students.get(i + 1));
                    students.set(i + 1, temp);
                    swapped = true;
                }
            }
            sortedCount++;
        }

        return students;
    }

 /*   public ArrayList mf() {

    }

    public ArrayList mfNH() {

    }
*/

}
