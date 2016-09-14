package controlador;

import com.sun.org.apache.xerces.internal.util.DOMUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import datos.comandos;
import datos.MySQLConexion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import struct.Alumno;
import vista.Interfaz;
import java.util.Base64;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eduardo
 */
public class controladorAlumno  implements ActionListener, KeyListener {

    comandos com;
    Alumno alumno;
    MySQLConexion MySQLConexion;
    Interfaz interfaz;
    ResultSet rt;
    Statement st;
    JFileChooser fileChooser;
    String base64String;
    
    public controladorAlumno(comandos com, MySQLConexion MySQLConexion, Interfaz interfaz) 
    {
        this.com = com;
        this.MySQLConexion = MySQLConexion;
        this.interfaz = interfaz;
        alumno =new Alumno();
        fileChooser=new JFileChooser();
    }
    
/*----------------------------------------------------------------------------*/
    public void inicializarVista() throws SQLException {
/*----------------------------------------------------------------------------*/        
        interfaz.setLocationRelativeTo(null);
        interfaz.eliminar.addActionListener(this);
        interfaz.insertar.addActionListener(this);
        interfaz.nuevo.addActionListener(this);
        interfaz.jButtonBuscar.addActionListener(this);
        interfaz.actualizar.addActionListener(this);
        interfaz.jTextFieldBuscar.addKeyListener(this);
        interfaz.jButtonBuscarRuta.addActionListener(this);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);   
    }
/*----------------------------------------------------------------------------*/    
    public void obtenerRuta(){
/*----------------------------------------------------------------------------*/        
        java.io.File archivo=null;
        fileChooser.showOpenDialog(SwingUtilities.getRootPane(interfaz));
        archivo=fileChooser.getSelectedFile();
        if (archivo!=null) 
        {
           interfaz.jTextFieldBuscarRuta.setText(archivo.getAbsolutePath());
        }
    }
/*----------------------------------------------------------------------------*/        
    public void codificarImagen(String ruta) throws IOException{
/*----------------------------------------------------------------------------*/                    
        try {    
        ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
        BufferedImage img=ImageIO.read(new File(ruta));
        ImageIO.write(img,"jpg", baos);
        baos.flush();
        base64String=Base64.getEncoder().encodeToString(baos.toByteArray());
        baos.close();    
        actualizar(base64String);
        
        } catch (Exception e) {System.out.println(e);}
    }
/*----------------------------------------------------------------------------*/    
    public void decodificarImagen(String base64) throws IOException{
/*----------------------------------------------------------------------------*/                
            if (base64.equals("")) {
                JOptionPane.showMessageDialog(null, "Registro sin imagen");
            }else{
                InputStream in=null;
                byte[] imageBytes=null;
                BufferedImage bimage=null;
                imageBytes = Base64.getDecoder().decode(base64);
                in= new ByteArrayInputStream(imageBytes);
                bimage= ImageIO.read(in);
                ImageIcon icon = new ImageIcon(bimage);  
                interfaz.jLabelImagen.setIcon(icon);
            }
            
        
    }    
/*----------------------------------------------------------------------------*/    
    public void Refrescar() throws SQLException {
/*----------------------------------------------------------------------------*/        
        MySQLConexion.Desconectar();
        MySQLConexion.Conectar();
    }
    
/*----------------------------------------------------------------------------*/
    public void LimpiarCajas(){
/*----------------------------------------------------------------------------*/        
        interfaz.jTextFieldMatricula.setText(null);
        interfaz.jTextFieldNombre.setText(null);
        interfaz.jTextFieldApellidoPaterno.setText(null);
        interfaz.jTextFieldApellidoMaterno.setText(null);
        interfaz.jTextFieldGrupo.setText(null);
        interfaz.jTextFieldGeneracion.setText(null);
        interfaz.jTextFieldBuscar.requestFocus();
    }
