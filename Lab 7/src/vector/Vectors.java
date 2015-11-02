package vector;

import vector.impl.ArrayVector;

import java.io.*;

/**
 * Created by LxLiner on 07.10.2015.
 */
public class Vectors {
    public static void doSort(Vector a) {
        for (int i = 0; i < a.getSize() - 1; i++) {
            for (int j = i + 1; j < a.getSize(); j++) {
                if (a.getElement(i) < a.getElement(j)) {
                    double buff = a.getElement(i);
                    a.setElement(i, a.getElement(j));
                    a.setElement(j, buff);
                }
            }
        }
    }

    public static void outputVector(Vector v, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            dos.writeDouble(v.getElement(i));
        }
    }

    public static Vector inputVector(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);
        int size = dis.readInt();
        Vector result = new ArrayVector(size);
        for (int i = 0; i < size; i++) {
            result.setElement(i, dis.readDouble());
        }
        return result;
    }

    public static void writeVector(Vector v, Writer out) throws IOException {
        BufferedWriter bw = new BufferedWriter(out);
        bw.write(Integer.toString(v.getSize()));
        for (int i = 0; i < v.getSize(); i++) {
            bw.write(' ');
            bw.write(Double.toString(v.getElement(i)));
        }
        bw.flush();
    }

    public static Vector readVector(Reader in) throws IOException {
        StreamTokenizer st = new StreamTokenizer(in);
        st.nextToken();
        ArrayVector v = new ArrayVector((int) st.nval);
        int i = 0;
        while (st.nextToken() != st.TT_EOF) {
            v.setElement(i, st.nval);
            i++;
        }
        return v;
    }
}
