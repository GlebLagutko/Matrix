package mainMatrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AppTest {
    @Test
    public void testGetX() {
        Double[] answer = {2d};
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        line.add(2);
        line.add(4);
        matrix.add(line);
        Assert.assertArrayEquals(answer, Matrix.getX(matrix));
    }
}
