/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class PersonaBean {

    private Persona persona = new Persona();
    private List<Persona> lstPersonas = new ArrayList();
        
    public PersonaBean() {
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
        
    public void agregarPersona(){
        this.lstPersonas.add(this.persona);
    }
  
    public void eliminarPersona(Persona persona){
        lstPersonas.remove(persona);
    }    
        
    public void registrar(){
        this.lstPersonas.add(this.persona);
    }
    
    public void validar(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String  texto = (String)value;
        
        if(!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")){
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("SEXO NO VALIDO"));
        }
    }
    
    
}
