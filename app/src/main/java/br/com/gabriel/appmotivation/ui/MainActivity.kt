package br.com.gabriel.appmotivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import br.com.gabriel.appmotivation.utils.MotivationConstants
import br.com.gabriel.appmotivation.R
import br.com.gabriel.appmotivation.utils.SecurityPreferences
import br.com.gabriel.appmotivation.databinding.ActivityMainBinding
import br.com.gabriel.appmotivation.utils.Mock

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding:ActivityMainBinding;
    private var categoryId = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.root)

        //esconder a barra de navegacao
        supportActionBar?.hide();

        //eventos
        binding.buttonNewQuote.setOnClickListener(this);
        binding.imageInfinite.setOnClickListener(this);
        binding.imageLight.setOnClickListener(this);
        binding.imageSmile.setOnClickListener(this);

        //pegar a variavel de SharedPreferences pela key
        val name = SecurityPreferences(this).getString(MotivationConstants.username);

        //Setando o valor do id com o valor da variavel
        binding.textUser.text = "Olá, $name";


    }

    override fun onClick(view: View) {

        var mock:Mock = Mock();

        if(view.id == R.id.button_new_quote){
            binding.textMotivation.text = mock.getQuote(categoryId);
        }
        else if(view.id in listOf(R.id.image_infinite,R.id.image_light,R.id.image_smile)){
            handleFilter(view.id);
        }

    }

    private fun handleFilter(id:Int){

        binding.imageInfinite.setColorFilter(ContextCompat.getColor(this,R.color.purple_100))
        binding.imageSmile.setColorFilter(ContextCompat.getColor(this,R.color.purple_100))
        binding.imageLight.setColorFilter(ContextCompat.getColor(this,R.color.purple_100))



        if(id == R.id.image_infinite){
            binding.imageInfinite.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstants.KEYS.ALL
        }else if(id == R.id.image_light){
            binding.imageLight.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstants.KEYS.LIGHT

        }else if(id == R.id.image_smile){
            binding.imageSmile.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstants.KEYS.SMILE
        }
    }

}