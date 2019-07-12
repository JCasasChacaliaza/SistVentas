package controlador;

import dao.Impl.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.Persona;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    
    private Persona persona;
    private PersonaImpl dao;
    private List<Persona> listPer;

    @PostConstruct
    public void init() {

    }

    public void persona() {
        dao = new PersonaImpl();
        persona = new Persona();
        listPer = new ArrayList<>();
    }

    
    
    
    
    
    
    
}
