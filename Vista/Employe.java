package Vista;

import eventos_hilos.Hilo_imagenes_plantillas;
import Admin.AdminDatos;
import Admin.PlantillaDos;
import Admin.PlantillaUno;
import eventos_hilos.Hilo_eventos_plantillaUno;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Employe extends javax.swing.JFrame implements Runnable {

    private CardLayout cardLayout = null;
    private PlantillaUno plantillaUno = new PlantillaUno();
    private PlantillaDos plantillaDos = new PlantillaDos();
    private AdminDatos admin = null;
    private JFileChooser archivo = null;
    private FileNameExtensionFilter filtrado = null;
    private File files[] = null;
    private JFileChooser fileChooser = null;
    private boolean banderaRuta = false;
    public static File fileSave = null;

    public Employe() {
        new Hilo_imagenes_plantillas(this).start();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setResizable(false);
        this.setTitle("Generador de Plantillas");

        btnPlantillaDos.setFocusable(false);
        btnPlantillaUno.setFocusable(false);

        cardLayout = (CardLayout) panelVista.getLayout();
        panelVista.add(panelPlantillaUno, "plantillaUno");
        panelVista.add(panelPlantillaDos, "plantillaDos");
        panelVista.add(panel_inicio, "panelInicio");
        cardLayout.show(panelVista, "panelInicio");

        admin = new AdminDatos();
        admin.listarTabla(tblPlantillaUno, tblPlantillaDos);

        new Thread(this).start();
        Hilo_eventos_plantillaUno eventP1 = new Hilo_eventos_plantillaUno(btnBuscar_p1, btnGenerar_p1, btnLimpiar_p1);
        eventP1.setJTextFiels(txtNombre_Completo_p1, txtCc_p1, txtDateInicio_p1, txtDateFin_p1);
        eventP1.start();

    }

    private void limpiarcampos() {
        txtNombreCompleto_p2.setText("");
        txtSeniores_p2.setText("");
        txtCc_p2.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        btnPlantillaUno = new javax.swing.JButton();
        btnPlantillaDos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        panelVista = new javax.swing.JPanel();
        panelPlantillaUno = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlantillaUno = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre_Completo_p1 = new javax.swing.JTextField();
        txtCc_p1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDateInicio_p1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDateFin_p1 = new javax.swing.JTextField();
        btnGenerar_p1 = new javax.swing.JButton();
        btnBuscar_p1 = new javax.swing.JButton();
        btnLimpiar_p1 = new javax.swing.JButton();
        panelPlantillaDos = new javax.swing.JPanel();
        panelTabla_p2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlantillaDos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreCompleto_p2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCc_p2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSeniores_p2 = new javax.swing.JTextField();
        btnGenerar_p2 = new javax.swing.JButton();
        btnLimpiar_p2 = new javax.swing.JButton();
        btnBuscar_p2 = new javax.swing.JButton();
        panel_inicio = new javax.swing.JPanel();
        txtImagen_inicio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelMenu.setBackground(new java.awt.Color(204, 204, 204));

        btnPlantillaUno.setBackground(new java.awt.Color(255, 255, 255));
        btnPlantillaUno.setForeground(new java.awt.Color(0, 0, 0));
        btnPlantillaUno.setIcon(new javax.swing.ImageIcon("C:\\Users\\lcamp\\Documents\\NetBeansProjects\\Plantillas\\src\\main\\java\\Imagenes\\PlantillaUno.png")); // NOI18N
        btnPlantillaUno.setBorderPainted(false);
        btnPlantillaUno.setContentAreaFilled(false);
        btnPlantillaUno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlantillaUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantillaUnoActionPerformed(evt);
            }
        });

        btnPlantillaDos.setBackground(new java.awt.Color(204, 204, 204));
        btnPlantillaDos.setForeground(new java.awt.Color(0, 0, 0));
        btnPlantillaDos.setIcon(new javax.swing.ImageIcon("C:\\Users\\lcamp\\Documents\\NetBeansProjects\\Plantillas\\src\\main\\java\\Imagenes\\PlantillaDos.png")); // NOI18N
        btnPlantillaDos.setBorderPainted(false);
        btnPlantillaDos.setContentAreaFilled(false);
        btnPlantillaDos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlantillaDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantillaDosActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon("C:\\Users\\lcamp\\Documents\\NetBeansProjects\\Plantillas\\src\\main\\java\\Imagenes\\cruz.png")); // NOI18N
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnInicio.setBackground(new java.awt.Color(204, 204, 204));
        btnInicio.setForeground(new java.awt.Color(0, 0, 0));
        btnInicio.setIcon(new javax.swing.ImageIcon("C:\\Users\\lcamp\\Documents\\NetBeansProjects\\Plantillas\\src\\main\\java\\Imagenes\\mapa-marcador-inicio.png")); // NOI18N
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlantillaUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPlantillaDos, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlantillaUno, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlantillaDos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelVista.setLayout(new java.awt.CardLayout());

        panelPlantillaUno.setBackground(new java.awt.Color(0, 102, 255));

        tblPlantillaUno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPlantillaUno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPlantillaUnoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlantillaUno);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PLANTILLA 1");

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre completo");

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cedula");

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha Inicio");

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha Fin");

        btnGenerar_p1.setText("Generar PDF");

        btnBuscar_p1.setText("Buscar");

        btnLimpiar_p1.setText("Limpiar");

        javax.swing.GroupLayout panelPlantillaUnoLayout = new javax.swing.GroupLayout(panelPlantillaUno);
        panelPlantillaUno.setLayout(panelPlantillaUnoLayout);
        panelPlantillaUnoLayout.setHorizontalGroup(
            panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlantillaUnoLayout.createSequentialGroup()
                .addGroup(panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPlantillaUnoLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(panelPlantillaUnoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre_Completo_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addGroup(panelPlantillaUnoLayout.createSequentialGroup()
                                    .addGroup(panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDateFin_p1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                        .addComponent(txtDateInicio_p1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCc_p1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscar_p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelPlantillaUnoLayout.createSequentialGroup()
                                .addGap(0, 174, Short.MAX_VALUE)
                                .addComponent(btnLimpiar_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerar_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(12, 12, 12)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPlantillaUnoLayout.setVerticalGroup(
            panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPlantillaUnoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre_Completo_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCc_p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar_p1))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDateInicio_p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtDateFin_p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(panelPlantillaUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelVista.add(panelPlantillaUno, "card2");

        panelPlantillaDos.setBackground(new java.awt.Color(0, 204, 153));

        tblPlantillaDos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPlantillaDos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPlantillaDosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblPlantillaDos);

        javax.swing.GroupLayout panelTabla_p2Layout = new javax.swing.GroupLayout(panelTabla_p2);
        panelTabla_p2.setLayout(panelTabla_p2Layout);
        panelTabla_p2Layout.setHorizontalGroup(
            panelTabla_p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabla_p2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTabla_p2Layout.setVerticalGroup(
            panelTabla_p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PLANTILLA 2");

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre completo");

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cedula");

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Señores");

        btnGenerar_p2.setText("Generar PDF");

        btnLimpiar_p2.setText("Limpiar");

        btnBuscar_p2.setText("Buscar");

        javax.swing.GroupLayout panelPlantillaDosLayout = new javax.swing.GroupLayout(panelPlantillaDos);
        panelPlantillaDos.setLayout(panelPlantillaDosLayout);
        panelPlantillaDosLayout.setHorizontalGroup(
            panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlantillaDosLayout.createSequentialGroup()
                .addGroup(panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPlantillaDosLayout.createSequentialGroup()
                        .addGroup(panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPlantillaDosLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(txtNombreCompleto_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addGroup(panelPlantillaDosLayout.createSequentialGroup()
                                        .addGroup(panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtSeniores_p2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                            .addComponent(txtCc_p2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar_p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlantillaDosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLimpiar_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnGenerar_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(panelPlantillaDosLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelTabla_p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPlantillaDosLayout.setVerticalGroup(
            panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabla_p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPlantillaDosLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreCompleto_p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCc_p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar_p2))
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtSeniores_p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPlantillaDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelVista.add(panelPlantillaDos, "card3");

        panel_inicio.setBackground(new java.awt.Color(255, 255, 255));
        panel_inicio.setForeground(new java.awt.Color(0, 0, 0));

        txtImagen_inicio.setIcon(new javax.swing.ImageIcon("C:\\Users\\lcamp\\Documents\\NetBeansProjects\\Plantillas\\src\\main\\java\\Imagenes\\plantilla-alternativa (1).png")); // NOI18N

        jLabel10.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("BIENVENIDO NELSON GENERA TU PLANTILLA AHORA");

        javax.swing.GroupLayout panel_inicioLayout = new javax.swing.GroupLayout(panel_inicio);
        panel_inicio.setLayout(panel_inicioLayout);
        panel_inicioLayout.setHorizontalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(txtImagen_inicio))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel10)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        panel_inicioLayout.setVerticalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(88, 88, 88)
                .addComponent(txtImagen_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        panelVista.add(panel_inicio, "card4");

        panelPrincipal.add(panelVista, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlantillaUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlantillaUnoActionPerformed

        cardLayout.show(panelVista, "plantillaUno");


    }//GEN-LAST:event_btnPlantillaUnoActionPerformed

    private void btnPlantillaDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlantillaDosActionPerformed
        cardLayout.show(panelVista, "plantillaDos");

    }//GEN-LAST:event_btnPlantillaDosActionPerformed

    private void tblPlantillaUnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlantillaUnoMousePressed

        int row = tblPlantillaUno.getSelectedRow();

        txtNombre_Completo_p1.setText(tblPlantillaUno.getValueAt(row, 0) + "");
        txtCc_p1.setText(tblPlantillaUno.getValueAt(row, 1) + "");
        txtDateInicio_p1.setText(tblPlantillaUno.getValueAt(row, 2) + "");
        txtDateFin_p1.setText(tblPlantillaUno.getValueAt(row, 3) + "");
    }//GEN-LAST:event_tblPlantillaUnoMousePressed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        cardLayout.show(panelVista, "panelInicio");
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblPlantillaDosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlantillaDosMousePressed
        int fila = tblPlantillaDos.getSelectedRow();

        txtCc_p2.setText(tblPlantillaDos.getValueAt(fila, 1) + "");
        txtNombreCompleto_p2.setText(tblPlantillaDos.getValueAt(fila, 0) + "");
        txtSeniores_p2.setText(tblPlantillaDos.getValueAt(fila, 4) + "");
    }//GEN-LAST:event_tblPlantillaDosMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Employe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar_p1;
    private javax.swing.JButton btnBuscar_p2;
    private javax.swing.JButton btnGenerar_p1;
    private javax.swing.JButton btnGenerar_p2;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiar_p1;
    private javax.swing.JButton btnLimpiar_p2;
    private javax.swing.JButton btnPlantillaDos;
    private javax.swing.JButton btnPlantillaUno;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelPlantillaDos;
    private javax.swing.JPanel panelPlantillaUno;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelTabla_p2;
    private javax.swing.JPanel panelVista;
    private javax.swing.JPanel panel_inicio;
    private javax.swing.JTable tblPlantillaDos;
    private javax.swing.JTable tblPlantillaUno;
    private javax.swing.JTextField txtCc_p1;
    private javax.swing.JTextField txtCc_p2;
    private javax.swing.JTextField txtDateFin_p1;
    private javax.swing.JTextField txtDateInicio_p1;
    private javax.swing.JLabel txtImagen_inicio;
    private javax.swing.JTextField txtNombreCompleto_p2;
    private javax.swing.JTextField txtNombre_Completo_p1;
    private javax.swing.JTextField txtSeniores_p2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

        btnBuscar_p2.addActionListener(new eventsPlantilla_2());
        btnLimpiar_p2.addActionListener(new eventsPlantilla_2());
        btnGenerar_p2.addActionListener(new eventsPlantilla_2());

    }

    private class eventsPlantilla_2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnBuscar_p2) {

                if (!txtCc_p2.getText().isEmpty()) {
                    admin.buscarPersona(txtCc_p2, txtNombreCompleto_p2, txtSeniores_p2);

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar Todos Los campos", "Warning", 2);
                }

            }

            if (e.getSource() == btnLimpiar_p2) {
                limpiarcampos();

            }

            if (e.getSource() == btnGenerar_p2) {

                if (!txtCc_p2.getText().isEmpty() && !txtNombreCompleto_p2.getText().isEmpty()
                        && !txtSeniores_p2.getText().isEmpty()) {

                    plantillaDos.plantillaPdf("CARTA DERECHO PETICION VERACIDAD " + txtCc_p2.getText(), txtNombreCompleto_p2.getText(), txtCc_p2.getText(), txtSeniores_p2.getText());
                    JOptionPane.showMessageDialog(null, "PDF generado Correctamente", "Succes", 1);
                    limpiarcampos();

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos", "", 1);
                }
            }

        }
    }
}
