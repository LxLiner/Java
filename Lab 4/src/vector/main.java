package vector;

import vector.impl.ArrayVector;
import vector.impl.LinkedVector;

import java.io.*;

import static vector.Vectors.*;

/**
 * Created by LxLiner on 26.10.2015.
 */
public class main {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        ArrayVector av = new ArrayVector(5);
        double[] array = {10, 20, 30, 40, 50};
        av.fillFromMass(array);

        LinkedVector lv = new LinkedVector();
        double[] array2 = {60, 70, 80, 90, 100};
        lv.fillFromMass(array2);

        DataOutputStream out = new DataOutputStream(new FileOutputStream("out.bin"));
        outputVector(av, out);

        DataInputStream in = new DataInputStream(new FileInputStream("out.bin"));
        Vector av2 = inputVector(in);

        System.out.println(av2.toString());

        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
        writeVector(lv, out2);

        BufferedReader in2 = new BufferedReader(new FileReader("out.txt"));
        Vector lv2 = readVector(in2);

        System.out.println(lv2.toString());

        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("serOut.bin"));
        ous.writeObject(lv);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serOut.bin"));
        Vector av3 = (Vector) ois.readObject();

        System.out.println(av3);
    }
}
