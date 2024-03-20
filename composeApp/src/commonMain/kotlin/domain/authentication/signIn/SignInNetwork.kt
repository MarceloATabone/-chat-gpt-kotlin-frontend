package domain.authentication.signIn

import baseUrl
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import org.koin.core.component.KoinComponent
import util.ApiError

class SignInNetwork(private val httpClient: HttpClient) : KoinComponent {

    suspend fun signIn(request: SignInRequest): Any {
        val signInEndpoint = baseUrl + "signIn"
        val response = httpClient.post(signInEndpoint) {
            contentType(ContentType.Application.Json)
            setBody(json.encodeToString(request))
        }
        if (response.status == HttpStatusCode.OK) return true
        else return response.body<ApiError>()
    }
}


