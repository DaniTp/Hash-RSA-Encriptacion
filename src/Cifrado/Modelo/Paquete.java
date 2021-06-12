/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado.Modelo;

/**
 *
 * @author David TC
 */
public class Paquete {

    private byte[] firma;
    private byte[] mensaje;

    public Paquete(byte[] firma, byte[] mensaje){
        this.firma = firma;
        this.mensaje = mensaje;
    }

    public byte[] getMensaje(){
        return mensaje;
    }

    public byte[] getFirma(){
        return firma;
    }
}