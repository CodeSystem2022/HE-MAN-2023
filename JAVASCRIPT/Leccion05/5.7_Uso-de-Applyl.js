

let persona4 = {
    nombre: 'Juan',
    apellido: 'Perez',
    nombreCompleto2: function(){
        //return titulo+': ' +this.nombre+' '+this.apellido+' '+telefono;
        return this.nombre+' '+this.apellido;
    }
}

let persona5 = {
    nombre: 'Carlos',
    apellido: 'Lara'

}

console.log(persona4.nombreCompleto2('Lic.','56484621'))
console.log(persona4.nombreCompleto2.call(persona5, 'Ing','651486168'))

//Uso de Apply

console.log(persona4.nombreCompleto2.apply(persona5));
