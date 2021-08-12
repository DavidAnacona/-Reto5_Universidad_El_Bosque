import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Formulariobd extends JFrame implements ActionListener{
    private JPanel pnlTitulo;
    private JPanel pnlOperacion;
    private JPanel pnlBotones;
    private JLabel lblTitulo;
    private JLabel lblcod;
    private JLabel lblti;
    private JLabel lblau;
    private JLabel lbledi;
    private JLabel lblpre;
    private JLabel lblcant;
    private JLabel lblConsu;
    private JTextField txtcod;
    private JTextField txtti;
    private JTextField txtau;
    private JTextField txtedi;
    private JTextField txtpre;
    private JTextField txtcant;
    private JTextField txtConsu;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnConsultar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnSalir;
    private Container contenedor;
    Conexion con = new Conexion();
    libro a = new libro();
    public Formulariobd (){
        //definicion objetos panel del titulo
        this.pnlTitulo = new JPanel();
        this.lblTitulo = new JLabel("BASE DE DATOS LIBRERIA");
        pnlTitulo.add(lblTitulo);
        //definicion panel de objetos de las operaciones
        this.pnlOperacion = new JPanel();
        this.pnlOperacion.setLayout(new GridLayout(7,2));
        this.lblcod = new JLabel("Codigo ");
        this.txtcod = new JTextField(10);
        this.lblti = new JLabel("Titulo ");
        this.txtti = new JTextField(10);
        this.lblau = new JLabel("Autor");
        this.txtau = new JTextField(10);
        this.lbledi = new JLabel("Editorial");
        this.txtedi = new JTextField(10);
        this.lblpre = new JLabel("Precio");
        this.txtpre = new JTextField(10);
        this.lblcant = new JLabel("Cantidad");
        this.txtcant = new JTextField(10);
        this.lblConsu = new JLabel("Consulta Por Editorial");
        this.txtConsu = new JTextField(10);
        //adicionar objetos al panel transaccion
        pnlOperacion.add(lblcod);
        pnlOperacion.add(txtcod);
        pnlOperacion.add(lblti);
        pnlOperacion.add(txtti);
        pnlOperacion.add(lblau);
        pnlOperacion.add(txtau);
        pnlOperacion.add(lbledi);
        pnlOperacion.add(txtedi);
        pnlOperacion.add(lblpre);
        pnlOperacion.add(txtpre);
        pnlOperacion.add(lblcant);
        pnlOperacion.add(txtcant);
        pnlOperacion.add(lblConsu);
        pnlOperacion.add(txtConsu);
        //definicion panel de los botones
        this.pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(2,3));
        this.btnNuevo = new JButton("Nuevo");
        this.btnGuardar = new JButton("Guardar");
        this.btnConsultar = new JButton("Consultar");
        this.btnActualizar = new JButton("Actualizar");
        this.btnEliminar = new JButton("Eliminar");
        this.btnSalir = new JButton("Salir");
        //adicionar objetos al panel botones
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnConsultar);
        pnlBotones.add(btnActualizar);
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnSalir);
        // suscribimos los botones a la accion que java considera mÃ¡s importante para ese componente
        btnNuevo.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnSalir.addActionListener(this);
        // el contenedor obtiene el frame donde ubica los objetos graficos
        this.contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(pnlTitulo, BorderLayout.NORTH);
        contenedor.add(pnlOperacion,BorderLayout.CENTER);
        contenedor.add(pnlBotones,BorderLayout.SOUTH);
        //sentencias menejo de la ventana
        Conexion men = new Conexion();
        setTitle(men.result);
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
            Guardar();
        } else	if(evento.getSource()==btnConsultar){
            Consultar();
        } else	if(evento.getSource()==btnActualizar){
            Actualizar();
        }     else	if(evento.getSource()==btnEliminar){
            Eliminar();
        } else if(evento.getSource()==btnSalir){
            System.exit(0);
        }

    }

    private void Nuevo() {
        txtcod.setText("");
        txtti.setText("");
        txtau.setText("");
        txtedi.setText("");
        txtpre.setText("");
        txtcant.setText("");   
        txtConsu.setText("");
        txtcod.requestFocus();

    }

    private void Guardar() {
        try {

            Statement comando=con.getConnection().createStatement();
            a.setCodigo(Integer.parseInt(txtcod.getText())); 
            a.setTitulo(txtti.getText());
            a.setAutor(txtau.getText());
            a.setEditorial(txtedi.getText());
            a.setPrecio(Integer.parseInt(txtpre.getText()));
            a.setCantidad(Integer.parseInt(txtcant.getText()));
            comando.executeUpdate("insert into libros(codigo,titulo,autor,editorial,precio,cantidad) values ('"+a.getCodigo()+"','"+a.getTitulo()+"','"+a.getAutor()+"','"+a.getEditorial()+"','"+a.getPrecio()+"','"+a.getCantidad()+"')");
            setTitle("Se Registraron Los Datos");
            Nuevo(); 
        } catch(SQLException ex){
            setTitle(ex.toString());
        }
    }

    private void Consultar() {

        Limpiarcampos();  

        try {

            Statement comando=con.getConnection().createStatement();
            a.setEditorial(txtConsu.getText());
            ResultSet registro = comando.executeQuery("select codigo,titulo,autor,editorial,precio,cantidad from libros where editorial= '" +a.getEditorial()+"'" );
            if (registro.next()==true) {
                txtcod.setText(registro.getString("codigo"));  
                txtti.setText(registro.getString("titulo"));
                txtau.setText(registro.getString("autor"));
                txtedi.setText(registro.getString("editorial"));
                txtpre.setText(registro.getString("precio"));
                txtcant.setText(registro.getString("cantidad"));
            } else {
                setTitle("No existe un libro con dicha Editorial");
            }
        } catch(SQLException ex){
            setTitle(ex.toString());
        }

    }

    private void Actualizar() {

        try {

            Statement comando=con.getConnection().createStatement();

            a.setEditorial(txtConsu.getText());
            int cantidad = comando.executeUpdate("update libros set titulo='"+txtti.getText()+"',"+"autor='"+txtau.getText()+"'"+"where editorial='" +a.getEditorial()+"'");
            if (cantidad==1) {
                setTitle("Se modifico los datos del libro con dicho código");
            } else {
                setTitle("No existe un libro dicha Editorial");
            }
        } catch(SQLException ex){
            setTitle(ex.toString());
        }
    }

    private void Eliminar() {
        try {
            Limpiarcampos();
            Statement comando=con.getConnection().createStatement();
            a.setEditorial(txtConsu.getText());
            int cantidad = comando.executeUpdate("delete from libros where editorial= '" +a.getEditorial()+"'");
            if (cantidad==1) {

                setTitle("Se borro el libro con dicha Editorial");
            } else {
                setTitle("No existe un libro con dicha Editorial");
            }

        } catch(SQLException ex){
            setTitle(ex.toString());
        }
    }

    private void Limpiarcampos()
    {
        txtcod.setText("");
        txtti.setText("");
        txtau.setText("");
        txtedi.setText("");
        txtpre.setText("");
        txtcant.setText(""); 	

    }
}
