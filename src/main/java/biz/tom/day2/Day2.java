package biz.tom.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


public class Day2 {

    //PART 1
    private static final String[][] keys = {
            new String[]{"1", "2", "3"},
            new String[]{"4", "5", "6"},
            new String[]{"7", "8", "9"}
    };
    private static final Map<String, Function<Coord, Coord>> keyMapHM = new HashMap<>() {
        {
            put("U", p -> p.x > 0 ? new Coord(p.x - 1, p.y) : p);
            put("D", p -> p.x < keys.length - 1 ? new Coord(p.x + 1, p.y) : p);
            put("L", p -> p.y > 0 ? new Coord(p.x, p.y - 1) : p);
            put("R", p -> p.y < keys.length - 1 ? new Coord(p.x, p.y + 1) : p);
        }
    };

    //PART 2
    private static final String[][] keys2 = {
            new String[]{null, null, "1", null, null},
            new String[]{null, "2", "3", "4", null},
            new String[]{"5", "6", "7", "8", "9"},
            new String[]{null, "A", "B", "C", null},
            new String[]{null, null, "D", null, null},
    };

    private static final Map<String, Function<Coord, Coord>> keyMap2 = new HashMap<String, Function<Coord, Coord>>() {
        {
            put("U", p -> (p.x > 0 && keys2[p.x - 1][p.y] != null) ? new Coord(p.x - 1, p.y) : p);
            put("D", p -> (p.x < keys2.length - 1 && keys2[p.x + 1][p.y] != null) ? new Coord(p.x + 1, p.y) : p);
            put("L", p -> (p.y > 0 && keys2[p.x][p.y - 1] != null) ? new Coord(p.x, p.y - 1) : p);
            put("R", p -> (p.y < keys2.length - 1 && keys2[p.x][p.y + 1] != null) ? new Coord(p.x, p.y + 1) : p);
        }
    };

    private static String solve(List<String> instructions, String[][] keypad, Coord current) {
        StringBuilder codeBuilder = new StringBuilder();
        for (String instruction : instructions) {
            current = Arrays.stream(instruction.split("")).reduce(current, (subResult, nextEl) -> Day2.keyMap2.get(nextEl).apply(subResult), (p1, p2) -> p1);
            codeBuilder.append(keypad[current.x][current.y]);
        }
        return codeBuilder.toString();
    }

    public static List<String> getInstructions(String s) throws IOException {
        String filepath = "src/main/resources/" + s;

        List<String> instructions = Files.readAllLines(Paths.get(filepath));

        return instructions;
    }

    public static void main(String[] args) throws IOException {

        List<String> instructions = getInstructions("day2_input.txt");
        System.out.println("Instructions = " + instructions);
        String code = solve(instructions, keys2, new Coord(2, 0));
        System.out.println(code);
        //Solve(instructions);

    }

    private record Coord(int x, int y) {

    }

}
