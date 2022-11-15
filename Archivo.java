package utilerias;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Archivo {

    public static ArrayList leer(String cad) {
        ArrayList a = new ArrayList();
        try {
            FileInputStream fi = new FileInputStream(cad);
            ObjectInputStream oi = new ObjectInputStream(fi);
            a = (ArrayList) oi.readObject();
            oi.close();
        } catch (Exception exception) {
            System.out.println("Error al abrir archivo" + exception.toString());
        }
        return a;
    }
    public static void guardar(ArrayList a, String nombrearch){
        try {
                        FileOutputStream fo = new FileOutputStream(nombrearch);
                        ObjectOutputStream oo = new ObjectOutputStream(fo);
                        oo.writeObject(a);
                        oo.close();
                        System.out.println("Se guardo correctamente");
                    } catch (IOException e) {
                        System.out.println("Error " + e.toString());
                    }
    }
}
