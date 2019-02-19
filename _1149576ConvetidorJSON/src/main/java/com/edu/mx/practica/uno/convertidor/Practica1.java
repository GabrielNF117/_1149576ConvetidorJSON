
package com.edu.mx.practica.uno.convertidor;
import com.edu.mx.practica.uno.Clan.Uchiha;

import com.google.gson.Gson;
import org.json.*;

import javax.swing.*;
import java.util.ArrayList;

public class Practica1 {
    /*
      *Metodo para convertir Clase a JSON
      * @param clase texto en formato clase para convertir
      * @return Clase convertida a JSON
     */
    public String convertirClaseAJsonN(String clase){

        String res = "";
        try {
            //split para separar por comas la variable recibida
            String[] sp = clase.split(",");
            //clase a la cual se le envian parametros que se encuentran en el split
            Uchiha nuevo = new Uchiha();
            nuevo.setNombre(sp[0]);
            nuevo.setKekkeiGenkai(sp[1]);
            nuevo.setEdad(Integer.parseInt(sp[2]));
            nuevo.setElemento(sp[3]);

            //Objeto de la clase Gson
            Gson json = new Gson();
            //el objeto se convierte a json y se almacena en una variable string
            res = json.toJson(nuevo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Formato de texto no compatible");
        }

        return res;
    }

    /*
     *Metodo para convertir Clase a JSON
     * @param clase texto en formato clase para convertir
     * @return XML convertida a JSON
     */

    public String convertirXmlAJson(String xml){

        String jsonString = "";
        try {
            //creacion de un objeto JSONObject el cual convierte la variable que recibio el metodo
            //a un objeto json
            JSONObject jsonObject = XML.toJSONObject(xml);
            //convierte el objeto json a string y lo almacena en una variable
            jsonString = jsonObject.toString(4);

        } catch (JSONException je) {
            JOptionPane.showMessageDialog(null,"El texto no esta en formato XML");
        }
        return jsonString;
    }

}
