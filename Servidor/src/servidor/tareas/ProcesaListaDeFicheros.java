/*
 * Este proyecto esta sujeto a licencia GPL
 * This project and code is uncer GPL license
 */

package servidor.tareas;

import datos.ArchivoClientes;
import datos.ListadoClientes;
import gestorDeRed.GestorDeRed;
import mensajes.Mensaje;
import mensajes.serverclient.DatosCliente;
import mensajes.serverclient.ListaArchivos;

/**
 *
 * @author Luis Ayuso
 */
public class ProcesaListaDeFicheros extends Thread {

    // ATRIBUTOS
    private GestorDeRed<Mensaje> _red;
    
    private DatosCliente _datosCliente;
    private ArchivoClientes _listaficheros;
    private ListaArchivos _archivosEnviados;


    /**
     * 
     * @param conexion
     * @throws java.io.IOException
     */
    public ProcesaListaDeFicheros(GestorDeRed<Mensaje> conexion, 
                           ArchivoClientes      listaficheros,
                           DatosCliente datos,
                           ListaArchivos archivos){
        _red = conexion;
        _datosCliente = datos;
        _listaficheros = listaficheros;
        _archivosEnviados = archivos;
    }
    
    @Override
    public void run(){
        
        _listaficheros.actualizarDesdeListaCliente(_datosCliente, _archivosEnviados);
        
    }
}