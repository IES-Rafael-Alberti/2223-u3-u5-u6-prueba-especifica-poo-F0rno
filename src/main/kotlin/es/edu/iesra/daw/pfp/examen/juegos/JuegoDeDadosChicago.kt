package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador
import es.edu.iesra.daw.pfp.examen.dados.DadoHexaedro

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

    private fun jugadoresConMaximaPuntuacion(jugadorConPuntuacion: List<Jugador>) : List<Jugador> {
        val maximaPuntuacion = jugadorConPuntuacion.maxOf { jugador -> jugador.puntuacion }
        return jugadorConPuntuacion.filter { jugador -> jugador.puntuacion == maximaPuntuacion}
    }

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

    override fun mostrarGanadores(): List<Jugador> {
        return ganadores
    }
}