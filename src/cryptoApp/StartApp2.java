package cryptoApp;

import InO.InputFile;
import InO.OutputFile;
import cypher.CypherOperations;

import java.io.IOException;
import java.util.Scanner;

public class StartApp2 {

    public static void startTheApp() throws IOException {
        System.out.println("Please choose from following options... \n" +
                "1)Encrypt file \n" +
                "2)Decrypt file \n" +
                "3)Brute Force \n" +
                "4)Exit");
        String path;
        int shiftKey = 0;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Please enter file path and shift key");
                path = scanner.next();
                scanner.nextLine();
                shiftKey = scanner.nextInt();
                OutputFile.createAndWriteInFile(CypherOperations.encrypt(InputFile.readFile(path), shiftKey));
                break;
            case 2:
                System.out.println("Please enter file path and shift key");
                path = scanner.next();
                scanner.nextLine();
                shiftKey = scanner.nextInt();
                OutputFile.createAndWriteInFile(CypherOperations.decrypt(InputFile.readFile(path), shiftKey));
                break;
            case 3:
                System.out.println("Please enter file path");
                path = scanner.next();
                OutputFile.createAndWriteInFile(CypherOperations.bruteForce(InputFile.readFile(path)));
                break;
            case 4:
                System.out.println("Bye!");
                break;
        }

    }
}
