package kiwi.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import kiwi.app.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findNavController(R.id.fragmentStart)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragmentStart).navigateUp()
    }

}
