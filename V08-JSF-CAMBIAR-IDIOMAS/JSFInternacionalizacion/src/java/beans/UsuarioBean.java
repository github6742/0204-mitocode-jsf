/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class UsuarioBean  implements Serializable{
    private static final long serialVersionUID = 1l;
    private String localidad;
    private static Map<String, Object> LstPaises;   
    /*

    public UsuarioBean(String localidad) {
        this.localidad = localidad;
    }
*/
    
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Map<String, Object> getLstPaises() {
        return LstPaises;
    }

    public static void setLstPaises(Map<String, Object> LstPaises) {
        UsuarioBean.LstPaises = LstPaises;
    }
    
    static{
        LstPaises = new LinkedHashMap<String, Object>();
        
        LstPaises.put("English", Locale.ENGLISH);
        LstPaises.put("Francais", Locale.FRENCH);
        
        Locale espanol = new Locale("ES");
        LstPaises.put("Español", espanol);       
    }
    
    public void localidadChanged(ValueChangeEvent e){
        String newLocaleValue = e.getNewValue().toString();
        for (Map.Entry<String, Object> entry : LstPaises.entrySet()){
            if (entry.getValue().toString().equals(newLocaleValue)){
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }
}
