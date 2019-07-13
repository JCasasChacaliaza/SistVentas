package controlador;

import dao.Impl.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Persona;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    private Persona persona;
    private PersonaImpl dao;
    private List<Persona> listPer;

    @PostConstruct
    public void init() {
        try {

        } catch (Exception e) {
        }

    }

    public void persona() throws Exception {
        dao = new PersonaImpl();
        persona = new Persona();
        listPer = new ArrayList<>();
    }

    public void registrar() throws Exception {

        try {
            dao.registra(persona);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado"));
        } catch (Exception e) {
            throw e;
        }

    }
    
    public void modificar()throws Exception{
        
        try {
            dao.modificar(persona);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto","Modificado"));
                    
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(Persona pers)throws Exception{
        try {
            dao.eliminar(pers);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void  listaPers () throws Exception{
        try {
            listPer = dao.ListModelo();
        } catch (Exception e) {
            throw e;
        }
        
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaImpl getDao() {
        return dao;
    }

    public void setDao(PersonaImpl dao) {
        this.dao = dao;
    }

    public List<Persona> getListPer() {
        return listPer;
    }

    public void setListPer(List<Persona> listPer) {
        this.listPer = listPer;
    }



}
