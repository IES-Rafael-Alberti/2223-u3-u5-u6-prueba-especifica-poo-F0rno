package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador
import es.edu.iesra.daw.pfp.examen.dados.Dado

/**
 * Representa un juego en el que se utilizan dados para jugar, con la modalidad de juego sencillo
 */
class JuegoDeDadosSencillo(
    private var jugadores: List<Jugador>,
    val dados: List<Dado>,
    private val numeroDeRondas: Int = 10
) : JuegoDeDados() {

    init {
        require(jugadores.size >= 2)
        require(numeroDeRondas > 0)
        require(dados.size == 3)
    }

    private lateinit var ganador: List<Jugador>

    /**
     * Devuelve si las tiradas han sacado el mismo número
     */
    private fun sonTiradasIdenticas(tiradas: List<Int>) : Boolean {
        return tiradas.distinct().size == 1
    }

    /**
     * Devuelve los jugadores ganadores de una ronda
     */
    private fun jugadoresGanadores(posiblesGanadores: List<Jugador>) : List<Jugador> {
        return posiblesGanadores.filter { jugador -> jugador.esGanador }
    }

    /**
     * Ejecuta la modalidad de juego
     */
    override fun empezarJuego() {
        repeat(numeroDeRondas) {
            jugadores.forEach { jugador ->
                val tiradasAnteriores = mutableListOf<Int>()
                dados.forEach{ dado ->
                    tiradasAnteriores.add(jugador.tirarDado(dado))
                }
                jugador.esGanador = sonTiradasIdenticas(tiradasAnteriores)
            }
        }
        val ganadores = jugadoresGanadores(jugadores)
        if (ganadores.size > 1) {
            jugadores = ganadores
            empezarJuego()
        } else {
            ganador = ganadores
        }
    }

    /**
     * Devuelve los jugadores ganadores de la modalidad de juego
     */
    override fun mostrarGanadores(): List<Jugador> {
        return ganador
    }
}