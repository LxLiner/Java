package vector;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created by LxLiner on 07.10.2015.
 */
public class ArrayVectorTest {

    @Test
    public void testGetElement() throws Exception {
        System.out.println("getValue");
        int index = 3;
        ArrayVector instance = new ArrayVector(5);
        double expResult = 0.7;
        instance.vector[index] = expResult;
        double result = instance.getElement(index);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetElement() throws Exception {
        System.out.println("setValue");
        int index = 3;
        double value = 0.7;
        ArrayVector instance = new ArrayVector(5);
        instance.setElement(index, value);
        assertEquals(value, instance.vector[index], 0.0);
    }

    @Test
    public void testFillFromMass() throws Exception {
        System.out.println("fillFromMass");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] oldMass = {0.0, 0.9, -6.4, 8, -0.4};
        ArrayVector instance = new ArrayVector(5);
        instance.vector = oldMass;
        instance.fillFromMass(mass);
        for (int i = 0; i < 5; i++) {
            assertEquals(mass[i], instance.vector[i], 0.0);
        }
    }

    @Test
    public void testFillFromVector() throws Exception {
        System.out.println("fillFromVector");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] oldMass = {0.0, 0.9, -6.4, 8, -0.4};
        ArrayVector instance = new ArrayVector(5);
        instance.vector = oldMass;
        ArrayVector vector = new ArrayVector(5);
        vector.vector = mass;
        instance.fillFromVector(vector);
        for (int i = 0; i < 5; i++) {
            assertEquals(mass[i], instance.vector[i], 0.0);
        }
    }

    @Test
    public void testEqual() throws Exception {
        System.out.println("equal");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] newMass = {0.0, 0.9, -6.4, 8, -0.4};
        double[] newOldMass = {5.0, -2.9, 0.0, -50000, 9};
        ArrayVector instance = new ArrayVector(5);
        instance.vector= mass;
        ArrayVector vector = new ArrayVector(5);
        vector.vector = newMass;
        boolean expResult = false;
        boolean result = instance.equals(vector);
        assertEquals(expResult, result);

        vector.vector = newOldMass;
        expResult = true;
        result = instance.equals(vector);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSize() throws Exception {
        System.out.println("getSize");
        int expResult = 5;
        ArrayVector instance = new ArrayVector(expResult);
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxValue() throws Exception {
        System.out.println("getMaxValue");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        ArrayVector instance = new ArrayVector(5);
        instance.vector = mass;
        double expResult = 9;
        double result = instance.getMaxValue();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMinValue() throws Exception {
        System.out.println("getMinValue");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        ArrayVector instance = new ArrayVector(5);
        instance.vector = mass;
        double expResult = -50000;
        double result = instance.getMinValue();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMult() throws Exception {
        System.out.println("mult");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] resultMass = {10.0, -5.8, 0.0, -100000, 18};
        ArrayVector instance = new ArrayVector(5);
        instance.vector = mass;
        double number = 2;
        instance.mult(number);
        for (int i = 0; i < 5; i++) {
            assertEquals(resultMass[i], instance.vector[i],  0.00000000001);
        }
    }

    @Test
    public void testSum() throws Exception {
        System.out.println("sum");
        double[] mass = {5.0, -2.9, 0.0, -50000, 9};
        double[] newMass = {1.1, 0.9, -6.4, 100, -9.4};
        double[] resultMass = {6.1, -2.0, -6.4, -49900, -0.4};
        ArrayVector instance = new ArrayVector(5);
        instance.vector = mass;
        ArrayVector vector = new ArrayVector(5);
        vector.vector = newMass;
        instance.sum(vector);
        for (int i = 0; i < 5; i++) {
            assertEquals(resultMass[i], instance.vector[i], 0.00000000001);
        }
    }
}