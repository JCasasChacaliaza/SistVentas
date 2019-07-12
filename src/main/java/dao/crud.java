package dao;

import java.util.List;

public interface crud<Modelo> {

    public void registra(Modelo modelo) throws Exception;

    public void modificar(Modelo modelo) throws Exception;

    public void eliminar(Modelo modelo) throws Exception;
    
    List<Modelo>ListModelo()throws Exception;

}
