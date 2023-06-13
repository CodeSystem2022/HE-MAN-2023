class Cliente extends Persona{
    static contadorClientes = 0;

    constructor(nombre,apellido,edad,fecharegistro){
        super(nombre,apellido,edad);

        this._idCliente = ++Cliente.contadorClientes;
        this._fechaRegistro = fecharegistro;
    }

    get idCliente(){
        return this._idCliente;
    }
   
}