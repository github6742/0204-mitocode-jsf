/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author sgrsm
 */
@ManagedBean
@RequestScoped
public class PersonaBean {

    private Persona persona = new Persona();
    private static List<Persona> lstPersonas = new ArrayList();

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    
    
    public PersonaBean() {
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    public void agregarPersona(){
        PersonaBean.lstPersonas.add(persona);
    }
   /* 
    public void agregar(String nombre, String apellido, String sexo){
        this.persona.setNombre(nombre);
        this.persona.setApellido(apellido);
        this.persona.setSexo(sexo);
        this.lista.add(persona);
    }
    */
    public void eliminarPersona(Persona persona){
        PersonaBean.lstPersonas.remove(persona);
    }
    
}
