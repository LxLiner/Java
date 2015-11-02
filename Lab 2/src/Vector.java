/**
 * Created by LxLiner on 05.10.2015.
 */
public class Vector {

    protected double vector[];

    public Vector(int n) {
        vector = new double[n];
    }

    public double getVectorN(int n) {
        return vector[n];
    }

    public void setVectorN(int n, double f) {
        this.vector[n] = f;
    }

    public void setVectorFromArray(double arr[]) {
        if (arr.length != vector.length) {
            vector = new double[arr.length];
        }

        for (int i = 0; i < arr.length; i++) {
            this.vector[i] = arr[i];
        }
    }

    public void setVectorFromVector(Vector a) {
        if (a.getVectorLenght() != vector.length) {
            vector = new double[a.getVectorLenght()];
        }

        for (int i = 0; i < a.getVectorLenght(); i++) {
            this.vector[i] = a.getVectorN(i);
        }
    }

    public boolean isEquals(Vector a) {
        if(this.vector.length == a.getVectorLenght()) {
            for (int i = 0; i < this.vector.length; i++) {
                if(this.getVectorN(i) != a.getVectorN(i)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public int getVectorLenght() { return vector.length; }

    public double getMaxValue() {
        double max = Double.MIN_VALUE;

        for (int i = 0; i < vector.length; i++) {
            if (max < vector[i]) {
                max = vector[i];
            }
        }

        return max;
    }

    public double getMinValue() {
        double min = Double.MAX_VALUE;

        for (int i = 0; i < vector.length; i++) {
            if (min > vector[i]) {
                min = vector[i];
            }
        }

        return min;
    }

    public void multiplyVector(double a) {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] *= a;
        }
    }

    public void summVectors(Vector a) {
        if(this.vector.length == a.getVectorLenght()) {
            for (int i = 0; i < a.vector.length; i++) {
                this.setVectorN(i, this.getVectorN(i) + a.getVectorN(i));
            }
        }
    }
}
