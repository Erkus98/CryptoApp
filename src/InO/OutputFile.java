package InO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputFile {

    public static void createAndWriteInFile(String text) throws IOException {

        try {
            File file = new File("out/production/cryptoAnalyzer/resources/Processed Text.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
