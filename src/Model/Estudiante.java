package Model;


import java.io.*;

public class Estudiante{
    
    //Definimos las acaracteristicas de nuestro objeto Estudiante 
    private String nombres;
    private String apellidos;
    private String fechaDeNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private Long numeroCelular;
    private Long numeroFijo;
    private String ProgramaAcademico;

    public Estudiante() {
    }

    public Estudiante(String nombres, String apellidos, String fechaDeNacimiento, String correoInstitucional, String correoPersonal, Long numeroCelular, Long numeroFijo, String ProgramaAcademico) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.numeroCelular = numeroCelular;
        this.numeroFijo = numeroFijo;
        this.ProgramaAcademico = ProgramaAcademico;
    }
    //Creamos los get y set de todas las caracteristicas de nuestro objeto Estudiante
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public Long getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(Long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Long getNumeroFijo() {
        return numeroFijo;
    }

    public void setNumeroFijo(Long numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    public String getProgramaAcademico() {
        return ProgramaAcademico;
    }

    public void setProgramaAcademico(String ProgramaAcademico) {
        this.ProgramaAcademico = ProgramaAcademico;
    }
 
}
