/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mecanicos;
import Vista.frmMecanicos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class ctrlMecanicos implements MouseListener {
    
    private Mecanicos Modelo;
    private frmMecanicos Vista;
    
    public ctrlMecanicos(Mecanicos modelo, frmMecanicos vista){
    
        this.Modelo = modelo;
        this.Vista = vista;
        
        modelo.Mostrar(vista.jtMecanicos);
        vista.btnEliminar1.addMouseListener(this);
        vista.btnGuardar1.addMouseListener(this);

        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == Vista.btnGuardar1){
            Modelo.setNombre_Mecanico(Vista.txtNombre.getText());
            Modelo.setEdad_Mecanico(Integer.parseInt(Vista.txtEdad.getText()));
            Modelo.setPeso_Mecanico(Double.parseDouble(Vista.txtPeso.getText()));
            Modelo.setCorreo_Mecanico(Vista.txtCorreoElectronico.getText());
            
            Modelo.Guardar();
            Modelo.Mostrar(Vista.jtMecanicos);
            
        }
        
        if(e.getSource() == Vista.btnEliminar1){
            Modelo.Eliminar(Vista.jtMecanicos);
            Modelo.Mostrar(Vista.jtMecanicos);
            JOptionPane.showMessageDialog(Vista, "Registro eliminado exitosamente");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
