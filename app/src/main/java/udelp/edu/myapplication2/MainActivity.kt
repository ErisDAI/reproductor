package udelp.edu.myapplication2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.main)
        val navegationView : NavigationView = findViewById(R.id.nav_view)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        loadFragment(HomeFragment())

        navegationView.setNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_perfil -> loadFragment(PerfilFragment())
                R.id.nav_salir -> logout()

            }
            drawerLayout.closeDrawers()
            true
        }

    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
        .replace(R.id.mainLayout, fragment)
        .commit()
    }
    private fun logout() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}