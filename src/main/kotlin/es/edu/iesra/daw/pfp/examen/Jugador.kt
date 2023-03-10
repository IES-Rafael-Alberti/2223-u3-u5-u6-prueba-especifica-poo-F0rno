package es.edu.iesra.daw.pfp.examen

import es.edu.iesra.daw.pfp.examen.dados.Dado


/**
 * Representa a un jugador de juegos de dados,
 * que puede lanzar dados para jugar en los diferentes modos de juego
 */
class Jugador(val nombre: String) {
    var puntuacion = 1
    var esGanador  = false

    /**
     * Devuelve el valor de la cara del dado que lanza
     */
    fun tirarDado(dadoParaTirar: Dado): Int {
        return dadoParaTirar.leerCara()
    }

    override fun toString(): String {
        return "Jugador $nombre con $puntuacion puntos"
    }
}