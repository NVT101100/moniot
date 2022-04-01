package com.example.moniot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.Observer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class dieukhien : AppCompatActivity() {
    private var database = Firebase.database("https://iot-server-62a96-default-rtdb.asia-southeast1.firebasedatabase.app").reference
    private lateinit var model : TuoiNuocModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dieukhien)
        model = TuoiNuocModel()

        database.child("tuoinuoctang1").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                model.receiveT1(snapshot.value.toString())
            }
        })
        database.child("tuoinuoctang2").addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                model.receiveT2(snapshot.value.toString())
            }
        })
        database.child("tuoinuoctang3").addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                model.receiveT3(snapshot.value.toString())
            }
        })
        database.child("tuoinuoccac").addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                model.receiveAll(snapshot.value.toString())
            }
        })

        model.t1.observe(this, Observer {
            if(it == "1") {
                findViewById<Switch>(R.id.tuoinuoctang1).isChecked = true
            }
            else if(it == "0") findViewById<Switch>(R.id.tuoinuoctang1).isChecked = false
        })
        model.t2.observe(this, Observer {
            if(it == "1") {
                findViewById<Switch>(R.id.tuoinuoctang2).isChecked = true
            }
            else if(it == "0") findViewById<Switch>(R.id.tuoinuoctang2).isChecked = false
        })
        model.t3.observe(this, Observer {
            if(it == "1") {
                findViewById<Switch>(R.id.tuoinuoctang3).isChecked = true
            }
            else if(it == "0") findViewById<Switch>(R.id.tuoinuoctang3).isChecked = false
        })
        model.all.observe(this, Observer {
            if(it == "1") {
                findViewById<Switch>(R.id.tuoinuoccactang).isChecked = true
            }
            else if(it == "0") findViewById<Switch>(R.id.tuoinuoccactang).isChecked = false
        })

        findViewById<Switch>(R.id.tuoinuoctang1).setOnCheckedChangeListener { compoundButton, b ->
            database.child("tuoinuoctang1").setValue(if(b) 1 else 0)
        }
        findViewById<Switch>(R.id.tuoinuoctang2).setOnCheckedChangeListener { compoundButton, b ->
            database.child("tuoinuoctang2").setValue(if(b) 1 else 0)
        }
        findViewById<Switch>(R.id.tuoinuoctang3).setOnCheckedChangeListener { compoundButton, b ->
            database.child("tuoinuoctang3").setValue(if(b) 1 else 0)
        }
        findViewById<Switch>(R.id.tuoinuoccactang).setOnCheckedChangeListener { compoundButton, b ->
            database.child("tuoinuoccactang").setValue(if(b) 1 else 0)
        }
    }
}