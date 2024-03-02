package InO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputFile {


    public static String readFile(String path) throws IOException {

        String text = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            text = stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}

