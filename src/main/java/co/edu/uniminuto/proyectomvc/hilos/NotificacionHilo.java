package co.edu.uniminuto.proyectomvc.hilos;

import co.edu.uniminuto.proyectomvc.controllers.MensajeController;
import co.edu.uniminuto.proyectomvc.enums.TipoMensajeEnum;
import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.utils.ViewUtil;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotificacionHilo extends Thread{

    private PrincipalModel principalModel;
     private String mensaje; 
      private TipoMensajeEnum tipoMensaje;
  

  

    public NotificacionHilo(PrincipalModel principalModel, String mensaje, TipoMensajeEnum tipoMensaje) {
        this.principalModel = principalModel;
        this.mensaje = mensaje;
        this.tipoMensaje = tipoMensaje;
    }
    
    

    @Override
    public void run() {
        try {
           
            switch (tipoMensaje) {
                case CORRECTO:
                    this.principalModel.getMensajeController().getMensajeView().getjLabelMensaje().setText(mensaje);
                    this.principalModel.getMensajeController().getMensajeView().setBackground(Color.green);
                    break;
                case ALERTA:
                    this.principalModel.getMensajeController().getMensajeView().getjLabelMensaje().setText(mensaje);
                    this.principalModel.getMensajeController().getMensajeView().setBackground(Color.yellow);
                    break;
                case ERROR:
                    this.principalModel.getMensajeController().getMensajeView().getjLabelMensaje().setText(mensaje);
                    this.principalModel.getMensajeController().getMensajeView().setBackground(Color.red);
                    break;
            }

            this.principalModel.getPrincipalController().getPrincipalView().getjInternalFrameNotificaciones().getContentPane().add(this.principalModel.getMensajeController().getMensajeView());
            ViewUtil.fullrepaint(this.principalModel.getPrincipalController().getPrincipalView().getjInternalFrameNotificaciones());

            Thread.sleep(4000);

            this.principalModel.getPrincipalController().getPrincipalView().getjInternalFrameNotificaciones().getContentPane().remove(this.principalModel.getMensajeController().getMensajeView());
            ViewUtil.fullrepaint(this.principalModel.getPrincipalController().getPrincipalView().getjInternalFrameNotificaciones());
            
        } catch (InterruptedException ex) {
            Logger.getLogger(MensajeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
