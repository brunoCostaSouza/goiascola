package br.com.bruno.goiascola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_view_product.*

class ViewProductActivity : AppCompatActivity() {

    companion object {
        lateinit var TYPE_PRODUCT: ProductsEnum
        lateinit var TYPE_BRICK: TijolosEnum
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)
        TYPE_BRICK = TijolosEnum.TIJOLO_14X09
        setViews()
    }

    private fun setViews(){
        val text1 = intent.extras.getString("TEXT1")
        val text2 = intent.extras.getString("TEXT2")
        val img = intent.extras.getInt("IMG")
        val type = intent.extras.getString("TYPE")
        TYPE_PRODUCT = ProductsEnum.valueOf(type)

        when(TYPE_PRODUCT){
            ProductsEnum.ARGAMASSA_POLIMERICA_BARRICA_50KG,
                ProductsEnum.ARGAMASSA_POLIMERICA_SACO_15KG,
                ProductsEnum.ARGAMASSA_POLIMERICA_BISNAGA_3KG -> {
                spnTipoTijolo.visibility = View.VISIBLE
            }
        }

        textProduct1.text = text1
        textProduct.text = text2
        imgProduct.setImageResource(img)

        btnCalcular.setOnClickListener {
            if(editMQ.text.toString().isNotEmpty()){
                val result = ResultFactory.getInstanceFactory(TYPE_PRODUCT, TYPE_BRICK).calcular(editMQ.text.toString().toDouble())
                textResult.text = result[1]
                if(result.size > 1) {
                    textObs.text = result[2]
                } else {
                    textObs.text = ""
                }
            }
        }

        spnTipoTijolo.onItemSelectedListener = listener
    }

    object listener : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
            TYPE_BRICK = when(pos){
                0 -> {TijolosEnum.TIJOLO_14X09}
                1 -> {TijolosEnum.TIJOLO_19X09}
                2 -> {TijolosEnum.TIJOLO_DEITADO}
                3 -> {TijolosEnum.BLOCO_CONCRETO_19X09}
                else -> {TijolosEnum.TIJOLO_14X09}
            }
        }

        override fun onNothingSelected(parent: AdapterView<out Adapter>?) {

        }

    }
}
