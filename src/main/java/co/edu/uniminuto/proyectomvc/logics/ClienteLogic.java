/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.logics;

import co.edu.uniminuto.proyectomvc.daos.ClienteDao;
import co.edu.uniminuto.proyectomvc.daos.Dao;
import co.edu.uniminuto.proyectomvc.daos.PersonaDao;
import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.models.Cliente;
import co.edu.uniminuto.proyectomvc.models.Persona;
import co.edu.uniminuto.proyectomvc.utils.DaoUtil;
import java.util.List;

/**
 *
 * @author henry
 */
public class ClienteLogic extends Logic<ClienteDao> implements ILogic<Cliente> {

    
    private PersonaDao personaDao;
    
    public ClienteLogic(ClienteDao dao) {
        super(dao);
        this.personaDao= new PersonaDao(dao.getCon());
    }

    @Override
    public List<Cliente> getAll() throws ApplicationException {
        return super.dao.getAll();
    }

    @Override
    public void save(Cliente u) throws ApplicationException {
        try {
            this.personaDao.save( new Persona(u.getNombre(), u.getCedula(), u.getEdad()));
            super.dao.save(u);
            DaoUtil.commit(super.dao.getCon());
        } catch (ApplicationException e) {
            DaoUtil.rollback(super.dao.getCon());
            throw e;
        }
    }

    @Override
    public void edith(Cliente u) throws ApplicationException {
          try {
            this.personaDao.edith(new Persona(u.getNombre(), u.getCedula(), u.getEdad()));
            super.dao.edith(u);
            DaoUtil.commit(super.dao.getCon());
        } catch (ApplicationException e) {
            DaoUtil.rollback(super.dao.getCon());
            throw e;
        }
    }

    @Override
    public Cliente find(Cliente p) throws ApplicationException {
        return super.dao.find(p);
    }

    @Override
    public List<Cliente> findAll(Cliente p) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Cliente u) throws ApplicationException {
           try {
            super.dao.delete(u);
            this.personaDao.delete(new Persona(u.getNombre(), u.getCedula(), u.getEdad()));
            
            DaoUtil.commit(super.dao.getCon());
        } catch (ApplicationException e) {
            DaoUtil.rollback(super.dao.getCon());
            throw e;
        }
        
    }

    @Override
    public void desactivate(Cliente usuario) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
