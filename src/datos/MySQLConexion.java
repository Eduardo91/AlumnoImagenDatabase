package datos;
import java.sql.*;


public class MySQLConexion {
        
    private Connection conexion;
    Statement st;
    ResultSet resultado;
    String ruta;
    String usuario;
    String contraseña;
    
    public MySQLConexion() {
        ruta="jdbc:mysql://localhost:3306/alumnosutl";
        usuario="root";
        contraseña ="";
    }
    
    public void Conectar() throws SQLException{
        try{    
            conexion=DriverManager.getConnection( ruta,usuario,contraseña);
            st = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch(Exception e){
            e.printStackTrace();
            conexion = null;
        }
    }
    
    public void Desconectar(){
        
        if(conexion == null)return;
        try{
           conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        conexion = null;
    }

    public Connection getConexion() {
        return conexion;
    }
    
}
