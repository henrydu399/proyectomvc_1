/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.controllers;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.models.Cliente;
import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.utils.JTableUtils;
import co.edu.uniminuto.proyectomvc.utils.ViewUtil;
import co.edu.uniminuto.proyectomvc.views.clients.GestionCLienteView;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorClienteController {

    private PrincipalModel principalModel;
    private GestionCLienteView gestionClienteView;

    private Cliente clienteSelecionado = null;

    private String[] columnNames = {"TELEFONO", "CEDULA", "NOMBRE", "EDAD"};

    public GestorClienteController(PrincipalModel _principalModel) {
        this.principalModel = _principalModel;
        this.gestionClienteView = new GestionCLienteView();
        this.gestionClienteView.setSize(1080, 518);

        iniciarJtableClientes();

        this.gestionClienteView.getjButtonCrearCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPanelAdicionarCliente(evt);
            }
        });

        this.gestionClienteView.getjButtonEditarCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPanleEditarCliente(evt);
            }
        });

        this.gestionClienteView.getjButtonEliminarCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCLiente(evt);
            }
        });

        this.gestionClienteView.getjTableClientes().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarCliente(evt);
            }
        });

    }

    public void seleccionarCliente(java.awt.event.MouseEvent evt) {
        this.clienteSelecionado = JTableUtils.selectClienteDataJtable(this.gestionClienteView.getjTableClientes());

        this.gestionClienteView.getjTextFieldNombre().setText(clienteSelecionado.getNombre());
        this.gestionClienteView.getjTextFieldCedula().setText(clienteSelecionado.getCedula());
        this.gestionClienteView.getjTextFieldTelefono().setText(clienteSelecionado.getTelefono());
        this.gestionClienteView.getjTextFieldEdad().setText(String.valueOf(clienteSelecionado.getEdad()));

    }

    public GestionCLienteView getGestionClienteView() {
        return gestionClienteView;
    }

    private void iniciarJtableClientes() {
        this.gestionClienteView.getjTableClientes().setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                this.columnNames
        ));
    }

    public void cargarClientes(List<Cliente> list) {
        String[][] data = JTableUtils.convertClients(list, columnNames.length);
        this.gestionClienteView.getjTableClientes().setModel(new javax.swing.table.DefaultTableModel(
                data,
                this.columnNames
        ));

    }

    private void eliminarCLiente(java.awt.event.ActionEvent evt) {
        try {

            if (Objects.nonNull(this.clienteSelecionado)) {
                this.principalModel.eliminarCliente(this.clienteSelecionado);
                this.principalModel.cargarClientes();
                this.principalModel.mostrarMensaje("Se elimino el cliente correctamente", MensajeController.TipoMensajeEnum.CORRECTO);
            } else {
                this.principalModel.mostrarMensaje("Se debe seleccionar un cliente para editar", MensajeController.TipoMensajeEnum.ALERTA);
            }

        } catch (ApplicationException ex) {
            this.principalModel.mostrarMensaje("Error eliminando el cliente", MensajeController.TipoMensajeEnum.ERROR);
            Logger.getLogger(GestorClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarPanelAdicionarCliente(java.awt.event.ActionEvent evt) {
        this.principalModel.switchView(this.principalModel.getAdicionarClienteController().getAdicionarClienteView());
    }

    private void mostrarPanleEditarCliente(java.awt.event.ActionEvent evt) {
        if (Objects.nonNull(this.clienteSelecionado)) {
            this.principalModel.getEditarClienteController1().setClienteSelecionado(clienteSelecionado);
            this.principalModel.switchView(this.principalModel.getEditarClienteController1().getEditarClienteView());
        } else {
            this.principalModel.mostrarMensaje("Se debe seleccionar un cliente para editar", MensajeController.TipoMensajeEnum.ALERTA);
        }

    }

}
