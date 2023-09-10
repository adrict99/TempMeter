package com.adrict99.weather.data.network

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val urlWithParams = chain.request()
            .url
            .newBuilder()
            /*.addQueryParameter("param", BuildConfig.API_PARAM)*/
            .build()

        var request = chain.request()

        request = request.newBuilder()
            .url(urlWithParams)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}