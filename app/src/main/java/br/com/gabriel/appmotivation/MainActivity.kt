package br.com.gabriel.appmotivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.gabriel.appmotivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding:ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater);

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    override fun onClick(view: View) {

    }
}