import java.io.File;

public class Database {

    private String filename;
    private int rowWidth;
    private int recordCount;

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
            FileHandler.writeLineAt(filename, data, (rowWidth + 2) * rowNumber);
            recordCount++;
        }
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

    public int findRecordLine(String data) {
        int line = 0;
        for(int i= 0;i<recordCount - 1;i++){
            if(FileHandler.readLineAt(filename,(rowWidth + 2) * i).equals(data)){
                return line;
            }
            line++;
        }
        return -1;
    }
}












