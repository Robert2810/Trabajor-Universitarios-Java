package simuladordecine;

import java.util.Scanner;

public class SimuladorDeCine {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int boletos = 0;
        double total = 0;
        String[][] asientosCine = new String[7][21];//Matriz principal

        boolean menu = false;//Variable controladora del switch principal

        String titulo, director, año, pais, sinopsis, horario = null;
        int duracion;
        double precio;

        //Inicializacion de la Matriz
        for (int i = 0; i < asientosCine.length; i++) {
            for (int j = 0; j < asientosCine[i].length; j++) {
                asientosCine[i][j] = "0";
            }
        }

        //Informacion de la Pelicula
//        System.out.println("Ingrese los datos de la pelicula a proyectar:");
//        System.out.println("Titulo: "); 
//        titulo = leer.nextLine();
//        System.out.println("Director: "); 
//        director = leer.nextLine();
//        System.out.println("Año: "); 
//        año = leer.nextLine();
//        System.out.println("Pais: "); 
//        pais = leer.nextLine();
//        System.out.println("Sinopsis: "); 
//        sinopsis = leer.nextLine();
//        System.out.println("Horario de Estreno: "); 
//        horario = leer.nextLine();
//        System.out.println("Duracion en min: "); 
//        duracion = leer.nextInt();
//        System.out.println("Precio en pesos($): "); 
//        precio = leer.nextDouble();
//Informacion se pelicula para pruebas
        titulo = "Chernóbil: La película";
        director = "Danila Kozlovsky";
        año = "2021";
        pais = "Rusia";
        sinopsis = "Primer gran largometraje ruso sobre las "
                + "\n| consecuencias de la explosión de la central nuclear de "
                + "\n| Chernóbil, cuando cientos de personas sacrificaron sus "
                + "\n| vidas para limpiar el lugar de la catástrofe y evitar con "
                + "\n| éxito un desastre aún mayor que podría haber convertido "
                + "\n| una gran parte del continente europeo en una zona de "
                + "\n| exclusión inhabitable.";
        horario = " 6:00PM 27/04/2021";
        duracion = 136;
        precio = 2500.00;

        //Creacion de Objeto Pelicula
        Pelicula p1 = new Pelicula(titulo, director, año, pais, duracion, precio, sinopsis, horario);
        Ventas v1 = new Ventas(p1, 0, 0, 0, horario);
        System.out.println("");

