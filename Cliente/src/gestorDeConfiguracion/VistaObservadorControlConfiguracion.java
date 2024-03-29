/* 
	This file is part of eGorilla.

    eGorilla is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    eGorilla is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with eGorilla.  If not, see <http://www.gnu.org/licenses/>.
*/

package gestorDeConfiguracion;

import java.util.Properties;
import javax.swing.*;
import java.awt.*;

//************************************************************************************//
/**
 * Panel observador sobre el objeto ControlConfiguracionCliente
 * 
 * @author F. Javier Sánchez Pardo
 * 
 */
public class VistaObservadorControlConfiguracion extends JPanel implements ObservadorControlConfiguracionCliente{

    // CONSTANTES
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS

    // Se guarda una referencia al Modelo (PATRÓN MVC) que en este caso es un objeto
    // ControlConfiguracionCliente.
    private ControlConfiguracionCliente _modelo;
    
    // COMPONENTES GRÁFICOS
    private JButton _btnAceptar;
    private JButton _btnRestaurar;
    private JButton _btnCancelar;
    private JLabel _lblNumDescargasSim;
    private JLabel _lblLimVelocidadSubida;
    private JLabel _lblLimVelocidadBajada;
    private JLabel _lblPuerto;
    private JLabel _lblDirLlegada;
    private JLabel _lblDirCompartidos;
    private JLabel _lblIPServidor;
    private JLabel _lblPuertoServidor;
    private JLabel _lblNombreServidor;
    private JLabel _lblDescripServidor;
    private JLabel _lblNombreUsuario;
    private JPanel _panelConexion;
    private JPanel _panelDirectorios;
    private JPanel _panelServidor;
    private JPanel _panelUsuario;
    private JPanel _panelBotones;
    private JTextField _txtNumDescargasSim;
    private JTextField _txtLimVelocidadSubida;
    private JTextField _txtLimVelocidadBajada;
    private JTextField _txtPuerto;
    private JTextField _txtDirLlegada;
    private JTextField _txtDirCompartidos;
    private JTextField _txtIPServidor;
    private JTextField _txtPuertoServidor;
    private JTextField _txtNombreServidor;
    private JTextField _txtDescripServidor;
    private JTextField _txtNombreUsuario;
    
   
//	************************************************************************************//
    /**
     * Constructor de la clase PanelConfiguración.
     * @param oControlConfiguracionCliente Objeto ControlConfiguracionCliente.
     *        Mediante este parametro la Vista (este JPanel) tiene una referencia al Modelo
     *        (el objeto ControlConfiguracionCliente) y le permite pedir información 
     *        al Modelo para actualizarse convenientemente.
     * 
     */
    public VistaObservadorControlConfiguracion(ControlConfiguracionCliente oControlConfiguracionCliente) {
        _modelo = oControlConfiguracionCliente;
        createGUI();
        inicializarCampos ();        
    }

//	************************************************************************************//
    /**
     * Inicia los componentes del panel de Configuración.
     */
    private void createGUI() {
    	GridBagConstraints gridBagConstraints;

        _panelConexion = new JPanel();
        _lblNumDescargasSim = new JLabel();
        _txtNumDescargasSim = new JTextField(5);
        _lblLimVelocidadSubida = new JLabel();
        _txtLimVelocidadSubida = new JTextField(5);
        _lblLimVelocidadBajada = new JLabel();
        _txtLimVelocidadBajada = new JTextField(5);
        _lblPuerto = new JLabel();
        _txtPuerto = new JTextField(4);
        
        _panelDirectorios = new JPanel();
        _lblDirLlegada = new JLabel();
        _txtDirLlegada = new JTextField(40);
        _lblDirCompartidos = new JLabel();
        _txtDirCompartidos = new JTextField(40);
        
        _panelServidor = new JPanel();
        _lblIPServidor = new JLabel();
        _lblPuertoServidor = new JLabel();
        _lblNombreServidor = new JLabel();
        _lblDescripServidor = new JLabel();        
        _txtIPServidor = new JTextField(15);
        _txtPuertoServidor = new JTextField(4);
        _txtNombreServidor = new JTextField(25);
        _txtDescripServidor = new JTextField(40);
        
        _panelUsuario = new JPanel();
        _lblNombreUsuario = new JLabel();
        _txtNombreUsuario = new JTextField(25);
    
        _panelBotones = new JPanel();
        _btnAceptar = new JButton();
        _btnRestaurar = new JButton();
        _btnCancelar =  new JButton();

        setBorder(BorderFactory.createTitledBorder("Configuración")); 
        setName("PanelConfiguracion"); 
        setLayout(new GridBagLayout());

        //----------------
        // PANEL CONEXION
        //----------------
        _panelConexion.setName("panelConexion"); 
        _panelConexion.setLayout(new GridBagLayout());

        //
        //LABEL NUMERO DE DESCARGAS SIMULTANEAS
        _lblNumDescargasSim.setText(PropiedadCliente.NUM_DESCARGAS_SIM.obtenerLiteralEdicion()); 
        _lblNumDescargasSim.setName("lblNumDescargasSim"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_lblNumDescargasSim, gridBagConstraints);
        this.add(_lblNumDescargasSim, gridBagConstraints);
        
        
        //TEXTBOX NUMERO DE DESCARGAS SIMULTANEAS
        _txtNumDescargasSim.setText(""); 
        _txtNumDescargasSim.setMinimumSize(new Dimension(100, 20));
        _txtNumDescargasSim.setMaximumSize(new Dimension(100, 20));
        _txtNumDescargasSim.setPreferredSize(new Dimension(100, 20));        
        _txtNumDescargasSim.setName("txtNumDescargasSim"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_txtNumDescargasSim, gridBagConstraints);
        this.add(_txtNumDescargasSim, gridBagConstraints);

        //
        //LABEL LIMITE DE VELOCIDAD DE SUBIDA
        _lblLimVelocidadSubida.setText(PropiedadCliente.LIM_VELOCIDAD_SUBIDA.obtenerLiteralEdicion()); 
        _lblLimVelocidadSubida.setName("lblLimVelocidadSubida");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_lblLimVelocidadSubida, gridBagConstraints);
        this.add(_lblLimVelocidadSubida, gridBagConstraints);

