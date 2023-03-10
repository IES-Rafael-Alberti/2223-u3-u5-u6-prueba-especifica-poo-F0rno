package es.edu.iesra.daw.pfp.examen

import es.edu.iesra.daw.pfp.examen.dados.Dado

class Jugador(private val nombre: String) {
    var puntuacion = 0

    fun tirarDado(dadoParaTirar: Dado): Int {
        return dadoParaTirar.leerCara()
    }

    override fun toString(): String {
        return "Jugador $nombre con $puntuacion puntos"
    }
}