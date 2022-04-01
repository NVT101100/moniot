package com.example.moniot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.moniot.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class thongtin : AppCompatActivity() {
    private var data2 = Firebase.database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thongtin)



        data2.child("thongtinnhietdo").addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                findViewById<TextView>(R.id.nhietdo).text = snapshot.value.toString()
            }
        })
        data2.child("thongtindoam").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                findViewById<TextView>(R.id.doam).text="Độ ẩm hiện tại: "+snapshot.value.toString()
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        data2.child("thongtinbaomua").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var baomuanhe :String =snapshot.value.toString()
                if(baomuanhe=="1"){
                    findViewById<TextView>(R.id.baomua).text="Hôm qua  trời có mưa"
                }
                if(baomuanhe=="0"){
                    findViewById<TextView>(R.id.baomua).text="Hôm qua  trời không  có mưa"
                }
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        data2.child("thongtinmucnuoc").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                findViewById<TextView>(R.id.mucnuoc).text="Mực nước hiện tài là: "+ snapshot.value.toString()
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}