package es.edu.iesra.daw.pfp.examen

import es.edu.iesra.daw.pfp.examen.dados.Dado
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDadosSencillo

fun main() {
    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<Dado>()
    val numeroDeJugadores = 100

    repeat(3) {
        dados.add(Dado(3U))
    }

    repeat(numeroDeJugadores) {
        jugadores.add(Jugador(it.toString()))
    }

    val miJuego = JuegoDeDadosSencillo(numeroDeJugadores, jugadores, dados, 1000)
    miJuego.empezarJuego()
    println(miJuego.mostrarGanador())
}