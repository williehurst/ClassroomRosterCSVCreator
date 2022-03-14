import java.io.PrintWriter;

public class TA extends Student{
    private String teacherID;

    //Constructor//
    public TA(String position, String name, String studentID, String teacherID, String phone) {
        super(position, name, studentID, teacherID, phone);
        this.teacherID = teacherID;
    }
    /*
    //--Inherited FIELD VARIABLES--//
    private String Name;
    private String iD;
    private long phone;

    //--Inherited METHODS--//
    public String getName()
    public int getID() @override
    public void csvPrintln(PrintWriter out) @override
    public int getPhone()
     */

    //METHODS//
    // Method returns the maximum value of the Student and Teacher IDs
    @ Override
    public int getID() {
        return Math.max(Integer.parseInt(studentID), Integer.parseInt(teacherID));
    }

    // This method will be used to write information to CSV file.
    @ Override
    public void csvPrintln(PrintWriter out) {
        PrintWriter writer = new PrintWriter(out);
        writer.write(this.getName() + "," + this.getID() + "," + this.getPhone() + "\n");
        writer.flush();
    }

}


