/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.frmMecanicos;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Estudiante
 */
public class Mecanicos {
    
    private  int id_Mecanico;
    private  String nombre_Mecanico;
    private  int edad_Mecanico; 
    private  Double peso_Mecanico;
    private  String correo_Mecanico; 

    public int getId_Mecanico() {
        return id_Mecanico;
    }

    public void setId_Mecanico(int id_Mecanico) {
        this.id_Mecanico = id_Mecanico;
    }

    public String getNombre_Mecanico() {
        return nombre_Mecanico;
    }

    public void setNombre_Mecanico(String nombre_Mecanico) {
        this.nombre_Mecanico = nombre_Mecanico;
    }

    public int getEdad_Mecanico() {
        return edad_Mecanico;
    }

    public void setEdad_Mecanico(int edad_Mecanico) {
        this.edad_Mecanico = edad_Mecanico;
    }

    public Double getPeso_Mecanico() {
        return peso_Mecanico;
    }

    public void setPeso_Mecanico(Double peso_Mecanico) {
        this.peso_Mecanico = peso_Mecanico;
    }

    public String getCorreo_Mecanico() {
        return correo_Mecanico;
    }

    public void setCorreo_Mecanico(String correo_Mecanico) {
        this.correo_Mecanico = correo_Mecanico;
    }
    
    
    public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
 
        //Definimos el modelo de la tabla
        DefaultTableModel DatosMecanico = new DefaultTableModel();
        DatosMecanico.setColumnIdentifiers(new Object[]{"id_Mecanico", "nombre_Mecanico", "edad_Mecanico", "peso_Mecanico", "correo_Mecanico"});
 
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
 
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbMecanico");
 
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                DatosMecanico.addRow(new Object[]{
                    rs.getInt("id_Mecanico"),
                    rs.getString("nombre_Mecanico"),
                    rs.getString("edad_Mecanico"),
                    rs.getDouble("peso_Mecanico"),
                    rs.getString("correo_Mecanico")
                });
            }
 
          
            tabla.setModel(DatosMecanico);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void Eliminar(JTable tabla) {
        
        Connection conexion = ClaseConexion.getConexion();

        int filaSeleccionada = tabla.getSelectedRow();

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
 
        try {
            PreparedStatement deleteEstudiante = conexion.prepareStatement("delete from tbmecanico where id_Mecanico = ?");
            deleteEstudiante.setString(1, miId);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO tbMecanico(nombre_Mecanico, edad_Mecanico, peso_Mecanico, correo_Mecanico ) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, getNombre_Mecanico());
            addProducto.setInt(2, getEdad_Mecanico());
            addProducto.setDouble(3, getPeso_Mecanico());
            addProducto.setString(4, getCorreo_Mecanico());
            //Ejecutar la consulta
            addProducto.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
           public void cargarDatosTabla(frmMecanicos vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtMecanicos.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String id = vista.jtMecanicos.getValueAt(filaSeleccionada, 0).toString();
            String NombreMecanico = vista.jtMecanicos.getValueAt(filaSeleccionada, 1).toString();
            String Edad = vista.jtMecanicos.getValueAt(filaSeleccionada, 2).toString();
            String Peso = vista.jtMecanicos.getValueAt(filaSeleccionada, 3).toString();
            String Correo = vista.jtMecanicos.getValueAt(filaSeleccionada, 4).toString();
 
            // Establece los valores en los campos de texto
            vista.txtNombre.setText(NombreMecanico);
            vista.txtEdad.setText(Edad);
            vista.txtPeso.setText(Peso);
            vista.txtCorreoElectronico.setText(Correo);

        }
    }
           
        public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String id = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateUser = conexion.prepareStatement("update tbMecanico set nombre_Mecanico = ?, edad_Mecanico = ?, peso_Mecanico = ?, correo_Mecanico = ? where id_Mecanico = ?");
                updateUser.setString(1, getNombre_Mecanico());
                updateUser.setInt(2, getEdad_Mecanico());
                updateUser.setDouble(3, getPeso_Mecanico());
                updateUser.setString(4, getCorreo_Mecanico());
                updateUser.setString(5, id);
                updateUser.executeUpdate();
 
            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }
        
        
    public void limpiar(frmMecanicos vista) {
        vista.txtNombre.setText("");
        vista.txtEdad.setText("");
        vista.txtCorreoElectronico.setText("");
        vista.txtPeso.setText("");
    }
    
    
}
