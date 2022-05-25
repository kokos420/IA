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
        Database db;

        public Classroom(String fn, int x, int y) {   //constructor - puts in placeholder values for the 2d array//
                this.filename = fn;
                this.xWidth = y;
                this.yWidth = x;
                layout = new Student[xWidth][yWidth];
                db = new Database(filename, 16);

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


                switch (input) {
                        case 1:
                                students = manual();

                                break;
                        case 2:
                                students = alphabetical();
                                Collections.reverse(students);
                                break;
                        case 3:
                                students = mf();

                                break;
                        case 4:
                                students = mfPrioritiseNeedsHelp();
                                Collections.reverse(students);
                                break;


                }

                for (int i = 0; i < students.size(); i++) {
                        db.changeRecord(students.get(i).toString(),i);
                }

                Main.studentsG = students;
                printList();
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

        public ArrayList manual() {
                boolean done = false;
                String doneS;
                Classroom c = new Classroom(filename, xWidth, yWidth);
                c.readInStudents();
                Scanner scanner = new Scanner(System.in);
                Student temp;


                int toSwitch;
                int switchWith;

                while(done == false) {   //sorts the students by hand until the user is done//
                        c.printList();

                        System.out.println("Which student would you like to switch? (enter the position) ");
                        toSwitch = scanner.nextInt();
                        System.out.println("Which student would you like to switch with? (enter the position) ");
                        switchWith = scanner.nextInt();

                        temp = students.get(toSwitch - 1);
                        students.set(toSwitch - 1, students.get(switchWith - 1));
                        students.set(switchWith - 1, temp);

                        System.out.println("Are you finished? (enter y or n) ");
                        doneS = scanner.next();

                        doneS = doneS.toLowerCase();

                        if (doneS.equals("y") || doneS.equals("yes")) {
                                done = true;
                        } else {
                                done = false;
                        }
                }

                return students;
        }

        public ArrayList alphabetical() {   //bubble sorts the students alphabetically//
                int sortedCount = 0;
                Student temp;
                boolean swapped = true;
                while (swapped == true) {
                        swapped = false;
                        for (int i = 0; i < students.size() - 1 - sortedCount; i++ ) {
                                if (students.get(i).returnInitials() < students.get(i + 1).returnInitials()) {
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


        public ArrayList mf() {   //sorts the students (male / female alternating)//
                ArrayList<Student> m = new ArrayList<>();
                ArrayList<Student> f = new ArrayList<>();
                ArrayList<Student> sorted = new ArrayList<>();

                for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).returnGender() == 'm') {
                                m.add(students.get(i));
                        } else {
                                f.add(students.get(i));
                        }
                }

                int fcount = f.size();
                int mcount = m.size();

                for (int i = 0; i < students.size(); i++) {
                        if(mcount > 0) {
                                sorted.add(m.get(i));
                                mcount = mcount - 1;
                        }

                        if(fcount > 0) {
                                sorted.add(f.get(i));
                                fcount = fcount - 1;
                        }
                }


                return sorted;
        }

        public ArrayList mfPrioritiseNeedsHelp() {   //sort male/female alternating but puts the students that need help at the front//
                ArrayList<Student> m = new ArrayList<>();
                ArrayList<Student> f = new ArrayList<>();
                ArrayList<Student> sorted = new ArrayList<>();
                ArrayList<Student> mNh = new ArrayList<>();
                ArrayList<Student> fNh = new ArrayList<>();

                for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).returnNH() == true) {
                                if (students.get(i).returnGender() == 'm') {
                                        mNh.add(students.get(i));
                                } else {
                                        fNh.add(students.get(i));
                                }
                        } else {
                                if (students.get(i).returnGender() == 'm') {
                                        m.add(students.get(i));
                                } else {
                                        f.add(students.get(i));
                                }
                        }
                }

                int fNHcount = fNh.size();
                int mNHcount = mNh.size();

                for (int i = 0; i < (mNHcount + fNHcount); i++) {
                        if(mNHcount > 0) {
                                sorted.add(mNh.get(i));
                                mNHcount = mNHcount - 1;
                        }

                        if(fNHcount > 0) {
                                sorted.add(fNh.get(i));
                                fNHcount = fNHcount - 1;
                        }
                }

                int fcount = f.size();
                int mcount = m.size();

                for (int i = 0; i < students.size(); i++) {
                        if(mcount > 0) {
                                sorted.add(m.get(i));
                                mcount = mcount - 1;
                        }

                        if(fcount > 0) {
                                sorted.add(f.get(i));
                                fcount = fcount - 1;
                        }
                }

                return sorted;
        }

}
