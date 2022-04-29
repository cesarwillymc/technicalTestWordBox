package com.cesarwillymc.technicaltestwordbox.data.util.network

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorSource
}
