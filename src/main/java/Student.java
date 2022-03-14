import java.io.PrintWriter;

public class Student implements CSVPrintable{

    //FIELD VARIABLES//
    protected String name;
    protected String studentID;
    private long phone; //stores a 10-digit phone number

    //Constructor//
    public Student(String position, String name, String studentID, String teacherID, String phone){
        String [] nameSplit = name.split(",");
        this.name = nameSplit[0] + " " + nameSplit[1];
        this.studentID = studentID;
        this.phone = (Long.parseLong(phone));
    }
    //METHODS//;
    // Getter for Student name
    public String getName() {
        return name;
    }

    // Getter returns only Student Ids, it must not return any Teacher IDs.)
    public int getID() {
        return Integer.parseInt(studentID);
    }

    // Getter for Phone
    public String getPhone() {
        return String.valueOf(phone);
    }

    // This method will be used to write information to CSV file.
    public void csvPrintln(PrintWriter out) {
        PrintWriter writer = new PrintWriter(out);
        writer.write(this.getName() + "," + this.getID() + "," + this.getPhone() + "\n");
        writer.flush();
    }

}
