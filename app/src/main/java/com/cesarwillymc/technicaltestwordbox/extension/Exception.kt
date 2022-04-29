package com.cesarwillymc.technicaltestwordbox.extension

import androidx.compose.runtime.snapshots.SnapshotApplyResult

import com.cesarwillymc.technicaltestwordbox.data.util.network.ErrorSource
import com.cesarwillymc.technicaltestwordbox.domain.base.entities.Failure

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */

fun Exception.toDomain() = when (this) {
    is ErrorSource.Network -> Failure.NoInternet
    is ErrorSource.ServiceError -> Failure.Source(errorCode, errorMessage)
    else -> Failure.Generic
}
