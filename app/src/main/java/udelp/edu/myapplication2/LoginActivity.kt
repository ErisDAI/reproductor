package udelp.edu.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import udelp.edu.myapplication2.client.ApiClient
import udelp.edu.myapplication2.data.LoginRequest

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val etUsername = findViewById<EditText>(R.id.username)
        val etPassword = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.aceptarLogin)
        btnLogin.setOnClickListener {
            val usuario = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if(usuario.isNotEmpty() || password.isNotEmpty()) {
                Toast.makeText(this,"Completa todos los campos",
                    Toast.LENGTH_SHORT).show()
            }else{
                doLogin()
            }
        }
    }
    fun doLogin() {
        lifecycleScope.launch {
            try {
                val username : EditText = findViewById<EditText>(R.id.username)
                val password : EditText = findViewById<EditText>(R.id.password)
                val request = LoginRequest(
                    usuario = username.text.toString(),
                    password = password.text.toString()
                )
                val response = ApiClient.usuarioService.login(request)
                if (response.isSuccessful) {
                    val usuarioResponse = response.body()
                    if (null != usuarioResponse && usuarioResponse.usuario.isNotEmpty()) {

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("usuario", response.body()?.usuario.toString())
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Usuario o contraseña incorrectos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }else{
                    Toast.makeText(
                        this@LoginActivity,
                        "Error inesperado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }catch (e: Exception){
                Toast.makeText(
                    this@LoginActivity,
                    "Error de conexión",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}