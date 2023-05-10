class ManejoArchivos:
	def __init__(self, nombre):
		self.nombre = nombre

	def __enter__(self):
		print('Obtenemos el recurso' .center(50, '-'))
		self.nombre = open(sel.nombre,'r', encoding='utf8') #Encapsulamos el codigo dentro del metodo
		return self.nombre
	def __exit__(self, exc_type, exc_val, traza_error):
		print('cerramos el recurso' .center(50, '-'))
		if self.nombre: 
			self.nombre.close() #cerramos el archivo
