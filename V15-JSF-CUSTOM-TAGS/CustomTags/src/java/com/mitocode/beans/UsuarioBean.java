/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UsuarioBean {
    private String nombre;
    private String clave;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String logear(){
        String pagina;
        
        if (nombre.equalsIgnoreCase("mitocode") && clave.equalsIgnoreCase("123")) {
            pagina = "saludo";
        } else {
            pagina = "index";
        }
        
        return pagina;
    }
    
}
