package br.com.hu.allyson.desafiohu.util

import br.com.hu.allyson.desafiohu.domain.Amenity

object StringUtils {

    fun formatAmenities(amenities: List<Amenity>): String{
        var amenitiesConcat = ""
        var count = 0
        do {
            if(count != 2)
                amenitiesConcat += "${amenities[count].name}, "
            else
                amenitiesConcat += amenities[count].name
            count++
        }while (count <= 2 && amenities.size > count)

        return amenitiesConcat
    }

}