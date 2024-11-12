import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.coroutines.runBlocking

@Serializable
data class OllamaRequest(
    val model: String,
    val prompt: String,
    val stream: Boolean
)

@Serializable
data class OllamaResponse(
    val response: String? = null
)

suspend fun fetchOllamaResponse(): String {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 100_000
        }
    }

    val requestPayload = OllamaRequest(
        model = "llama3.2",
        prompt = "Why is the sky blue?",
        stream = false
    )

    // Making the POST request
    val response: HttpResponse = client.post("http://localhost:11434/api/generate") {
        contentType(ContentType.Application.Json) // Set the content type
        setBody(requestPayload)
    }

    //Parsing the response
    val ollamaResponse = response.body<OllamaResponse>()
    val responseField = ollamaResponse.response
    client.close()
    return responseField.toString()
}

fun main() = runBlocking {
    val answer = fetchOllamaResponse()
    println("Ollama Response: $answer")
}
