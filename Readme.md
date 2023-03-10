# Prueba específica unidad 4, 5 y 6: Programación orienta a objetos.

> Se evaluará el RA2, RA4 y RA7.


## 1. Descripción del ejercicio.
Desde **GameJamIndie SL** nos solicitan ayuda para desarrollar un juego basado en los dados. 

La particularídad de este juego es que debe permitir jugar con **varios tipos de dados** y a **varios tipos de juegos** basado en los dados.   

### Tipos de dados.   
En lo que respecta a los distintos tipos de datos, se listan algunos de las posibilidades:   
![](assets/tiposDados.png)
- El **dado de cuatro caras** suele ser un tetraedro regular.   
- El **dado de seis caras** es un cubo (o lo que es lo mismo: un hexaedro regular).   
- El **dado de ocho caras** es un octaedro regular.   
- El **dado de diez caras** es un trapezoedro pentagonal.   
- El **dado de doce caras** es un dodecaedro regular.   
- El **dado de veinte caras** es un icosaedro regular.   

### Tipos de juegos.   
Respecto a los tipos de juegos, nos indican los primeros tres juegos a implementar:

#### a. Sencillo.   
* **Número de jugadores**: 2 jugadores mínimo.   
* **Número de rondas**: Puede establecerse un límite o dejar hasta que se cumpla la condición de victoria. (10 por ejemplo)  
* **Número de dados**: 3.   
* **Tipo de dados**: Se puede elegir entre varios tipos de dados.   
* **¿Cómo se juega?**: Un jugador tira los dados. Si todos salen con el mismo valor, dicho jugador habrá ganado. Hay que tener en cuenta que, según el tipo de dado se podrá conseguir hacer más corta/larga la partida. Si en la misma ronda ambos obtienen la condición de victoria, se invalida la ronda y se sigue jugando hasta que en dicha ronda haya un solo jugador con la condición de victoria o se llegue al límite de rondas. 
* **Quién gana**: Aquel jugador que consigue sacar los 3 dados con el mismo valor.
  * Ganador: `Jugador` o nada si finaliza sin ganador.    
  * Puntuación: 1.   

#### b. Chicago.
* **Número de jugadores**: 3 jugadores mínimo.   
* **Número de rondas**: 11 rondas.   
* **Número de dados**: 2.   
* **Tipo de dados**: Dado de seis caras.   
* **¿Cómo se juega?**: En cada ronda hay una puntuación objetivo. En la primera ronda comienza en 2, e irá subiendo uno a uno hasta llegar a la ronda número 11, en la que tendrá como puntuación objetivo 12. Cada jugador debe tirar dos dados y el objetivo es lograr, sumando los números de ambos dados, la puntuación objetivo de la ronda que se está jugando. Si un jugador consigue el objetivo, se le anotará la puntuación conseguida. Si por el contrario no lo consigue, no se anota nada en esta ronda y pasa el turno al siguiente jugador.   
* **Quién gana**: Aquel jugador que más puntos tenga al final de las 11 rondas.   
  * Ganador: `Jugador`. Contempla el caso de empate. 
  * Puntuación: Puntos conseguidos

#### c. Barco Capitán Tripulación.   
* **Número de jugadores**: 2 jugadores mínimo.  
* **Número de rondas**: 3 tiradas x ronda. Tiene que establecerse un número total de rondas o condición de victoria, que puede ser un límite total de puntos. (10 por ejemplo)         
* **Número de dados**: 5.  
* **Tipo de dados**: Dado de seis caras.   
* **¿Cómo se juega?**: Cada jugador debe conseguir en cada ronda un Barco (lado 6), un Capitán (lado 5) y una Tripulación (lado 4) antes de sumar carga. Para lograrlo tiene 3 tiradas. Comienza tirando los 5 dados. Si consigue un 6 en la primera tirada lo aparta (ya tiene el Barco) y continúa tirando los otros cuatro dados para intentar conseguir un Capitán (lado 5) y una Tripulación (lado 4). Si en una sola tirada le salen un Barco (lado 6) y un Capitán (lado 5) puede guardar los dos, pero deben ir en orden, de menor a mayor, por lo que si sale un lado 6 y un lado 4 solo podrá guardar el lado 6.
Si consigue el barco, el capitán y la tripulación, sólo a partir de ese momento anotará como puntuación el número que salga en los 2 dados que están en juego en la última tirada. Esta será la carga y por tanto la puntuación que indicará quien ha ganado el juego.   
Una vez tenga un Barco (lado 6), un Capitán (lado 5) y una Tripulación (lado 4), si aún le queda una o mas tiradas hasta completar la ronda, eligirá volver a tirar siempre que la carga obtenida sea menor que 6. En caso negativo se quedará con la carga obtenida.   
* **Quién gana**: Aquel jugador que tenga más puntuación (más carga) al final de las rondas que estipulemos 
  * Ganador: `Jugador`. Contempla el caso de empate.
  * Puntuación: Puntos conseguidos


