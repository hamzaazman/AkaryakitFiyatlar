package com.hamzaazman.akaryakitfiyatlar.domain.model

import kotlin.collections.find

sealed class CityList(val name: String, val plateCode: Int) {
    object Adana : CityList("Adana", 1)
    object Adıyaman : CityList("Adıyaman", 2)
    object Afyonkarahisar : CityList("Afyonkarahisar", 3)
    object Ağrı : CityList("Ağrı", 4)
    object Amasya : CityList("Amasya", 5)
    object Ankara : CityList("Ankara", 6)
    object Antalya : CityList("Antalya", 7)
    object Artvin : CityList("Artvin", 8)
    object Aydın : CityList("Aydın", 9)
    object Balıkesir : CityList("Balıkesir", 10)
    object Bilecik : CityList("Bilecik", 11)
    object Bingöl : CityList("Bingöl", 12)
    object Bitlis : CityList("Bitlis", 13)
    object Bolu : CityList("Bolu", 14)
    object Burdur : CityList("Burdur", 15)
    object Bursa : CityList("Bursa", 16)
    object Çanakkale : CityList("Çanakkale", 17)
    object Çankırı : CityList("Çankırı", 18)
    object Çorum : CityList("Çorum", 19)
    object Denizli : CityList("Denizli", 20)
    object Diyarbakır : CityList("Diyarbakır", 21)
    object Edirne : CityList("Edirne", 22)
    object Elazığ : CityList("Elazığ", 23)
    object Erzincan : CityList("Erzincan", 24)
    object Erzurum : CityList("Erzurum", 25)
    object Eskişehir : CityList("Eskişehir", 26)
    object Gaziantep : CityList("Gaziantep", 27)
    object Giresun : CityList("Giresun", 28)
    object Gümüşhane : CityList("Gümüşhane", 29)
    object Hakkari : CityList("Hakkari", 30)
    object Hatay : CityList("Hatay", 31)
    object Isparta : CityList("Isparta", 32)
    object Mersin : CityList("Mersin", 33)
    object İstanbul : CityList("İstanbul", 34)
    object İzmir : CityList("İzmir", 35)
    object Kars : CityList("Kars", 36)
    object Kastamonu : CityList("Kastamonu", 37)
    object Kayseri : CityList("Kayseri", 38)
    object Kırklareli : CityList("Kırklareli", 39)
    object Kırşehir : CityList("Kırşehir", 40)
    object Kocaeli : CityList("Kocaeli", 41)
    object Konya : CityList("Konya", 42)
    object Kütahya : CityList("Kütahya", 43)
    object Malatya : CityList("Malatya", 44)
    object Manisa : CityList("Manisa", 45)
    object Kahramanmaraş : CityList("Kahramanmaraş", 46)
    object Mardin : CityList("Mardin", 47)
    object Muğla : CityList("Muğla", 48)
    object Muş : CityList("Muş", 49)
    object Nevşehir : CityList("Nevşehir", 50)
    object Niğde : CityList("Niğde", 51)
    object Ordu : CityList("Ordu", 52)
    object Rize : CityList("Rize", 53)
    object Sakarya : CityList("Sakarya", 54)
    object Samsun : CityList("Samsun", 55)
    object Siirt : CityList("Siirt", 56)
    object Sinop : CityList("Sinop", 57)
    object Sivas : CityList("Sivas", 58)
    object Tekirdağ : CityList("Tekirdağ", 59)
    object Tokat : CityList("Tokat", 60)
    object Trabzon : CityList("Trabzon", 61)
    object Tunceli : CityList("Tunceli", 62)
    object Şanlıurfa : CityList("Şanlıurfa", 63)
    object Uşak : CityList("Uşak", 64)
    object Van : CityList("Van", 65)
    object Yozgat : CityList("Yozgat", 66)
    object Zonguldak : CityList("Zonguldak", 67)
    object Aksaray : CityList("Aksaray", 68)
    object Bayburt : CityList("Bayburt", 69)
    object Karaman : CityList("Karaman", 70)
    object Kırıkkale : CityList("Kırıkkale", 71)
    object Batman : CityList("Batman", 72)
    object Şırnak : CityList("Şırnak", 73)
    object Bartın : CityList("Bartın", 74)
    object Ardahan : CityList("Ardahan", 75)
    object Iğdır : CityList("Iğdır", 76)
    object Yalova : CityList("Yalova", 77)
    object Karabük : CityList("Karabük", 78)
    object Kilis : CityList("Kilis", 79)
    object Osmaniye : CityList("Osmaniye", 80)
    object Düzce : CityList("Düzce", 81)

    companion object {
        val allCities = listOf(
            Adana,
            Adıyaman,
            Afyonkarahisar,
            Ağrı,
            Amasya,
            Ankara,
            Antalya,
            Artvin,
            Aydın,
            Balıkesir,
            Bilecik,
            Bingöl,
            Bitlis,
            Bolu,
            Burdur,
            Bursa,
            Çanakkale,
            Çankırı,
            Çorum,
            Denizli,
            Diyarbakır,
            Edirne,
            Elazığ,
            Erzincan,
            Erzurum,
            Eskişehir,
            Gaziantep,
            Giresun,
            Gümüşhane,
            Hakkari,
            Hatay,
            Isparta,
            Mersin,
            İstanbul,
            İzmir,
            Kars,
            Kastamonu,
            Kayseri,
            Kırklareli,
            Kırşehir,
            Kocaeli,
            Konya,
            Kütahya,
            Malatya,
            Manisa,
            Kahramanmaraş,
            Mardin,
            Muğla,
            Muş,
            Nevşehir,
            Niğde,
            Ordu,
            Rize,
            Sakarya,
            Samsun,
            Siirt,
            Sinop,
            Sivas,
            Tekirdağ,
            Tokat,
            Trabzon,
            Tunceli,
            Şanlıurfa,
            Uşak,
            Van,
            Yozgat,
            Zonguldak,
            Aksaray,
            Bayburt,
            Karaman,
            Kırıkkale,
            Batman,
            Şırnak,
            Bartın,
            Ardahan,
            Iğdır,
            Yalova,
            Karabük,
            Kilis,
            Osmaniye,
            Düzce
        )

        fun fromPlateCode(plateCode: Int): CityList? {
            return allCities.find { it.plateCode == plateCode }
        }
    }
}
