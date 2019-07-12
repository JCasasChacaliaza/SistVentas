package dao.Impl;

import dao.Conexion;
import dao.crud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

public class PersonaImpl extends Conexion implements crud<Persona> {

    @Override
    public void registra(Persona modelo) throws Exception {
        try {
            String sql = "insert into persona (nomper, apeper, sexper, dniper, telper, estper) values (?, ?, ?, ?, ?, 'A')";
            PreparedStatement ps = getConectar().prepareStatement(sql);
            ps.setString(1, modelo.getNomPer());
            ps.setString(2, modelo.getApePer());
            ps.setString(3, modelo.getSexPer());
            ps.setString(4, modelo.getDniPer());
            ps.setString(5, modelo.getTelPer());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Persona modelo) throws Exception {
        try {
            String sql = "update persona set nomper=?, apeper =? , sexper=?, dniper=?, telper=? where idper = ?";
            PreparedStatement ps = getConectar().prepareStatement(sql);
            ps.setString(1, modelo.getNomPer());
            ps.setString(2, modelo.getApePer());
            ps.setString(3, modelo.getSexPer());
            ps.setString(4, modelo.getDniPer());
            ps.setString(5, modelo.getTelPer());
            ps.setString(6, modelo.getCodPer());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Persona modelo) throws Exception {
        try {
            String sql = "update persona set estper = 'I' where idper=?";
            PreparedStatement ps = getConectar().prepareStatement(sql);
            ps.setString(1, modelo.getEstPer());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Persona> ListModelo() throws Exception {
        List<Persona> listado;
        ResultSet rs;
        try {
            String sql = "select * from persona where estper='A'";
            listado = new ArrayList<>();
            Statement st = getConectar().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Persona per = new Persona();
                per.setCodPer(rs.getString("IDPER"));
                per.setNomPer(rs.getString("NOMPER"));
                per.setApePer(rs.getString("APEPER"));
                per.setDniPer(rs.getString("DNIPER"));
                per.setTelPer(rs.getString("TELPER"));
                per.setSexPer(rs.getString("SEXPER"));
                listado.add(per);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            cerrar();
        }
        return listado;
    }

}
