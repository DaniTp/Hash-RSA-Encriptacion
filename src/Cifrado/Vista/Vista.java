/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado.Vista;

import Cifrado.Controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Vista extends JFrame{
    
    private JButton enviarButton, btnEnviar, descifrarButton, btnDescifrar, generarLlavesButton;
    private JPanel pgeneral;
    private JLabel nombreAlumnoLabel, calificacionLabel;
    private JLabel mensajeAlumnoLabel, llavePuAlumnoLabel, llavePriAlumnoLabel;
    private JLabel hashAlumnoLabel, mensajeCifradoAlumnoLabel;
    private JLabel mensajeCalLabel, llavePuCalLabel, llavePriCalLabel;
    private JLabel hashCalLabel, mensajeCifradoCalLabel;
    private JLabel mensajeRecibidoLabel, mensajeDescifradoLabel;
    private JPanel p1;
    private JLabel alumno, profesor;
  //  private JPanel p2;
    private JPanel p3;
    private JTextField nombreAlumnoField,calificacionField;
    private JTextField mensajeAlumnoField, llavepublicaAlumnoField;
    private JTextField llaveprivadaAlumnoField, hashAlumnoField, mcifradoAlumnoField;
    private JTextField mensajecalField, llavepublicacalField;
    private JTextField llaveprivadacalField, hashcalField, mdescifradocalField;
    private JTextField mensajeRecibidoField, mensajeDescifradoField;
    private Controlador controlador;
      private JLabel hashProf, firmaProf;
  private JTextField hashProfField, firmaProfField;

    public Vista(){
        initComponentes();
        inicializarEventos();
    }

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }

    private void initComponentes(){
        this.setSize(820,650);
        this.setLocationRelativeTo(null);
        setTitle("Consulta calificaciones");
        pgeneral = new JPanel();
        p1 = new JPanel();
      //  p2 = new JPanel();
        p3 = new JPanel();
        pgeneral.setLayout(null);
        //pgeneral.setBackground(new Color(230,238,249));
        pgeneral.setBackground(new Color(187,224,232));
        pgeneral.setBounds(0,0, 600, 600);
        add(pgeneral);
        
        
        
        p1.setLayout(null);
        p1.setBackground(new Color(64,167,189));
        p1.setBounds(50, 100, 710, 325);
      //  p1.setBorder();
        pgeneral.add(p1);
        
      /*  p2.setLayout(null);
        p2.setBackground(new Color(64,167,189));
        p2.setBounds(360,100,300,325);
        pgeneral.add(p2);*/
        
        generarLlavesButton = new JButton("Generar llaves");
        generarLlavesButton.setBounds(330, 60, 130, 30);
        generarLlavesButton.setForeground(Color.WHITE);
        generarLlavesButton.setBackground(new Color(44,97,96));
        pgeneral.add(generarLlavesButton);
        
        enviarButton = new JButton("Enviar");
        enviarButton.setBounds(150, 60, 115, 30);
        enviarButton.setForeground(Color.WHITE);
        enviarButton.setBackground(new Color(44,97,96));
        enviarButton.setEnabled(false);
        pgeneral.add(enviarButton);
        
        descifrarButton = new JButton("Descifrar");
        descifrarButton.setBounds(530, 60, 115, 30);
        descifrarButton.setForeground(Color.WHITE);
        descifrarButton.setBackground(new Color(44,97,96));
        descifrarButton.setEnabled(false);
        descifrarButton.setVisible(false);
        pgeneral.add(descifrarButton);

        nombreAlumnoLabel = new JLabel("Nombre del alumno:");
        nombreAlumnoLabel.setBounds(55, 25, 115, 25);
        pgeneral.add(nombreAlumnoLabel);
        
        nombreAlumnoField = new JTextField();
        nombreAlumnoField.setBounds(170, 25, 150, 25);
        pgeneral.add(nombreAlumnoField);
        
        
        calificacionLabel = new JLabel("Calificación:");
        calificacionLabel.setBounds(380, 25, 100, 25);
        pgeneral.add(calificacionLabel);
        
        
        calificacionField = new JTextField();
        calificacionField.setBounds(460, 25, 150, 25);
        pgeneral.add(calificacionField);
        
        btnDescifrar = new JButton("Descifrar");
        btnDescifrar.setLayout(null);
        btnDescifrar.setForeground(Color.WHITE);
        btnDescifrar.setBackground(new Color(44,97,96));
        btnDescifrar.setBounds(530, 60, 115, 30);
        btnDescifrar.setEnabled(false);
        btnDescifrar.setVisible(true);
        pgeneral.add(btnDescifrar);        
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.setLayout(null);
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setBackground(new Color(44,97,96));
        btnEnviar.setBounds(530, 60, 115, 30);
        btnEnviar.setEnabled(false);
        btnEnviar.setVisible(false);
        pgeneral.add(btnEnviar);  
        //Panel 1, alumno
        mensajeAlumnoLabel = new JLabel("Mensaje");
    mensajeAlumnoLabel.setBounds(35, 150, 100, 25);
    p1.add(mensajeAlumnoLabel);
    
    mensajeAlumnoField = new JTextField();
    mensajeAlumnoField.setBounds(135, 150, 200, 25);
    mensajeAlumnoField.setEditable(false);
    p1.add(mensajeAlumnoField);
    
    llavePuAlumnoLabel= new JLabel("Llave publica");
    //llavePuAlumnoLabel.setBounds(35, 100, 100, 25);
    llavePuAlumnoLabel.setBounds(35, 50, 100, 25);
    p1.add(llavePuAlumnoLabel);
    
    llavepublicaAlumnoField = new JTextField();
   // llavepublicaAlumnoField.setBounds(135, 100, 130, 25);
    llavepublicaAlumnoField.setBounds(135, 50, 200, 25);
    llavepublicaAlumnoField.setEditable(false);
    p1.add(llavepublicaAlumnoField);
    
    llavePriAlumnoLabel= new JLabel("Llave privada");
   // llavePriAlumnoLabel.setBounds(35, 150, 100, 25);
   llavePriAlumnoLabel.setBounds(35, 100, 100, 25);
    p1.add(llavePriAlumnoLabel);
    
    llaveprivadaAlumnoField= new JTextField();
    //llaveprivadaAlumnoField.setBounds(135, 150, 130, 25);
    llaveprivadaAlumnoField.setBounds(135, 100, 200, 25);
    llaveprivadaAlumnoField.setEditable(false);
    p1.add(llaveprivadaAlumnoField);
    
    hashAlumnoLabel = new JLabel("Hash");
    hashAlumnoLabel.setBounds(35, 200, 100, 25);
    p1.add(hashAlumnoLabel);
    
    hashAlumnoField = new JTextField();
    hashAlumnoField.setBounds(135, 200, 200, 25);
    hashAlumnoField.setEditable(false);
    p1.add(hashAlumnoField);
    
    mensajeCifradoAlumnoLabel= new JLabel("Mensaje Cifrado");
    mensajeCifradoAlumnoLabel.setBounds(35, 250, 100, 25);
    p1.add(mensajeCifradoAlumnoLabel);
    
    mcifradoAlumnoField = new JTextField();
    mcifradoAlumnoField.setBounds(135, 250, 200,25);
    mcifradoAlumnoField.setEditable(false);
    p1.add(mcifradoAlumnoField);
    
        
        
        //Panel 2, calificacion
         mensajeCalLabel = new JLabel("M. Descifrado");
    mensajeCalLabel.setBounds(360, 150, 100, 25);
    p1.add(mensajeCalLabel);
    
    mensajecalField = new JTextField();
    mensajecalField.setBounds(460, 150, 200, 25);
    mensajecalField.setEditable(false);
    p1.add(mensajecalField);
    
    
    hashCalLabel = new JLabel("Hash");
    hashCalLabel.setBounds(360, 100, 100, 25);
    p1.add(hashCalLabel);
    
    hashcalField = new JTextField();
    hashcalField.setBounds(460, 100, 200, 25);
    hashcalField.setEditable(false);
    p1.add(hashcalField);
    
    mensajeCifradoCalLabel= new JLabel("Mensaje Cifrado");
  //  mensajeCifradoCalLabel.setBounds(350, 250, 100, 25);
  mensajeCifradoCalLabel.setBounds(360, 50, 100, 25);
    p1.add(mensajeCifradoCalLabel);
    
    mdescifradocalField = new JTextField();
    //mdescifradocalField.setBounds(450, 250, 200,25);
    mdescifradocalField.setBounds(460, 50, 200, 25);
    mdescifradocalField.setEditable(false);
    p1.add(mdescifradocalField);
        
        //Panel3 Servidor
         p3 = new JPanel();
    
    p3.setLayout(null);
    p3.setBackground(new Color(187,224,232));
    p3.setBounds(55, 450, 710, 140);
    pgeneral.add(p3);
    
    profesor = new JLabel("Profesor");
    profesor.setBounds(310, 0, 120, 20);
    p3.add(profesor);
    
    llavePuCalLabel= new JLabel("Llave publica");
    llavePuCalLabel.setBounds(80, 30, 100, 25);
    p3.add(llavePuCalLabel);
    
    llavepublicacalField = new JTextField();
    llavepublicacalField.setBounds(170, 30, 170, 25);
    llavepublicacalField.setEditable(false);
    p3.add(llavepublicacalField);
    
    llavePriCalLabel= new JLabel("Llave privada");
    llavePriCalLabel.setBounds(80, 70, 100, 25);
    p3.add(llavePriCalLabel);
    
    llaveprivadacalField= new JTextField();
    llaveprivadacalField.setBounds(170, 70, 170, 25);
    llaveprivadacalField.setEditable(false);
    p3.add(llaveprivadacalField);
    
        mensajeRecibidoLabel = new JLabel("Mensaje recibido");
    mensajeRecibidoLabel.setBounds(350, 25, 120, 25);
    p3.add(mensajeRecibidoLabel);
    
    mensajeRecibidoField = new JTextField();
    mensajeRecibidoField.setBounds(470 , 25, 170, 25);
    mensajeRecibidoField.setEditable(false);
    p3.add(mensajeRecibidoField);
    
    mensajeDescifradoLabel = new JLabel("Mensaje descifrado");
    mensajeDescifradoLabel.setBounds(350, 70, 120, 25);
    p3.add(mensajeDescifradoLabel);
    
    mensajeDescifradoField= new JTextField();
    mensajeDescifradoField.setBounds(470 , 70, 170, 25);
    mensajeDescifradoField.setEditable(false);
    p3.add(mensajeDescifradoField);
    
    hashProf = new JLabel("Hash");
    hashProf.setBounds(80, 110, 100, 25);
    p3.add(hashProf);
    
    hashProfField = new JTextField();
    hashProfField.setBounds(170, 110, 170, 25);
    hashProfField.setEditable(false);
    p3.add(hashProfField);
    
    firmaProf = new JLabel("Firma recibida");
    firmaProf.setBounds(350, 110, 120, 25);
    p3.add(firmaProf);
    
    firmaProfField = new JTextField();
    firmaProfField.setBounds(470, 110, 170, 25);
    firmaProfField.setEditable(false);
    p3.add(firmaProfField);

    }
    
    @SuppressWarnings("deprecation")
    private void inicializarEventos(){
        generarLlavesButton.addActionListener((ActionEvent e) -> {
            generarLlaves();
        });
        
        enviarButton.addActionListener((ActionEvent e) -> {
            enviarNombre();
        });
        
        btnEnviar.addActionListener((ActionEvent e) -> {
            enviarCalificacion();
        });
        
        btnDescifrar.addActionListener((ActionEvent e) -> {
            descifrarMensajeProfesor();
        });
        
        descifrarButton.addActionListener((ActionEvent e) -> {
            descifrarMensajeAlumno();
        });
    }
    
    public void mostrarLlaves(String publicaAlumno, String privadaAlumno, String publicaProfesor, String privadaProfesor){
        //System.out.println(publicaAlumno);
        llavepublicaAlumnoField.setText(publicaAlumno);
        llaveprivadaAlumnoField.setText(privadaAlumno);
        llavepublicacalField.setText(publicaProfesor);
        llaveprivadacalField.setText(privadaProfesor);
        generarLlavesButton.setEnabled(false);
        generarLlavesButton.setVisible(false);
        enviarButton.setEnabled(true);
  }
    
    private void generarLlaves(){
        this.controlador.generarLlaves();
        enviarButton.setEnabled(true);
        enviarButton.setVisible(true);
        nombreAlumnoField.setText("");
        calificacionField.setText("");
    }
    
    private void enviarNombre(){
        //System.out.println(publicaAlumno);
        mensajeAlumnoField.setText(nombreAlumnoField.getText());
        controlador.enviarNombre(nombreAlumnoField.getText());
        enviarButton.setEnabled(false);
    }
    
    private void enviarCalificacion(){
        //System.out.println(publicaAlumno);
        controlador.enviarCalificacion(mensajecalField.getText());
        btnEnviar.setEnabled(false);
        btnEnviar.setVisible(false);
        btnDescifrar.setEnabled(false);
        btnDescifrar.setVisible(false);
        descifrarButton.setEnabled(true);
        descifrarButton.setVisible(true);
        enviarButton.setVisible(false);
        mensajeDescifradoField.setText("");
    }
    
    private void descifrarMensajeProfesor(){
        controlador.descifrarMensajeProfesor();
    }
    
    private void descifrarMensajeAlumno(){
        controlador.descifrarMensajeAlumno();
        limpiar();
    }
    
    public void mostrarResultado(int num, String mensajeDescifrado, String resultado){
      if(num == 1){
        calificacionField.setText(resultado);
        mensajeDescifradoField.setText(mensajeDescifrado);
        generarLlavesButton.setEnabled(true);
        generarLlavesButton.setVisible(true);
      }else{
        mensajecalField.setText(resultado);
        mensajeDescifradoField.setText(mensajeDescifrado);
        btnDescifrar.setEnabled(false);
        btnDescifrar.setVisible(false);
        btnEnviar.setEnabled(true);
        btnEnviar.setVisible(true);
      }
      descifrarButton.setEnabled(true);
  }
    
  public void mostrarHash(int num, String mensaje){
      if(num == 1){
          hashAlumnoField.setText(mensaje);
      }else{
        hashcalField.setText(mensaje);
      }
  }
  
  public void mostrarMensajeCifrado(int num, String mensaje){
      if(num == 1){
          mcifradoAlumnoField.setText(mensaje);
      }else{
          mdescifradocalField.setText(mensaje);
      }
      mensajeRecibidoField.setText(mensaje);
      btnDescifrar.setEnabled(true);
      btnDescifrar.setVisible(true);
  }
  
    public void limpiarCampos(){
        nombreAlumnoField.setText("");
        calificacionField.setText("");
        mensajeAlumnoField.setText("");
        llavepublicaAlumnoField.setText("");
        llaveprivadaAlumnoField.setText("");
        hashAlumnoField.setText("");
        mcifradoAlumnoField.setText("");
        mensajecalField.setText("");
        llavepublicacalField.setText("");
        llaveprivadacalField.setText("");
        hashcalField.setText("");
        mdescifradocalField.setText("");
        mensajeRecibidoField.setText("");
        mensajeDescifradoField.setText("");
        //enviarButton.setVisible(false);
        enviarButton.setEnabled(false);
        btnDescifrar.setEnabled(false);
        btnDescifrar.setVisible(false);
        descifrarButton.setEnabled(false);
        generarLlavesButton.setEnabled(true);
        generarLlavesButton.setVisible(true);
    }
    
    public void limpiar(){
        mensajeAlumnoField.setText("");
        llavepublicaAlumnoField.setText("");
        llaveprivadaAlumnoField.setText("");
        hashAlumnoField.setText("");
        mcifradoAlumnoField.setText("");
        mensajecalField.setText("");
        llavepublicacalField.setText("");
        llaveprivadacalField.setText("");
        hashcalField.setText("");
        mdescifradocalField.setText("");
        mensajeRecibidoField.setText("");
        mensajeDescifradoField.setText("");
        //enviarButton.setVisible(false);
        enviarButton.setEnabled(false);
        btnDescifrar.setEnabled(false);
        btnDescifrar.setVisible(false);
        descifrarButton.setEnabled(false);
        generarLlavesButton.setEnabled(true);
        generarLlavesButton.setVisible(true);
    }
    
    public void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
}