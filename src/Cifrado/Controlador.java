/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado;

import Cifrado.Modelo.Modelo;
import Cifrado.Modelo.Paquete;
import Cifrado.Vista.Vista;
import javax.swing.JFrame;

/**
 *
 * @author David TC
 */
public class Controlador{
    private Modelo modelo;
    private Vista vista;
    private Paquete paquete;
    
    public Controlador(){
        vista = new Vista();
        vista.setControlador(this);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void generarLlaves(){
        modelo = new Modelo();
        modelo.setControlador(this);
        vista.mostrarLlaves(modelo.getAlumno().llavePublica(), modelo.getAlumno().llavePrivada(), modelo.getProfesor().llavePublica(), modelo.getProfesor().llavePrivada());
    }
    
    public void enviarNombre(String nombre){
        paquete = modelo.enviarNombre(nombre);
    }
    
    public void enviarCalificacion(String calificacion){
        paquete = modelo.enviarCalificacion(calificacion);
    }
    
    public Vista getVista(){
        return this.vista;
    }
    
    public void descifrarMensajeProfesor(){
        modelo.validarPaquete(paquete);
    }
    
    public void descifrarMensajeAlumno(){
        modelo.recibirCalificacion(paquete);
    }
    
    public void limpiarCampos(){
        vista.limpiarCampos();
    }
    
    public void mostrarError(String mensaje){
        vista.mensajeError(mensaje);
    }
    
}
