package com.example.activitystudyapp

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivityLog"

    private lateinit var button: MaterialButton
    private lateinit var secActivityBtn: MaterialButton
    private lateinit var secActivityBtnNewTask: MaterialButton
    private lateinit var display: TextView
    private lateinit var user: User

    private var counter = 0

    /** onCreate()
     * vincular dados a uma lista, associação de viewModel, usar findViewById(), etc.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"onCreate() called <----------------------------")

        button = findViewById(R.id.count_btn)
        display = findViewById(R.id.count_display)
        secActivityBtn = findViewById(R.id.second_activity_btn)
        secActivityBtnNewTask = findViewById(R.id.second_activity_new_task_btn)
        user = User(
            "Nikola Tesla",
            "10/07/1856 - 07/01/1943",
            //Parcelables aceitam dados maiores, porém uma imagem ainda é pesada para usar isso:
            //BitmapFactory.decodeResource( resources, R.drawable.tesla_article)
            //então passamos a referencia apenas
            R.drawable.tesla_article
        )

        button.setOnClickListener {
            counter++
            display.text = counter.toString()
        }

        secActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
                //extras são usados para dados pequenos !
                .putExtra("title", "A came from MainActivity !")
                .putExtra("number",counter)
                //se user não herdasse de Parcelable, não seria possível add ao extra
                .putExtra("user", user)
            startActivity(intent)
        }

        secActivityBtnNewTask.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra("title", "A came from MainActivity !")
                .putExtra("number",counter)
                .addFlags(FLAG_ACTIVITY_NEW_TASK)
                //FLAG_ACTIVITY_SINGLE_TOP não permite activity repetida no topo da pilha
                //FLAG_ACTIVITY_SINGLE_TOP não permite activity repetida no topo da pilha
            startActivity(intent)
        }



    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    override fun onSaveInstanceState(outState: Bundle) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)
        outState.putInt("key_counter",counter)

    }

    // This callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        counter = savedInstanceState.getInt("key_counter",0)
        display.text = counter.toString()
    }

    /** onStart()
     */
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() called <----------------------------")
    }

    /** onResume()
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() called <----------------------------")
    }

    /** onPause()
     */
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() called <----------------------------")
    }

    /** onStop()
     */
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called <----------------------------")
    }

    /** onDestroy()
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called <----------------------------")
    }


}