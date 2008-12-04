/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServidoresPanel.java
 *
 * Created on 26-nov-2008, 23:43:49
 */

package presentacion.servidores;

import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ServidoresPanel extends javax.swing.JPanel {

    /** Creates new form ServidoresPanel */
    public ServidoresPanel() {
        initComponents();
    }

    //Inicia la interfaz
	private void iniciar() {
		setVisible(true);
		
		ServidoresControl.instancia().action(ServidoresControl.ACCION1, "");
	}

    //Distingue entre los distintos eventos de actualización
	@SuppressWarnings("unchecked")
	public void update(int action, Object object) {
		switch (action) {
			case GUIServidores.EVENTO1:
				//cargarServidores();
				break;
            case GUIServidores.EVENTO2:				
				break;
		}
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ServidoresPanel.class);
        setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title"))); // NOI18N
        setName("Form"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}