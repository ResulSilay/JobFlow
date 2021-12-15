package app.flow.job.data.api

import app.flow.job.data.api.ApiConst.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private var retrofit: Retrofit? = null

    fun client(): Retrofit? {
        try {
            val client = OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS).build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return retrofit
    }

    companion object {
        private var instance: ApiClient? = null

        fun instance(): ApiClient {
            if (instance == null) {
                return ApiClient()
            }

            return instance as ApiClient
        }
    }
}