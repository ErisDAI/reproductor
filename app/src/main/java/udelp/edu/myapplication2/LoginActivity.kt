package udelp.edu.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aceptarButton: Button = findViewById<Button>(R.id.aceptarLogin)
        aceptarButton.setOnClickListener {
           doLogin()
        }
    }
    fun doLogin() {
        val username : EditText = findViewById<EditText>(R.id.username)
        val password : EditText = findViewById<EditText>(R.id.password)
        if (username.getText().isNotEmpty() && password.getText().isNotEmpty()) {
            if(username.getText().toString()=="admin" && password.getText().toString()=="123"){

            }else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Por favor ingrese un usuario y contraseña", Toast.LENGTH_SHORT).show()
        }
    }
}