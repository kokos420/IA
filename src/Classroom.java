import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Classroom {
        private ArrayList<Student> students;
        private String filename;
        private int xWidth;
        private int yWidth;
        private Student[][] layout;

        public Classroom(String fn, int x, int y) {   //constructor - puts in placeholder values for the 2d array//
                this.filename = fn;
                this.xWidth = y;
                this.yWidth = x;
                layout = new Student[xWidth][yWidth];

                Student placeholder = new Student("-" , 'f' , false);

                for (int i = 0; i < xWidth; i++) {
                        for (int z = 0; z < yWidth; z++) {
                                layout[i][z] = placeholder;
                        }
                }
        }

        public void readInStudents() {   //reads in the students into the arraylist//
                Database db = new Database(filename, 16);
                students = db.returnStudents();
        }

        public ArrayList<Student> returnStudents() {   //reads in the students into the arraylist//
                Database db = new Database(filename, 16);
                students = db.returnStudents();
                return students;
        }

        public void printStudents() { //prints the students//
                for (int i = 0; i < xWidth; i++) {
                        for (int z = 0; z < yWidth; z++) {
                                System.out.print(layout[i][z].returnInitials() + " ");
                        }
                        System.out.println(" ");
                }
        }

        public void printList() {  //prints the list of students//
                for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).returnInitials());
                }
        }

        public void sort() {
                Scanner ms = new Scanner(System.in);
                System.out.println("1) Manual");
                System.out.println("2) Alphabetical");
                System.out.println("3) M/F");
                System.out.println("4) M/F prioritise Needs help");
                int input = ms.nextInt();
                Sort mySort = new Sort(Main.studentsG);

                switch (input) {
                        case 1:
                                students = mySort.manual();
                        case 2:
                                students = mySort.alphabetical();
                        case 3:
                                students = mySort.mf();
                        case 4:
                                students = mySort.mfPrioritiseNeedsHelp();
                                Collections.reverse(students);
                }

                printList();
                Main.studentsG = students;
        }

        public void enterStudents() {
                Student teacher = new Student("@", 'g', false);
                Scanner scanner = new Scanner(System.in);
                System.out.println("where is the teacher desk? (enter x value)");
                int tXCoord = scanner.nextInt();
                System.out.println("now enter y value");
                int tYCoord = scanner.nextInt();

                layout[tYCoord - 1][tXCoord - 1] = teacher;   //gets where the teacher is//

              int studentCounter = 0;

                for (int i = 0; i < yWidth; i++) {           //puts in the students in the array//
                        for (int z = 0; z < xWidth; z++) {
                                if (layout[i][z] != teacher && studentCounter < students.size()) {
                                        layout[i][z] = students.get(studentCounter);
                                        studentCounter++;
                                }
                        }
                }
        }

        public void saveClass() {

        }

}
