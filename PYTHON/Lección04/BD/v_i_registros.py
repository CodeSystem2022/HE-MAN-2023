import psycopg2 #Esto es para poder conectarnos a Postgre

conexion = psycopg2.connect(
    user='postgres',
    password='admin',
    host='127.0.0.1',
    port='5432',
    database='test_bd'
);
try:
    with conexion:
        with conexion.cursor() as cursor:
            sentencia = 'INSERT INTO persona(nombre, apellido, email)VALUES(%s,%s,%s)'
            valores =( ('Carlos', 'Lara', 'clara@email.com')
                       ('Marcos','Canto', 'mcanto@mail.com')
            )  # es una tupla
            cursor.executemany(sentencia, valores)  #De esta nabera ejecutamos la sentencia
            # conexion.commit()# esto se utiliza para guardar cambios en la base de datos
            registros_insertados = cursor.rowcount
            print(f'los registros insertados son: {registros_insertados}')

except Exception as e:
    print(f'Ocurrió un error: {e}')
finally:
    conexion.close()
