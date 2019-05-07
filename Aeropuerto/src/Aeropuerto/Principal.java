package Aeropuerto;

public class Principal {
    
    private final static int num = 4;//Numero de aeropuertos

    private final static Aeropuerto aeropuertos[] = new Aeropuerto[num];
    
    public static void main(String[] args) {
        
        Metodos.insertarDatosAeropuerto(aeropuertos);
        Metodos.Menu(aeropuertos);
        
    }

}
