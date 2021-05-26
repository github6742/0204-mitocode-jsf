/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.beans;



import com.mitocode.clases.Perro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class PersonaBean {
    private Perro perro = new Perro();
    private List<Perro> lstPerros = new ArrayList<Perro>();

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public List<Perro> getLstPerros() {
        return lstPerros;
    }

    public void setLstPerros(List<Perro> lstPerros) {
        this.lstPerros = lstPerros;
    }
    
    public void refrescar(){
        
        
        Perro p1 = new Perro();
        p1.setCodigo(1);
        p1.setNombre("KAISER");
        lstPerros.add(p1);
        
        Perro  p2 = new Perro();
        p2.setCodigo(2);
        p2.setNombre("REX");
        lstPerros.add(p2);
        
        Perro  p3 = new Perro();
        p3.setCodigo(3);
        p3.setNombre("SCOBBY");
        lstPerros.add(p3);
        
        
    }
}
