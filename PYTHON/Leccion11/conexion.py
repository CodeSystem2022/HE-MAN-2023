from psycopg2 import pool
#psycopg2 as bd otra manera de importar el psycopg2
from logger_base import log
import sys

class Conexion:
    _DATABASE = "test_bd"
    _USERNAME = "postgres"
    _PASSWORD = "Admin"
    _DB_PORT = "5432"
    _HOST = "127.0.0.1"
    _MIN_CON = 1
    _MAX_CON = 5
    _pool = None

    @classmethod
    def obtenerConexion(cls):
        conexion = cls.obtenerpool().getconn()
        log.debug(f"Conexion obtenida del pool: {conexion}")
        return conexion


    @classmethod
    def obtenerpool(cls):
        if cls._pool is None:
            try:
                cls._pool = pool.SimpleConnectionPool(cls._MIN_CON,
                                                      cls._MAX_CON,
                                                      host=cls._HOST,
                                                      user=cls._USERNAME,
                                                      password=cls._PASSWORD,
                                                      port=cls._DB_PORT,
                                                      database=cls._DATABASE)
                log.debug(f"Creacion del exitosa: {cls._pool}")
                return cls._pool
            except  Exception as e:
                log.error(f"Ocurrio un error al obtener el pool: {e}")
                sys.exit()
        else:
            return cls._pool


    @classmethod
    def liberarConexion(cls, conexion):
        cls.obtenerpool().putconn(conexion)
        log.debug(f"Regresamos la conexion del pool: {conexion}")


if __name__ == "__main__":
    conexion1 = Conexion.obtenerConexion()
    Conexion.liberarConexion(conexion1)
    conexion2 = Conexion.obtenerConexion()
    Conexion.liberarConexion(conexion2)
    conexion3 = Conexion.obtenerConexion()
    Conexion.liberarConexion(conexion3)
    conexion4 = Conexion.obtenerConexion()
    conexion5 = Conexion.obtenerConexion()
    conexion6 = Conexion.obtenerConexion()


