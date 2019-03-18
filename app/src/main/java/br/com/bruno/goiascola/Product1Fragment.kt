package br.com.bruno.goiascola

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_products.view.*

class Product1Fragment : Fragment() {

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): Product1Fragment {
            val fragment = Product1Fragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val section = arguments!!.get(ARG_SECTION_NUMBER) as Int
        val rootView = inflater.inflate(R.layout.fragment_products, container, false)
        activity?.window?.statusBarColor = Color.BLACK

        when (section) {
            1 -> {
                rootView.descriptionProduct.text = "BARRICA DE 50 KG"
                rootView.section_label.text = "Argamassa Polimérica"
                rootView.imageProduct.setImageResource(R.drawable.barrica50kg)
                rootView.llButton.setOnClickListener {
                    startViewProduct(
                            rootView.section_label.text.toString(),
                            rootView.descriptionProduct.text.toString(),
                            R.drawable.barrica50kg,
                            ProductsEnum.ARGAMASSA_POLIMERICA_BARRICA_50KG)
                }
            }
            2 -> {
                rootView.descriptionProduct.text = "SACO VALVULADO DE 15 KG"
                rootView.section_label.text = "Argamassa Polimérica"
                rootView.imageProduct.setImageResource(R.drawable.sacovalvulado)
                rootView.llButton.setOnClickListener {
                    startViewProduct(
                            rootView.section_label.text.toString(),
                            rootView.descriptionProduct.text.toString(),
                            R.drawable.sacovalvulado,
                            ProductsEnum.ARGAMASSA_POLIMERICA_SACO_15KG)
                }
            }
            3 -> {
                rootView.descriptionProduct.text = "BISNAGA DE 3,5 KG"
                rootView.section_label.text = "Argamassa Polimérica"
                rootView.imageProduct.setImageResource(R.drawable.bisnaga)
                rootView.llButton.setOnClickListener {
                    startViewProduct(
                            rootView.section_label.text.toString(),
                            rootView.descriptionProduct.text.toString(),
                            R.drawable.bisnaga,
                            ProductsEnum.ARGAMASSA_POLIMERICA_BISNAGA_3KG)
                }
            }
            4 -> {
                rootView.descriptionProduct.text = "BALDE DE 30 KG"
                rootView.section_label.text = "Reboco Plus Pronto"
                rootView.imageProduct.setImageResource(R.drawable.reboco)
                rootView.llButton.setOnClickListener {
                    startViewProduct(
                            rootView.section_label.text.toString(),
                            rootView.descriptionProduct.text.toString(),
                            R.drawable.reboco,
                            ProductsEnum.REBOCO_PLUS_BALDE_30_KG)
                }
            }
            5 -> {
                rootView.descriptionProduct.text = "BARRICA DE 50 KG"
                rootView.section_label.text = "Reboco Plus Pronto"
                rootView.imageProduct.setImageResource(R.drawable.reboco)
                rootView.llButton.setOnClickListener {
                    startViewProduct(
                        rootView.section_label.text.toString(),
                        rootView.descriptionProduct.text.toString(),
                        R.drawable.reboco,
                        ProductsEnum.REBOCO_PLUS_BARRICA_50_KG)
                }
            }
            6 -> {
                rootView.descriptionProduct.text = "BARRICA DE 50 KG"
                rootView.section_label.text = "Chapisco Rolado"
                rootView.imageProduct.setImageResource(R.drawable.chapiscoprod)
                rootView.llButton.setOnClickListener {
                    startViewProduct(
                            rootView.section_label.text.toString(),
                            rootView.descriptionProduct.text.toString(),
                            R.drawable.chapiscoprod,
                            ProductsEnum.CHAPISCO_ROLADO_BARRICA_40KG)
                }
            }
        }

        return rootView
    }

    private fun startViewProduct(text1: String, text2: String, idImg: Int, typeProduct: ProductsEnum) {
        var intent = Intent(activity!!.applicationContext, ViewProductActivity::class.java)
        intent.putExtra("TEXT1", text1)
        intent.putExtra("TEXT2", text2)
        intent.putExtra("IMG", idImg)
        intent.putExtra("TYPE", typeProduct.name)
        startActivity(intent)
    }

}