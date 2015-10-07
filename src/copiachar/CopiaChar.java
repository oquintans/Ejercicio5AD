/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiachar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class CopiaChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("texto3.txt")));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("texto3.txt", true)));

            for (int i = 1; i <= 2; i++) {
                dos.writeChars("esta e unha cadea\n");
                System.out.println("Se escribio: esta e unha cadea");
                System.out.println("Se escribieron: " + (dos.size() / i) + " Bytes");
            }
            System.out.println("Total escrito: " + dos.size() + " Bytes");
            dos.close();
            int lineas = 0;

            System.out.println("Tamaño: " + dis.available() + " Bytes\n");
            while (dis.available() != 0) {
                int leido = dis.available();
                String linea = dis.readLine();
                System.out.println("Linea leida: " + linea);
                leido = leido - dis.available();
                System.out.println("Leidos: " + leido + " Bytes");
                System.out.println("Quedan: " + dis.available() + " Bytes");
                lineas++;
            }
            System.out.println("Lineas leidas: " + lineas);
            dis.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopiaChar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopiaChar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
