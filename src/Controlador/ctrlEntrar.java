/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.frmEntrar;
import Vista.frmMecanicos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author User
 */
public class ctrlEntrar implements MouseListener{
    
    private frmEntrar Vista;
    
    public ctrlEntrar(frmEntrar vista){
    
    this.Vista = vista;
    vista.btnIngresar.addMouseListener(this);
    
    
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
        if(e.getSource() == Vista.btnIngresar){
            frmMecanicos.initfrmMecanicos();
            Vista.dispose();
            
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
