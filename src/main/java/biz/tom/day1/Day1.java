package biz.tom.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Day1 {
    public static void main(String[] args) throws IOException {

        String[] instructions = getInstructions("day1_input.txt");

        int x = 0;
        int y = 0;
        int rotation = 90;

        ArrayList<int[]> visitedPositions = new ArrayList<>();


        for (String instruction : instructions) {
            String direction = instruction.substring(0, 1);
            int translation = Integer.parseInt(instruction.substring(1));

            if (direction.equals("L")) {
                rotation += 90;
            } else {
                rotation -= 90;
            }

            int[] position = new int[]{x, y};
            switch (rotation % 360) {
                case 0:
                    x += translation;
                    position = new int[]{x, y};
                    visitedPositions.add(position);
                    break;
                case 90:
                case -270:

                    y += translation;
                    position = new int[]{x, y};
                    visitedPositions.add(position);
                    break;
                case 180:
                case -180:
                    x -= translation;
                    position = new int[]{x, y};
                    visitedPositions.add(position);
                    break;
                case 270:
                case -90:
                    y -= translation;
                    position = new int[]{x, y};
                    visitedPositions.add(position);
                    break;
            }
        }

        int totalDistance = Math.abs(x) + Math.abs(y);
        findDuplicatesUsingHashMap(visitedPositions);
        System.out.println("Total distance = " + totalDistance + ".");
    }


    private static String[] getInstructions(String s) throws IOException {
        String filepath = "src/main/resources/" + s;
        BufferedReader reader = new BufferedReader(new FileReader(new File(filepath)));
        String[] instructions = reader.readLine().split(", ");
        reader.close();
        return instructions;
    }


    private static void findDuplicatesUsingHashMap(ArrayList<int[]> inputArray) {
        HashMap<Object, Integer> map = new HashMap<>();

        for (Object element : inputArray) {
            if (map.get(element) == null) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }

        Set<Map.Entry<Object, Integer>> entrySet = map.entrySet();

        for (Map.Entry<Object, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Element : " + entry.getKey() + " - found " + entry.getValue() + " times.");
            } else {
                System.out.println("no dup");
            }
        }

    }
}
