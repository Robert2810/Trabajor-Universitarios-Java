package simuladordecine;

public class Ventas {
    
    private Pelicula pelicula;   
    private int numeroBoletos;
    private double precioBoleto;
    private double totalVetas;
    private String fecha;
    
  public Ventas(Pelicula pelicula, int numeroBoletos, double precioBoleto, double totalVentas, String fecha){
      this.pelicula = pelicula;
      this.numeroBoletos = numeroBoletos;
      this.precioBoleto = precioBoleto;
      this.totalVetas = totalVentas;
      this.fecha = fecha;
  }
  //Metodos Acumulativos
  public void VentaBoleto(int boletos){
      this.numeroBoletos += boletos;
  }
  
  public void Total(double total){
      this.totalVetas += total;
  }
  
  //Metodos Accesors y Mutattors
  public Pelicula getPelicula(){
    return pelicula;
  }

  public void setPelicula(Pelicula pelicula){
    this.pelicula = pelicula;
  }
  
  public int getNumeroBoletos(){
    return numeroBoletos;
  }
  
  public void setNumeroBoletos(int numero){
      this.numeroBoletos = numero;
  }

  public double getPrecioBoleto(){
    return precioBoleto;
  }

  public void setPrecioBoleto(double precio){
    this.precioBoleto = precio;
  }
  
  public double getTotalVentas(){
      return totalVetas;
  }
  
  public void setTotalVentas(double total){
      this.totalVetas = total;
  }
  
  public String getFecha(){
      return fecha;
  }
  
  public void getFecha(String fecha){
      this.fecha = fecha;
  }
  
  public void VentasTotal(){
      System.out.println("###Titulo de la Pelicula:");
      System.out.println("#"+pelicula.getTitulo());
      System.out.println("#Total de Boletos Vendidos: "+numeroBoletos);
      System.out.println("#Total de Ventas: "+totalVetas);
  }
    
}
