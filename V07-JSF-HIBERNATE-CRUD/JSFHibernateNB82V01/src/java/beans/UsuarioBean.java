/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();

    public UsuarioBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String verificarDatos() throws Exception {
        UsuarioDAO usuDAO = new UsuarioDAO();
        Usuario us = null;
        String resultado = null;

        try {
            // Enviando la encriptaciuon
            // String encript = DigesUtil.md5Hex(this.usuario.getNombre());
            // String encript = DigestUtils.sha1Hex(this.usuario.getNombre());
            //this.usuario.setClave(encript);
            
            us = usuDAO.verificarDatos(this.usuario);

            if (us != null) {
                System.out.println("if-true");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                resultado = "exito";
            } else {
                resultado = "error";
            }
        } catch (Exception e) {
            throw e;
        }

        System.out.println("UsuarioBean-us.get.Usuario: " + us.getNombre());
        System.out.println("UsuarioBean-us.get.clave: " + us.getClave());
        System.out.println("UsuarioBean-resultado: " + resultado);
        return resultado;
    }

    public boolean verificarSesion() {
        boolean estado = false;

        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            estado = true;
        }

        return estado;
    }

    public String cerrarSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
