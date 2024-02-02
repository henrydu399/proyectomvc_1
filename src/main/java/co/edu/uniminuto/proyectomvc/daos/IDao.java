/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.daos;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import java.util.List;


public interface IDao<T>  {
    
    	List<T> getAll ()throws ApplicationException;
	
	void  save(T u)  throws ApplicationException;
	
	void  edith(T p) throws ApplicationException;
	
	T  find(T p) throws ApplicationException;
	
	List<T>  findAll(T p) throws ApplicationException;
	
	void  delete(T p) throws ApplicationException;
	
	public void desactivate(T usuario) throws ApplicationException ;
}
