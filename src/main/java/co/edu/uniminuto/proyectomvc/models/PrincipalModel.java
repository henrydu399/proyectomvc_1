package co.edu.uniminuto.proyectomvc.models;

import co.edu.uniminuto.proyectomvc.config.ConexionCofig;
import co.edu.uniminuto.proyectomvc.controllers.AdicionarClienteController;
import co.edu.uniminuto.proyectomvc.controllers.EditarClienteController;

import co.edu.uniminuto.proyectomvc.controllers.GestorClienteController;
import co.edu.uniminuto.proyectomvc.controllers.MensajeController;
import co.edu.uniminuto.proyectomvc.controllers.MensajeController.TipoMensajeEnum;
import co.edu.uniminuto.proyectomvc.controllers.PrincipalController;
import co.edu.uniminuto.proyectomvc.daos.ClienteDao;
import co.edu.uniminuto.proyectomvc.daos.PersonaDao;
import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.hilos.NotificacionHilo;
import co.edu.uniminuto.proyectomvc.logics.ClienteLogic;
import co.edu.uniminuto.proyectomvc.logics.PersonaLogic;
import co.edu.uniminuto.proyectomvc.utils.PropertiesUtil;
import co.edu.uniminuto.proyectomvc.utils.ViewUtil;
import co.edu.uniminuto.proyectomvc.views.InformacionView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 1.0
 * @author henry
 * <b>funciones</>
 * - controla el ciclo de vida de la aplicacion 
 * - controla todos las vistas y controladores de la aplicacion
 * - controla las clases de logica de la aplicacion
 * - controla los hilos ejecutados en la aplicacion
 */

public class PrincipalModel extends Thread{

    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleados;

    //Controladores o Actions de las vistas
    private PrincipalController principalController;
    private GestorClienteController gestorClienteController;
    private MensajeController mensajeController;
    private AdicionarClienteController adicionarClienteController;
    private EditarClienteController editarClienteController1;

    private Properties properties;

    ////Unica conexion a la base de datos
    private Connection con;
    //

    //Clases logica de la aplicacion
    private PersonaLogic personaLogic;
    private ClienteLogic clienteLogic;
    ///
    
    private javax.swing.JPanel panelActual;

    private NotificacionHilo notificaciones;
    
    private InformacionView informacionView;

    /**
     * Carga todos los componentes de la aplicacion
     *  -Impotante el orden de carga :
     *      1. Caga las propiedades
     *      2. Carga la configuracion de la conexion a la base de datos
     *      3. Instacia los componentes: controladores y logica
     *      4. Muestra la vista principal
     */
    public void iniciar() {

        String mensajeError = null;

        try { // INTENTAMOS CARGAMOS LOS PROPERTIES
            this.properties = PropertiesUtil.get();
        } catch (ApplicationException e) {
            mensajeError = e.getMsjUsuario();
        }

        try { //CONECTAMOS A LA BASE DE DATOS
            this.con = ConexionCofig.get(this.properties);
            this.con.setAutoCommit(false);
        } catch (ApplicationException e) {
            mensajeError = e.getMsjUsuario();
        } catch (SQLException ex) {
            mensajeError = "ERROR LA BASE DE DATOS NO SOPORTA TRANSACIONES";
            Logger.getLogger(PrincipalModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.mensajeController = new MensajeController(this);
        this.gestorClienteController = new GestorClienteController(this);
        this.principalController = new PrincipalController(this);
        this.adicionarClienteController = new AdicionarClienteController(this);
        this.editarClienteController1 = new EditarClienteController(this,null);
        
        this.personaLogic = new PersonaLogic(new PersonaDao(this.con));
        this.clienteLogic = new ClienteLogic(new ClienteDao(this.con) );
        
        this.informacionView = new InformacionView();
        this.informacionView.setSize(800, 400);
        
        this.switchView(this.informacionView);
        
        this.principalController.show();
        
    

        if (Objects.isNull(mensajeError)) {
            mostrarMensaje("Se ha iniciado correctamente la aplicacion" ,TipoMensajeEnum.CORRECTO );
        } else {
            mostrarMensaje(mensajeError,TipoMensajeEnum.ALERTA);
        }
      
        
  

    }
    
    public void mostrarMensaje(String mensaje,  TipoMensajeEnum tipoMensaje){
        this.notificaciones = new NotificacionHilo(this , mensaje, tipoMensaje);  
        this.notificaciones.start();
       
    }

    public void cargarClientes() throws ApplicationException{
            this.listaClientes = this.clienteLogic.getAll();   
            this.gestorClienteController.cargarClientes(listaClientes);
    }
    
    /**
     * Metodo que guarda el cliente
     * @param Cliente
     * @exception ApplicationException
     * @return void
    */
    public void guardarCliente(Cliente c) throws ApplicationException{
        this.clienteLogic.save(c);
    }
    public boolean existeCliente(Cliente c)throws ApplicationException{
        Cliente c2 =  this.clienteLogic.find(c);
        if( Objects.isNull(c2)){
            return false;
        }
            return true;    
    }
    public void editarCliente(Cliente c)throws ApplicationException{
        this.clienteLogic.edith(c);
    }
    
    public void eliminarCliente(Cliente c )throws ApplicationException{
        this.clienteLogic.delete(c);
    }

    public void switchView(javax.swing.JPanel view) {
        
        if( Objects.isNull(this.panelActual)  ){
         this.panelActual = view;
        }else{
            this.principalController.getPrincipalView().getjInternalFrameCuerpo().getContentPane().remove(this.panelActual);
            this.panelActual = view;
        }   
        this.principalController.getPrincipalView().getjInternalFrameCuerpo().getContentPane().add ( view);
        ViewUtil.fullrepaint(this.principalController.getPrincipalView());   
    }
    
    
    
    

    @Override
    public void run() {
        
            iniciar();
        
        
    }

    public NotificacionHilo getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(NotificacionHilo notificaciones) {
        this.notificaciones = notificaciones;
    }

    public AdicionarClienteController getAdicionarClienteController() {
        return adicionarClienteController;
    }
    
    
    
    
    

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public GestorClienteController getGestorClienteController() {
        return gestorClienteController;
    }

    public Properties getProperties() {
        return properties;
    }

    public MensajeController getMensajeController() {
        return mensajeController;
    }

    public EditarClienteController getEditarClienteController1() {
        return editarClienteController1;
    }
    
    
    

}
