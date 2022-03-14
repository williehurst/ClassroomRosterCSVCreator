import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    private static boolean verify(String position, String name, String studentID, String teacherID, String phone) {
        final String ID_INPUT_ERROR = """
            
            StudentID and TeacherID must be either “0” or a string of 5 digits. 
            If Position is “teacher”, StudentID is zero, but TeacherID is not zero. 
            If Position is “student”, TeacherID is zero, but StudentID is not zero. 
            If Position is “TA”, neither StudentID nor TeacherID are zero.
            """;
        String[] nameSplit = name.split(","); // splits up name by comma separator
        switch (position) {
            case "student":
                if ((!(studentID.matches("\\d{5}"))) || (!(teacherID.matches("0")))) {
                    System.out.println(ID_INPUT_ERROR);
                    return false;
                }
                break;
            case "teacher":
                if ((!(studentID.matches("0"))) || (!(teacherID.matches("\\d{5}")))) {
                    System.out.println(ID_INPUT_ERROR);
                    return false;
                }
                break;
            case "TA":
                if ((!(studentID.matches("\\d{5}"))) || (!(teacherID.matches("\\d{5}")))) {
                    System.out.println(ID_INPUT_ERROR);
                    return false;
                }
                break;
            default:
                return false;
        }
        if (nameSplit.length != 2) {
            return false;
        }
        if (!((nameSplit[0].matches("^[A-Za-z]+$")) && (nameSplit[1].matches("^[A-Za-z]+$")))) {
            return false;
        }
        if (!(phone.matches("\\d{10}")))
            return false;
        return true; // if all test pass then return true.
    }
    private static CSVPrintable createPerson(String position, String name, String studentID, String teacherID, String phone) {
        CSVPrintable person;
        switch (position) {
            case "student":
                person = new Student(position, name, studentID, teacherID, phone);
                break;
            case "teacher":
                person = new Teacher(position, name, studentID, teacherID, phone);
                break;
            case "TA":
                person = new TA(position, name, studentID, teacherID, phone);
                break;
            default:
                person = null;
        }
        return person;
    }
    public static String outputPath = System.getProperty("user.dir") + "/output/";

    // Main Method
    public static void main(String[] args) throws IOException {
        PrintWriter p = new PrintWriter( outputPath + "out.csv");
        CSVPrintable person;
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        // Get how many lines we are entering from user
        System.out.println("Lets start with how many entries do you need to enter.");

        // Keep asking into user enters a pos int.
        while (n < 0) {
            System.out.println("Please enter a positive int for number of entries.");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        // Take in user's input for each line. If incorrect make user try that line again.
        System.out.println("Now please enter your entries in the following format:");
        System.out.println("\"Position firstName,lastName StudentID TeacherID Phone\"");
        for (int i = 0; i < n; i++) {
            String position =  scanner.next();
            String name = scanner.next();
            String studentID = scanner.next();
            String teacherID = scanner.next();
            String phone = scanner.next();
            if (!verify(position, name, studentID, teacherID, phone)) {
                i--;
                System.out.println("(" + position + " " + name + " " + studentID + " " + teacherID + " " + phone+") is not the correct format");
                System.out.println("Try again");
                continue;
            }
            person = createPerson (position, name, studentID, teacherID, phone);
            person.csvPrintln(p);
        }
        p.close();

    }
}

/******************* NOTES ************************/
/*
Problem Specification
In order to implement the system, you need to write a java program that gets the personal
information of individuals from the console and store it in different rows of the output .csv
file.

User enters personal information of nstudents and teachers using the console in the following
format:
n
Position1 Name1 StudentID1 TeacherID1 Phone1
Position2 Name2 StudentID2 TeacherID2 Phone2
Position3 Name3 StudentID3 TeacherID3 Phone3
. . .
Positionn Namen StudentIDn TeacherIDn Phonen

Please note that the first line contains only an integer counting the number of lines
following the first line.

In each of the nth given input lines,
- Position must be one of the following three strings “student”, “teacher”, or “TA”.
- Name must be a string of two words separated by a single comma only.
- StudentID and TeacherID must be either “0” or a string of 5 digits. If Position is
  “teacher”, StudentID is zero, but TeacherID is not zero. If Position is “student”,
  TeacherID is zero, but StudentID is not zero. If Position is “TA”, neither StudentID
  nor TeacherID are zero.
- Phone is a string of 10 digits.

If the user enters information in a way that is not consistent with the mentioned format, your
program must gracefully handle the situation by printing a message on the screen asking the
user to partially/completely re-enter the information that was previously entered in a wrong
format.
*/
