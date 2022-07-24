package com.example.activitystudyapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.activitystudyapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var title: TextView
    private lateinit var teslaName: TextView
    private lateinit var teslaBirth: TextView
    private lateinit var teslaImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        title = findViewById(R.id.title)
        teslaName = findViewById(R.id.teslas_name)
        teslaBirth = findViewById(R.id.teslas_birth_death)
        teslaImg = findViewById(R.id.dear_tesla)


        val extra = intent.extras
        val titleExtra = extra?.getString("title")
        val numberExtra = extra?.getInt("number")
        title.text = "$titleExtra ${numberExtra.toString()}"

        val parcelable = extra?.getParcelable<User>("user")
        teslaName.text = parcelable?.name
        teslaBirth.text = parcelable?.birthDeath
        parcelable?.photo?.let { teslaImg.setImageResource(it) }



    }

}