# Nonograma-en-Java
Este proyecto permite la creación de un juego de Nonograma en Java con la entrada de un archivo especifico.
Funcionamiento: al dar clic sobre la cuadrícula se colocará una “X” en la celda seleccionada o se
rellenará de color negro, dependiendo del botón del ratón que se haya presionado.
Casos que pueden presentarse:
  • Al dar clic con el botón derecho del ratón, se rellenará de negro la celda seleccionada. El
  programa debe verificar con la imagen oculta si la selección fue correcta. Si la verificación
  es correcta, el cuadro se rellenará con el color negro. Si la verificación resulto equivocada
  el programa colocará una “X” y descontará una vida.
  • Al dar clic con el botón izquierdo del ratón se colocará una “X” en la celda seleccionada. El
  programa debe verificar con la imagen oculta si la selección fue correcta. Si la verificación
  es correcta, en la celda se colocará una “X”. Si la verificación resulto equivocada el
  programa rellenará la celda con color negro y descontará una vida.
  • El programa deberá terminar si la imagen fue descubierta adecuadamente o si las vidas se
  terminaron.
  • El programa permitirá hasta 3 vidas.
  
(Ver en la carpeta "nonogramas" el archivo "nono0.in" o "nono1.in")
        Las primeras 5 líneas del archivo corresponden
        a las pistas de las columnas. Los ceros indican
        que no hay pistas.
        Las siguientes 10 líneas del archivo, son las
        pistas de las filas, igualmente los ceros indican
        que no ha pista.
        Finalmente, las siguientes 10 líneas
        corresponden a la imagen oculta.
        Los ceros corresponden a una celda
        rellena de color negro:
        Las X, corresponden a las X de la imagen.
