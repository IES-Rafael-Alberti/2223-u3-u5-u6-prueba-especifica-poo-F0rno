package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador
import es.edu.iesra.daw.pfp.examen.dados.DadoHexaedro

/**
 * Representa un juego en el que se utilizan dados para jugar, con la modalidad de juego Chicago
 */
class JuegoDeDadosChicago(
    private var jugadores: List<Jugador>,
    private val dados: List<DadoHexaedro>,
) : JuegoDeDados() {

    init {
        require(jugadores.size >= 3)
        require(dados.size == 2)
    }

    private val numeroDeRondas: Int = 11
    private lateinit var ganadores: List<Jugador>

    /**
     * Devuelve los jugadores con la mayor puntuación
     */
    private fun jugadoresConMaximaPuntuacion(jugadorConPuntuacion: List<Jugador>) : List<Jugador> {
        val maximaPuntuacion = jugadorConPuntuacion.maxOf { jugador -> jugador.puntuacion }
        return jugadorConPuntuacion.filter { jugador -> jugador.puntuacion == maximaPuntuacion}
    }

    /**
     * Ejecuta la modalidad de juego
     */
    override fun empezarJuego() {
        val rondas = List(numeroDeRondas) {it + 1}
        rondas.forEach { ronda ->
            val objetivoDeRonda = ronda + 1
            jugadores.forEach { jugador ->
                var sumaDeTiradasAnteriores = 0
                dados. forEach { dado ->
                    sumaDeTiradasAnteriores += jugador.tirarDado(dado)
                }
                if (sumaDeTiradasAnteriores == objetivoDeRonda) jugador.puntuacion += objetivoDeRonda
            }
        }
        ganadores = jugadoresConMaximaPuntuacion(jugadores)
    }

    /**
     * Devuelve los jugadores ganadores de la modalidad de juego
     */
    override fun mostrarGanadores(): List<Jugador> {
        return ganadores
    }
}