package ozodbek.pl.bottomnaviagtioncompose

import kotlinx.serialization.Serializable


sealed class Destinations {

    @Serializable
    data object HomeGraph: Destinations()

    @Serializable
    data object Home : Destinations()

    @Serializable
    data class Search(val searchText: String? = null) : Destinations()

    @Serializable
    data object Profile : Destinations()
}