package com.example.traveldesk

data class Place(
    var  aImageRes :  Int,
    var CityName: String
)

class PlaceRepository {
    fun getAllData(): List<Place> {
        return listOf(
            Place(
                R.drawable.one,
                "Grand Forks"
            ),
            Place(
                R.drawable.three,
                "Bontoc"
            ),
            Place(
                R.drawable.two,
                "Arganda"
            ),
            Place(
                R.drawable.four,
                "Eschenlohe"
            ),
            Place(
                R.drawable.five,
                "Sidney"
            ),
            Place(
                R.drawable.two,
                "Chennai"
            ),
            Place(
                R.drawable.four,
                "Moscow"
            )
        )
    }
}