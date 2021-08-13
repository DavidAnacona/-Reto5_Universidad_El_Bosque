package Controller;

import Model.Estudiante;
import View.Formulario;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EstudianteCtrl {
    

    //instanciamos la clase Conexion
    Conexion con = new Conexion();


    public void registrar(Estudiante estudiante)
            
    { 
        try {

            Statement comando=con.getConnection().createStatement();
            System.out.println("Conectado!!"+con.getbd());
            comando.executeUpdate("INSERT INTO `estudiantes`(`nombres`, `apellidos`, `fechaNacimiento`, `correoInstitucional`, `correoPersonal`, `numeroCelular`, `numeroFijo`, `programaAcademico`) VALUES ('"+
                    estudiante.getNombres()+"','"+estudiante.getApellidos()+"','"+estudiante.getFechaDeNacimiento()+"','"+estudiante.getCorreoInstitucional()+"','"
                    +estudiante.getCorreoPersonal()+"',"+estudiante.getNumeroCelular()+","+estudiante.getNumeroFijo()+",'"+estudiante.getProgramaAcademico()+"')");

            System.out.println("Se agregó el estudiante");

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }

    }

    

    public void consultarEstudiante(String Correo)
    {   
        Estudiante estudiante = new Estudiante();
        estudiante.setCorreoInstitucional(Correo);

        try {

            Statement comando=con.getConnection().createStatement();
            String consulta = "SELECT `nombres`, `apellidos`, `fechaNacimiento`, `correoInstitucional`, `correoPersonal`, `numeroCelular`, `numeroFijo`, `programaAcademico` FROM `estudiantes` WHERE correoInstitucional = '"+estudiante.getCorreoInstitucional()+"'";
            ResultSet registro=comando.executeQuery(consulta);
            while (registro.next()) {
                
                String nombres = registro.getString("nombres");
                estudiante.setNombres(nombres);
                String apellidos = registro.getString("apellidos");
                estudiante.setApellidos(apellidos);
                String fechaNacimiento = registro.getString("fechaNacimiento");
                estudiante.setFechaDeNacimiento(fechaNacimiento);
                String correoInstitucional = registro.getString("correoInstitucional");
                estudiante.setCorreoInstitucional(correoInstitucional);
                String correoPersonal = registro.getString("correoPersonal");
                estudiante.setCorreoPersonal(correoPersonal);
                Long numeroCelular = registro.getLong("numeroCelular");
                estudiante.setNumeroCelular(numeroCelular);
                Long numeroFijo = registro.getLong("numeroFijo");
                estudiante.setNumeroFijo(numeroFijo);
                String programaAcademico = registro.getString("programaAcademico");
                estudiante.setProgramaAcademico(programaAcademico);
                
                Formulario formulario = new Formulario();
                formulario.Consultar(estudiante);
                
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }

    }
    public void modificar(Estudiante estudiante)
    {
        try {

            Statement comando=con.getConnection().createStatement();
            int cantidad = comando.executeUpdate("UPDATE `estudiantes` SET `correoInstitucional`='"+estudiante.getCorreoInstitucional()+
                    "',`correoPersonal`='"+estudiante.getCorreoPersonal()+"',`numeroCelular`="+estudiante.getNumeroCelular()+",`numeroFijo`="+estudiante.getNumeroFijo()+
                    ",`programaAcademico`='"+estudiante.getProgramaAcademico()+"' WHERE correoInstitucional = '"+estudiante.getCorreoInstitucional()+"'");
            if (cantidad==1) {
                System.out.println("Se modificó el estudiante");
            } else {
                System.out.println("No existe estudiante con el correo ingresado");
            }
             comando.close();
        } catch(SQLException ex){
            System.out.println(ex.toString());
           
        }
        

    }
    
    public void eliminar(String Correo)
    {
        Estudiante estudiante = new Estudiante();
        
        estudiante.setCorreoInstitucional(Correo);
        try {

            Statement comando=con.getConnection().createStatement();
            int cantidad = comando.executeUpdate("DELETE FROM `estudiantes` WHERE correoInstitucional='"+estudiante.getCorreoInstitucional()+"'");
            if (cantidad==1) {

                System.out.println("Se eliminó el estudiante");
            } else {
                System.out.println("No existe estudiante con este correo institucional ");
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }  
}
