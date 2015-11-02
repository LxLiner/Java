package vector.impl;

import vector.IncompatibleVectorSizesException;
import vector.Vector;
import vector.VectorIndexOutOfBoundsException;

/**
 * Created by LxLiner on 07.10.2015.
 */
public class ArrayVector implements Vector, Cloneable {

    protected double data[];

    public ArrayVector(int n) {
        data = new double[n];
    }

    @Override
    public double getElement(int n) {
        if (data.length <= n || n < 0) {
            throw new VectorIndexOutOfBoundsException();
        }
        return data[n];
    }

    @Override
    public void setElement(int n, double f) {
        if (data.length <= n || n < 0) {
            throw new VectorIndexOutOfBoundsException();
        }
        this.data[n] = f;
    }

    @Override
    public void fillFromMass(double arr[]) {
        if (arr.length != data.length) {
            data = new double[arr.length];
        }

        System.arraycopy(arr,0,data,0,data.length);
    }

    @Override
    public void fillFromVector(Vector a) {
        if (a.getSize() != data.length) {
            data = new double[a.getSize()];
        }

        for (int i = 0; i < a.getSize(); i++) {
            this.data[i] = a.getElement(i);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Vector) {
            if (this.getSize() == ((Vector) obj).getSize()) {
                for (int i = 0; i < this.getSize(); i++) {
                    if (this.getElement(i) != ((Vector) obj).getElement(i)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void addElement(double value) {
        double[] temp = new double[data.length+1];
        System.arraycopy(data, 0, temp, 0, data.length);
        temp[temp.length-1] = value;
        this.fillFromMass(temp);
    }

    @Override
    public void insertElement(double value, int pos) {
        if (data.length < pos || pos < 0) {
            throw new VectorIndexOutOfBoundsException();
        }

        double[] temp = new double[data.length+1];

        if (pos == 0) {
            temp[0] = value;
            System.arraycopy(data, pos, temp, pos + 1, temp.length - pos - 1);
        } else {
            System.arraycopy(data,0,temp,0,pos);
            temp[pos] = value;
            System.arraycopy(data, pos, temp, pos + 1, temp.length - pos - 1);
        }

        this.fillFromMass(temp);
    }

    @Override
    public void deleteElement(int pos) {
        if (data.length <= pos || pos < 0) {
            throw new VectorIndexOutOfBoundsException();
        }

        double[] temp = new double[data.length-1];

        if (pos == 0) {
            System.arraycopy(data, pos + 1, temp, 0, data.length - 1);
        } else if (pos == data.length - 1) {
            System.arraycopy(data, 0, temp, 0, data.length - 1);
        } else {
            System.arraycopy(data, 0, temp, 0, pos);
            System.arraycopy(data, pos + 1, temp, pos, temp.length - pos);
        }

        this.fillFromMass(temp);
    }

    @Override
    public int getSize() { return data.length; }

    public double getMaxValue() {
        double max = Double.MIN_VALUE;

        for (int i = 0; i < data.length; i++) {
            if (max < data[i]) {
                max = data[i];
            }
        }

        return max;
    }

    public double getMinValue() {
        double min = Double.MAX_VALUE;

        for (int i = 0; i < data.length; i++) {
            if (min > data[i]) {
                min = data[i];
            }
        }

        return min;
    }

    @Override
    public void mult(double a) {
        for (int i = 0; i < data.length; i++) {
            this.data[i] *= a;
        }
    }

    @Override
    public void sum(Vector a) throws IncompatibleVectorSizesException {
        if(this.data.length == a.getSize()) {
            for (int i = 0; i < a.getSize(); i++) {
                this.setElement(i, this.getElement(i) + a.getElement(i));
            }
        } else {
            throw new IncompatibleVectorSizesException();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(data[0]);

        for (int i = 1; i < this.getSize(); i++){
            str.append(' ');
            str.append(data[i]);
        }

        return new String(str);
    }

    public Object clone() throws CloneNotSupportedException {
        ArrayVector result = (ArrayVector) super.clone();
        result.data = new double[this.getSize()];
        result.fillFromVector(this);
        return result;
    }
}
