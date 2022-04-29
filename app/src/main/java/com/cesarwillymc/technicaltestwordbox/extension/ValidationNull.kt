package com.cesarwillymc.technicaltestwordbox.extension

/**
 * Created by Willy on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
fun Int?.orEmpty(): Int = this ?: 0

fun Boolean?.orEmpty(): Boolean = this ?: false

fun Double?.orEmpty(): Double = this ?: 0.0

fun Float?.orEmpty(): Float = this ?: 0F

inline fun <reified T> List<T>?.orEmpty(): List<T> = this ?: listOf<T>()

fun String.removeUrl(): String {
    return this.replace(URL_IMAGE, "")
}

fun String.setUrl(): String {
    return URL_IMAGE + this
}