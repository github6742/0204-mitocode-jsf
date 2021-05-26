/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.EmpleadoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Empleado;

@ManagedBean
@SessionScoped
public class EmpleadoBean {

    private Empleado empleado = new Empleado();
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private List<Empleado> lstEmpleado;

    public EmpleadoBean() {
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }
    
    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }
    
    public List<Empleado> getLstEmpleado() {
        return lstEmpleado;
    }
    
    public void setLstEmpleado(List<Empleado> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }
    
    public void registrar() throws Exception {
        empleadoDAO.Registrar(this.empleado);
    }
    
    public void eliminar(Empleado emp) throws Exception {
        empleadoDAO.Eliminar(emp);
        this.listar();
    }
    
    public String leer(Empleado emp){
        this.empleado = emp;
        return "editar";
    }
    
    /*
    *
     Luego de cargar los datos del objeto con el metodo leer, puedo modificar
    * con nuevos datos
    */
    public String modificar() throws Exception{
        empleadoDAO.Modificar(this.empleado);
        return "exito";
    }
    
    public void listar() throws Exception{
        this.lstEmpleado = empleadoDAO.Listar();
    }
}
