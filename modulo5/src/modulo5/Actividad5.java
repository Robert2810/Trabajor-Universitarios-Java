package modulo5;

import java.io.*;
import java.text.*;
import java.util.*;

public class Actividad5 {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double log;
        String ruta, nombre, rCom;
        System.out.println("Ingrese una ruta con el nombre del archivo:");
        System.out.println("Ejemplo de ruta a ingresar: C:\\Users\\SALAS\\Desktop");
        ruta = leer.nextLine();
        System.out.println("Ingrese el nombre del archivo: ");
        nombre = leer.nextLine();
        rCom = ruta + "\\\\"+ nombre + ".txt";
        
        
        
        BufferedReader entrada =  archivoEntrada(rCom);
        if (entrada == null) {
            System.exit(0);
        }
       
        System.out.println("Ingrese la ruta del archivo del salida");
        ruta = leer.nextLine();
        System.out.println("Ingrese el nombre del archivo de salida");
        nombre = leer.nextLine();
        rCom = ruta + "\\\\"+nombre + ".txt";
        
        PrintWriter salida = archivoSalida(rCom);
        promedioLongitudes(convertiraMayus(entrada, salida));
        
        
         }
    
    private static BufferedReader archivoEntrada(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "UTF-8"));
            return entrada;
        } catch (FileNotFoundException ex) {
            //ex.printStackTrace();
            System.out.println("El archivo no existe");
            return null;
        } catch (IOException ex){
            System.out.println("El archivo no existe");
            ex.printStackTrace();
            return null;
        }
        
    }
    
    private static PrintWriter archivoSalida(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            return salida;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static double convertiraMayus(BufferedReader archivoEntr, PrintWriter archivoSali){
    
     double promedio;   
     double ca = 0;
     double caes = 0;
     String mayus = "";
     String mayus2 = "";
     //Lectura del archivo
    try {
         String lectura = archivoEntr.readLine();
        if (lectura != null) {
            mayus += lectura.trim() + "\r\n";
        }
         while (lectura != null) {
             for (char c : lectura.toCharArray()) {
                 if (c == ' ') {
                    // caes++;
                 }else{
                     ca++;
                 }
             }
             lectura.trim();
             StringTokenizer st = new StringTokenizer(lectura);
             caes += st.countTokens();
             lectura = archivoEntr.readLine();
             if (lectura != null) {
                 mayus += lectura + "\r\n";
             }
         }
         archivoEntr.close();
         //variable mayus para la conversion a mayusculas
         mayus2 = mayus.toUpperCase();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    archivoSali.println(mayus2);
    archivoSali.close();
        ca = ca-1;
   promedio = ca/caes;
    
    return promedio;
    }
    
    private static void promedioLongitudes(double result){
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat forma = new DecimalFormat("#.00", dfs);
        System.out.println("Promedio: " + forma.format(result));
    }
    
}
