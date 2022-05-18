import javax.lang.model.type.ArrayType;
import java.io.File;
import java.util.ArrayList;

public class Database {

    private String filename;
    private int rowWidth;
    private int recordCount;
    private ArrayList<Student> students = new ArrayList<>();

    public Database(String filename, int rowWidth) {    //constructor//
        this.filename = filename;
        this.rowWidth = rowWidth;
        recordCount = getRecordCount();
    }

    public static String pad(String data, int width) {        //class to pad any string to a certain length//
        while (data.length() < width) {
            data += " ";
        }
        return data;
    }

    public void appendRecord(String data) {
        if(data.length()>rowWidth){                             //appends record to the data file//
            System.out.println("error: data length too long");
        }else {
            while (data.length() < rowWidth) {
                data += " ";
            }
            FileHandler.appendLine(filename, data);
            recordCount++;
        }
    }

    public void changeRecord(String data, int rowNumber) {    //changes the record at a certain line to a new record//
        if(data.length()>rowWidth){                           //for example if the record changes                   //
            System.out.println("error: data length too long");
        }else {
            while (data.length() < rowWidth) {
                data += " ";
            }
            FileHandler.writeLineAt(filename, data, (rowNumber * 16) + (rowNumber)); //for every there is one more character to get to the next line//
            recordCount++;
        }
    }

    public void swapRecord(int toSwap, int swapWith) {  //swaps the record with the other//
        String temp = getRecord(toSwap - 1);
        changeRecord(getRecord(swapWith - 1), toSwap - 1);
        changeRecord(temp, swapWith - 1);
    }

    public void deleteRecord(int rowNumber) {           //deletes a record at a certain line//
        FileHandler.writeLineAt(filename, "----------------", (rowWidth + 2) * rowNumber);
        recordCount--;
    }

    public String getRecord(int rowNumber) {   //gets the record at a certain row//
        return FileHandler.readLineAt(filename, (rowWidth + 2) * rowNumber);
    }

    public int getRecordCount() {
        return FileHandler.countLines(filename);
    }    //gets the amount of records in the database//

    public boolean findRecord(String data) {        //sees if there is a record with matching data//
        // search for a record matching data
        // return true if found
        for(int i=0;i<recordCount;i++){
            if(FileHandler.readLineAt(filename,(rowWidth + 2) * i).equals("----------------")){
                System.out.println("record has been deleted");
            }
        }
        for(int i=0;i<recordCount;i++){
            if(FileHandler.readLineAt(filename,(rowWidth + 2) * i).equals(data)){
                return true;
            }
        }
        return false;
    }

    public int findRecordLine(String data) {   //gets the line where the specified record is at//
        int line = 0;
        for(int i= 0;i<recordCount - 1;i++){
            if(FileHandler.readLineAt(filename,(rowWidth + 2) * i).equals(data)){
                return line;
            }
            line++;
        }
        return -1;
    }

    public ArrayList<Student> returnStudents() {   //returns the records as an array list of students//

        for(int i = 0; i < recordCount; i++) {
            Student x = new Student(getRecord(i));
            students.add(x);
        }

        return students;
    }

}













