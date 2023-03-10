package es.edu.iesra.daw.pfp.examen

import es.edu.iesra.daw.pfp.examen.dados.Dado
import es.edu.iesra.daw.pfp.examen.dados.DadoHexaedro
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDadosChicago
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDadosSencillo

fun main() {
    /*
    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<Dado>()
    val numeroDeJugadores = 100

    repeat(3) {
        dados.add(Dado(3U))
    }

    repeat(numeroDeJugadores) {
        jugadores.add(Jugador(it.toString()))
    }

    val miJuego = JuegoDeDadosSencillo(jugadores, dados, 1000)
    miJuego.empezarJuego()
    miJuego.mostrarGanador().forEach { jugador ->
        println(jugador)
    }
    */


    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<DadoHexaedro>()
    val numeroDeJugadores = 10

    repeat(2) {
        dados.add(DadoHexaedro())
    }

    repeat(numeroDeJugadores) {
        jugadores.add(Jugador(it.toString()))
    }

    val miJuego = JuegoDeDadosChicago(jugadores, dados)
    miJuego.empezarJuego()
    miJuego.mostrarGanador().forEach { ganador ->
        println(ganador)
    }

}