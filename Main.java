import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter File Name with extention: ");

        Scanner scanFileName = new Scanner(System.in);
        String fileName = scanFileName.next();

        // Initialising the file reader
        InputProcessor i = new InputProcessor(fileName);

    }

}
