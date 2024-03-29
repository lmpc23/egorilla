/*
 * Este proyecto esta sujeto a licencia GPL
 * This project and code is uncer GPL license
 */

package mensajes.p2p;

import java.io.Serializable;
import java.util.*;
import mensajes.TipoMensaje;
import mensajes.Mensaje;
import datos.Fragmento;

/**
 *
 * @author Luis Ayuso
 */
public class Tengo implements Mensaje, Serializable{

  private String _nombre;
  
  private String _hash;
    
    public Vector<Fragmento> _fragmentos;
    
    private String _destino;
    private int    _puerto;

   
    public Tengo( String nombre, String hash, Vector<Fragmento> fragmentos, String destino, int puerto ){
    _nombre = nombre;
    _hash = hash;
    _fragmentos = fragmentos;
    _destino = destino;
    _puerto = puerto;
  }

  public String getNombre(){
    return _nombre;
  }

  public String getHash(){
    return _hash;
  }

  public Vector<Fragmento> getFragmentos(){
    return _fragmentos;
  }
  
  public TipoMensaje getTipoMensaje() {
       return TipoMensaje.Tengo;
    }
    
    public void setDestino(String destino, int puerto) {
        _destino = destino;
        _puerto  = puerto;
    }
    public String ipDestino() {
        return _destino;
    }
    public int puertoDestino() {
        return _puerto;
    }
}
