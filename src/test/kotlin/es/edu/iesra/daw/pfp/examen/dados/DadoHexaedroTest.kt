package es.edu.iesra.daw.pfp.examen.dados

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.shouldBe

class DadoHexaedroTest : DescribeSpec({
    describe("Instanciamos la clase") {
        val dadoDe6Caras = DadoHexaedro()
        it("siempre nos da un número entre 1 y 6") {
            dadoDe6Caras.leerCara().shouldBeBetween(1,6)
        }
    }
})
