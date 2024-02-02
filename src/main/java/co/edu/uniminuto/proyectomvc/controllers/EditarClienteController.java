/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.controllers;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.models.Cliente;
import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.views.clients.AdicionarClienteView;
import co.edu.uniminuto.proyectomvc.views.clients.EditarClienteView;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class EditarClienteController {

    private PrincipalModel principalModel;

    private EditarClienteView editarClienteView;

    private Cliente clienteSelecionado = null;

    public EditarClienteController(PrincipalModel principalModel, Cliente cliente) {
        this.principalModel = principalModel;
        this.editarClienteView = new EditarClienteView();
        this.editarClienteView.setSize(500, 400);
        this.clienteSelecionado = cliente;

        if (Objects.nonNull(this.clienteSelecionado)) {
            this.editarClienteView.getjTextNombre().setText(this.clienteSelecionado.getNombre());
            this.editarClienteView.getjTextTelefono().setText(this.clienteSelecionado.getTelefono());
            this.editarClienteView.getjTextCedula().setText(this.clienteSelecionado.getCedula());
            this.editarClienteView.getjComboEdad().setSelectedItem(String.valueOf(this.clienteSelecionado.getEdad()));
        }

        this.editarClienteView.getjButtonGuardarCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar(evt);
            }
        });

        this.editarClienteView.getjButtonRegresar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar(evt);
            }
        });

    }

    public void editar(java.awt.event.ActionEvent evt) {
        String nombre = this.editarClienteView.getjTextNombre().getText();
        String Telefono = this.editarClienteView.getjTextTelefono().getText();
        String cedula = this.editarClienteView.getjTextCedula().getText();
        String edad = (String) this.editarClienteView.getjComboEdad().getSelectedItem();
        if (Objects.isNull(nombre) || nombre.isEmpty()) {
            this.principalModel.mostrarMensaje("El campo nombre no puede estar vacio", MensajeController.TipoMensajeEnum.ALERTA);
            return;
        }
        if (Objects.isNull(cedula) || cedula.isEmpty()) {
            this.principalModel.mostrarMensaje("El campo cedula no puede estar vacio", MensajeController.TipoMensajeEnum.ALERTA);
            return;
        }
        if (Objects.isNull(Telefono) || Telefono.isEmpty()) {
            this.principalModel.mostrarMensaje("El campo Telefono no puede estar vacio", MensajeController.TipoMensajeEnum.ALERTA);
            return;
        }

        Cliente c = new Cliente(Telefono, nombre, cedula, Integer.parseInt(edad));

        try {
            this.principalModel.editarCliente(c);

            this.principalModel.cargarClientes();
            this.principalModel.mostrarMensaje("Se edito el cliente correctamente", MensajeController.TipoMensajeEnum.CORRECTO);

            this.principalModel.switchView(this.principalModel.getGestorClienteController().getGestionClienteView());

        } catch (ApplicationException ex) {
            this.principalModel.mostrarMensaje("Error al editar el cliente", MensajeController.TipoMensajeEnum.ERROR);
            Logger.getLogger(EditarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void clear() {
        this.editarClienteView.getjTextNombre().setText("");
        this.editarClienteView.getjTextTelefono().setText("");
        this.editarClienteView.getjTextCedula().setText("");
    }

    public void regresar(java.awt.event.ActionEvent evt) {
        this.principalModel.switchView(this.principalModel.getGestorClienteController().getGestionClienteView());
    }

    public EditarClienteView getEditarClienteView() {
        return editarClienteView;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;

        if (Objects.nonNull(this.clienteSelecionado)) {
            this.editarClienteView.getjTextNombre().setText(this.clienteSelecionado.getNombre());
            this.editarClienteView.getjTextTelefono().setText(this.clienteSelecionado.getTelefono());
            this.editarClienteView.getjTextCedula().setText(this.clienteSelecionado.getCedula());
            this.editarClienteView.getjComboEdad().setSelectedItem(String.valueOf(this.clienteSelecionado.getEdad()));
        }
    }

}
