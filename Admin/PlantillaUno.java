package Admin;

import Vista.Employe;
import eventos_hilos.Hilo_imagenes_plantillas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class PlantillaUno {

    private Document documento = new Document();
    private Image imagen = null, imagenParrafo = null;
    private Session session;
    private MimeMessage mensaje;
    private MimeBodyPart bodyPart;
    private Transport transport;
    private Properties propiedades;
    private MimeMultipart multiPart;

    public PlantillaUno() {

        propiedades = new Properties();
        bodyPart = new MimeBodyPart();
        multiPart = new MimeMultipart();

    }

    public void plantillaPDF(String nombrePdf, String nombres, String cc, String inicio, String fin) {

        try {

            FileOutputStream archivoPdf = new FileOutputStream(nombrePdf + ".pdf");
            PdfWriter.getInstance(documento, archivoPdf);
            documento.open();

            //Imagen
            imagen = Image.getInstance(Hilo_imagenes_plantillas.imagenEmpresa);
            imagen.scaleAbsolute(145, 50);
            imagen.setAbsolutePosition(415, 770);
            documento.add(imagen);

            //Texto capital
            Paragraph textoCapital = new Paragraph();
            textoCapital.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK));
            textoCapital.add("BOGOTA, " + AdminDatos.getDate(AdminDatos.numMnes, AdminDatos.meses));
            documento.add(textoCapital);
            documento.add(Chunk.NEWLINE);

            //Textos emcabezados
            AdminDatos.estiloTexto(documento, "Señor(a):", FontFactory.defaultEncoding, 10, Font.BOLD, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, nombres, FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, "C.C." + cc, FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, "Ciudad", FontFactory.defaultEncoding, 10, Font.BOLD, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);

            // Referencia 
            Paragraph ref = new Paragraph();
            ref.add("Ref.: ");
            ref.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, Font.ITALIC, BaseColor.BLACK));
            ref.setAlignment(Chunk.ALIGN_CENTER);
            ref.add(Parrafos.texto1);
            ref.setAlignment(Chunk.ALIGN_JUSTIFIED);
            documento.add(ref);

            // Linea separadora
            LineSeparator linea = new LineSeparator();
            linea.setPercentage(4);
            linea.setAlignment(Chunk.ALIGN_LEFT);
            documento.add(linea);

            Paragraph tex2 = new Paragraph();
            tex2.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, Font.ITALIC, BaseColor.BLACK));
            tex2.setAlignment(Chunk.ALIGN_LEFT);
            tex2.add(Parrafos.texto2 + "\n");
            documento.add(tex2);

            AdminDatos.estiloTexto(documento, "Respetado(a) Sr(a).", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            AdminDatos.estiloTexto(documento, nombres, FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);

            Paragraph txtIntro = new Paragraph();
            txtIntro.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            txtIntro.setAlignment(Chunk.ALIGN_JUSTIFIED);
            txtIntro.add(Parrafos.txtIntroduccion);
            documento.add(txtIntro);
            documento.add(Chunk.NEWLINE);

            Paragraph p2 = new Paragraph();
            p2.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p2.setAlignment(Chunk.ALIGN_JUSTIFIED);
            p2.add(Parrafos.parrafo1);
            p2.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.BOLD, BaseColor.BLACK));
            p2.add(" AUDITORIA Y CONTROL ");
            p2.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p2.add(Parrafos.parrafo2);
            documento.add(p2);
            documento.add(Chunk.NEWLINE);

            Paragraph p3 = new Paragraph();
            p3.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p3.setAlignment(Chunk.ALIGN_JUSTIFIED);
            p3.add(Parrafos.parrafo3);
            p3.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.BOLD, BaseColor.RED));
            p3.add("  del " + inicio + " al " + fin + " de Noviembre 2023, ");
            p3.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p3.add(Parrafos.parrafo4);
            documento.add(p3);
            documento.add(Chunk.NEWLINE);

            Paragraph p4 = new Paragraph();
            p4.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p4.setAlignment(Chunk.ALIGN_JUSTIFIED);
            p4.add(Parrafos.parrafo5);
            documento.add(p4);

            imagenParrafo = Image.getInstance(Hilo_imagenes_plantillas.imagenEmcabezado_last);
            imagenParrafo.scaleAbsolute(540, 250);
            imagenParrafo.setAbsolutePosition(34, 15);
            documento.add(imagenParrafo);

            documento.close();
            archivoPdf.close();

        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error a el Generar PDF " + e.getMessage(), "Warning", 2);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error a el Generar PDF "+ex.getMessage(), "Warning", 2);
        }

    }

    public void planrillaCorreo(String user, String password, String userDestino) {

        String contenido = "<html>"
                + "<p class = texto>"
                + "Buen dia,<br><br>"
                + "Solicito su colaboración con la verificación de la incapacidad adjunta que corresponde a la trabajadora<b>NOMBRE</b><br>"
                + "identificada con <b>102312312321</b> quien labora para la empresa <b>COVISIAN COLOMBIA S.A.S  con NIT. 900154405.<b/>"
                + "</p>"
                + "<table border=1>"
                + "<tr>"
                + "<th border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FECHA INICIO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
                + "<th border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FECHA FIN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
                + "<th border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DIAS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
                + "</tr>"
                + "<tr>"
                + "<td border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;20-20-2000&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                + "<td border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;21-25-22&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                + "<td border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                + "</tr>"
                + "</table>"
                + "</html>";

        String text = "VERIFICACIÓN DE AUNTENTICIDAD DE INCAPACIDAD 900154405";

        try {
            propiedades.put("mail.smtp.host", "smtp.gmail.com");
            propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            propiedades.setProperty("mail.smtp.starttls.enable", "true");
            propiedades.setProperty("mail.smtp.port", "587");
            propiedades.setProperty("mail.smtp.user", user);
            propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            propiedades.setProperty("mail.smtp.auth", "true");

            session = Session.getDefaultInstance(propiedades);
            mensaje = new MimeMessage(session);

            bodyPart.setContent(contenido, "text/html; charset=utf-8");
            multiPart.addBodyPart(bodyPart);

            mensaje.setFrom(new InternetAddress(user));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(userDestino));
            mensaje.setSubject(text);
            mensaje.setContent(multiPart);
            send(user, password);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

    private void send(String user, String password) {

        try {
            transport = session.getTransport("smtp");
            transport.connect(user, password);
            transport.sendMessage(mensaje, mensaje.getRecipients(Message.RecipientType.TO));
            transport.close();
            System.out.println("Mesaje enviado correctamente...");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
