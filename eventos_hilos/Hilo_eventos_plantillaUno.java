package eventos_hilos;

import Admin.PlantillaUno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Hilo_eventos_plantillaUno extends Thread {

    private JButton btnBuscar, btnGenerarPdf, btnLimpiar;
    private JTextField nombres, cedula, fechaInicio, fechaFin;

    public Hilo_eventos_plantillaUno() {
    }

    public Hilo_eventos_plantillaUno(JButton btnBuscar, JButton btnGenerarPdf, JButton btnLimpiar) {
        this.btnBuscar = btnBuscar;
        this.btnGenerarPdf = btnGenerarPdf;
        this.btnLimpiar = btnLimpiar;
    }

    @Override
    public void run() {
        btnGenerarPdf.addActionListener(new gestionarEventos());
        btnBuscar.addActionListener(new gestionarEventos());
        btnLimpiar.addActionListener(new gestionarEventos());
    }

    public void setJTextFiels(JTextField nombres, JTextField cedula, JTextField fechaInicio, JTextField fechaFin) {
        this.nombres = nombres;
        this.cedula = cedula;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    private class gestionarEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnLimpiar) {
                limpiarCampos();
            }

            if (e.getSource() == btnGenerarPdf) {
                if (!nombres.getText().isEmpty() && !cedula.getText().isEmpty() && !fechaInicio.getText().isEmpty()
                        && !fechaFin.getText().isEmpty()) {

                    new PlantillaUno().plantillaPDF(cedula.getText(), nombres.getText(), cedula.getText(), fechaInicio(), fechaFin());
                    JOptionPane.showMessageDialog(null, "PDF generado Correctamente", "Succes", 1);
                    limpiarCampos();
                } else {
                    System.err.println("debes llenar los datos para generar el pdf correctamente...");
                }
            }

            if (e.getSource() == btnBuscar) {
                if (!cedula.getText().isEmpty()) {

                    new Admin.AdminDatos().buscarPersona(cedula, nombres, fechaInicio, fechaFin);
                    JOptionPane.showMessageDialog(null, "Dato encontrado Correctamente", "Succes", 1);

                } else {
                    System.err.println("debes llenar los datos para Buscar el Dato correctamente...");

                }
            }

        }
    }

    private void limpiarCampos() {
        nombres.setText("");
        cedula.setText("");
        fechaInicio.setText("");
        fechaFin.setText("");
    }
    
       private String fechaInicio() {

        String fecha[] = fechaInicio.getText().split("|");
        String date = fecha[0] + fecha[1];

        return date;
    }

    private String fechaFin() {

        String fecha[] = fechaFin.getText().split("|");
        String date = fecha[0] + fecha[1];

        return date;
    }

}
