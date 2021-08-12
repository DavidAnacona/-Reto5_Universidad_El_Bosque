package View;

import Controller.EstudianteCtrl;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.Validacion;
import Model.Estudiante;


public class Formulario extends JFrame implements ActionListener{
    
    Validacion validacion = new Validacion();
    EstudianteCtrl estudianteCtrl = new EstudianteCtrl();
    
    private JPanel pnlTitulo;
    private JPanel pnlOperacion;
    private JPanel pnlBotones;
    private JLabel lblTitulo;
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JLabel lblFechaDeNacimiento;
    private JLabel lblCorreoInstitucional;
    private JLabel lblCorreoPersonal;
    private JLabel lblNumeroCelular;
    private JLabel lblNumeroFijo;
    private JLabel lblProgramaAcademico;
    private JLabel lblCorreoBuscar;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtFechaDeNacimiento;
    private JTextField txtCorreoInstitucional;
    private JTextField txtCorreoPersonal;
    private JTextField txtNumeroCelular;
    private JTextField txtNumeroFijo;
    private JTextField txtProgramaAcademico;
    private JTextField txtCorreoBuscar;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnConsultar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnSalir;
    private Container contenedor;
    
    public Formulario(){
        //Definicionde objetos panel del titulo
        
        this.pnlTitulo = new JPanel();
        this.lblTitulo = new JLabel("Instituto La Floresta");
        pnlTitulo.add(lblTitulo);
        
        //Definimos el panel principal de ingreso de informacion
        
        this.pnlOperacion = new JPanel();
        this.pnlOperacion.setLayout(new GridLayout(10,2));
        this.lblNombres = new JLabel("Nombres: ");
        this.txtNombres = new JTextField(15);
        this.lblApellidos = new JLabel("Apellidos: ");
        this.txtApellidos = new JTextField(15);
        this.lblFechaDeNacimiento = new JLabel("Fecha de nacimiento: ");
        this.txtFechaDeNacimiento = new JTextField(15);
        this.lblCorreoInstitucional = new JLabel("Correo institucional: ");
        this.txtCorreoInstitucional = new JTextField(15);
        this.lblCorreoPersonal = new JLabel("Correo personal: ");
        this.txtCorreoPersonal = new JTextField(15);
        this.lblNumeroCelular = new JLabel("Numero celular: ");
        this.txtNumeroCelular = new JTextField(15);
        this.lblNumeroFijo = new JLabel("Numero fijo: ");
        this.txtNumeroFijo = new JTextField(15);
        this.lblProgramaAcademico = new JLabel("Programa academico: ");
        this.txtProgramaAcademico = new JTextField(15);
        this.lblCorreoBuscar = new JLabel("Correo para buscar estudiante: ");
        this.txtCorreoBuscar = new JTextField(15);
        
        //Adicionamos los objetos principales al panel
        
        pnlOperacion.add(lblNombres);
        pnlOperacion.add(txtNombres);
        pnlOperacion.add(lblApellidos);
        pnlOperacion.add(txtApellidos);
        pnlOperacion.add(lblFechaDeNacimiento);
        pnlOperacion.add(txtFechaDeNacimiento);
        pnlOperacion.add(lblCorreoInstitucional);
        pnlOperacion.add(txtCorreoInstitucional);
        pnlOperacion.add(lblCorreoPersonal);
        pnlOperacion.add(txtCorreoPersonal);
        pnlOperacion.add(lblNumeroCelular);
        pnlOperacion.add(txtNumeroCelular);
        pnlOperacion.add(lblNumeroFijo);
        pnlOperacion.add(txtNumeroFijo);
        pnlOperacion.add(lblProgramaAcademico);
        pnlOperacion.add(txtProgramaAcademico);
        
        //Definimos ahora los botones que utilizaremos para el crud
        this.pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(2,3));
        this.btnNuevo = new JButton("Nuevo");
        this.btnGuardar = new JButton("Guardar");
        this.btnConsultar = new JButton("Consultar");
        this.btnActualizar = new JButton("Actualizar");
        this.btnEliminar = new JButton("Eliminar");
        this.btnSalir = new JButton("Salir");
        
