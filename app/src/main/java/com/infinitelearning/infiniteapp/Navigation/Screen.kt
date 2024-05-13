package com.infinitelearning.infiniteapp.Navigation

sealed class Screen (val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Explore : Screen("explore", "Explore")
    object Detail : Screen ("detail_drama", "Detail Kdrama")
    object About :Screen ("about_me", "About Me")

    companion object {
        fun fromRoute(route: String?):
                Screen{
            return when (route){
                Home.route -> Home
                Explore.route -> Explore
                Detail.route -> Detail
                About.route -> About
                else ->{
                    Detail
                }
            }
        }
    }
}