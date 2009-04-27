package gestorDeFicheros;

import java.util.*;
import mensajes.serverclient.*;
import datos.*;

class ManejarListaArchivos {
  
  protected Archivo buscarArchivoEnLista( ListaArchivos listaArchivos, String hash){
    boolean encontrado = false;
    Archivo encontradoArchivo = null;
    
    for( int i = 0;  i < listaArchivos.size() && encontrado == false;  i++ ){
      encontradoArchivo = listaArchivos.get( i );
      //System.out.println("Comparo hashA:"+encontradoArchivo.getHash()+" con hashB:"+hash);
      if( comparaHash( encontradoArchivo.getHash(), hash ) == true )
        encontrado = true;
    }
    if( encontrado == false ){
      //Sino lo ha encontrado devuelvo un nulo
      encontradoArchivo = null;
    }//Sino no tengo que cambiar nada
 
    return encontradoArchivo;
  }

  protected boolean comparaHash( String hashA, String hashB){
    if( hashA.compareTo( hashB ) == 0 )
      return true;
    else
      return false;
  }

  protected void includirArchivoEnLista( Archivo archivo, ListaArchivos lista ){
    lista.add( archivo );
  }

  protected void eliminarArchivoDeLista( Archivo archivo, ListaArchivos lista ){
    lista.remove( archivo );
  }

  protected void moverArchivoEntreListas( Archivo archivo, ListaArchivos listaA, ListaArchivos listaB ){
    //Un archivo de la lista A se elimina, pasando a la listaB
    listaA.remove( archivo );
    listaB.add( archivo );
  }
}