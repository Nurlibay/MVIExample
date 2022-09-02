package uz.unidev.mviexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.unidev.mviexample.ui.login.LoginFragment
import uz.unidev.mviexample.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commitNow()
        }
    }

    fun navigateToProfile(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ProfileFragment())
            .commitNow()
    }
}