        //adicionamos los botones al Jpanel que los contendra
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnConsultar);
        pnlBotones.add(btnActualizar);
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnSalir);
        
        //Suscribimos los botones a la accion que en java se considera mas importante
        btnNuevo.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnSalir.addActionListener(this);
        
        //Contenedor es el objeto papa de todos los Jpanel que hemos creado por lo que contendra toda nuestra parte grafica 
        this.contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(pnlTitulo, BorderLayout.NORTH);
        contenedor.add(pnlOperacion, BorderLayout.CENTER);
        contenedor.add(pnlBotones, BorderLayout.SOUTH);
        
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource()==btnNuevo){
            Nuevo();
        }else	if(evento.getSource()==btnGuardar){
            AgregarEstudiante();
        } else	if(evento.getSource()==btnConsultar){
            ConsultarEstudianteCorreo();
        } else	if(evento.getSource()==btnActualizar){
            Actualizar();
        }     else	if(evento.getSource()==btnEliminar){
            Eliminar();
        } else if(evento.getSource()==btnSalir){
            System.exit(0);
        }
    }
    public void Nuevo(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFechaDeNacimiento.setText("");
        txtCorreoInstitucional.setText("");
        txtCorreoPersonal.setText("");
        txtNumeroCelular.setText("");
        txtNumeroFijo.setText("");
        txtProgramaAcademico.setText("");
        txtNombres.requestFocus();
    }
    
    public void AgregarEstudiante(){
        
        Estudiante estudiante = new Estudiante();
        
        estudiante.setNombres(validacion.leerDatoString(txtNombres.getText()));
        estudiante.setApellidos(validacion.leerDatoString(txtApellidos.getText()));
        estudiante.setFechaDeNacimiento(validacion.leerDatoString(txtFechaDeNacimiento.getText()));
        estudiante.setCorreoInstitucional(validacion.leerDatoString(txtCorreoInstitucional.getText()));
        estudiante.setCorreoPersonal(validacion.leerDatoString(txtCorreoPersonal.getText()));
        estudiante.setNumeroCelular(validacion.leerDatoLong(txtNumeroCelular.getText()));
        estudiante.setNumeroFijo(validacion.leerDatoLong(txtNumeroFijo.getText()));
        estudiante.setProgramaAcademico(validacion.leerDatoString(txtProgramaAcademico.getText()));
        estudianteCtrl.registrar(estudiante);
    }
    
    public void ConsultarEstudianteCorreo(){
        String correoBuscar = txtCorreoBuscar.getText();
        estudianteCtrl.consultarEstudiante(correoBuscar);
    }
    
    public void Consultar(Estudiante estudiante){
        
        txtNombres.setText(estudiante.getNombres());
        txtApellidos.setText(estudiante.getApellidos());
        txtFechaDeNacimiento.setText(estudiante.getFechaDeNacimiento());
        txtCorreoInstitucional.setText(estudiante.getCorreoInstitucional());
        txtCorreoPersonal.setText(estudiante.getCorreoPersonal());
        txtNumeroCelular.setText(Long.toString(estudiante.getNumeroCelular()));
        txtNumeroFijo.setText(Long.toString(estudiante.getNumeroFijo()));
        txtProgramaAcademico.setText(estudiante.getProgramaAcademico());
        txtCorreoBuscar.setText("");
    }
    public void Actualizar(){
        Estudiante estudiante = new Estudiante();
        
        estudiante.setCorreoInstitucional(txtCorreoInstitucional.getText());
        estudiante.setCorreoPersonal(txtCorreoPersonal.getText());
        estudiante.setNumeroCelular(Long.parseLong(txtNumeroCelular.getText()));
        estudiante.setNumeroFijo(Long.parseLong(txtNumeroFijo.getText()));
        estudiante.setProgramaAcademico(txtProgramaAcademico.getText());
        
        estudianteCtrl.modificar(estudiante);
    }
    
    public void Eliminar(){
        LimpiarCampos();
        String correo = txtCorreoInstitucional.getText();
        
        estudianteCtrl.eliminar(correo);
    }
    
    public void LimpiarCampos(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFechaDeNacimiento.setText("");
        txtCorreoInstitucional.setText("");
        txtCorreoPersonal.setText("");
        txtNumeroCelular.setText("");
        txtNumeroFijo.setText("");
        txtProgramaAcademico.setText("");
    }
}
