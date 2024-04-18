package com.example.myamplifyapp

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain

class AuthorizationInterceptor() : HttpInterceptor {

    override suspend fun intercept(request: HttpRequest, chain: HttpInterceptorChain): HttpResponse {

        val response = chain.proceed(request.newBuilder().addHeader("X-Api-Key", "da2-oh7xcvy57ffatj27ryyihigcnu").build())

        return if (response.statusCode == 401) {
            chain.proceed(request.newBuilder().addHeader("X-Api-Key", "da2-oh7xcvy57ffatj27ryyihigcnu").build())
        } else {
            response
        }
    }
}