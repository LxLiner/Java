package vector;

import vector.impl.LinkedVector;

import java.io.Serializable;

/**
 * Created by LxLiner on 07.10.2015.
 */
public interface Vector extends Cloneable, Serializable{

    double getElement(int n);

    void setElement(int n, double value);

    int getSize();

    void fillFromMass(double arr[]);

    void fillFromVector(Vector a);

    void mult(double f);

    void sum(Vector a) throws IncompatibleVectorSizesException;

    boolean equals(Object obj);

    void addElement(double value);

    void insertElement(double value,int pos);

    void deleteElement(int pos);

    String toString();
}
