package Formulario;

import Clases.Celda;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Álex José
 */
public class Principal extends javax.swing.JFrame {

    //Atributos
    public static Celda celda[][]; //Se utilizará para formar una matriz con diferentes celdas
    public static int filas; //Almacenará el número de filas que van a existir en la matriz
    public static int columnas; //Almacenará el número de columnas que van a existir en la matriz
    public static int minas; //Número de celdas al que se le van a asignar una mina
    public static boolean victoria; //Indicará si el jugador ha descubierto todas las celdas sin bombas
    public static boolean derrota; //Indicará si el jugador ha descubierto una bomba o se le ha terminado los 10 minutos del tiempo
    public static Timer tiempo; //Se empleará para comenzar y parar el tiempo contabilizado
    private int centesimas_segundos = 0; //Se utilizará para conatbilizar las centésimas de segundos en el tiempo de juego
    private int segundos = 0; //Se utilizará para contabilizar los segundos en el tiempo de juego
    private int minutos = 0; //Se utilizará para contabilizar los minutos en el tiempo de juego

    public Principal() {
        initComponents(); //Método que iniciará los componentes gráficos
        setIconImage(obtenerImagen()); //Se establecerá el icono de imagen del programa, obteniéndose la imagen de la función "obtenerImagen()"
        setExtendedState(this.MAXIMIZED_BOTH); //Se establecerá la ventana del programa a pantalla completa
        tiempo = new Timer(1, acciones); //Se establece para el timer de "tiempo" un delay de "1" entre lo que se llamará a "acciones"
        cargar(); //Se llamará a la función "cargar()"
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        etiquetaTiempo = new javax.swing.JLabel();
        etiquetaEstado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonSalir.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setAlignmentY(0.0F);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        etiquetaTiempo.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        etiquetaTiempo.setText("00:00");
        etiquetaTiempo.setToolTipText("");
        etiquetaTiempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        etiquetaEstado.setFont(new java.awt.Font("Cooper Black", 1, 48)); // NOI18N
        etiquetaEstado.setText("JUGANDO...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(etiquetaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(364, 364, 364)
                .addComponent(etiquetaTiempo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        etiquetaTiempo.getAccessibleContext().setAccessibleName("etiquetatiempo");

        jPanel2.setLayout(new java.awt.GridLayout(10, 10));

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose(); //Se cerrará el programa
    }//GEN-LAST:event_botonSalirActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    public void cargar() { //Esta función empezará a cargar los aspectos relacionados con la plantilla de juego
        tiempo.start(); //Se dará inicio a cronometrar el tiempo
        victoria = false; //Se establece "victoria" en "false" en el comienzo del juego
        derrota = false; //Se establece "derrota" en "false" en el comienzo del juego
        filas = 10; //Se le asigna a "filas" un valor determinado
        columnas = 10; //Se le establece a "columnas" un valor determinado
        minas = 15; //Se establece el número de minas para el juego
        celda = new Celda[filas][columnas]; //Se crea un array de objetos denominado "celda" basado sus espacio en función de las variables "filas" y "columnas"

        for (int i = 0; i < filas; i++) { //Se recorrerá todas las filas
            for (int u = 0; u < columnas; u++) { //En cada fila se recorrerán todas las columnas
                celda[i][u] = new Celda(i, u); //Se crea un objeto para cad posición
                celda[i][u].setTipoCelda(1); //Se le asgina a cada objeto un tipo de celda "1" sin mina
                jPanel2.add(celda[i][u]); //Se añade este objeto al jPanel2
            }
        }
        
        int repeticiones = 0; //Se establece una variable de inicio de conteo
        while(repeticiones<minas){ //Se repetirá tantas veces el bucle hasta que la variable "repeticiones" llegue al número de minas establecido
            int aleatorio1 = (int)Math.floor(Math.random()*((filas-1)-0+1)+0); //Se genera un número aleatorio entre "0" y el número de filas
            int aleatorio2 = (int)Math.floor(Math.random()*((columnas-1)-0+1)+0); //Se genera un número aleatorio entre "0" y el número de columnas
             if(celda[aleatorio1][aleatorio2].getTipoCelda()==1){ //Si la celda con la posición asociada a los números aleatorios dispone de un tipo de celda "1", se ejecutarán las instrucciones inferiores
                celda[aleatorio1][aleatorio2].setTipoCelda(0); //Se establece la celda en cuestión con un tipo de celda "0"
                repeticiones++; //Se incrementa laz variable "repeticiones"
        }
        }
    }
    
    private ActionListener acciones = new ActionListener(){ //Es llamado por el Timer con un determinado delay
        public void actionPerformed(ActionEvent e) {
            centesimas_segundos++; //Incrementamos la variable que almacenará las centésimas de segundo
            if(centesimas_segundos==100){ //Cunando las centésimas de segundos alcancen los "100", se ejecutarán las instrucciones inferiores
                segundos++; //Se incrementan los segundos
                centesimas_segundos = 0; //Se vuelven a inicializar las centésimas de segundo
            }
            if(segundos==60){ //Cuando los segundos llegan a "60", se ejecutarán las instrucciones inferiores
                minutos++; //Se incrementan los minutos
                segundos = 0; //Se vuelven a inicializar los segundos
            }
            if(minutos==10){ //Cuando los minutos llegan a "10" se ejecutarán las instrucciones inferiores
                derrota=true; //Se establece "derrota" en "true" para terminar la partida
                tiempo.stop(); //Se para de cronometrar el tiempo
                etiquetaEstado.setText("¡Derrota!"); //Establecemos el texo de derrota en la etiqueta superior izquierda
            }
            actualizarTiempo(); //Se llamará a la función "actualizarTiempo" para actualizar el texto de la etiqueta superior derecha que mostrará el tiempo de la partida
        }
    };
    
    
    private void actualizarTiempo(){ //Se utiliza para actualizar el tiempo de la etiqueta superior derecha
        String texto = (minutos<=9?"0":"") + minutos + ":" + (segundos<=9?"0":"") + segundos; //Se almacena en la variable "texto" el tiempo establecido
        etiquetaTiempo.setText(texto); //Se establece a la "etiquetaTiempo" de la parte superior derecha el texto de la variable "texto"
    }
    
    public Image obtenerImagen(){ //Se emplea para retornar la imagen que se establecerá como icono de la aplicación
        Image imagen = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/mina.png"));
        
        return imagen;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    public static javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaTiempo;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
