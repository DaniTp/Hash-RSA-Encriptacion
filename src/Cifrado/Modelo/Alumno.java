/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado.Modelo;

import Cifrado.Controlador;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author David TC
 */
public class Alumno {
    private MD5 md5;
    private RSA rsa;
    private PublicKey llavePublica;
    private String publicaAlumno, privadaAlumno;
    private PrivateKey llavePrivada;
    private Controlador controlador;
    
    public Alumno(){
        this.md5 = new MD5();
        this.rsa = new RSA();
        generarLlaves();
        publicaAlumno = llavePublica.getEncoded().toString();
        privadaAlumno = llavePrivada.getEncoded().toString();
        System.out.println("privada alumno: "+publicaAlumno);
    }
    
    private void generarLlaves(){
        rsa.generateKeys(1024,"llaves_alumno");
        try {
            llavePublica = rsa.readPublicKeyFromFile("llaves_alumno_pub.key");
            llavePrivada = rsa.readPrivateKeyFromFile("llaves_alumno_priv.key");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getHash(String mensaje){
        return md5.getMD5(mensaje);
    }

    public byte[] cifrarMensaje(String mensaje){
        return rsa.encryptData(mensaje, llavePrivada);
    }
    
    public String descifrarMensaje(byte[] mensaje, PublicKey llave){
        return rsa.decryptData(mensaje, llave);
    }
    
    public PublicKey getLlavePublica(){
        return this.llavePublica;
    }
    
    public String llavePublica(){
        return this.publicaAlumno;
    }
    
    public String llavePrivada(){
        return this.privadaAlumno;
    }
    
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
    /*
    public String descifrarHash(byte[] firma, PublicKey llave){
        return rsa.decryptData(firma, llave);
    }
    public byte[] getFirma(String mensaje){
        return rsa.encryptData(mensaje, llavePrivada);
    }
    */
    
    

}
