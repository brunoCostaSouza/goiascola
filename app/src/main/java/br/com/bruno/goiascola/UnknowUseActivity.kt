package br.com.bruno.goiascola

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_unknow_use.*

class UnknowUseActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent{
            return Intent(context, UnknowUseActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unknow_use)
        createListeners()
    }

    private fun createListeners(){
        llUnknow1.setOnClickListener { startActivity(ProductsActivity.getInstance(this, ProductsActivity.type_parede)) }
        llUnknow2.setOnClickListener { startActivity(ProductsActivity.getInstance(this, ProductsActivity.type_reboco)) }
    }
}
