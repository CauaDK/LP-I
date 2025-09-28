package org.example.functions;

import java.io.FileWriter;
import java.io.IOException;

public class SaveCSV {
    public void salvarCSV(String object, String path, String folder) {
        try (FileWriter writer = new FileWriter("src/main/resources/org/example/" + folder + "/" + path + ".csv", true)) {
            writer.write(object + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
