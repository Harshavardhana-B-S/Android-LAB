package com.example.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.buttonSignUp
import kotlinx.android.synthetic.main.activity_main.buttonSLogin
import kotlinx.android.synthetic.main.activity_main.passwordSignUp
import kotlinx.android.synthetic.main.activity_main.usernameSignup
import java.util.regex.Matcher
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSLogin.setOnClickListener {
            val it= Intent(this,LoginActivity::class.java)
            startActivity(it)
        }

        buttonSignUp.setOnClickListener{ saveUserCredentials() }


    }

    private fun saveUserCredentials(){

        val username=usernameSignup.text.toString()
        val password=passwordSignUp.text.toString()

        if(!validPassword(password))
        {
            Toast.makeText(this,"Invalid pssword Format",Toast.LENGTH_SHORT).show()
        }
        else {
           Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
            val it = Intent(this, LoginActivity::class.java)
            val bundle = Bundle()
            bundle.putString("username", username)
            bundle.putString("password", password)
            it.putExtras(bundle)
            startActivity(it)
        }

    }

    private fun validPassword(password: String):Boolean{
        val pattern: Pattern
        val matcher: Matcher
        val passwordPat = "
                           ^
                          (?=.*[0-9])
                          (?=.*[A-Z])
                          (?=.*[!@#$%^&*])
                          .{8,}
                          $
                          "
        pattern = Pattern.compile(passwordPat)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }
}