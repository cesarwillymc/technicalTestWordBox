package com.cesarwillymc.technicaltestwordbox.data.util.network

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */

sealed class ErrorSource : Exception() {

    object Network : ErrorSource()

    object Unknown : ErrorSource()

    data class ServiceError(val errorCode: String, val errorMessage: String) : ErrorSource()
}
