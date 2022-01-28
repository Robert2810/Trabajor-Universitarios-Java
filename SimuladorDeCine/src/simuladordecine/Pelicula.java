package simuladordecine;

public class Pelicula {
    
    private String titulo;
    private String director;
    private String año;
    private String pais;
    private int duracion;
    private double precio;
    private String sinopsis;
    private String horario;
    
    public Pelicula(String titulo, String director, String año, String pais, int duracion, double precio, String sinopsis, String horario){
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.pais = pais;
        this.duracion = duracion;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.horario = horario;
                
    }
    
    public void mostrarDetalles(){
        System.out.println("-------------------------------");
        System.out.println("| Informacion  de la Pelicula:");
        System.out.println("| Titulo:################# " + titulo);
        System.out.println("| Nombre del Director:#### " + director);
        System.out.println("| Año:#################### " + año);
        System.out.println("| Pais:################### " + pais);
        System.out.println("| Duracion:############### " + duracion);
        System.out.println("| Precio:################# " + precio);
        System.out.println("| Sinopsis:############### " + sinopsis);
        System.out.println("| Hora de Transmision:#### " + horario);
    }

    public double getPrecio(){
      return precio;
    }

    public void setPrecio(double precio){
      this.precio = precio;
    }
    
    public String getTitulo(){
    return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    
}
