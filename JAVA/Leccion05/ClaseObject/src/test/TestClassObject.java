
package test;

import domain.*;

public class TestClassObject {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan", 5000);
        Empleado empleado2 = new Empleado("Juan", 5000);
        
        if (empleado1 == empleado2){
            System.out.println("Tienen la misma referencia en memoria");
        }
        else{
            System.out.println("Tienen distintas referencia en memoria");
        }
        
        if(empleado1.equals(empleado2)){
            System.out.println("Los objetos son iguales en contenido");
        }
        else{
            System.out.println("Los objetos son diferentes en contenido");
        }
        
        if(empleado1.hashCode() == empleado2.hashCode()){
            System.out.println("El vlor hashCode es igual");
        }
        else{
            System.out.println("El valor hashCode es diferente");
        }
        
    }
}
