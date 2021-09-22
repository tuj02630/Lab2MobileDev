package edu.temple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    lateinit var namew: EditText
    lateinit var emailw: EditText
    lateinit var passwordw: EditText
    lateinit var passwordcw: EditText
    lateinit var signupw: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        namew = findViewById(R.id.id_name)
        emailw = findViewById(R.id.id_email)
        passwordw = findViewById(R.id.id_password)
        passwordcw = findViewById(R.id.id_cpassword)
        signupw = findViewById(R.id.id_signup)
        signupw.setOnClickListener {
            val sname = namew.text.toString();
            val semail = emailw.text.toString();
            val spassword = passwordw.text.toString();
            val spasswordc = passwordcw.text.toString();

            if(sname != "" && semail != "" && spassword != "" && spasswordc != "")
            {
                if(spassword == spasswordc)//success
                {
                    val ttext = "Welcome, $sname!";
                    val tduration = Toast.LENGTH_SHORT;
                    val toastw = Toast.makeText(applicationContext, ttext, tduration)
                    toastw.show();
                }
                else//user needs to make passwords match
                {
                    passwordw.error = "Passwords don't match";
                    passwordcw.error = "Passwords don't match";
                }
            }
            else//user needs to fill in the fields
            {
                if(sname == "")
                {
                    namew.error = "Field cannot be blank"
                }
                if(semail == "")
                {
                    emailw.error = "Field cannot be blank"
                }
                if(spassword == "")
                {
                    passwordw.error = "Field cannot be blank"
                }
                if(spasswordc == "")
                {
                    passwordcw.error = "Field cannot be blank"
                }
            }
        }

    }
}