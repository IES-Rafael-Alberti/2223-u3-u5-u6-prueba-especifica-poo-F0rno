package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador
import es.edu.iesra.daw.pfp.examen.dados.Dado
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class JuegoDeDadosSencilloTest : DescribeSpec({
    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<Dado>()
    val numeroDeJugadores = 100

    beforeTest {
        repeat(3) {
            dados.add(Dado(3U))
        }

        repeat(numeroDeJugadores) {
            jugadores.add(Jugador(it.toString()))
        }
    }

    describe("Instanciamos la clase") {
        val miJuego = JuegoDeDadosSencillo(jugadores, dados, 1000)

        it("jugamos") {
            miJuego.empezarJuego().shouldBe(Unit)
        }
        it("nos devuelve los ganadores") {
            miJuego.mostrarGanadores().shouldBeInstanceOf<List<Jugador>>()
        }
    }
})
