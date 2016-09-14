package principal;
import controlador.controladorAlumno;
import datos.MySQLConexion;
import datos.comandos;
import vista.Interfaz;
import java.sql.*;

/**
 *
 * @author Eduardo
 */
public class Inicio {
     
    public static void main(String[] args) throws SQLException {
        MySQLConexion conexion = new MySQLConexion();
        Interfaz interfaz = new Interfaz();
        comandos coman = new comandos();
        
        controladorAlumno controlaAlumno = new controladorAlumno(coman, conexion,interfaz);
        
        controlaAlumno.inicializarVista();
        interfaz.setVisible(true);
        
    }
    
}
