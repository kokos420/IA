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

        while(done == false) {   //sorts the students by hand until the user is done//
            c.printList();

            System.out.println("Which student would you like to switch? (enter the position) ");
            toSwitch = scanner.nextInt();
            System.out.println("Which student would you like to switch with? (enter the position) ");
            switchWith = scanner.nextInt();

            temp = students.get(toSwitch - 1);
            students.set(toSwitch - 1, students.get(switchWith -1));
            students.set(switchWith- 1, temp);

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

    public ArrayList mfNH() {
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
        //TODO this//


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
