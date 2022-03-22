package com.internshal.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtRegister: TextView
    val ValidMobileNumber = "0123456789"
    val ValidPassword = arrayOf("tony","steve","bruce","thanos")
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        if(isLoggedIn){

            val intent = Intent(this@LoginActivity, AvengerActivity::class.java)
            startActivity(intent)


        }else {

            setContentView(R.layout.activity_login)
        }
        title="Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgetPassword = findViewById(R.id.txtForgetPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener{
            val mobileNumber = etMobileNumber.text.toString()

            val password = etPassword.text.toString()

            var nameofAvenger = "Avenger"
            val intent = Intent(this@LoginActivity, AvengerActivity::class.java)

            if(mobileNumber == ValidMobileNumber) {

                if(password == ValidPassword[0]){

                    savePreferences()
                    nameofAvenger = "Iron Man"
                    intent.putExtra("Name",nameofAvenger)
                    startActivity(intent)

                } else if (password == ValidPassword[1]){

                    savePreferences()
                    nameofAvenger="Captain America"
                    intent.putExtra("Name",nameofAvenger)
                    startActivity(intent)

                } else if (password == ValidPassword[2]){

                    savePreferences()
                    nameofAvenger="The Hulk"
                    intent.putExtra("Name",nameofAvenger)
                    startActivity(intent)

                } else if(password == ValidPassword[3]) {

                    savePreferences()
                    nameofAvenger = "The Avengers"
                    intent.putExtra("Name",nameofAvenger)
                    startActivity(intent)

                }

            }

            else{

                Toast.makeText(this@LoginActivity,"Incorrect Credential",Toast.LENGTH_LONG).show()
            }
        }

        }
    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }

    }





