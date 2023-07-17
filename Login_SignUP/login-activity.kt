package com.example.loginsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.buttonLSignUp
import kotlinx.android.synthetic.main.activity_login.buttonLogin
import kotlinx.android.synthetic.main.activity_login.passwordLogin
import kotlinx.android.synthetic.main.activity_login.usernameLogin


class LoginActivity : AppCompatActivity() {

    var count = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        buttonLSignUp.setOnClickListener {
            val it= Intent(this,MainActivity::class.java)
            startActivity(it)
        }

        buttonLogin.setOnClickListener {


            if(count==0) {
                Toast.makeText(this, "Failed Login Attempts", Toast.LENGTH_SHORT).show();
                buttonLogin.isEnabled=false;
            }
          else {
               
                val bundle = intent.extras
                val regUsername = bundle?.getString("username")
                val regPassword = bundle?.getString("password")

                val username = usernameLogin.text.toString();
                val password = passwordLogin.text.toString();

                if (regUsername.equals(username) && regPassword.equals(password)) {
                    val it = Intent(this, HomeActivity::class.java)
                    startActivity(it)
                } else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

                count--;
            }

        }

    }
}