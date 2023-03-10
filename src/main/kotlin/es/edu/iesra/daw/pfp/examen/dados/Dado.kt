package es.edu.iesra.daw.pfp.examen.dados

import kotlin.random.Random

/**
 * Representa un dado el cual se puede tirar para sacar un número aleatorio
 */
open class Dado(private val caraMayor: UByte) {
    init {
        require(caraMayor >= 3u && caraMayor <= 20u)
    }

    /**
     * Devuelve el número que ha sacado el dado
     */
    fun leerCara() : Int {
        return Random.nextInt(1, (caraMayor+1U).toInt())
    }
}