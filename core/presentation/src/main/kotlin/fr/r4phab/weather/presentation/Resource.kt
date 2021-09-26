package fr.r4phab.weather.presentation

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Error<out T>(val cause: Throwable) : Resource<T>()
    class Loading<out T> : Resource<T>()
    class Nothing<out T> : Resource<T>()
}