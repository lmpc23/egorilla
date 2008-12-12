/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidoregorilla.protocolo;

import networking.PeerConn;
import servidoregorilla.datos.ListaArchivos;
import servidoregorilla.datos.TablaClientes;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidoregorilla.paquete.DatosCliente;

/**
 * Clase que implementa un hilo de ejecución que se expande por parte del 
 * servidor cuando alguien se identifica.
 * Mantiene los datos necesarios para la comunicación con un cliente. 
 * Para empezar comenzará un hilo de ejecución que recibirá todos los datos
 * que el cliente envía al conectar, estos son:
 * 
 *      - Nombre del usuario.
 *      - Puerto por el que el usuario escucha a otros clientes.
 *      - Lista de ficheros compartidos que tiene el cliente.
 *
 * @author pitidecaner
 * @author Salcedonia
 */
public class ConexionCliente extends Thread{
    

    private PeerConn _conn;
    private DatosCliente _datos;
    private ListaArchivos _listaGlobalArchivos;
    private TablaClientes _tablaDeClientes ;

    /**
     * Constructor de la clase Cliente. Almacenamos los datos proporcionados
     * por el servidor al conectarse.
     * 
     * @param conexion Conexión recién abierta con el cliente.
     * @param lista Lista de ficheros del servidor, los que tienen todos los 
     * usuarios conectados en conjunto.
     * @param tabla La lista de clientes conectados al servidor en este momento.
     */
    public ConexionCliente(PeerConn conexion, DatosCliente datos, ListaArchivos archivos, TablaClientes clientes) {
        _conn = conexion;
        _datos = datos;
        _listaGlobalArchivos = archivos;
        _tablaDeClientes = clientes;
    }

    public PeerConn getConnexion() {
       return _conn;
    }
    
    /**
     * Método que ejecuta el hilo.
     */
    @Override
    public void run () {
        try {
            // recibe los archivos del cliente 
            ListaArchivos archivosCliente = (ListaArchivos)_conn.reciveObject();

            // alta del cliente en el sistema
            _tablaDeClientes.add(this);

            // alta de los archivos en el sistema
            _listaGlobalArchivos.actualizarDesdeListaCliente(this, _listaGlobalArchivos);

            // listo para usar!
            _conn.setReady();
        }
        catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (Exception ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
