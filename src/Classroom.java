import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class Classroom {
        private ArrayList<Student> students;
        private String filename;
        private int xWidth;
        private int yWidth;

        public Classroom(String fn, int x, int y) {
                this.filename = fn;
                this.xWidth = x;
                this.yWidth = y;
        }

        public void readInStudents() {
                Database db = new Database(filename, 16);
                students = db.returnStudents();
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

                        case 2:

                        case 3:

                        case 4:

                }
        }

}
