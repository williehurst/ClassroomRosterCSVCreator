import java.io.PrintWriter;

public class Teacher implements CSVPrintable{

    //FIELD VARIABLES//
    private String name;
    private String teacherID;
    private int phone = 0; //stores a 4-digit post fix of phone number

    //Constructor//
    public Teacher(String position, String name, String studentID, String teacherID, String phone){

        this.teacherID = teacherID;
        //long temp = Long.parseLong(phone,6,9,10);
        this.phone = Integer.parseInt(phone.substring(6));
        String [] nameSplit = name.split(",");
        this.name = nameSplit[0] + " " + nameSplit[1];
    }

    //METHODS//
    // Getter for Teacher name
    public String getName() {
        return name;
    }

    // Getter returns only Teacher IDs, it must not return any Student IDs.
    public int getID() {
        return Integer.parseInt(this.teacherID);
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
