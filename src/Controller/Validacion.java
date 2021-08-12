package Controller;

import java.util.Scanner;

public class Validacion {
    
    private Scanner leer;
    
    public Validacion(){
        leer = new Scanner(System.in);
    }
    
    public String leerDatoString(String mensaje){
        System.out.println(mensaje);
        String dato = leer.nextLine();
        return dato;
    }
    
    public long leerDatoLong(String mensaje){
        long dato = 0;
        try {
            System.out.println(mensaje);
            dato = leer.nextLong();
            leer.nextLine();
        }catch(Exception e){
            leer.nextLine();
            System.out.println("El dato ingresado no es un número");
            dato = 0;
        }
        return dato;
    }
    
    public double leerDatoDouble(String mensaje){
        System.out.println(mensaje);
        double dato = leer.nextDouble();
        leer.nextLine();
        return dato;
    }
    
    public int leerDatoEntero(String mensaje){
        int dato = 0;
        try {
            System.out.println(mensaje);
            dato = leer.nextInt();
            leer.nextLine();
        }catch(Exception e){
            leer.nextLine();
            System.out.println("El dato ingresado no es un número");
            dato = 0;
        }
        return dato;
    }
    
    public void mostrarInformacion(String mensaje){
        System.out.println(mensaje);
    }
}
