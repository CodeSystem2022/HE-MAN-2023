package paquete1;

class Clase2{
    String atributoDefault = "Valor del atributo default";
    /*
    Clase2(){
        System.out.println("Constructor Default");
    }*/
    
    public Clase2(){
        super();
        this.atributoDefault = "Modificacion del atibuto Default";
        System.out.println("atributoDefault = " + this.atributoDefault);
        this.metodoDefault();
    }
    
    void metodoDefault(){
        System.out.println("Metodo Default");
    }
}
