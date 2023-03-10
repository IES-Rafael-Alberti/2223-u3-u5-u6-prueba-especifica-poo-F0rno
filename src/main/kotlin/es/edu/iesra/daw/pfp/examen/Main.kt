package es.edu.iesra.daw.pfp.examen

import es.edu.iesra.daw.pfp.examen.dados.Dado
import es.edu.iesra.daw.pfp.examen.dados.DadoHexaedro
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDados
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDadosChicago
import es.edu.iesra.daw.pfp.examen.juegos.JuegoDeDadosSencillo

fun configurarSencillo(tipoDeDado: Int, numeroDeJugadores: Int, numeroDeRondas: Int) : JuegoDeDados {
    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<Dado>()
    val numeroDeDados = 3

    repeat(numeroDeDados) {
        dados.add(Dado(tipoDeDado.toUByte()))
    }

    repeat(numeroDeJugadores) {
        jugadores.add(Jugador(it.toString()))
    }
    return JuegoDeDadosSencillo(jugadores, dados, numeroDeRondas)
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

fun banner(numeroDePartida: UByte, ganadores: List<Jugador>) {
    println("######### PARTIDA $numeroDePartida ###############################")
    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    ganadores.forEach { jugador ->  
        println("Ganador: Jugador ${jugador.nombre}")
        println("Puntos: ${jugador.puntuacion}")
    }
    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
}

fun main() {
    val miJuegoSencillo = configurarSencillo(3, 10, 10)
    miJuegoSencillo.empezarJuego()
    banner(1U, miJuegoSencillo.mostrarGanadores())

    println()

    val miJuegoChicago = configurarChicago(10)
    miJuegoChicago.empezarJuego()
    banner(2U, miJuegoChicago.mostrarGanadores())
}