package com.erev.cucei.cadenabytes;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing phrases int cadena bytes")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CadenaBytesTest {

    @Test
    void clase() {
        String phrase = "HOY ES VIERNES 20 DE AGOSTO Y ESTAMOS EN CLASES EN " +
          "LINEA";
        byte[] array = CadenaBytes.packageBuilder( phrase );
        assertEquals(phrase, CadenaBytes.unpacked( array ));
    }

    @ParameterizedTest(name = "Phrase Nanatsu {0}.")
    @ValueSource(strings = {
      "123456789012345678901234567890123456789012345678901234567890123456789" +
        "012345678901234567890123456789012345678901234567890123456",
      "Cuando decides mantener un sueno vivo",
      "No importa cuanto sangres, aun si te quedas sin lagrimas, debes " +
        "seguir adelante. - Melodias",
      "Todos mueren, pero mientras alguien mantenga la esperanza, los suenos " +
        "no moriran. - Meliodas",
      "Todo aquello que te propones, lo puedes lograr, si te esfuerzas. - " +
        "Meliodas",
      "Amo a una mujer, mas no voy a obligarla a amarme. - Escanor",
      "El no huyo, solamente cerro los ojos y lucho por lo que amaba. - " +
        "Gowther",
      "No tengo razon de sentir odio hacia aquellos que estan por debajo de " +
        "mi,",
      "todo lo que siento hacia ellos es pena Ese es mi pecado- Escanor",
      "Debajo de nuestros lazos de justicia y amor, todos nos reunimos con " +
        "espadas cruzadas,",
      "eso es lo que nos hace los siete pecados capitales - Escanor",
      "Porque sentiria odio haci alguien que es mucho mas debil que yo - " +
        "Escanor",
      "Un verdadero pecado no puede ser borrado, sin importar lo que hagas - " +
        "Ban",
      "Da igual lo mucho que mientas, no puedes enganar a tu propio corazon -" +
        " Meliodas",
      "Las investigaciones toman tiempo, pero cuando te enfocas completamente" +
        " en una,",
      "muchos nuevos fenomenos y desarrollos ocurren en el mundo -" +
        " Merlin",
      "Encuentren la respuesta para ustedes mismos, un humano deja de ser una" +
        " vez que deja de pensar - Merlin",
      "Que importa si fallas una o dos veces ni siquiera se cuantas veces " +
        "he fallado al controlar mi ira - Meliodas"
    })
    void NanatsuNoTaizaiPhrases(String phrase) {
        byte[] array = CadenaBytes.packageBuilder( phrase );
        assertEquals(phrase, CadenaBytes.unpacked( array ));
    }

    @ParameterizedTest(name = "Phrase Shuumarsu {0}.")
    @ValueSource(strings = {
      "Todos dicen lo mismo, odio, venganza, no necesito nada de eso",
      "No hay ninguna razon. Hay algun hombre que necesite una razon para " +
        "proteger a sus hijos - Adan",
      "En alguna parte de la arena hay un bebe llorando, esta bien,ya no " +
        "llores. Tu papa esta aqui para protegerte...",
      "de las cosas malas y aterradoras, me asegurare de derrotar a " +
        "cualquiera que intente - Adan",
      "Se siente bien ganar, aunque sea solo por una vez. - Kojiro Sasaki",
      "Despues de que pierdo es cuando siempre brillo - Kojiro Sasaki",
      "Esta espada representa los suenos y esperanzas de hombres ingenuos,",
      "tu nunca has sostenido los suenos y esperanzas de nadie en tu " +
        "existencia,",
      "y por eso no puedo perder contra alguien como tu. - Kojiro Sasaki",
      "Oye, proclamado dios del mar, puedo preguntarte una cosa",
      "Alguna vez has permanecido una noche entera en vela mejorando tu " +
        "tecnica con la espada",
      "Alguna vez llorarte lagrimas de agradecimiento por alguien que te " +
        "hizo mas fuerte",
      "Alguna vez amaste con tal conviccion a un contrincante que incluso " +
        "moririas por el",
      "No, claro, nunca, es una pena, no sabes de que te hablo - Kojiro Sasaki",
      "Cada vez que pierdes, encuentra una forma de ganar, continua " +
        "aprendiendo por tu cuenta, eso tambien es talento. - Brunnhilde",
      "Cuando pierdes la espada debes golpear con los punos, cuando pierdes " +
        "los punos debes morder con los dientes,",
      "debes pelear hasta el final. - Kagekatsu Toda",
      "Los dioses no se unen, los dioses no conspiran, los dioses no confian " +
        "en los demas,",
      "asi es como un dios debe ser, son perfectos cada uno a su manera. - " +
        "Poseidon",
      "Cuando era nino, vi un arbol incendiarse y ser destruido por un rayo, " +
        "nunca tuve miedo,",
      "mi unico pensamiento era que el cielo debia albergar algo muy poderoso" +
        ". - Lu Bu",
      "Asi es como los mas fuertes viven la vida, subestimando el poder de " +
        "los dioses. - Brunnhilde",
      "Humanos, dejen de rezar, los enemigos a los que enfrentamos son los " +
        "mismos a los que les rezan,",
      "ellos no quieren ayudarlos, quieren destruirlos. - Brunnhilde",
      "Los dioses pierden los estribos mucho mas facil que los humanos. - " +
        "Brunnhilde",
      "31 de agostp de 1888 D.C. El monstruo aparecio de repente entre la " +
        "tenebrosa oscuridad.",
      "Con sus afilados cuchillos, corto en pedazos y le quito la vida a 5 " +
        "prostitutas. Mientras tanto, en la ciudad, 3 ",
        "millones de personas... TEMBLABAN DE MIEDO UN MAL ENTRE LOS " +
          "MALES",
      "Alimentado por la oscuridad de su negro corazon... El asesino mas " +
        "famoso de la humanidad Su nombre es...",
      "JACK... EL... DESTRIPADOR",
      "Al trabajar nos deleitamos con dolor fisico - Jack el destripador",
    })
    void ShuumatsuNoValkyriePhrases(String phrase){
        byte[] array = CadenaBytes.packageBuilder( phrase );
        assertEquals(phrase, CadenaBytes.unpacked( array ));
    }
}
