package es.edu.iesra.daw.pfp.examen.juegos

import es.edu.iesra.daw.pfp.examen.Jugador
import es.edu.iesra.daw.pfp.examen.dados.DadoHexaedro
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class JuegoDeDadosChicagoTest : DescribeSpec({
    val jugadores = mutableListOf<Jugador>()
    val dados = mutableListOf<DadoHexaedro>()
    val numeroDeJugadores = 10

    beforeTest {
        repeat(2) {
            dados.add(DadoHexaedro())
        }

        repeat(numeroDeJugadores) {
            jugadores.add(Jugador(it.toString()))
        }
    }

    describe("Instanciamos la clase") {
        val miJuego = JuegoDeDadosChicago(jugadores, dados)

        it("ejecutamos el juego chicago") {
            miJuego.empezarJuego().shouldBe(Unit)
        }
        it("nos devuelve los ganadores") {
            miJuego.mostrarGanador().shouldBeInstanceOf<List<Jugador>>()
        }
    }
})
