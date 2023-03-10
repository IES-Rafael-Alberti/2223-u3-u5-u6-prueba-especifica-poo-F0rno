package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador
import es.edu.iesra.daw.pfp.examen.dados.Dado

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

    private fun sonTiradasIdenticas(tiradas: List<Int>) : Boolean {
        return tiradas.distinct().size == 1
    }

    private fun jugadoresGanadores(posiblesGanadores: List<Jugador>) : List<Jugador> {
        return posiblesGanadores.filter { jugador -> jugador.esGanador }
    }

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

    override fun mostrarGanadores(): List<Jugador> {
        return ganador
    }
}