

package datos;
import struct.Alumno;

/**
 *
 * @author Eduardo
 */
public class comandos {
  
    public static String insertarAlumno(Alumno a){
        
        String query = "INSERT INTO alumno(matricula,nombre,apellidoPaterno,apellidoMaterno,grupo,generacion,fotografia) VALUES ('"+a.getMatricula()+"','"+a.getNombre()+"','"+a.getApellidoPaterno()+ "','"+a.getApellidoMaterno()+"','"+a.getGrupo()+"','"+a.getGenerarcion()+"','"+a.getFotografia()+"');";
        return query;        
    }
    
    public String buscarAlumno(Alumno a){
        String query="SELECT * FROM alumno WHERE matricula='"+a.getMatricula()+"';";
        return query;
    }
    
    
   public static String eliminarAlumno(Alumno a){
       
       String query = "Delete From alumno where matricula='"+a.getMatricula()+"';";
       return query;
   }
   public static String consultarTodo(Alumno a){
       String query="SELECT * FROM alumno";
       return query;
   }
   
   public static String actualizarAlumno(Alumno a){
       String query = "UPDATE alumno SET matricula='"+a.getMatricula()+
               "',nombre='"+a.getNombre()+
               "',apellidoPaterno='"+a.getApellidoPaterno()+
               "',apellidoMaterno='"+a.getApellidoMaterno()+
               "',grupo='"+a.getGrupo()+
               "',generacion='"+a.getGenerarcion()+
               "',fotografia='"+a.getFotografia()+
               "' WHERE idAlumno="+
               a.getIdAlumno()+";"
                ;
       return query;
   }
}
