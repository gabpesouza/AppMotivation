package br.com.gabriel.appmotivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.gabriel.appmotivation.utils.MotivationConstants
import br.com.gabriel.appmotivation.R
import br.com.gabriel.appmotivation.utils.SecurityPreferences
import br.com.gabriel.appmotivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater);

        setContentView(binding.root)

        supportActionBar?.hide();

        verifyUserName();

        binding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {

            handleSave();

        }
    }

    private fun handleSave() {


        val name: String = binding.textUserName.text.toString();
        if (name != "") {
            val security: SecurityPreferences = SecurityPreferences(this);
            security.storeString(MotivationConstants.username, name);
            startActivity(Intent(this, MainActivity::class.java));
            finish();

        } else {
            Toast.makeText(this, "Insira um nome por favor", Toast.LENGTH_SHORT).show()
        }

    }

    private fun verifyUserName() {

        val name = SecurityPreferences(this).getString(MotivationConstants.username);
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java));
            finish();
        }

    }

}