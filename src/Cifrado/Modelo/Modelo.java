/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado.Modelo;

import Cifrado.Controlador;

/**
 *
 * @author David TC
 */
public class Modelo {
    private Alumno alumno;
    private Profesor profesor;
    private Controlador controlador;
    
    public Modelo(){
        alumno = new Alumno();
        profesor = new Profesor();
        //this.controlador = controlador;
    }
    
    public Paquete enviarNombre(String nombre){
        String hashAlumno = alumno.getHash(nombre);
        controlador.getVista().mostrarHash(1, hashAlumno);
        byte[] firma = alumno.cifrarMensaje(hashAlumno);
        byte[] mensajeCifrado = alumno.cifrarMensaje(nombre);
        String msgCifrado = mensajeCifrado.toString();
        controlador.getVista().mostrarMensajeCifrado(1, msgCifrado);
        Paquete paqueteAlumno = new Paquete(firma, mensajeCifrado);
        return paqueteAlumno;
    }
    
    public void validarPaquete(Paquete paqueteAlumno){
        //Paquete paqueteProfesor = new Paquete(paqueteAlumno.getFirma(), paqueteAlumno.getMensaje());
        byte[] firma = paqueteAlumno.getFirma();
        byte[] mensajeRecibido = paqueteAlumno.getMensaje();
        String hashProfesor = profesor.descifrarMensaje(firma, alumno.getLlavePublica());
        String mensajeDescifrado = profesor.descifrarMensaje(mensajeRecibido, alumno.getLlavePublica());
        //controlador.getVista().descifrado(2);
        String hashObtenido = profesor.getHash(mensajeDescifrado);
        if(hashObtenido.equals(hashProfesor)){
            String calificacion = obtenerCalificacion(mensajeDescifrado);
            if(calificacion == ""){
                controlador.mostrarError("Alumno no existe");
                System.out.println("Alumno no existe");
                controlador.limpiarCampos();
            }else
                controlador.getVista().mostrarResultado(2, mensajeDescifrado, calificacion);
        }else{
            controlador.mostrarError("¡Hubo una intersepción!");
            System.out.println("No son iguales");
        }
    }
    
    private String obtenerCalificacion(String alumno){
        String calificacion = profesor.getCalificacion(alumno);
        if(calificacion == null){
            return "";
        }else 
            return calificacion;
    }
    
    public Paquete enviarCalificacion(String calificacion){
        //controlador.getVista().mostrarCalificacion(2, calificacion);
        String hashCalificacion = profesor.getHash(calificacion);
        controlador.getVista().mostrarHash(2, hashCalificacion);
        byte[] firma = profesor.cifrarMensaje(hashCalificacion);
        byte[] mensajeCifrado = profesor.cifrarMensaje(calificacion);
        String msgCifrado = mensajeCifrado.toString();
        controlador.getVista().mostrarMensajeCifrado(2, msgCifrado);
        Paquete paqueteProfesor = new Paquete(firma, mensajeCifrado);
        return paqueteProfesor;
        
    }
    
    public void recibirCalificacion(Paquete paqueteProfesor){
        //Paquete paqueteAlumno = new Paquete(paqueteProfesor.getFirma(), paqueteProfesor.getMensaje());
        byte[] firma = paqueteProfesor.getFirma();
        byte[] mensajeRecibido = paqueteProfesor.getMensaje();
        String hashAlumno = alumno.descifrarMensaje(paqueteProfesor.getFirma(), profesor.getLlavePublica());
        String mensajeDescifrado = alumno.descifrarMensaje(mensajeRecibido, profesor.getLlavePublica());
        String hashObtenido = alumno.getHash(mensajeDescifrado);
        if(hashAlumno.equals(hashObtenido)){
            System.out.println("Tu calificacion es "+mensajeDescifrado);
            controlador.getVista().mostrarResultado(1, mensajeDescifrado, mensajeDescifrado);
        }else{
            controlador.mostrarError("¡Hubo una intersepción!");
            System.out.println("No son iguales");
        }
    }
    
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
    
    public Alumno getAlumno(){
        return this.alumno;
    }
    
    public Profesor getProfesor(){
        return this.profesor;
    }
}
