package mainMatrix;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Matrix {
    public static void main(String[] args) {
        List<String> lines = readFile(new File("src/main/java/mainMatrix/input.txt"));
        for (String line : lines) {
            System.out.println(line);
        }
        List<List<Integer>> matrix = lines.stream().map(parseLine()).collect(Collectors.toList());
        chechMatrix(matrix);
        Double[] answer = getX(matrix);
        System.out.println("Answer : ");
        for (Double x : answer) {
            System.out.println(x);
        }
    }

    protected static void chechMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size() - 1; i++) {
            if (matrix.get(i).get(i) == 0)
                throw new RuntimeException("Det == 0");
        }
    }

    protected static Double[] getX(List<List<Integer>> matrix) {
        int matrixSize = matrix.size();

        Double[] answer = new Double[matrixSize];

        for (int i = matrixSize - 1; i >= 0; i--) {
            List<Integer> currentLine = matrix.get(i);
            double x = currentLine.get(matrixSize);
            for (int j = matrixSize - 1; j > i; j--) {
                x -= answer[j] * currentLine.get(j);
            }
            x /= currentLine.get(i);
            answer[i] = x;
        }
        return answer;
    }

    private static Function<String, List<Integer>> parseLine() {
        return line -> Arrays.asList(line.split(" ")).stream().
                map(Integer::parseInt).
                collect(Collectors.toList());
    }

    private static List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }


}