/*----------------------------------------------------------------------------*/   
    public void actualizar(String base) throws SQLException{
/*----------------------------------------------------------------------------*/           
        try {
        alumno=new Alumno(Integer.parseInt(interfaz.jTextFieldID.getText()),
                            interfaz.jTextFieldMatricula.getText(), 
                            interfaz.jTextFieldNombre.getText(), 
                            interfaz.jTextFieldApellidoPaterno.getText(), 
                            interfaz.jTextFieldApellidoMaterno.getText(),
                            interfaz.jTextFieldGrupo.getText(),
                            interfaz.jTextFieldGeneracion.getText(),
                            base);
        
        MySQLConexion.Conectar();
        st=MySQLConexion.getConexion().createStatement();
        st.executeUpdate(comandos.actualizarAlumno(alumno));
        Refrescar();
            JOptionPane.showMessageDialog(null, "Registro actualizado");
        } catch (Exception e) {System.err.println(e);}
    }
/*----------------------------------------------------------------------------*/       
    public void buscarAlumno() throws SQLException, IOException{
/*----------------------------------------------------------------------------*/   
            alumno=new Alumno();
            alumno.setMatricula(interfaz.jTextFieldBuscar.getText());
            String sqlObtenerMat=com.buscarAlumno(alumno);
            MySQLConexion.Conectar();
            st=MySQLConexion.getConexion().createStatement();
            rt=st.executeQuery(sqlObtenerMat);
            while (rt.next()) 
            {            
                interfaz.jTextFieldID.setText(rt.getString(1));
                interfaz.jTextFieldMatricula.setText(rt.getString(2));
                interfaz.jTextFieldNombre.setText(rt.getString(3));
                interfaz.jTextFieldApellidoPaterno.setText(rt.getString(4));
                interfaz.jTextFieldApellidoMaterno.setText(rt.getString(5));
                interfaz.jTextFieldGrupo.setText(rt.getString(6));
                interfaz.jTextFieldGeneracion.setText(rt.getString(7));
                decodificarImagen(rt.getString(8));
            }
    }

/*
|
|
|
|
| A C T I O N   P E R F O R M E D   O R I G I N A L
|
|
|
|
|    
*/
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try {
/*------------------------------------------------------------------------------
PUSH BUTTON NUEVO
------------------------------------------------------------------------------*/                
                if (e.getActionCommand().equals("Nuevo")) 
                {
                    LimpiarCajas();
                }
/*------------------------------------------------------------------------------
PUSH BUTTON BUSCAR RUTA
------------------------------------------------------------------------------*/                                
                if (e.getActionCommand().equals("Search")){
                    obtenerRuta();
                    String ruta=interfaz.jTextFieldBuscarRuta.getText();
                    codificarImagen(ruta);
                    
                }
/*------------------------------------------------------------------------------
PUSH BUTTON BUSCAR
------------------------------------------------------------------------------*/                
                if (e.getActionCommand().equals("Buscar")) 
                {
                    interfaz.jLabelImagen.setIcon(null);
                    buscarAlumno();
                }                
/*------------------------------------------------------------------------------
PUSH BUTTON INSERT INFORMATION ON DATABASE
------------------------------------------------------------------------------*/    
                if (e.getActionCommand().equals("Insertar")) 
                {
                  
                }
/*------------------------------------------------------------------------------
PUSH BUTTON DELETE USER
------------------------------------------------------------------------------*/    
                if (e.getActionCommand().equals("Eliminar")) 
                {
                   
                }
/*------------------------------------------------------------------------------
PUSH BUTTON UPDATE DATABASE
------------------------------------------------------------------------------*/    
                if (e.getActionCommand().equals("Actualizar")) 
                {
                    
                   
                }
/*------------------------------------------------------------------------------
                                END ACTION COMANDS
------------------------------------------------------------------------------*/    
            } catch (Exception e1) 
                {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
                }
    }
/*------------------------------------------------------------------------------
                                KEYLISTENER
------------------------------------------------------------------------------*/        

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
/*----------------------------------------------------------------------------*/            
                if (e.getSource()==interfaz.jTextFieldBuscar) {
/*----------------------------------------------------------------------------*/                                
                    if (KeyEvent.VK_ENTER == e.getKeyCode()) 
                    {
                        interfaz.jButtonBuscar.doClick();
                    }
                }
            
        } catch (Exception ek) {}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
