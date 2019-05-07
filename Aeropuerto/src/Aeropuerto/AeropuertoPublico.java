
package Aeropuerto;

public class AeropuertoPublico extends Aeropuerto{
    
    private long subvencion;
    
    public AeropuertoPublico(String nombre,String ciudad,String pais){
         super(nombre, ciudad, pais);
    }
    
    public AeropuertoPublico(long sub,String nombre,String ciudad,String pais,Compañia c[]){
         super(nombre, ciudad, pais,c);
         this.subvencion = sub;
    }
    
    public AeropuertoPublico(long sub,String nombre,String ciudad,String pais){
         super(nombre, ciudad, pais);
         this.subvencion = sub;
    }
    
    public double getSubvencion(){
        return subvencion;
    }
}
