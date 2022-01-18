import java.io.*;

import list.Manager;

//Process the file and execute the commands based on the file input
public class InputProcessor {

    // Constructor - takes the file name and process the file
    public InputProcessor(String fileName) {
        // also handles the exception
        try {
            fileRead(fileName); // process the file
        } catch (ArithmeticException ae) {
            System.out.println("MATH ERROR!");
            ae.printStackTrace();
        } catch (FileNotFoundException fe) {
            System.out.println("FILE NOT FOUND!");
            fe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something Went Wrong !");
            e.printStackTrace();
        }
    }

    // reads each line of the line and process the commands
    public void fileRead(String inputFile) throws Exception {

        // initialise the objects for fileReading
        FileReader fRead = new FileReader(inputFile);
        BufferedReader bRead = new BufferedReader(fRead);

        String line = bRead.readLine(); // storing the first line in string

        Manager user = new Manager(); // initializing WikiManager to execute commands

        // loop runs until we reach to the end of the file
        while (line != null) {

            line = line.trim();

            String[] array = line.split(" ", 10);

            // Manage the comments in the text file
            if (line.startsWith("#")) {
                line = bRead.readLine(); // skip the line and reads the next line
            } else {
                // the program executes various commands based on the what it reads from the
                // file
                if (array[0].equals("ADD")) {
                    user.create(array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]));
                } else if (array[0].equals("REMOVE")) {
                    user.remove(array[1]);
                } else if (array[0].equals("PRINT")) {
                    user.print_list();
                } else if (array[0].equals("QUIT")) {
                    System.exit(0);
                } else {
                    System.out.println("UnKnown Command Applied ! Check It Again");
                }
                line = bRead.readLine();
            }
        }
    }
}
