/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import control.ControlAplicacion;
import control.FileServer;
import control.filemanagement.GestorCompartidos;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Victor
 */
public class Main {

    /**
     * Método main de la aplicación.
     * @param args
     */
    public static void main(String[] args) {

        try {
            
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch (Exception ex) {
        
        }

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(GeneralFrame.class);

        SplashScreen sp = new SplashScreen(resourceMap.getImageIcon("imageSplash.icon").getImage());
        sp.open(3000);

        
        // TODO: ojo con esto, el puerto de ecucha esta puesto muy mal
        // hay que leerlo de la configuracion. properties o lo que sea
        FileServer fs = new FileServer(4000);
        fs.start();


        try {
            // TODO: darle forma a esta mierda.
            GestorCompartidos gestionCompartidos = new GestorCompartidos(new File("./compartidos"));
            ControlAplicacion.compartidos (gestionCompartidos);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Thread.sleep(3001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        eGorillaControlGeneral.instancia().iniciar();
    }
}