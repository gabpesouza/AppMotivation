package br.com.gabriel.appmotivation.utils

import kotlin.random.Random

class Quotes(quote:String,categoryId:Int){
     var quote = quote;
     var categoryId = categoryId;

}






class Mock {

    var id1 = MotivationConstants.KEYS.ALL
    var id2 = MotivationConstants.KEYS.SMILE
    var id3 = MotivationConstants.KEYS.LIGHT

    val phrases = listOf(Quotes("Imagine uma nova história para sua vida e acredite nela.",id1),
    Quotes("Quando você quer alguma coisa, todo o universo conspira para que você realize o seu desejo.",id1),
    Quotes("Nossa maior fraqueza está em desistir. O caminho mais certo de vencer é tentar mais uma vez.",id1),
    Quotes("Coragem é a resistência ao medo, domínio do medo, e não a ausência do medo.",id1),
    Quotes("Quem quer vencer um obstáculo deve armar-se da força do leão e da prudência da serpente.",id2),
    Quotes("Quer você acredite que consiga fazer uma coisa ou não, você está certo.",id2),
    Quotes("Acredite na justiça, mas não a que emana dos demais e sim na tua própria.",id2),
    Quotes("Não abandones as tuas ilusões. Sem elas podes continuar a existir, mas deixas de viver.",id3),
    Quotes("Se fracassar, ao menos que fracasse ousando grandes feitos, de modo que a sua postura não seja nunca a dessas almas frias e tímidas que não conhecem nem a vitória nem a derrota.",id3),
    Quotes("Acredite que você pode, assim você já está no meio do caminho.",id3)

    )

    fun getQuote(id:Int):String{

        var size = phrases.filter { it.categoryId == id }.size;
        var number = Random.nextInt(0,size);

        return phrases.filter { it.categoryId == id }[number].quote;

    }

}