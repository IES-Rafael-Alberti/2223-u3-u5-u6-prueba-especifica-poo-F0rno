package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador

/**
 * Representa un juego en el que se utilizan dados para jugar
 */
abstract class JuegoDeDados {

    /**
     * Ejecuta el modo de juego
     */
    abstract fun empezarJuego()

    /**
     * Devuelve los jugadores que han ganado en el modo de juego
     */
    abstract fun mostrarGanadores() : List<Jugador>
}