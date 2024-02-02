package co.edu.uniminuto.proyectomvc.controllers;

import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.views.MensajeView;


public class MensajeController {

    private PrincipalModel principalModel;
    private MensajeView mensajeView;

    public MensajeController(PrincipalModel _principalModel) {
        this.principalModel = _principalModel;
        this.mensajeView = new MensajeView();
        this.mensajeView.setSize(1080, 48);

    }

   

    
    public MensajeView getMensajeView() {
        return mensajeView;
    }
    
    
    

}
