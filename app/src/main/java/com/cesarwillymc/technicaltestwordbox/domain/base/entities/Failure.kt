package com.cesarwillymc.technicaltestwordbox.domain.base.entities

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */

sealed class Failure : Exception() {
    object NoInternet : Failure()

    object Generic : Failure()

    data class Source(val code: String? = null, val errorMessage: String) : Failure()
}
