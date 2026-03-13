package udelp.edu.myapplication2.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import udelp.edu.myapplication2.service.UsuarioService

object ApiClient {
    private const val BASE_URL = "http://10.0.2.2_8080/"
    val usuarioService: UsuarioService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsuarioService::class.java)
    }
}