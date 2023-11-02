package com.example.homework4_leacture7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework4_leacture7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var person:Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backBtn.setOnClickListener{
            Toast.makeText(this, "Why are iu rannin", Toast.LENGTH_SHORT).show();

        }

        binding.nextBtn.setOnClickListener{
            if(validateInfo()){
                person = Person(binding.edtxt1.text.toString(),binding.edtxt2.text.toString())
                pingGoogleServer(person)
            }else{
                Toast.makeText(this, "Fill all fields!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private fun validateInfo():Boolean{
        return ((binding.edtxt1.text.toString().length != 0) && (binding.edtxt2.text.toString().length != 0))
    }

    private fun pingGoogleServer(person:Person){
        val ip = "8.8.8.8"
        Toast.makeText(this, "${person.fullName} sent to google on $ip waiting response...", Toast.LENGTH_LONG).show();
    }
}