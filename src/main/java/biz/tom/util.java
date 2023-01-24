package biz.tom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class util {
    static String[] getInstructions(String s) throws IOException {
        String filepath = "src/main/java/biz/tom/" + s;
        BufferedReader reader = new BufferedReader(new FileReader(new File(filepath)));
        String[] instructions = reader.readLine().split(", ");
        reader.close();
        return instructions;
    }
}
