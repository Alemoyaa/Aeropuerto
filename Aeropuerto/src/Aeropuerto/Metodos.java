package Aeropuerto;
import java.util.Scanner;

public class Metodos {
    
    static Scanner in = new Scanner(System.in);

    public static void insertarDatosAeropuerto(Aeropuerto aero[]) {

        aero[0] = new AeropuertoPublico(80000000, "Jorge Chavez", "Lima", "Perú");
        aero[0].insertarCompañia(new Compañia("AeroPeru"));
        aero[0].insertarCompañia(new Compañia("LATAM"));
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB20", "Lima", "Mexico", 150.90, 150));
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB21", "Lima", "Buenos Aires", 180.99, 120));
        aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("FC12", "Lima", "Londres", 500.90, 180));
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Alejandro", "20BGHP", "Peruana"));
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Maria", "PJKL20", "Mexicana"));
        aero[0].getCompañia("LATAM").getVuelo("FC12").insertarPasajero(new Pasajero("Raul", "JK12L1", "Boliviana"));

        aero[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "España");
        aero[1].insertarCompañia(new Compañia("AirEuropa"));
        String empresas[] = {"Cobresol", "Anguila34"};
        ((AeropuertoPrivado) aero[1]).insertarEmpresas(empresas);
        aero[1].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AE025", "Madrid", "Buenos Aires", 253.9, 120));
        aero[1].getCompañia("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Alejandro", "RJQ51", "Argentina"));

        aero[2] = new AeropuertoPublico(20000000, "Aeropuerto Bogota", "Bogota", "Colombia");
        aero[2].insertarCompañia(new Compañia("AirAmerica"));
        aero[2].insertarCompañia(new Compañia("VueloBogota"));
        aero[2].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AE030", "Bogota", "Lima", 92.6, 200));
        aero[2].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AE031", "Bogota", "Lima", 100.0, 50));
        aero[2].getCompañia("AirAmerica").getVuelo("AE030").insertarPasajero(new Pasajero("Alejandro", "AE900", "Argentina"));
        aero[2].getCompañia("AirAmerica").getVuelo("AE030").insertarPasajero(new Pasajero("Benatia", "PO904", "Polonia"));

        aero[3] = new AeropuertoPublico(40000000, "Aeropuero Mexico", "Mexico", "Mexico");
        aero[3].insertarCompañia(new Compañia("AeroMexico"));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB2040", "Mexico", "Puerto Rico", 280.7, 80));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB2042", "Mexico", "Costa Rica", 720, 10));
        aero[3].getCompañia("AeroMexico").getVuelo("IB2040").insertarPasajero(new Pasajero("Alejandro", "AE900", "Argentina"));
        aero[3].getCompañia("AeroMexico").getVuelo("IB2040").insertarPasajero(new Pasajero("Jose cruz", "AE904", "Polonia"));

    }
     
     public static void Menu(Aeropuerto aeropuertos[]) {
        int opcion;
        do {

            System.out.println("\t\t..:MENU:..");
            System.out.println("1. Ver aeropuertos gestionados(Publicos o Privados).");
            System.out.println("2. Consultar las empresas que patrocinan(Privado) o la subvencion(Publico) de un aeropuerto.");
            System.out.println("3. Mostrar la lista de compañias de un aeropuerto.");
            System.out.println("4. Lista de vuelos por compañia.");
            System.out.println("5. Mostrar vuelos de ciudad origen a ciudad destino");
            System.out.println("6. Salir");

            System.out.print("Elija una opcion de menu: ");
            opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    mostrarAeropuertos(aeropuertos);//Aeropuertos gestionados 
                    break;
                case 2:
                    consultaEmpresasSubvencion(aeropuertos);//Consultar las empresas que patrocinan(Privado) o la subvencion(Publico) de un aeropuerto
                    break;
                case 3:
                    listaCompañiasAero(aeropuertos);//Mostrar la lista de compañias de un aeropuerto
                    break;
                case 4:
                    listaVuelos(aeropuertos);// Lista de vuelos por compañia
                    break;
                case 5:
                    vuelosCoCD(aeropuertos);//Mostrar vuelos de ciudad origen a ciudad destino
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error, se equivoco de opcion de menu");
                    break;
            }

            System.out.println("");
        } while (opcion != 6);
    }

    private static void mostrarAeropuertos(Aeropuerto aeropuertos[]) {
        for (int i = 0; i < aeropuertos.length; i++) {

            if (aeropuertos[i] instanceof AeropuertoPrivado) { //Nos va a determinar si el arreglo pertenece a esa clase
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            } else {
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            }
            System.out.println("");
        }
    }

    private static void consultaEmpresasSubvencion(Aeropuerto aeropuertos[]) {
        int opcion;
        System.out.print("Indique que aeropuerto desea ver su subvencion o empresas que patrocinan");
        opcion = in.nextInt();

        if (aeropuertos[opcion] instanceof AeropuertoPrivado) {
            String Empresas[] = ((AeropuertoPrivado) aeropuertos[opcion]).getlistaEmpresas();
            System.out.println("Las empresas que patrocinan al aeropuerto " + aeropuertos[opcion].getNombre());
            for (int i = 0; i < Empresas.length; i++) {
                System.out.println("Empresa N°" + (i + 1) + ": " + Empresas[i]);
            }
        } else {
            long valor = (long) ((AeropuertoPublico) aeropuertos[opcion]).getSubvencion();
            System.out.println("La subvencion del aeropuerto " + aeropuertos[opcion].getNombre());
            System.out.println("Es de " + valor);
        }
    }

    private static void listaCompañiasAero(Aeropuerto aeropuertos[]) {//Mostrar la lista de compañias de un aeropuerto
        int opcion;

        System.out.print("Indique que aeropuerto desea conocer las compañias que posee: ");
        opcion = in.nextInt();

        System.out.println("Las compañias que posee el aeropuerto " + aeropuertos[opcion].getNombre() + " son : ");

        for (int i = 0; i < aeropuertos[opcion].getNumCompañia(); i++) {
            System.out.println("Empresa N°" + (i + 1) + ": " + aeropuertos[opcion].getCompañia(i).getNombre());
        }
    }

    private static void listaVuelos(Aeropuerto aeropuertos[]) {// Lista de vuelos por compañia

        int aeropuerto, compañia;

        System.out.print("Indique un aeropuerto y su compañia para conocer los vuelos disponibles: ");

        for (int i = 0; i < aeropuertos.length; i++) {
            System.out.println("");
            System.out.print((i + 1) + ". Aeropuerto " + aeropuertos[i].getNombre());

        }

        System.out.println("\nLa compañia a que aeropuerto pertenece: ");
        aeropuerto = in.nextInt();
        aeropuerto -= 1;
        if (aeropuertos[aeropuerto].getNumCompañia() == 1) {

            System.out.println("El aeropuerto solo cuenta con una compañia.");
            System.out.println("Los vuelos de la compañia " + aeropuertos[aeropuerto].getCompañia(0).getNombre() + " son: ");

            for (int i = 0; i < aeropuertos[aeropuerto].getCompañia(0).getNumVuelo(); i++) {

                System.out.println("Vuelo N°" + (i + 1) + " codigo : " + aeropuertos[aeropuerto].getCompañia(0).getVuelo(i).getIdentificador());
            }
        } else {

            System.out.println("Elija la compañia que desea conocer los vuelos disponibles: ");

            for (int j = 0; j < aeropuertos[aeropuerto].getNumCompañia(); j++) {

                System.out.println("");
                System.out.print((j + 1) + ". Compañia " + aeropuertos[aeropuerto].getCompañia(j).getNombre());

            }
            System.out.println("");
            System.out.print("Elija el numero de la compañia: ");
            compañia = in.nextInt();
            compañia -= 1;
            System.out.println("Los vuelos de dicha compañia son: ");
            if (aeropuertos[aeropuerto].getCompañia(compañia).getNumVuelo() == 0) {
                System.out.println("La compañia no posee vuelos");
            } else {
                for (int i = 0; i < aeropuertos[aeropuerto].getCompañia(compañia).getNumVuelo(); i++) {

                    System.out.println((i + 1) + ". Vuelo " + aeropuertos[aeropuerto].getCompañia(compañia).getVuelo(i).getIdentificador());

                }
            }
        }
    }

    private static void vuelosCoCD(Aeropuerto aeropuertos[]) {//Mostrar vuelos de ciudad origen a ciudad destino
        String ciudadO, ciudadD;
        System.out.print("A continuacion ingrese la ciudad de origen: ");
        in.nextLine();
        ciudadO = in.nextLine();
        System.out.print("A continuacion ingrese la ciudad de destino: ");
        ciudadD = in.nextLine();
        
        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {
                    
                    if ((ciudadO.equals(aeropuertos[i].getCompañia(j).getVuelo(k).getCiudadOrigen())) && (ciudadD.equals(aeropuertos[i].getCompañia(j).getVuelo(k).getCiudadDestino()))) {
                        System.out.println("El vuelo de " + ciudadO + " hasta " + ciudadD + " es de la empresa " + aeropuertos[i].getCompañia(j).getNombre());
                        System.out.println("y posee el codigo: " + aeropuertos[i].getCompañia(j).getVuelo(k).getIdentificador());
                        System.out.println("con un valor de " + aeropuertos[i].getCompañia(j).getVuelo(k).getPrecio());
                    }

                }
            }
        }
    }
}
