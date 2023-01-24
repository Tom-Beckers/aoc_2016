package biz.tom.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day4 {
    private static int solve(List<String> instructions) {
        int result = 0;

        Character[] keys = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (String line : instructions) {
            int[] map = new int[keys.length];

            int i = 0;
            for (; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '-') {
                    continue;
                } else if (c >= '0' && c <= '9') {
                    break;
                }

                map[c - 97]++;
            }

        }


        return result;
    }

    public static List<String> getInstructions(String s) throws IOException {
        String filepath = "src/main/resources/" + s;

        List<String> instructions = Files.readAllLines(Paths.get(filepath));

        return instructions;
    }

    public static void main(String[] args) throws IOException {

        List<String> instructions = getInstructions("day4_input.txt");
        System.out.println("Part 1: " + solve(instructions));
        //System.out.println("Part 2: " + solve2(instructions));


    }

}
