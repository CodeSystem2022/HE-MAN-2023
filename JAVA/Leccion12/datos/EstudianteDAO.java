package UTN.dominio.datos;

import UTN.dominio.Estudiante;
import static UTN.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
    //metodo listar
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        //creamos algunos objetos que son necesarios para comunicarlos con la base de datos
        PreparedStatement ps;//introduce la sentencia
        ResultSet rs;//obtiene el resultado
        //creamos un objeto de tipo conexion
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 ORDER BY idestudiantes2022";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                //falta agregarlo a la lista
                estudiantes.add(estudiante);
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al seleccionar datos: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion ");
            }
        }//fin finally
        return estudiantes;
    }//fin metodo listar

    //metodo por id -> fin by id
    public boolean buscarEstudiantesPorid(EstudianteDao estudiante)
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiantes.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true; // se encontro un registro
            }//Fin if
        }catch (Exeption e){
        System.out.println("Ocurrio un error al buscar estudiante"+e.getMessage);
        }//Fin catch
    finally {
       try{
           con.close();
       }catch (Exeption e){
           System.out.println("Ocurrio un error al cerrar la conexion:");
       }//Fin catch
    }//Fin finally
    public static void main(String[] args){
        //Listar los estudiantes
        var EstudianteDao = new EstudianteDAO();
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = EstudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println); // Funcion lambda para imprimir

        // Buscar por Id
	    var estudiante1 = new Estudiante(1);
	    System.out.println("Estudiantes antes de la busqueda: " + estudiante1);
	    var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);
	    if(encontrado)
		    System.out.println("Estudiante encontrado: "+estudiante1);
	    else
		    System.out.println("No se encontro el Estudiante: "+estudiante1.getIdEstudiante());
    }




    //Emmanuel Sbona
    //Metodo para modificar estudiante
    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception  e){
            System.out.println("Error al modificar estudiante: "+e.getMessage());
        }//Fin catch
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println(("Error al cerrar la conexion: "+e.getMessage()));
            }//Fin catch
        }//Fin finally
        return false;
    }//Fin metodo modificarEstudiante

public static void main(String[] args) {
        var estudianteDao = new EstudianteDAO();
        //Modificar estudiante
        var estudianteModificado = new Estudiante(1, "Juan Carlos", "Juarez", "545556242", "juancarlosj@mail.com");
        var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
        if(modificado)
            System.out.println("Estudiante modificado: "+estudianteModificado);
        else
            System.out.println("No se modifico el estudiante: "+estudianteModificado);

        //Agregar estudiante
        //var nuevoEstudiante = new Estudiante("Carlos", "Lara", "549855521","carlosl@mail.com");
        //var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
        //if(agregado)
        //    System.out.println("Estudiante agregado: "+nuevoEstudiante);
        //else
        //    System.out.println("No se ha agregado estudiante: "+nuevoEstudiante);

        //Listar los estudiantes
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);//Funcion lambda para imprimir


        //Buscar por id
        //var estudiante1 = new Estudiante(1);
        //System.out.println("Estudiante antes de la busqueda: "+estudiante1);
        //var encontrado = estudianteDao.buscarEstudiantePorId((estudiante1));
        //if(encontrado)
        //    System.out.println("Estudiante encontrado: ");
        //else
        //   System.out.println("No se encontro el estudiante: "+estudiante1.getIdEstudiante());
    }

}

