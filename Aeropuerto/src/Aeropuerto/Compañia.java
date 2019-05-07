package Aeropuerto;

public class Compañia {
    
   private String nombre;
   private Vuelo listaVuelos[] = new Vuelo[10];
   private int numVuelo = 0;
   
   public Compañia (String nombre) {
       this.nombre = nombre;
   }
   
   public Compañia (String nombre,Vuelo vuelo[]){
       this.nombre = nombre;
       listaVuelos = vuelo;
       numVuelo = vuelo.length;
    }
   
   public void insertarVuelo(Vuelo vuelo){
       listaVuelos[numVuelo]=vuelo;
       numVuelo++;
   }
   
   public String getNombre(){
       return nombre;
   }
   
   public int getNumVuelo(){
       return numVuelo;
   }
   
   public Vuelo getVuelo(int i){
       return listaVuelos[i];
   } 
   
   public Vuelo getVuelo(String id){
       boolean encontrado=false;
       int i=0;
       Vuelo v=null;
       while((!encontrado)&&(i<listaVuelos.length)){
           
           if(id == listaVuelos[i].getIdentificador()){
               encontrado=true;
               v=listaVuelos[i];
           }
           i++;
       }
       return v;
   }
   
}
