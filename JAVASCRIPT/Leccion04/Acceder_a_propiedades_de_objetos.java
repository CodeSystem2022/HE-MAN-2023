let persona2 = new Object(); //Creamos un nuevo objeto en memoria
persona2.nombre = 'Juan';
persona2.direccion = 'Salada 14';
persona2.telefono = '54926182821';
console.log(persona2.nombre);
console.log(persona2.direccion);
console.log(persona2.telefono);//console.log(persona2.teléfono);case sensitive no funciona
console.log('Creamos un nuevo objeto');
console.log(persona['apellido']); //Accedemos al objeto como si fuera un arreglo

console.log('Usamos el ciclo for in')
//for in (accedemos al objeto como si fuera un arreglo)
for(propiedad in persona){
    console.log(propiedad);
    console.log(persona[propiedad]);
}