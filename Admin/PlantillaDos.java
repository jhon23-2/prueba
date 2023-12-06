package Admin;

import eventos_hilos.Hilo_imagenes_plantillas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class PlantillaDos {

    private Image imagen = null, imagenSaludo = null;

    public PlantillaDos() {
    }

    public void plantillaPdf(String nombrePdf, String nombres, String cc,String seniores) {

        try {
            FileOutputStream archivo = new FileOutputStream(nombrePdf + ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);

            documento.open();
            documento.setPageSize(PageSize.LETTER);
            documento.addCreator("Microsoft® Word para Microsoft 365");
            documento.addAuthor("Bogota.RLaborales");
            documento.addProducer();

            //Imagen
            imagen = Image.getInstance(Hilo_imagenes_plantillas.imagenEmpresa);
            imagen.scaleAbsolute(145, 50);
            imagen.setAbsolutePosition(365, 760);
            documento.add(imagen);

            AdminDatos.estiloTexto(documento, "\n\n\n                 Bogota D.C., " + AdminDatos.getDate(AdminDatos.numMnes, AdminDatos.meses), FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            AdminDatos.estiloTexto(documento, "                 Señores", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, "                   "+seniores, FontFactory.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            AdminDatos.estiloTexto(documento, "                 Asunto: Derecho de peticion", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, "                 Nombre: " + nombres, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, "                 Cedula: " + cc, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);

            Paragraph parrafoUno = new Paragraph();
            parrafoUno.setAlignment(Chunk.ALIGN_JUSTIFIED);
            parrafoUno.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK));
            parrafoUno.add("                 Reciban un cordial saludo de ");
            parrafoUno.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.BOLD, BaseColor.BLACK));
            parrafoUno.add("COVISIAN COLOMBIA S.A.S., ");
            parrafoUno.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK));
            parrafoUno.add(Parrafos.parrafo1_p2);
            documento.add(parrafoUno);

            AdminDatos.estiloTexto(documento, Parrafos.parrafo1_1_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, Parrafos.parrafo1_2_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, Parrafos.parrafo1_3_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, Parrafos.parrafo1_4_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);

            AdminDatos.estiloTexto(documento, "                 Adjunto soporte;", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            AdminDatos.estiloTexto(documento, Parrafos.parrafo2_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, Parrafos.parrafo2_1_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            BaseColor color = new BaseColor(7, 122, 158);
            AdminDatos.estiloTexto(documento, "                 incapacidades.colombia@covisian.com", FontFactory.defaultEncoding, 10, Font.BOLD, color);

            imagenSaludo = Image.getInstance(Hilo_imagenes_plantillas.imagenSaludo);
            imagenSaludo.scaleAbsolute(250, 120);
            imagenSaludo.setAbsolutePosition(81, 220);
            documento.add(imagenSaludo);

            System.out.println("Documento escrito Correctamente...");
            documento.close();
            archivo.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Warning", 2);
        }

    }

}
