package vector;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LxLiner on 07.10.2015.
 */
public class VectorsTest {

    @Test
    public void testDoSort() throws Exception {
        System.out.println("sort");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] sortedMass = {-50000, -2.9, 0.0, 5.0, 9};
        double[] backSortedMass = {9, 5.0, 0.0, -2.9, -50000};
        ArrayVector instance = new ArrayVector(5);
        instance.vector = mass;
        Vectors.doSort(instance);
        for (int i = 0; i < 5; i++) {
            assertEquals(backSortedMass[i], instance.vector[i], 0.0);
        }
    }
}