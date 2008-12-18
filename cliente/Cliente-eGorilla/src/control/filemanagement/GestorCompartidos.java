/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import servidoregorilla.Datos.ListaArchivos;
import servidoregorilla.paquete.Archivo;

/**
 * esta clase se encarga de gestionar todos los archiovos compartidos del usuario
 *
 * leera la estructura de directorios para tener una lista de los archivos
 *
 *
 * @author layuso
 */
public class GestorCompartidos {

    Vector<Archivo> _lista;

    public GestorCompartidos(File path) throws IOException {

        _lista = new Vector<Archivo>();

        if (!path.isDirectory()) {
            throw new IOException("el path no es un directorio válido");
        }
        File[] ficherosComp = path.listFiles();
        for (File a : ficherosComp) {
            if (!a.isDirectory())
                _lista.add(new Archivo(a));
        }
    }

    /**
     * recupera la lista de archivos para ser enviada al servidor.
     *
     * @return la lista de archivos en la carpeta compartidos
     */
    public ListaArchivos getArchivosCompartidos(){
        return (ListaArchivos)_lista;
    }
}
