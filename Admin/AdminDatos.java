package Admin;

import lectura.Datos;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import java.io.File;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminDatos {

    public static final int numMnes = LocalDate.now().getMonth().getValue();
    public static final String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    private Hashtable<String, Datos> datos = new Hashtable<String, Datos>();

    public AdminDatos() {

        for (Datos ds : listaDatos()) {
            datos.put(ds.getDocumento(), ds);
        }

    }

    public void listarTabla(JTable tablaUno, JTable tablaDos) {

        String columnas[] = {"Nombres", "Documento", "Fecha Inicio", "Fecha Fin", "Eps"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String registros[] = new String[5];

        for (Datos d : listaDatos()) {

            if (!d.getNombres().equalsIgnoreCase("Nombres") && !d.getDocumento().equalsIgnoreCase("Documento")
                    && !d.getFechaInicio().equalsIgnoreCase("INICIO") && !d.getFechaFin().equalsIgnoreCase("FIN")
                    && !d.getEps().equalsIgnoreCase("EPS")) {

                registros[0] = d.getNombres();
                registros[1] = d.getDocumento();
                registros[2] = d.getFechaInicio();
                registros[3] = d.getFechaFin();
                registros[4] = d.getEps();
                modelo.addRow(registros);

            }

        }

        tablaUno.setModel(modelo);
        tablaDos.setModel(modelo);
    }

    private List<Datos> listaDatos() {

        File archivo = new File("C:\\Users\\lcamp\\Desktop\\Libro1.xlsx");

        PoijiOptions opciones = PoijiOptions.PoijiOptionsBuilder
                .settings()
                .sheetName("Hoja1")
                .trimCellValue(true)
                .build();

        List<Datos> datos = Poiji.fromExcel(archivo, Datos.class, opciones);

        return datos;
    }

    public void buscarPersona(JTextField cedula, JTextField nombres, JTextField fechaInicio, JTextField fechaFin) {

        if (datos.containsKey(cedula.getText())) {

            JOptionPane.showMessageDialog(null, "Dato encontrado con exito..", "Sucess", 1);
            nombres.setText(datos.get(cedula.getText()).getNombres());
            fechaInicio.setText(datos.get(cedula.getText()).getFechaInicio());
            fechaFin.setText(datos.get(cedula.getText()).getFechaFin());

        } else {
            JOptionPane.showMessageDialog(null, "El dato con cc " + cedula.getText() + " No existe", "Warning", 2);
            nombres.setText("");
            fechaInicio.setText("");
            fechaFin.setText("");
            cedula.setText("");
        }

    }

    public void buscarPersona(JTextField cedula, JTextField nombres ,JTextField seniores) {
        if (datos.containsKey(cedula.getText())) {

            JOptionPane.showMessageDialog(null, "Dato encontrado con exito..", "Sucess", 1);
            nombres.setText(datos.get(cedula.getText()).getNombres());
            cedula.setText(datos.get(cedula.getText()).getDocumento());
            seniores.setText(datos.get(cedula.getText()).getEps());

        } else {
            JOptionPane.showMessageDialog(null, "El dato con cc " + cedula.getText() + " No existe", "Warning", 2);
            nombres.setText("");
            cedula.setText("");
        }
    }

    public static String getDate(int numMes, String meses[]) {

        String date = "";
        int numDia = LocalDate.now().getDayOfMonth();
        int numAnio = LocalDate.now().getYear();

        for (int i = 0; i < meses.length; i++) {

            if (numMes - 1 == i) {
                date = numDia + " de " + meses[i] + " de " + numAnio;
                break;
            }

        }

        return date;
    }

    public static void estiloTexto(Document documento, String texto, String formatoLetra, float tam, int stile, BaseColor color) {

        try {

            Paragraph text = new Paragraph();
            text.setFont(FontFactory.getFont(formatoLetra, tam, stile, color));
            text.add(texto);
            text.setAlignment(Chunk.ALIGN_JUSTIFIED);
            documento.add(text);

        } catch (DocumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
