
package com.mitocode.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class PersonaBean {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void transferir(){
        FacesContext context = FacesContext.getCurrentInstance();
        ResultadoBean rb = context.getApplication().evaluateExpressionGet(context, "#{resultadoBean}", ResultadoBean.class);
        
        rb.setResultado(this.nombre);
    }
}
