package biz.tom.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Day3 {

    //PART 1


    private static int solve(List<String> instructions) {
        int possible = 0;
        for (String instruction : instructions) {
            String[] numbers = instruction.trim().split("\\s+");

            List<Integer> list = new ArrayList<>();
            for (String number : numbers) {
                list.add(Integer.valueOf(number));
            }

            Collections.sort(list);
            if (list.get(0) + list.get(1) > list.get(2)) {
                possible++;
            }
        }

        return possible;
    }

    private static int solve2(List<String> instructions) {

        int possible = 0;

        List<Integer> col1 = new ArrayList<>();
        List<Integer> col2 = new ArrayList<>();
        List<Integer> col3 = new ArrayList<>();

        for (String line : instructions) {
            String[] numbers = line.trim().split("\\h+");

            col1.add(Integer.valueOf(numbers[0]));
            col2.add(Integer.valueOf(numbers[1]));
            col3.add(Integer.valueOf(numbers[2]));

            if (col1.size() == 3) {
                Collections.sort(col1);
                Collections.sort(col2);
                Collections.sort(col3);

                if (col1.get(0) + col1.get(1) > col1.get(2)) possible++;
                if (col2.get(0) + col2.get(1) > col2.get(2)) possible++;
                if (col3.get(0) + col3.get(1) > col3.get(2)) possible++;

                col1.clear();
                col2.clear();
                col3.clear();
            }
        }
        System.out.println();
        return possible;
    }

    public static List<String> getInstructions(String s) throws IOException {
        String filepath = "src/main/resources/" + s;

        List<String> instructions = Files.readAllLines(Paths.get(filepath));

        return instructions;
    }

    public static void main(String[] args) throws IOException {

        List<String> instructions = getInstructions("day3_input.txt");
        System.out.println("Part 1: " + solve(instructions));
        System.out.println("Part 2: " + solve2(instructions));


    }

}
