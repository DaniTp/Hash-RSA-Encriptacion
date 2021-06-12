/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado.Modelo;

import Cifrado.Controlador;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David TC
 */
public class Profesor {
    private MD5 md5;
    private RSA rsa;
    private PublicKey llavePublica;
    private PrivateKey llavePrivada;
    private String publicaProfesor, privadaProfesor;
    private Map<String, String> alumnos;
    private Controlador controlador;
    
    public Profesor(){
        this.md5 = new MD5();
        this.rsa = new RSA();
        generarLlaves();
        publicaProfesor = llavePublica.getEncoded().toString();
        privadaProfesor = llavePrivada.getEncoded().toString();
        alumnos = new HashMap<String,String>();
        alumnos.put("Juan Perez", "9");
        alumnos.put("Mario Hernandez", "7");
    }
    
    private void generarLlaves(){
        rsa.generateKeys(1024,"llaves_profesor");
        try {
            llavePublica = rsa.readPublicKeyFromFile("llaves_profesor_pub.key");
            llavePrivada = rsa.readPrivateKeyFromFile("llaves_profesor_priv.key");
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
    
    public String getCalificacion(String alumno){
        return alumnos.get(alumno);
    }
    
    public PublicKey getLlavePublica(){
        return this.llavePublica;
    }
    
    public PrivateKey getLlavePrivada(){
        return this.llavePrivada;
    }
    
    public String llavePublica(){
        return this.publicaProfesor;
    }
    
    public String llavePrivada(){
        return this.privadaProfesor;
    }
    
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
    
}
