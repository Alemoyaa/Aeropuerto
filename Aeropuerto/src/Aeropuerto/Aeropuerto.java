
package Aeropuerto;

public class Aeropuerto {
    
    private String nombre;
    private String ciudad;
    private String pais;
    private int numCompañia=0;
    private Compañia listaCompañias[] = new Compañia[10];
    
    public Aeropuerto(String nombre,String ciudad,String pais){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompañia = 0;
    }
            
    public Aeropuerto(String nombre,String ciudad,String pais,Compañia c[]){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        listaCompañias = c;
        this.numCompañia= c.length;
    }
    
    public void insertarCompañia(Compañia compañia){
        listaCompañias[numCompañia] = compañia;
        numCompañia++;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public String getPais(){
        return pais;
    }
    
    public int getNumCompañia(){
        return numCompañia;
    }

    public Compañia[] getListaCompañias() {
        return listaCompañias;
    }
    
    public Compañia getCompañia(int i){
        return listaCompañias[i];
    }
    
    public Compañia getCompañia(String nombre){
        boolean comprobador=false;
        int i=0;
        Compañia co=null;
        while((!comprobador)&&(i<listaCompañias.length)){
            if(nombre == listaCompañias[i].getNombre()){
                comprobador=true;
                co = listaCompañias[i];
            }
            i++;
        }
        return co;
    }
}
