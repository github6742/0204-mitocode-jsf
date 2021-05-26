/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.beans;



import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;


@ManagedBean
@RequestScoped
public class CiudadBean2 {
    
    private String codCiudad;
    private String codPais;
    private String nombre;
    private List<String> lstCiudad = new ArrayList<String>();

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getLstCiudad() {
        return lstCiudad;
    }

    public void setLstCiudad(List<String> lstCiudad) {
        this.lstCiudad = lstCiudad;
    }
   
    public void cargarCiudades(AjaxBehaviorEvent event){
        switch (codPais){
            case "1":
                //PERU
                lstCiudad.add("LIMA");
                lstCiudad.add("CUZCO");
                break;
            case "2":
                //COLOMBIA
                lstCiudad.add("BOGOTA");
                lstCiudad.add("CALI");
                break;
                
        }
    }
   
    public void cargarCiudadesPrime(){
        switch (codPais){
            case "1":
                //PERU
                lstCiudad.add("LIMA");
                lstCiudad.add("CUZCO");
                break;
            case "2":
                //COLOMBIA
                lstCiudad.add("BOGOTA");
                lstCiudad.add("CALI");
                break;
                
        }
    }
    
}
