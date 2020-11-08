package FileManager;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Team4
 */
public class FileManager {
    
    int n; //Se utiliza para definir el tamaño de los bloques.
    public String pivot; //Se utiliza para realizar bloques de N tamaño.
    
    public FileManager(int n){
        this.n = n;
        this.pivot = "initial";
    }
    
    /**
     *
     * @param fileName
     * @return Regresa una lista con bloques del tamaño N definido en el constructor.
     * Éste método se debe seguir llamando hasta que el pivote sea nulo, recomendado usar un while.
     */
    public List<String> readBlockFile(String fileName) {
        File keyFile = new File(fileName);
        List<String> keys = new LinkedList<>();
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader(keyFile));
            String reading = input.readLine();
            if(pivot=="initial"){
                for(int i=0; i<n;i++){
                    System.out.println("Clave leida: " + reading);
                    keys.add(reading);
                    reading = input.readLine();
                }
            }
            else{
                while(!reading.equals(pivot)){
                    reading = input.readLine();
                }
                for(int i=0; i<n;i++){
                    if(reading == null){
                        break;
                    }
                    System.out.println("Clave leida: " + reading);
                    keys.add(reading);
                    reading = input.readLine();
                }
            }
            pivot = reading;
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return keys;
    }
        
    /**
     *
     * @param fileName
     * @return Regresa una lista con todas las claves contenidas en el archivo
     * keys.
     */
    public List<String> readKeyFile(String fileName) {
        File keyFile = new File(fileName);
        List<String> keys = new LinkedList<>();
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader(keyFile));
            String reading = input.readLine();
            while (reading != null) {
                System.out.println("Clave leida: " + reading);
                keys.add(reading);
                reading = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return keys;
    }
    
    /**
     * 
     * @param fileName Nombre del archivo en el que se va a escribir la clave.
     * @param keyToWrite Clave que se va a escribir.
     */
    public static void writeKeyFile(String fileName, String keyToWrite) {
        File keyFile = new File(fileName);
        try {
            PrintWriter exit = new PrintWriter(new FileWriter(keyFile, true));
            exit.println(keyToWrite);
            exit.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void createFile(String fileName) {
        File fileC = new File(fileName);
        try {
            PrintWriter exit = new PrintWriter(fileC);
            exit.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
}