        //Menu Principal
        do {
            int ope = 0;
            System.out.println("Operaciones de Taquilla: ");
            System.out.println("1)Venta de Boletos");
            System.out.println("2)Ver Informacion de la Pelicula");
            System.out.println("3)Resumen de Ventas");
            System.out.println("4)Salir");
            ope = leer.nextInt();

            switch (ope) {
                case 1:
                    int opc;
                    boolean opciw = false;
                    System.out.println("Venta de Boletos");
                    //sentencias de Ventas de Boletos
                    String[][] asientosAsig = new String[7][21];//Matriz secundaria
                    //Inicializar secundaria matriz:
                    for (int i = 0; i < asientosAsig.length; i++) {
                        for (int j = 0; j < asientosAsig[i].length; j++) {
                            asientosAsig[i][j] = "0";
                        }
                    }

                    System.out.println("Cuantos boletos desea comprar:");
                    boletos = leer.nextInt();

                    System.out.println("");
                    System.out.println("Puestos disponibles: 0 Ocupados X:");
                    System.out.println("Referencia para elegir los puestos:");
                    System.out.println("REN: " + asientosCine.length + " COL: " + asientosCine[0].length);

                    //Mostrar la matriz
                    System.out.println("\t\t| PANTALLA |          ");
                    System.out.println("");
                    for (int i = 0; i < asientosCine.length; i++) {
                        System.out.print("\t  ");
                        for (int j = 0; j < asientosCine[i].length; j++) {
                            System.out.print(asientosCine[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    //Asignacion de asientos:
                    System.out.println("Selecciones los asientos: ");
                    for (int i = 0; i < boletos; i++) {
                        int ar = 0, ac = 0, pr = 0, pc = 0, whi;

                        do {
                            System.out.println("Asiento Nro: " + (i + 1));
                            System.out.print("REN: ");
                            pr = leer.nextInt();
                            System.out.print("COL: ");
                            pc = leer.nextInt();

                            if ((pr > 0 && pr < 8) && (pc > 0 && pc < 22)) {
                                ar = (pr - 1);
                                ac = (pc - 1);
                                //Validar asientos disponibles
                                if (asientosCine[ar][ac] == "X" || asientosAsig[ar][ac] == "X") {
                                    System.out.println("Lo sentimos, el asiento esta ocupado, elija otro");
                                    whi = 1;
                                } else {
                                    //Ocupar Asientos Matriz secundaria:
                                    asientosAsig[ar][ac] = "X";
                                    whi = 0;
                                }

                            } else {
                                System.out.println("Columna o Fila que supera los limites esistentes");
                                whi = 1;
                            }
                        } while (whi == 1);

                    }

                    double Costo = p1.getPrecio();
                    //Calculo de total de ventas boletos
                    total = boletos * Costo;
                    System.out.println("\nMonto total de la Venta de Boletos: " + total + "\n");
                    int error = 0,
                     si;
                    do {
                        System.out.println("Desea realizar la compra de los Boletos:");
                        System.out.println("Si = 1, No = 0");
                        si = leer.nextInt();
                        if (si == 1) {
                            for (int i = 0; i < asientosAsig.length; i++) {
                                for (int j = 0; j < asientosAsig[0].length; j++) {
                                    if (asientosCine[i][j] == "0") {
                                        if (asientosAsig[i][j] == "X") {
                                            asientosCine[i][j] = asientosAsig[i][j];

                                        }
                                    }
                                }
                            }
                            v1.VentaBoleto(boletos);
                            v1.setPrecioBoleto(p1.getPrecio());
                            v1.Total(total);
                            System.out.println("Comprados Satisfactoriamente.");
                            //Mostrar la matriz
                            System.out.println("\t\t| PANTALLA |          ");
                            System.out.println("");
                            for (int i = 0; i < asientosCine.length; i++) {
                                System.out.print("\t  ");
                                for (int j = 0; j < asientosCine[i].length; j++) {
                                    System.out.print(asientosCine[i][j] + " ");
                                }
                                System.out.println("");
                            }
                            error = 0;
                        } else if (si == 0) {

                            error = 0;
                        } else {
                            System.out.println("Coloque una opcion valida");
                            error = 1;
                        }
                    } while (error == 1);

                    //Salida de Venta de Boletos 
                    do {
                        System.out.println("Desea Volver al Menu 1: si, 0: Salir: ");
                        opc = leer.nextInt();
                        if (opc == 1) {
                            opciw = false;
                            menu = true;
                        } else if (opc == 0) {
                            opciw = false;
                            menu = false;
                        } else {
                            System.out.println("Por favor ingrese una opcion validad");
                            opciw = true;
                        }
                    } while (opciw);
                    break;
                case 2:
                    System.out.println("");
                    p1.mostrarDetalles();
                    System.out.println("");
                    //
                    int opc2;
                    boolean opewh2;
                    do {
                        System.out.println("Desea abandonar el programa o Volver al menu: ");
                        System.out.println(" 1: Salir, 0: Menu");
                        opc2 = leer.nextInt();
                        if (opc2 == 1) {//Termina el programa                    
                            menu = false;
                            opewh2 = false;
                        } else if (opc2 == 0) {//Vuelve al menu 
                            menu = true;
                            opewh2 = false;
                        } else {
                            System.out.println("Por favor ingrese una opcion validad");
                            opewh2 = true;
                        }
                    } while (opewh2);

                    break;
                case 3:
                    int opc3;
                    boolean opewh3;

                    System.out.println("###Resumen de Ventas###");
                    v1.VentasTotal();
                    do {
                        //Salida de Resumen de Ventas
                        System.out.println("Desea Volver al Menu 1: si, 0: Salir: ");
                        opc3 = leer.nextInt();
                        if (opc3 == 1) {
                            opewh3 = false;
                            menu = true;
                        } else if (opc3 == 0) {
                            opewh3 = false;
                            menu = false;
                        } else {
                            System.out.println("Por favor ingrese una opcion validad");
                            opewh3 = true;
                        }
                    } while (opewh3);

                    break;
                case 4:
                    int opc1;
                    boolean opewh;
                    do {
                        System.out.println("Desea abandonar el programa: ");
                        System.out.println(" 1: si, 0: No");
                        opc1 = leer.nextInt();
                        if (opc1 == 1) {
                            menu = false;
                            opewh = false;
                        } else if (opc1 == 0) {
                            menu = true;
                            opewh = false;
                        } else {
                            System.out.println("Por favor ingrese una opcion validad");
                            opewh = true;
                        }
                    } while (opewh);

                    break;
                default:
                    System.out.println("Esa opcion no es valida, por favor ingrese una opcion correcta");
                    menu = true;
            }

        } while (menu);

    }

}
