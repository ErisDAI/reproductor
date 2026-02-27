package udelp.edu.myapplication2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
        .replace(R.id.mainLayout, fragment)
        .commit()
    }

}