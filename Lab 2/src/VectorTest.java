import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LxLiner on 05.10.2015.
 */
public class VectorTest {

    @Test
    public void testGetVectorN() throws Exception {
        System.out.println("getValue");
        int index = 3;
        Vector instance = new Vector(5);
        double expResult = 0.7;
        instance.vector[index] = expResult;
        double result = instance.getVectorN(index);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetVectorN() throws Exception {
        System.out.println("setValue");
        int index = 3;
        double value = 0.7;
        Vector instance = new Vector(5);
        instance.setVectorN(index, value);
        assertEquals(value, instance.vector[index], 0.0);
    }

    @Test
    public void testSetVectorFromArray() throws Exception {
        System.out.println("fillFromMass");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] oldMass = {0.0, 0.9, -6.4, 8, -0.4};
        Vector instance = new Vector(5);
        instance.vector = oldMass;
        instance.setVectorFromArray(mass);
        for (int i = 0; i < 5; i++) {
            assertEquals(mass[i], instance.vector[i], 0.0);
        }
    }

    @Test
    public void testSetVectorFromVector() throws Exception {
        System.out.println("fillFromVector");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] oldMass = {0.0, 0.9, -6.4, 8, -0.4};
        Vector instance = new Vector(5);
        instance.vector = oldMass;
        Vector vector = new Vector(5);
        vector.vector = mass;
        instance.setVectorFromVector(vector);
        for (int i = 0; i < 5; i++) {
            assertEquals(mass[i], instance.vector[i], 0.0);
        }
    }

    @Test
    public void testIsEquals() throws Exception {
        System.out.println("equal");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] newMass = {0.0, 0.9, -6.4, 8, -0.4};
        double[] newOldMass = {5.0, -2.9, 0.0, -50000, 9};
        Vector instance = new Vector(5);
        instance.vector= mass;
        Vector vector = new Vector(5);
        vector.vector = newMass;
        boolean expResult = false;
        boolean result = instance.isEquals(vector);
        assertEquals(expResult, result);

        vector.vector = newOldMass;
        expResult = true;
        result = instance.isEquals(vector);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetVectorLenght() throws Exception {
        System.out.println("getSize");
        int expResult = 5;
        Vector instance = new Vector(expResult);
        int result = instance.getVectorLenght();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxValue() throws Exception {
        System.out.println("getMaxValue");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        Vector instance = new Vector(5);
        instance.vector = mass;
        double expResult = 9;
        double result = instance.getMaxValue();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMinValue() throws Exception {
        System.out.println("getMinValue");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        Vector instance = new Vector(5);
        instance.vector = mass;
        double expResult = -50000;
        double result = instance.getMinValue();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMultiplyVector() throws Exception {
        System.out.println("mult");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] resultMass = {10.0, -5.8, 0.0, -100000, 18};
        Vector instance = new Vector(5);
        instance.vector = mass;
        double number = 2;
        instance.multiplyVector(number);
        for (int i = 0; i < 5; i++) {
            assertEquals(resultMass[i], instance.vector[i],  0.00000000001);
        }
    }

    @Test
    public void testSummVectors() throws Exception {
        System.out.println("sum");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] newMass = {1.1, 0.9, -6.4, 100, -9.4};
        double[] resultMass = {6.1, -2.0, -6.4, -49900, -0.4};
        Vector instance = new Vector(5);
        instance.vector = mass;
        Vector vector = new Vector(5);
        vector.vector = newMass;
        instance.summVectors(vector);
        for (int i = 0; i < 5; i++) {
            assertEquals(resultMass[i], instance.vector[i], 0.00000000001);
        }
    }
}