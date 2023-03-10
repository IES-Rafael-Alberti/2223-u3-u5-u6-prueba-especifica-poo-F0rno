package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador

abstract class JuegoDeDados {
    abstract fun empezarJuego()
    abstract fun mostrarGanador() : List<Jugador>
}