package com.example.shairaliassignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main2)

        val semail = findViewById<View>(R.id.semail) as EditText
        val spassword = findViewById<View>(R.id.spassword) as EditText
        val sname = findViewById<View>(R.id.name) as EditText
        val ssap = findViewById<View>(R.id.ssap) as EditText
        val mButton = findViewById<View>(R.id.button23) as Button
        val sButton = findViewById<View>(R.id.signup1) as Button

     sButton.setOnClickListener{
val realname = sname.text.toString();
          val realemail = semail.text.toString();
          val realsap = ssap.text.toString();
          val realpassword = spassword.text.toString();

          if(realname.isEmpty())
              sname.error= "please enter name";
          if(realemail.isEmpty())
              semail.error= "please enter email";
          if(realpassword.isEmpty())
              spassword.error= "please enter password";
          if(realsap.isEmpty())
              ssap.error= "please enter sap";






database = FirebaseDatabase.getInstance().getReference("user")
    val User = User(realname,realpassword,realemail,realsap)
database.setValue(User).addOnSuccessListener {
    Toast.makeText(this,"successfully added",Toast.LENGTH_LONG).show()
}.addOnFailureListener{
    Toast.makeText(this,"Fail to add added", Toast.LENGTH_LONG).show()

}




      }
        //handle onClick

        mButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@MainActivity2, MainActivity::class.java))
        }


    }

}