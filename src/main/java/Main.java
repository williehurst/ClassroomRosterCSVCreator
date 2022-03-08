public class Main {
    public static void main(String[] args) {

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
