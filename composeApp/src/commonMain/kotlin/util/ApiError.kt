package util

import kotlinx.serialization.Serializable


@Serializable
data class ApiError(val message: String)