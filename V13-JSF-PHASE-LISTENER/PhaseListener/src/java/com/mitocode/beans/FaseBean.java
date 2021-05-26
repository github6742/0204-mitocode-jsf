/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

@ManagedBean
@RequestScoped
public class FaseBean {
    
    
    public void evaluarFase(PhaseEvent evt) throws Exception{
        try {
            if (PhaseId.APPLY_REQUEST_VALUES.equals(evt.getPhaseId())){
                System.out.println("Fase: " + PhaseId.APPLY_REQUEST_VALUES);
            }
            if (PhaseId.INVOKE_APPLICATION.equals(evt.getPhaseId())){
                System.out.println("Fase: " + PhaseId.INVOKE_APPLICATION);
            }
            if (PhaseId.RENDER_RESPONSE.equals(evt.getPhaseId())){
                System.out.println("Fase: " + PhaseId.RENDER_RESPONSE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String submit(){
        System.out.println("Accion enviada");
        return "index.xhtml";
    }
}
