/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.bean;

import com.mitocode.model.Persona;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Arrays.stream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

@ManagedBean
@RequestScoped
public class PersonaBean {
    
    private List<Persona> personas = new ArrayList<Persona>();
    
    public List<Persona> getPersonas(){
        
        Persona per = new Persona();
        per.setNombres("Sergio");
        per.setApellidos("Rodriguez");
        
        Calendar cal = Calendar.getInstance();
        cal.set(1971, 9, 3);
        per.setFechaNacimiento(cal.getTime());
        
        personas.add(per);
        
        per = new Persona();
        per.setNombres("Carlos");
        per.setApellidos("Nowak");
        
        cal = Calendar.getInstance();
        cal.set(1971, 11, 20);
        per.setFechaNacimiento(cal.getTime());
        
        personas.add(per);
        
        
        
        
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException{
        Map<String,Object> parametros = new HashMap<String,Object>();
        parametros.put("txtUsuario","SISTEMAS");
               
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rptJSF.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasper.getPath(), 
                parametros, 
                new JRBeanCollectionDataSource(this.getPersonas())
        );
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
        ServletOutputStream stream = response.getOutputStream();
        
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    
     public void exportarExcel() throws JRException, IOException{
        Map<String,Object> parametros = new HashMap<String,Object>();
        parametros.put("txtUsuario","SISTEMAS");
               
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rptJSF.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasper.getPath(), 
                parametros, 
                new JRBeanCollectionDataSource(this.getPersonas())
        );
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.xls");
        ServletOutputStream stream = response.getOutputStream();
        
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
   
     
     
    
    
     public void exportarPPT() throws JRException, IOException{
        Map<String,Object> parametros = new HashMap<String,Object>();
        parametros.put("txtUsuario","SISTEMAS");
               
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rptJSF.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasper.getPath(), 
                parametros, 
                new JRBeanCollectionDataSource(this.getPersonas())
        );
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.ppt");
        ServletOutputStream stream = response.getOutputStream();
        
        JRPptxExporter exporter = new JRPptxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
     
     public void exportarDOC() throws JRException, IOException{
        Map<String,Object> parametros = new HashMap<String,Object>();
        parametros.put("txtUsuario","SISTEMAS");
               
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rptJSF.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasper.getPath(), 
                parametros, 
                new JRBeanCollectionDataSource(this.getPersonas())
        );
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.doc");
        ServletOutputStream stream = response.getOutputStream();
        
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
     
     
     
     public void verPDF() throws JRException, IOException{
               
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rptJSF.jasper"));
        
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getPersonas()));
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream stream = response.getOutputStream();
        
        
        stream.write(bytes, 0, bytes.length);
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
}
