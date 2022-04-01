import javax.xml.crypto.Data;

public class Student {
    private int number;
    private String name;
    private char gender;
    private boolean needsHelp;
    private String needsHelpString;
    private int nLength = 10;
    private int gLength = 1;
    private int nHLength = 5;


    public Student(String n, char g, boolean nH) {        //constructor to make a new student from scratch//
        this.name = n;
        this.gender = g;
        this.needsHelp = nH;
    }

    public Student(String dbRecord) {           //constructor to make a new student from a database record//
        this.name = dbRecord.substring(0, 9);
        this.gender = dbRecord.charAt(10);
        this.needsHelp = Boolean.parseBoolean(dbRecord.substring(11, 16));
    }

    public String toString() {    //returns the student in the string that the database will accept//
        String record;
        name = Database.pad(name, nLength);
        needsHelpString = Database.pad(Boolean.toString(needsHelp) , nLength);
        record = name + gender + needsHelp;

        return record;
    }

    public void addToDB(String fileName, int rowWidth) {           //adds the student to the db//
        Database db = new Database(fileName, rowWidth);
        db.appendRecord(toString());
    }

    public void printStudent() {      //prints the student in string format//
        System.out.println(name + " " + gender + " " + needsHelp);
    } //gets the initials of the student//

    public char returnInitials() {
        return name.charAt(0);
    }

    public char returnGender() {
        return gender;
    }

    public boolean returnNH() {
        return needsHelp;
    }

    public void changeName(String n, String fileName, int rowWidth) {                //setters for all the variables in the student//
        Database db = new Database(fileName, rowWidth);
        int line = db.findRecordLine(toString());

        name = n;
        name = Database.pad(name, nLength);

        FileHandler.writeLineAt(fileName, toString(), (rowWidth + 2) * line);
    }

    public void changeGender(char g, String fileName, int rowWidth) {
        Database db = new Database(fileName, rowWidth);
        int line = db.findRecordLine(toString());

        gender = g;

        FileHandler.writeLineAt(fileName, toString(), (rowWidth + 2) * line);
    }

    public void changeNeedsHelp(boolean nH, String fileName, int rowWidth) {
        Database db = new Database(fileName, rowWidth);
        int line = db.findRecordLine(toString());

        needsHelp = nH;
        needsHelpString = Database.pad(Boolean.toString(needsHelp) , nLength);

        FileHandler.writeLineAt(fileName, toString(), (rowWidth + 2) * line);
    }
}
