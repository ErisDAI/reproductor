package udelp.edu.myapplication2.service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import udelp.edu.myapplication2.data.LoginData
import udelp.edu.myapplication2.data.LoginRequest

interface UsuarioService {
    @POST("usuario/login")
    suspend fun login( @Body request: LoginRequest
    ): Response<LoginData>
}