package com.wasimsirschaudharyco.onBoarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wasimsirschaudharyco.R
import com.wasimsirschaudharyco.onBoarding.fragment.LoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Create initial fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.containers, LoginFragment()).addToBackStack(null)
                .commitAllowingStateLoss()
        }

    }

    //Implement for fragment pop operation
    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 1) {
            finishAffinity()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}