```txt 
Ejemplo: Una ronda de un jugador.
Primera tirada: El jugador obtiene 6-4-3-3-2 y guarda el barco (lado 6). 
Segunda tirada: Ahora saca 5-4-5-1 y guarda el capitán (lado 5) y la tripulación (lado 4). Podría anotarse 5-1 como carga pero como le queda una tirada, el jugador puede arriesgarse en una tercera tirada para obtener una mayor carga, una puntuación más alta.
...
```
 

## 2. ¿Qué se pide?
- Desarrollar el programa en el que se debe implementar **2** de los 3 juegos. El juego `a. Sencillo` será **obligatorio** implementarlo.
- Desarrollar los test que estimes necesarios. Cuanta más cobertura, mejor. **Mínimo** deberían de probarse el funcionamiento de los **juegos**.   
- En cuanto a los *Mockk*, **mínimo** usarlo para simular la clase `Dado` durante las pruebas de los juegos.   
- **Documentar** y **generar documentación**. **Sólo** para la clase `JuegoDeDados` y la clase `Dado`.   
- **Opcional**: uso de *Detekt* o *ktlint*.

### Apoyo

- No olvides añadir las librerías que vas a usar: *Dokka*, *Kotest*, *Mockk*, *Log*, *Detekt*, *Ktlint*
- Acuérdate y usa el juego del bingo, ya que es similar.
- Podemos identificar la clase `TableroDeJuego`, `JuegoDeDados`, `Dado`.
  - El objeto `Tablero` se puede inicializar con el `JuegoDeDados` que se usará.
  - El objeto `JuegoDeDados` se puede inicializar con el tipo de dado que se usará. Al finalizar la partida devolverá el ganador y la puntuación obtenida.  
- Piensa en las propiedades y los métodos de cada clase. Por ejemplo, para ver las propiedades de `JuegoDeDados`, mira la descripción de los juegos.
- Ten en cuenta que los juegos tendrán un comportamiento común, pero cada juego tendrá una lógica de funcionamiento distinta. Los dados tendrían un trato similar.

## 3. Procedimiento a seguir
- Piensa el problema de forma global, y plantea una tentativa de solución global. A la hora de abordarlo, rompe el problema en pequeños problemas, y soluciona los problemas pequeños uno a uno antes de avanzar al siguiente. Para ello puedes apoyarte en TDD.   
- Lo primero que hacemos es identificar las clases, y empezar a realizar sus test unitarios según el proceso TDD.   

## 4. Condiciones de entrega
- El programa debe compilar y ser funcional.
- Disponibilidad de los test y pasar los test.

### Entrada
En el main, se programará la ejecución de dos partidas, cada una a un juego distinto. Por tanto, contempla la configuración del tablero para poder indicarle el Juego que vas a usar. 

### Salida
Un ejemplo de salida, por ejemplo para *Barco Capitán Tripulación*

```kotlin
######### PARTIDA 1 ###############################
...
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Ganador: Jugador a
Puntos: 30
...
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

######### PARTIDA 2 ###############################
Nombre del juego: Barco Capitán Tripulación.   
Número de jugadores: Y [A, B]
Número de rondas: Z
Número de dados: 5
Tipo de dados: Dado de seis caras.  
###################################################
INICIA EL JUEGO
Ronda 4:
...
Ronda 5: ---------------------------
  Jugador: A
  Tirada 1: Obtenido [6,5] 
  Tirada 2: Obtenido [6,5,4] Carga:4
  Tirada 3: Obtenido [6,5,4] Carga:7
  Puntuación obtenida: 7
  Puntuación total: 33
  .....................
  Jugador: B
  Tirada 1: Obtenido [6,] 
  Tirada 2: Obtenido [6,5,4] Carga:12
  Puntuación obtenida: 12
  Puntuación total: 40
Ronda 6
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Ganador: Jugador B
Puntos: 234
...
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
```

## 5. Evaluación
> Se evaluará el RA2, RA4 y RA7.

* Configuración y la incorporación y utilización de librerías de objetos en el IDE.   
* Funcionamiento del programa.   
* Definición de clases y elementos de POO.    
* Uso de los elementos de la POO.    
* Código comentado y documentado.   
* Código testeado.   

## 6. Bibliografía y ayuda
- [Juegos con dados](https://patapato.es/campamento-patapato-3/) 
- [Refactoring.Guru](https://refactoring.guru/es/)
[](https://www.tutorialesprogramacionya.com/kotlinya/detalleconcepto.php?punto=26&codigo=26&)