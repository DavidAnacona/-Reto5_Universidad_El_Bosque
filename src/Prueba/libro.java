
public class libro {
    public int codigo;
    public String titulo;
    public String autor;
    public String editorial;
    public int precio;
    public int cantidad;

    // Este constructor nos permite crear un libro sin ningún atributo.
    public libro(){}

    // Este constructor nos permite crear un libro el cual va a contener inmediatamente
    // todas sus variables asignadas.
    public libro(int codigo,String titulo, String autor, String editorial, int precio, int cantidad)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio=precio;
        this.cantidad=cantidad;
    }

    // Cabe mencionar que aunque creemos un libro sin atributos, siempre podemos
    // Asignarselos más adelante en el código utilizando los getters y setters.

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setEditorial(String editorial){
        this.editorial = editorial;
    }

    public String getEditorial(){
        return this.editorial;
    }

    public void setPrecio(int precio){
        this.precio=precio;
    }

    public int getPrecio(){
        return this.precio;
    }  
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }

    public int getCantidad(){
        return this.cantidad;
    }   
}