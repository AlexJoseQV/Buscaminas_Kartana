package Clases;

import Formulario.Principal;
import java.awt.Color;
import javax.swing.JButton;


/**
 *
 * @author Álex José
 */
public class Celda extends JButton{
    
    //Atributos
    private int x; //Posición "x" de la celda en la matriz
    private int y; //Posición "y" de la celda en la matriz
    private int tipocelda; //El tipo de la celda ("0" == Bomba, "1" == Sin Bomba)
    private boolean visible; //Mostrará si la celda ha sido descubierta o no ("true" == descubierta, "false" == no descubierta)
    private Color color[]; //Se empleará este array para guardar los diferentes colores, para dar color al número que indica las bombas cercanas
    
    //Constructor
    public Celda(int x, int y) { //Cada celda se construye mediante una posición de atributo "x" e "y" 
        this.x = x; //Se establece el atributo "x" introducido desde main
        this.y = y; //Se establece el atributo "y" introducido desde main
        visible = false; //Se establece como "false" que la celda sea visible
        color = new Color[]{Color.BLUE, Color.GREEN, Color.RED, Color.PINK, Color.MAGENTA, Color.cyan, Color.ORANGE, Color.BLACK, Color.YELLOW}; //Se establece el atributo "color" con una serie de colores para cmabiar el color en función de las bombas cercanas
        setBackground(new java.awt.Color(0, 0, 204)); //Se establece el color azul para la celda
        setFont(new java.awt.Font("Tahoma", 1, 12)); //Se establece la fuente y tamaño que se le dará uso para los números de las celdas
        addActionListener(new java.awt.event.ActionListener() { //Se agregará el ActionListener para realizar clic sobre la celda y desempeñar acciones
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celdaActionPerformed(evt);
            }
        });
    }

    //Setters
    public void setVisible(boolean visible) { //Permite establecer si la celda ha sido descubierta
        this.visible = visible;
    }
    public void setTipoCelda(int tipocelda) { //Permite establecer el tipo de celda que es (0==mina, 1==sin mina)
        this.tipocelda = tipocelda;
    }
    
    //Getters
    public boolean getVisible() { //Obtenemos si la celda ha sido descubierta
        return visible;
    }
    public int getTipoCelda() { //Obtenemos el tipo de la celda
        return tipocelda;
    }
    
    
    //Métodos
    private void celdaActionPerformed(java.awt.event.ActionEvent evt) { //Se presiona sobre una celda
        clic(); //Se realiza el método "clic"
        int contador = 0;
        for(int i = 0; i < Principal.filas; i++){ //Se recorren todas las celdas, y se cuentan aquellas celdas que son visibles
            for(int u = 0; u < Principal.columnas; u++){
                if(Principal.celda[i][u].getVisible()){ //Si nos devuelve un boolean "true" se incrementará el "contador"
                    contador++;
                }
            }
        }
        if(contador==((Principal.columnas*Principal.filas)-Principal.minas) && Principal.derrota==false){ //Si el contador lelga al máximo de celdas descubiertas y no se ha esteblecido el boolean "derrota", se ganará la partida
            Principal.victoria = true; //Establecemos el boolean de "voctoria" en "true"
            Principal.etiquetaEstado.setText("¡Victoria!"); //Mostramos en la etiqueta superior izquierda que se ha ganado la partida
            Principal.tiempo.stop(); //Paremos el tiempo cronometrado
        }
    }
    public void clic(){ //Método para la realización de acciones en función del tipo de celda descubierta
        if(!visible && Principal.derrota==false && Principal.victoria==false){ //Se realizará una función, si la celda no había sido descubierta, y no se ha establecido una derrota o victoria
            visible = true; //Establecemos como visible la celda
            this.setBackground(new java.awt.Color(240,240,240)); //Se cambia el fondo de la celda a color blanco
            switch(tipocelda){ //Se ejecutarán unas instrucciones en función del tipo de celda
                case 0: //Tipo de celda "0" == "Celda con Mina"
                    for(int i = 0; i<Principal.filas; i++){ //Se recorrerán todas las celdas
                        for(int u = 0; u<Principal.columnas; u++){
                            if(Principal.celda[i][u].getTipoCelda()==0){ //Si la celda en la que se encuentra tiene una mina, se ejecutarán las instrucciones inferiores
                                Principal.celda[i][u].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mina.png"))); //Se establece una imagen en la celda de una mina
                                Principal.celda[i][u].setBackground(new java.awt.Color(240,240,240)); //Se establece un fondo blanco para las celdas con minas
                            }
                        }
                    }
                    Principal.derrota = true; //Se establece como "true" el boolean de "derrota"
                    Principal.tiempo.stop(); //Paramos el tiempo
                    Principal.etiquetaEstado.setText("¡Derrota!"); //Cambiamos la etiqueta superior izquierda a derrota
                    break;
                case 1: //Tipo de celda "1" == "Celda sin Mina"
                    int cont = 0; //Se inicializa un contador
                    this.setBackground(new java.awt.Color(240, 240, 240)); //Establecemos el fondo de la celda en la que se ha hecho  clic en blanco
                    for(int i = -1; i <= 1; i++){ //Se recorre la posiciónes de alrrededor de la celda
                        if(x+i>=0 && x+i<Principal.filas){
                            for(int u = -1; u <= 1; u++){
                                if((y+u>=0 && (y+u)<Principal.columnas)&&Principal.celda[x+i][y+u].getTipoCelda()==0){ //Sumamos a un contador las celdas con bombas detectadas
                                    cont++;
                                }
                            }
                        }
                    }
                    if(cont>0){ //Si el contador es superior a "0", se ejecuta la instrucción inferior
                        setText("" + cont); //Se establece el número de bombas contadas en el la celda
                        setForeground(color[cont]); //Se establece el número con el color en función del array "color" con el color en función del contador "cont"
                    }else if(cont==0){ //En caso de que el contador sea igual que "0", se ejecutarán las siguientes instrucciones para desvelar las casillas con contador "0" cercanas
                        for(int i = -1; i<=1; i++){ //Se recorrerán las casillas de alrrededor de la casilla que no dispone de ninguna bomba en su alrrededor con ya que tiene "0" en el contador
                            if(x+i>=0 && x+i<Principal.filas){
                                for(int u = -1; u<=1; u++){
                                    if(y+u>=0 && y+u<Principal.columnas){
                                        Principal.celda[x+i][y+u].clic(); //Se llamará al método clic por parte de la celda en la posición sumada de "i" y "u", para desvelar las celdas cercanas cuyo contador sea igual que "0"
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }
    
}
