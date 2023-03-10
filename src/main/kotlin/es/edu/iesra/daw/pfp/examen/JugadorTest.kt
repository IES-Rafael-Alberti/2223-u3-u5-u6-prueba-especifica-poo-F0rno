package es.edu.iesra.daw.pfp.examen

import es.edu.iesra.daw.pfp.examen.dados.Dado
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class JugadorTest : DescribeSpec({
    describe("Instanciamos la clase") {
        val jugador1 = Jugador("A")
        val dadoTrucado = mockk<Dado>()
        it("tiramos dado") {
            every { dadoTrucado.leerCara() } returns 10
            jugador1.tirarDado(dadoTrucado).shouldBe(10)
        }
        it("sumar puntuaciín") {
            jugador1.puntuacion = 0
            jugador1.puntuacion += jugador1.tirarDado(dadoTrucado)
            jugador1.puntuacion.shouldBe(jugador1.tirarDado(dadoTrucado))
        }
    }
})
