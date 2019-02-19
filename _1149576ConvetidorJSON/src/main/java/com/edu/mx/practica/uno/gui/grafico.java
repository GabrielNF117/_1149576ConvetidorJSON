package com.edu.mx.practica.uno.gui;

import com.edu.mx.practica.uno.convertidor.Practica1;
import com.sun.deploy.panel.JSmartTextArea;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class grafico extends JFrame implements ActionListener {

    private JTextArea ta1, ta2;
    private JButton b1;
    private JComboBox cb1;
    private Practica1 convertidor = new Practica1();
    public grafico(){
        ta1 = new JTextArea();
        ta2 = new JTextArea();
        b1 = new JButton("Convertir");
        cb1 = new JComboBox();

        this.setSize(1100, 500);
        this.setLayout(null);

        ta1.setLocation(10, 50);
        ta1.setSize(400, 300);
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);

        ta2.setLocation(600,50);
        ta2.setSize(400,300);
        ta2.setLineWrap(true);
        ta2.setWrapStyleWord(true);

        b1.setLocation(460,120);
        b1.setSize(100,100);
        b1.addActionListener(this);

        cb1.setLocation(180,370);
        cb1.setSize(100,30);
        cb1.addItem("XML");
        cb1.addItem("JAVA");

        this.add(ta1);
        this.add(ta2);
        this.add(b1);
        this.add(cb1);

    }
    public static void main(String[] args) {

        grafico v = new grafico();

        v.setVisible(true);
        v.setDefaultCloseOperation(3);

    }

    public void actionPerformed(ActionEvent actionEvent) {

        //Se capturan los datos que se encuentra en el primer JTextArea
        String entrada = ta1.getText();
        //Se captura el valor que esta seleccionado en el combobox
        int tipo = cb1.getSelectedIndex();

        if (entrada.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "No hay texto", "Texto vacio!!!", JOptionPane.WARNING_MESSAGE);
        } else {

            if (tipo == 0) {

                //variable string que recibe el resultado de la variable entrada que se manda al metodo
                //convertirXmlAJson
                String json = convertidor.convertirXmlAJson(entrada);
                if(json.compareToIgnoreCase("{}")==0){
                    JOptionPane.showMessageDialog(null,"Formato de texto no compatible");
                }else {
                    ta2.setText(json);
                }

            } else if(tipo == 1){

                String jav = convertidor.convertirClaseAJsonN(entrada);
                if(jav.compareToIgnoreCase("{}")==0){
                    JOptionPane.showMessageDialog(null,"Formato de texto no compatible");
                }else {
                    ta2.setText(jav);
                }

            }
        }



    }

}
