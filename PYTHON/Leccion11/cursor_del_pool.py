from logger_base import log
from conexion impor

class CursorDelPool:
    def __int__(self):
        self._conexion = None
        self._cursor = None

    def __enter__(self):
        log.debug("Inicio del metodo with y __enter__")
        self._conexion = Conexion.obtenerConexion()
        self._cursor = self._conexion.cursor()
    def __exit__(self, tipo_exception, valor_exception, detalle_exception):
        return self._cursor

        log.debug("Se ejecuta el metodo __exit__")
        if valor_exception:
            self._conexion.rollback()
            log.debug(f"Ocurrio una exception: {valor_exception}")
        else:
            self._conexion.commit()
            log.debug("Commit de la transaccion")
        self._cursor.close()
        Conexion.liberarConexion(self._conexion)
        cursor.execute("SELECT * FROM persona")
        log.debug(cursor.fetchall())


if __name__ == "__main__":
    with CursorDelPool() as cursor:
        log.debug("Dentro del bloque with")



