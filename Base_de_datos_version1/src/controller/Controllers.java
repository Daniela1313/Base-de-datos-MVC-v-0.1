
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Models;
import view.Views;

public final class Controllers {

    Models modelBD;
    Views viewBD;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            if (e.getSource() == viewBD.Jb_primee_registro) {
                try {
                    jb_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_anterior) {
                try {
                    jb_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_siguiente_registro) {
                try {
                    jb_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_ultimo_registro) {
                try {
                    jb_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(e.getSource() == viewBD.Jb_guardar_registro){
                try {
                    jb_guardar();
                } catch (SQLException ex) {
                    Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }else if(e.getSource() == viewBD.jb_nuevo_registro){
                jb_nuevo();
            }

        }

    };

    public Controllers(Models modelE, Views viewE) {
        this.modelBD = modelE;
        this.viewBD = viewE;
        initComponents();
        setActionListener();
        initDB();
    }    

    public void initDB(){
        modelBD.conectarDB();
        viewBD.jtf_nombre_agenda.setText(modelBD.getNombre());
        viewBD.jtf_email.setText(modelBD.getEmail());
    }

    public void initComponents() {
        viewBD.setLocationRelativeTo(null);
        viewBD.setTitle("Agenda");
        viewBD.setVisible(true);
    }


    public void setActionListener() {
        viewBD.Jb_primee_registro.addActionListener(actionListener);
        viewBD.Jb_anterior.addActionListener(actionListener);
        viewBD.Jb_siguiente_registro.addActionListener(actionListener);
        viewBD.Jb_ultimo_registro.addActionListener(actionListener);
        viewBD.Jb_guardar_registro.addActionListener(actionListener);
        viewBD.jb_nuevo_registro.addActionListener(actionListener);
    }

 
    private void jb_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_primero");
        modelBD.primerRegistro();
        viewBD.jtf_nombre_agenda.setText(modelBD.getNombre());
        viewBD.jtf_email.setText(modelBD.getEmail());

    }


    private void jb_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_anterior");
        modelBD.anteriorRegistro();
        viewBD.jtf_nombre_agenda.setText(modelBD.getNombre());
        viewBD.jtf_email.setText(modelBD.getEmail());
    }


    private void jb_ultimo_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_ultimo");
        modelBD.ultimoRegistro();
        viewBD.jtf_nombre_agenda.setText(modelBD.getNombre());
        viewBD.jtf_email.setText(modelBD.getEmail());
 
    }
    private void jb_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_siguiente");
        modelBD.siguienteRegistro();
        viewBD.jtf_nombre_agenda.setText(modelBD.getNombre());
        viewBD.jtf_email.setText(modelBD.getEmail());
       
  
    }
    private void jb_guardar() throws SQLException {
        System.out.println("Action del boton jb_guardar");
        modelBD.setNombre(viewBD.jtf_nombre_agenda.getText());
        modelBD.setEmail(viewBD.jtf_email.getText());
        modelBD.guardarRegistro(modelBD.getNombre(),modelBD.getEmail());
        JOptionPane.showMessageDialog(viewBD, "El registro se ha guardado");
        }

        private void jb_nuevo() {
            System.out.println("Action del boton jb_nuevo");
            modelBD.setEmail(null);
            modelBD.setNombre(null);
            viewBD.jtf_email.setText(modelBD.getEmail());
            viewBD.jtf_nombre_agenda.setText(modelBD.getNombre());
            
        }
}
