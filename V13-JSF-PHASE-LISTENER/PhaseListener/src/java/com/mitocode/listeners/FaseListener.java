/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author sgrsm
 */
public class FaseListener implements PhaseListener {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void afterPhase(PhaseEvent event) {
        
      /*- switch (event.getPhaseId().toString()){
            case "RESTORE_VIEW":
                //logica
            break;
            
        }-*/
        System.out.println("AFTER FASE: " + event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("BEFORE FASE: " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
