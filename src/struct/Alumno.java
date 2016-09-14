package struct;

/**
 *
 * @author Eduardo
 */
public class Alumno {
    
   private int idAlumno; 
   private String matricula; 
   private String nombre;
   private String apellidoPaterno;
   private String apellidoMaterno;
   private String grupo;
   private String generarcion;
   private String fotografia;
   
   public Alumno()
   {
   }

    public Alumno(int idAlumno, String matricula, String nombre, String apellidoPaterno, String apellidoMaterno, String grupo, String generarcion, String fotografia) {
        this.idAlumno = idAlumno;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.grupo = grupo;
        this.generarcion = generarcion;
        this.fotografia = fotografia;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGenerarcion() {
        return generarcion;
    }

    public void setGenerarcion(String generarcion) {
        this.generarcion = generarcion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
   

      
}
