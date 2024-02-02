/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.logics;

import co.edu.uniminuto.proyectomvc.daos.Dao;
import co.edu.uniminuto.proyectomvc.daos.PersonaDao;
import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.models.Persona;
import co.edu.uniminuto.proyectomvc.utils.DaoUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonaLogic extends Logic<PersonaDao> implements ILogic<Persona>{

    public PersonaLogic(PersonaDao dao) {
        super(dao);
    }
    
    

    @Override
    public List<Persona> getAll() throws ApplicationException {
      return super.dao.getAll();
    }

    @Override
    public void save(Persona u) throws ApplicationException {  
        try{
             super.dao.save(u);  
               DaoUtil.commit(super.dao.getCon());  
        }catch(ApplicationException e  ){
              DaoUtil.rollback(super.dao.getCon());  
            throw  e;
        } 
              
    }

    @Override
    public void edith(Persona p) throws ApplicationException {
       super.dao.edith(p);
    }

    @Override
    public Persona find(Persona p) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> findAll(Persona p) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Persona p) throws ApplicationException {
        super.dao.delete(p);
    }

    @Override
    public void desactivate(Persona usuario) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
    
    
    
}
