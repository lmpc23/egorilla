/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidoregorilla.paquete;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que trata todo lo relacionado con los archivos que se comparten en
 * el servidor. 
 * 
 * @author pitidecaner
 * @author Salcedonia
 */
public class Archivo implements Serializable{

    // ATRIBUTOS
    public String _nombre;
    public String _hash;
    public long _tama;
    public TipoArchivo _tipo;

    /**
     * Constructor de la clase Archivo.
     */
    public Archivo() {
        
    }
        
    /**
     * Constructor de la clase Archivo. Genera la información de un archivo a 
     * partir un identificador de fichero.
     * 
     * @param f Identificador de fichero.
     */
    public Archivo(File f){
        
        //TODO: si el fichero no existe o no es un fichero... excepcion
        FileInputStream fs = null;

        try {

            // Aplicamos md5 al fichero para asignarle un hash único
            MessageDigest ms = MessageDigest.getInstance("md5");
            
            // Recibimos los datos relativos al archivo
            fs = new FileInputStream(f);

            int leidos = 0;
            int total = 0;
            int chunk = 1024 * 4;
            byte[] buff = new byte[chunk];

            do {

                fs.read (buff, chunk, leidos);
                ms.digest(buff, total, leidos);
                total += leidos;
            } while (leidos == chunk);

            fs.close();

            // Configuramos el tipo de archivo en función de los datos recibidos
            _hash = new String (ms.digest());
            _nombre = f.getName();
            _tama = f.length();
            _tipo= asignarTipoArchivo(f);
        } 
        catch (DigestException ex) {

            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {

            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (NoSuchAlgorithmException ex) {

            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {

            try {

                // Cerramos el flujo de entrada
                fs.close();
            } 
            catch (IOException ex) {

                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Devuelve el enumerado con el tipo de archivo correspondiente a la extensión 
     * que se pasa como parámetro.
     * 
     * @param f Referencia al fichero.
     * @return El enumerado con el tipo de archivo correspondiente a la extensión 
     * que se pasa como parámetro.
     */
    private TipoArchivo asignarTipoArchivo(File f) {
        
        String fileName = null;   
        String extension;  
        fileName = fileName.trim();

        int dotPos = fileName.lastIndexOf(".");
        extension = fileName.substring(dotPos);

        return TipoArchivo.devuelveTipo(extension);
    }

    /**
     * recupera el nombre de este archivo
     * @return el nombre del archivo
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * recupera el hash de este archivo
     *  el hash es unico para el archivo indempendientemente del nombre que tenga
     * dos archivos con el mismo hash seran el mismo siempre.
     * @return el hash del archivo
     */
    public String getHash() {
        return _hash;
    }

    /**
     * recupera el tamaño de este archivo
     * @return el tamaño del archivo
     */
    public long  getSize() {
        return _tama;
    }

    /**
     * Compara dos instancias para saber si referencian al mismo archivo
     *
     * @param archivo, el archivo a comparar con este
     *
     */
    public boolean comparaArchivo(Archivo a) {
        return _hash.contentEquals(a.getHash());
    }
}