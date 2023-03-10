package es.edu.iesra.daw.pfp.examen.dados

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.shouldBe

class DadoTest : DescribeSpec({
    describe("Inicializamos los dados") {
        it("de 3 caras, las mínimas") {
            val miDado = Dado(3u)
            miDado.leerCara().shouldBeBetween(1,3)
        }
        it("de 24 caras, las máximas") {
            val miDado = Dado(24u)
            miDado.leerCara().shouldBeBetween(1,24)
        }
        it("de 25 caras, mal") {
            shouldThrow<Exception> {
                Dado(25u)
            }.message shouldBe  ("Failed requirement.")
        }
    }
})
