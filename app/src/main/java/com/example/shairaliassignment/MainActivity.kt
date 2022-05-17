package com.example.shairaliassignment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth?=null
    val email = findViewById<View>(R.id.email) as EditText
    val password = findViewById<View>(R.id.password) as EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val email = findViewById<View>(R.id.email) as EditText
        val password = findViewById<View>(R.id.password) as EditText
        val mButton = findViewById<View>(R.id.button2) as Button
        //handle onClick
        mButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }




            //Initialize Firebase Auth
            mAuth=FirebaseAuth.getInstance()
        }

        public override fun onStart() {
            super.onStart()

            //if user logged in, go to sign in screen
            if(mAuth!!.currentUser!=null){
                startActivity(Intent(this,welcome::class.java))
                finish()
            }
        }

        override fun onResume() {
            super.onResume()

        }

        fun loginButtonClicked(view: View){
            if(TextUtils.isEmpty(email.text.toString())){
                Toast.makeText(applicationContext,"Enter Username!", Toast.LENGTH_LONG).show()
                return
            }
            if(TextUtils.isEmpty(password.text.toString())){
                Toast.makeText(applicationContext,"Enter password!", Toast.LENGTH_LONG).show()
                return
            }

            //Authenticate user
            mAuth!!.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
                .addOnCompleteListener(this){task ->


                    if(task.isSuccessful){
                        val intent=Intent(this,welcome::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        if(password.text.toString().length<6){
                            password.error="Password is too short, enter minimum 6 characters"
                        }
                        Toast.makeText(this,"Authentication Failed"+task.exception,Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