        //TEXTBOX LIMITE DE VELOCIDAD DE SUBIDA
        _txtLimVelocidadSubida.setText(""); 
        _txtLimVelocidadSubida.setMinimumSize(new Dimension(100, 20));
        _txtLimVelocidadSubida.setMaximumSize(new Dimension(100, 20));
        _txtLimVelocidadSubida.setPreferredSize(new Dimension(100, 20));
        _txtLimVelocidadSubida.setName("txtLimVelocidadSubida"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_txtLimVelocidadSubida, gridBagConstraints);
        this.add(_txtLimVelocidadSubida, gridBagConstraints);

        //
        //LABEL LIMITE DE VELOCIDAD DE BAJADA
        _lblLimVelocidadBajada.setText(PropiedadCliente.LIM_VELOCIDAD_BAJADA.obtenerLiteralEdicion()); 
        _lblLimVelocidadBajada.setName("lblLimVelocidadBajada");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_lblLimVelocidadBajada, gridBagConstraints);
        this.add(_lblLimVelocidadBajada, gridBagConstraints);

        //TEXTBOX LIMITE DE VELOCIDAD DE BAJADA
        _txtLimVelocidadBajada.setText(""); 
        _txtLimVelocidadBajada.setMinimumSize(new Dimension(100, 20));
        _txtLimVelocidadBajada.setMaximumSize(new Dimension(100, 20));
        _txtLimVelocidadBajada.setPreferredSize(new Dimension(100, 20));
        _txtLimVelocidadBajada.setName("txtLimVelocidadBajada"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_txtLimVelocidadBajada, gridBagConstraints);
        this.add(_txtLimVelocidadBajada, gridBagConstraints);

        //
        //LABEL PUERTO
        _lblPuerto.setText(PropiedadCliente.PUERTO.obtenerLiteralEdicion()); 
        _lblPuerto.setName("lblPuerto"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_lblPuerto, gridBagConstraints);
        this.add(_lblPuerto, gridBagConstraints);

        //TEXTBOX PUERTO
        _txtPuerto.setText(""); 
        _txtPuerto.setMinimumSize(new Dimension(100, 20));
        _txtPuerto.setMaximumSize(new Dimension(100, 20));
        _txtPuerto.setPreferredSize(new Dimension(100, 20));
        _txtPuerto.setName("txtPuerto"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelConexion.add(_txtPuerto, gridBagConstraints);
        this.add(_txtPuerto, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
//        gridBagConstraints.ipadx = 80;
//        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 200, 0, 0);
//        add(_panelConexion, gridBagConstraints);


        //----------------
        // PANEL SERVIDOR
        //----------------
        _panelServidor.setName("panelServidor"); 
        _panelServidor.setLayout(new GridBagLayout());

        //
        //LABEL IP SERVIDOR
        _lblIPServidor.setText(PropiedadCliente.IP_SERVIDOR.obtenerLiteralEdicion()); 
        _lblIPServidor.setName("lblIPServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_lblIPServidor, gridBagConstraints);
        this.add(_lblIPServidor, gridBagConstraints);

        //TEXTBOX IP SERVIDOR
        _txtIPServidor.setText(""); 
        _txtIPServidor.setMinimumSize(new Dimension(100, 20));
        _txtIPServidor.setMaximumSize(new Dimension(100, 20));
        _txtIPServidor.setPreferredSize(new Dimension(100, 20));        
        _txtIPServidor.setName("txtIPServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_txtIPServidor, gridBagConstraints);
        this.add(_txtIPServidor, gridBagConstraints);
        
        //
        //LABEL PUERTO SERVIDOR
        _lblPuertoServidor.setText(PropiedadCliente.PUERTO_SERVIDOR.obtenerLiteralEdicion()); 
        _lblPuertoServidor.setName("lblPuertoServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_lblPuertoServidor, gridBagConstraints);
        this.add(_lblPuertoServidor, gridBagConstraints);

        //TEXTBOX PUERTO SERVIDOR
        _txtPuertoServidor.setText(""); 
        _txtPuertoServidor.setMinimumSize(new Dimension(100, 20));
        _txtPuertoServidor.setMaximumSize(new Dimension(100, 20));
        _txtPuertoServidor.setPreferredSize(new Dimension(100, 20));        
        _txtPuertoServidor.setName("txtPuertoServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_txtPuertoServidor, gridBagConstraints);
        this.add(_txtPuertoServidor, gridBagConstraints);
        
        //
        //LABEL NOMBRE SERVIDOR
        _lblNombreServidor.setText(PropiedadCliente.NOMBRE_SERVIDOR.obtenerLiteralEdicion()); 
        _lblNombreServidor.setName("lblNombreServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_lblNombreServidor, gridBagConstraints);
        this.add(_lblNombreServidor, gridBagConstraints);

        //TEXTBOX NOMBRE SERVIDOR
        _txtNombreServidor.setText(""); 
        _txtNombreServidor.setMinimumSize(new Dimension(100, 20));
        _txtNombreServidor.setMaximumSize(new Dimension(100, 20));
        _txtNombreServidor.setPreferredSize(new Dimension(100, 20));        
        _txtNombreServidor.setName("txtNombreServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_txtNombreServidor, gridBagConstraints);
        this.add(_txtNombreServidor, gridBagConstraints);
                
        //
        //LABEL DESCRIPCION SERVIDOR
        _lblDescripServidor.setText(PropiedadCliente.DESCRIP_SERVIDOR.obtenerLiteralEdicion()); 
        _lblDescripServidor.setName("lblDescripServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_lblDescripServidor, gridBagConstraints);
        this.add(_lblDescripServidor, gridBagConstraints);

        //TEXTBOX DESCRIPCION SERVIDOR
        _txtDescripServidor.setText(""); 
        _txtDescripServidor.setMinimumSize(new Dimension(100, 20));
        _txtDescripServidor.setMaximumSize(new Dimension(100, 20));
        _txtDescripServidor.setPreferredSize(new Dimension(100, 20));        
        _txtDescripServidor.setName("txtDescripServidor"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelServidor.add(_txtDescripServidor, gridBagConstraints);
        this.add(_txtDescripServidor, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = GridBagConstraints.REMAINDER;
//        gridBagConstraints.ipadx = 0;
//        gridBagConstraints.ipady = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 200, 0, 0);
//        add(_panelServidor, gridBagConstraints);
        
        
        //----------------
        // PANEL DIRECTORIOS
        //----------------
        _panelDirectorios.setName("panelDirectorios"); 
        _panelDirectorios.setLayout(new GridBagLayout());
        
        //
        //LABEL DIRECTORIO DE LLEGADA
        _lblDirLlegada.setText(PropiedadCliente.DIR_LLEGADA.obtenerLiteralEdicion()); 
        _lblDirLlegada.setName("lblDirLlegada"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelDirectorios.add(_lblDirLlegada, gridBagConstraints);
        this.add(_lblDirLlegada, gridBagConstraints);

        //TEXTBOX NUMERO DE DESCARGAS SIMULTANEAS
        _txtDirLlegada.setText(""); 
        _txtDirLlegada.setMinimumSize(new Dimension(100, 20));
        _txtDirLlegada.setMaximumSize(new Dimension(100, 20));
        _txtDirLlegada.setPreferredSize(new Dimension(100, 20));        
        _txtDirLlegada.setName("txtDirLlegada"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelDirectorios.add(_txtDirLlegada, gridBagConstraints);
        this.add(_txtDirLlegada, gridBagConstraints);

        //
        //LABEL DIRECTORIO DE COMPARTIDOS
        _lblDirCompartidos.setText(PropiedadCliente.DIR_COMPARTIDOS.obtenerLiteralEdicion()); 
        _lblDirCompartidos.setName("lblDirCompartidos"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelDirectorios.add(_lblDirCompartidos, gridBagConstraints);
        this.add(_lblDirCompartidos, gridBagConstraints);

        //TEXTBOX DIRECTORIO DE COMPARTIDOS
        _txtDirCompartidos.setText(""); 
        _txtDirCompartidos.setMinimumSize(new Dimension(100, 20));
        _txtDirCompartidos.setMaximumSize(new Dimension(100, 20));
        _txtDirCompartidos.setPreferredSize(new Dimension(100, 20));        
        _txtDirCompartidos.setName("txtDirCompartidos"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelDirectorios.add(_txtDirCompartidos, gridBagConstraints);
        this.add(_txtDirCompartidos, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = GridBagConstraints.RELATIVE;
//        gridBagConstraints.ipadx = 80;
//        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 200, 0, 0);
//        add(_panelDirectorios, gridBagConstraints);

        
        //----------------
        // PANEL USUARIO
        //----------------
        _panelUsuario.setName("panelUsuario"); 
        _panelUsuario.setLayout(new GridBagLayout());
        
        //
        //LABEL NOMBRE USUARIO
        _lblNombreUsuario.setText(PropiedadCliente.NOMBRE_USUARIO.obtenerLiteralEdicion()); 
        _lblNombreUsuario.setName("lblNombreUsuario"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelUsuario.add(_lblNombreUsuario, gridBagConstraints);
        this.add(_lblNombreUsuario, gridBagConstraints);

        //TEXTBOX NOMBRE USUARIO
        _txtNombreUsuario.setText(""); 
        _txtNombreUsuario.setMinimumSize(new Dimension(100, 20));
        _txtNombreUsuario.setMaximumSize(new Dimension(100, 20));
        _txtNombreUsuario.setPreferredSize(new Dimension(100, 20));        
        _txtNombreUsuario.setName("txtNombreUsuario"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelUsuario.add(_txtNombreUsuario, gridBagConstraints);
        this.add(_txtNombreUsuario, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = GridBagConstraints.REMAINDER;
//        gridBagConstraints.ipadx = 80;
//        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 200, 0, 0);
//        add(_panelUsuario, gridBagConstraints);

        
        //----------------
        // PANEL BOTONES
        //----------------
        _panelBotones.setName("panelBotones"); 
        _panelBotones.setLayout(new GridBagLayout());

        //
        //BOTON ACEPTAR
        _btnAceptar.setText("Aceptar"); 
        _btnAceptar.setMaximumSize(new Dimension(100, 23));
        _btnAceptar.setMinimumSize(new Dimension(100, 23));
        _btnAceptar.setName("btnAceptar"); 
        _btnAceptar.setPreferredSize(new Dimension(100, 23));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelBotones.add(_btnAceptar, gridBagConstraints);

        //
        //BOTON ACEPTAR
        _btnCancelar.setText("Cancelar"); 
        _btnCancelar.setMaximumSize(new Dimension(100, 23));
        _btnCancelar.setMinimumSize(new Dimension(100, 23));
        _btnCancelar.setName("btnCancelar"); 
        _btnCancelar.setPreferredSize(new Dimension(100, 23));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelBotones.add(_btnCancelar, gridBagConstraints);

        //
        //BOTON RESTAURAR
        _btnRestaurar.setText("Config. defecto");
        _btnRestaurar.setName("btnRestaurar"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 0, 0);
//        _panelBotones.add(_btnRestaurar, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
//        gridBagConstraints.gridwidth = 2;
//        gridBagConstraints.ipadx = 23;
//        gridBagConstraints.ipady = 107;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 200, 0, 0);
//        add(_panelBotones, gridBagConstraints);

        getAccessibleContext().setAccessibleName("Configuracion");    
    }

    /**
     * Este metodo inicializa los campos del panel con los valores
     * contenidos en el objeto ControlConfiguracionCliente.
     */
    private void inicializarCampos(){
        _txtNumDescargasSim.setText(_modelo.obtenerPropiedad(PropiedadCliente.NUM_DESCARGAS_SIM.obtenerLiteral()));
        _txtLimVelocidadSubida.setText(_modelo.obtenerPropiedad(PropiedadCliente.LIM_VELOCIDAD_SUBIDA.obtenerLiteral()));
        _txtLimVelocidadBajada.setText(_modelo.obtenerPropiedad(PropiedadCliente.LIM_VELOCIDAD_BAJADA.obtenerLiteral()));
        _txtPuerto.setText(_modelo.obtenerPropiedad(PropiedadCliente.PUERTO.obtenerLiteral()));
        _txtDirLlegada.setText(_modelo.obtenerPropiedad(PropiedadCliente.DIR_LLEGADA.obtenerLiteral()));
        _txtDirCompartidos.setText(_modelo.obtenerPropiedad(PropiedadCliente.DIR_COMPARTIDOS.obtenerLiteral()));
        _txtIPServidor.setText(_modelo.obtenerPropiedad(PropiedadCliente.IP_SERVIDOR.obtenerLiteral()));
        _txtPuertoServidor.setText(_modelo.obtenerPropiedad(PropiedadCliente.PUERTO_SERVIDOR.obtenerLiteral()));
        _txtNombreServidor.setText(_modelo.obtenerPropiedad(PropiedadCliente.NOMBRE_SERVIDOR.obtenerLiteral()));
        _txtDescripServidor.setText(_modelo.obtenerPropiedad(PropiedadCliente.DESCRIP_SERVIDOR.obtenerLiteral()));
        _txtNombreUsuario.setText(_modelo.obtenerPropiedad(PropiedadCliente.NOMBRE_USUARIO.obtenerLiteral()));        
    }
    
    /**
     * Este metodo (implementacion de la interfaz ObservadorControlConfiguracionCliente) permite 
     * reflejar en la Vista (este panel) los cambios que se han producido en el Modelo (objeto 
     * ControlConfiguracionCliente). En el parametro propiedades están las propiedades
     * que han cambiado de valor (no tienen porqué haber cambiado todas). EN ESTE CASO NO
     * HACE FALTA tratar de manera diferenciada cada posible cambio: se muestra en el panel
     * el contenido del objeto entero.
     * @param obj Objeto ControlConfiguracionCliente que almacena la configuracion
     * @param propiedades Conjunto de propiedades que han cambiado en el objeto anterior.
     */
    public void cambioEnPropiedades(ControlConfiguracionCliente obj, Properties propiedades) {
        inicializarCampos();
    }
}
