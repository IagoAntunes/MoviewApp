package br.com.movieapp.core.util

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException

class LoggingInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val t1 = System.nanoTime()
        println("Sending request: ${request.url} on ${chain.connection()} \n${request.headers}")

        val response = chain.proceed(request)

        val t2 = System.nanoTime()
        println("Received response for ${response.request.url} in ${(t2 - t1) / 1e6}ms\n${response.headers}")

        return response
    }
}