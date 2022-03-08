import java.io.PrintWriter;

public interface CSVPrintable {

    public String getName();
    public int getID();
    public void csvPrintln(PrintWriter out);

}

/******************* NOTES ************************/
/*
CSVPrintable Interface class*
•	String getName();
•	int getID();
•	void csvPrintln(PrintWriter out);

*/