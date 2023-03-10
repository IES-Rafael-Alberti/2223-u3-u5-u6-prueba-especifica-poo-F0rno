package es.edu.iesra.daw.pfp.examen.dados

import kotlin.random.Random

class Dado(private val caraMayor: UByte) {
    init {
        require(caraMayor >= 3u && caraMayor <= 24u)
    }

    fun leerCara() : Int {
        return Random.nextInt(1, caraMayor.toInt())
    }
}