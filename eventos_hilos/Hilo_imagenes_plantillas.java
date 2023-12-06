package eventos_hilos;

import Vista.Employe;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Hilo_imagenes_plantillas extends Thread {

    private Employe vista = null;
    private JFileChooser archivos = null;
    private File files[] = null;
    public static String imagenEmpresa = "";
    public static String imagenEmcabezado_last = "";
    public static String imagenSaludo = "";

    public Hilo_imagenes_plantillas(Employe vista) {
        this.vista = vista;

    }

    @Override
    public void run() {

        archivos = new JFileChooser();
        archivos.setMultiSelectionEnabled(true);
        archivos.setDialogTitle("Selecciona las imagenes");

        if (archivos.showOpenDialog(vista) == JFileChooser.APPROVE_OPTION) {
            files = archivos.getSelectedFiles();
            setRutas();
            JOptionPane.showMessageDialog(vista, "Imagenes Seleccionadas con Exito...", "Succes", 1);
        } else {
            JOptionPane.showMessageDialog(vista, "Debes seleccionar las imagenes antes de comenzar", "Error", 2);
            vista.dispose();
        }

    }

    private void setRutas() {

        if (files.length > 0) {
            for (int j = 0; j < files.length; j++) {

                switch (files[j].getName()) {
                    case "imagenEmpresa.png" -> {
                        imagenEmpresa = files[j].getAbsolutePath();

                    }
                    case "emcabezado_last.png" -> {
                        imagenEmcabezado_last = files[j].getAbsolutePath();

                    }
                    case "saludo.png" -> {
                        imagenSaludo = files[j].getAbsolutePath();

                    }

                    default -> {
                        System.out.println(new AssertionError().getMessage());
                    }
                }

            }
        }

    }

}
