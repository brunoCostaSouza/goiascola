package br.com.bruno.goiascola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_product.*

class ViewProductActivity : AppCompatActivity() {

    companion object {
        lateinit var TYPE_PRODUCT: ProductsEnum
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)

        setViews()
    }

    private fun setViews(){
        val text1 = intent.extras.getString("TEXT1")
        val text2 = intent.extras.getString("TEXT2")
        val img = intent.extras.getInt("IMG")
        val type = intent.extras.getString("TYPE")
        TYPE_PRODUCT = ProductsEnum.valueOf(type)

        textProduct1.text = text1
        textProduct.text = text2
        imgProduct.setImageResource(img)

        btnCalcular.setOnClickListener {
            if(editMQ.text.toString().isNotEmpty()){
                val result = ResultFactory.getInstanceFactory(TYPE_PRODUCT).calcular(editMQ.text.toString().toDouble())
                textResult.text = result[1]
                if(result.size > 1) {
                    textObs.text = result[2]
                } else {
                    textObs.text = ""
                }
            }
        }
    }
}
