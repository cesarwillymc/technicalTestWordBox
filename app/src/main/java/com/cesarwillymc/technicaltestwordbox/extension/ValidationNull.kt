package com.cesarwillymc.technicaltestwordbox.extension

/**
 * Created by Willy on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */

fun String.removeUrl(): String {
    return this.replace(URL_IMAGE, "")
}

fun String.setUrl(): String {
    return URL_IMAGE + this
}