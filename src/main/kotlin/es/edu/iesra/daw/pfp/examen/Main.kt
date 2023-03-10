package es.edu.iesra.daw.pfp.examen

import es.edu.iesra.daw.pfp.examen.dados.Dado
import es.edu.iesra.daw.pfp.examen.dados.DadoHexaedro
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDados
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDadosChicago
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDadosSencillo

fun configurarSencillo(tipoDeDado: Int, numeroDeJugadores: Int = 2) : JuegoDeDados {
    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<Dado>()

    repeat(3) {
        dados.add(Dado(tipoDeDado.toUByte()))
    }

    repeat(numeroDeJugadores) {
        jugadores.add(Jugador(it.toString()))
    }
    return JuegoDeDadosSencillo(jugadores, dados, 1000)
}

fun configurarChicago(numeroDeJugadores: Int = 3) : JuegoDeDados {
    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<DadoHexaedro>()

    repeat(2) {
        dados.add(DadoHexaedro())
    }

    repeat(numeroDeJugadores) {
        jugadores.add(Jugador(it.toString()))
    }
    return JuegoDeDadosChicago(jugadores, dados)
}

fun main() {
    val miJuegoSencillo = configurarSencillo(3, 10)
    miJuegoSencillo.empezarJuego()

    miJuegoSencillo.mostrarGanador().forEach { jugador ->
        println(jugador)
    }

    println("########################")

    val miJuegoChicago = configurarChicago(10)
    miJuegoChicago.empezarJuego()
    miJuegoChicago.mostrarGanador().forEach { ganador ->
        println(ganador)
    }
}