package br.com.bruno.goiascola

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.fragment_products.view.*

class ProductsActivity : AppCompatActivity() {


    companion object {
        val type_reboco = 1
        val type_parede = 2
        private var type = 0
        fun getInstance(context: Context, type: Int = 0): Intent{
            this.type = type
            return Intent(context, ProductsActivity::class.java)
        }
    }

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        //setSupportActionBar(toolbar)
        starConfigFragments(type)
    }

    fun starConfigFragments(type: Int){
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, type)
        container.adapter = mSectionsPagerAdapter

        when (type) {
            type_parede -> {
                    dot1.setImageResource(R.drawable.dot_circular)
                    dot2.setImageResource(R.drawable.dot_circular_empy)
                    dot3.setImageResource(R.drawable.dot_circular_empy)
                    dot4.visibility = View.GONE
                    dot5.visibility = View.GONE
                    dot6.visibility = View.GONE
                }

            type_reboco -> {
                    dot1.visibility = View.GONE
                    dot2.visibility = View.GONE
                    dot3.visibility = View.GONE
                    dot4.setImageResource(R.drawable.dot_circular)
                    dot5.setImageResource(R.drawable.dot_circular_empy)
                    dot6.setImageResource(R.drawable.dot_circular_empy)
            }
        }

        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                when (type) {
                    type_parede -> when(position+1){
                        1 -> {
                            dot1.setImageResource(R.drawable.dot_circular)
                            dot2.setImageResource(R.drawable.dot_circular_empy)
                            dot3.setImageResource(R.drawable.dot_circular_empy)
                            dot4.visibility = View.GONE
                            dot5.visibility = View.GONE
                            dot6.visibility = View.GONE
                        }
                        2 -> {
                            dot1.setImageResource(R.drawable.dot_circular_empy)
                            dot2.setImageResource(R.drawable.dot_circular)
                            dot3.setImageResource(R.drawable.dot_circular_empy)
                            dot4.visibility = View.GONE
                            dot5.visibility = View.GONE
                            dot6.visibility = View.GONE
                        }
                        3 -> {
                            dot1.setImageResource(R.drawable.dot_circular_empy)
                            dot2.setImageResource(R.drawable.dot_circular_empy)
                            dot3.setImageResource(R.drawable.dot_circular)
                            dot4.visibility = View.GONE
                            dot5.visibility = View.GONE
                            dot6.visibility = View.GONE
                        }
                    }
                    type_reboco -> when(position+1){
                        1 -> {
                            dot1.visibility = View.GONE
                            dot2.visibility = View.GONE
                            dot3.visibility = View.GONE
                            dot4.setImageResource(R.drawable.dot_circular)
                            dot5.setImageResource(R.drawable.dot_circular_empy)
                            dot6.setImageResource(R.drawable.dot_circular_empy)
                        }
                        2 -> {
                            dot1.visibility = View.GONE
                            dot2.visibility = View.GONE
                            dot3.visibility = View.GONE
                            dot4.setImageResource(R.drawable.dot_circular_empy)
                            dot5.setImageResource(R.drawable.dot_circular)
                            dot6.setImageResource(R.drawable.dot_circular_empy)
                        }
                        3 -> {
                            dot1.visibility = View.GONE
                            dot2.visibility = View.GONE
                            dot3.visibility = View.GONE
                            dot4.setImageResource(R.drawable.dot_circular_empy)
                            dot5.setImageResource(R.drawable.dot_circular_empy)
                            dot6.setImageResource(R.drawable.dot_circular)
                        }
                    }
                    else -> when(position+1){
                        1 -> {
                            dot1.setImageResource(R.drawable.dot_circular)
                            dot2.setImageResource(R.drawable.dot_circular_empy)
                            dot3.setImageResource(R.drawable.dot_circular_empy)
                            dot4.setImageResource(R.drawable.dot_circular_empy)
                            dot5.setImageResource(R.drawable.dot_circular_empy)
                            dot6.setImageResource(R.drawable.dot_circular_empy)
                        }
                        2 -> {
                            dot1.setImageResource(R.drawable.dot_circular_empy)
                            dot2.setImageResource(R.drawable.dot_circular)
                            dot3.setImageResource(R.drawable.dot_circular_empy)
                            dot4.setImageResource(R.drawable.dot_circular_empy)
                            dot5.setImageResource(R.drawable.dot_circular_empy)
                            dot6.setImageResource(R.drawable.dot_circular_empy)
                        }
                        3 -> {
                            dot1.setImageResource(R.drawable.dot_circular_empy)
                            dot2.setImageResource(R.drawable.dot_circular_empy)
                            dot3.setImageResource(R.drawable.dot_circular)
                            dot4.setImageResource(R.drawable.dot_circular_empy)
                            dot5.setImageResource(R.drawable.dot_circular_empy)
                            dot6.setImageResource(R.drawable.dot_circular_empy)
                        }
                        4 -> {
                            dot1.setImageResource(R.drawable.dot_circular_empy)
                            dot2.setImageResource(R.drawable.dot_circular_empy)
                            dot3.setImageResource(R.drawable.dot_circular_empy)
                            dot4.setImageResource(R.drawable.dot_circular)
                            dot5.setImageResource(R.drawable.dot_circular_empy)
                            dot6.setImageResource(R.drawable.dot_circular_empy)
                        }
                        5 -> {
                            dot1.setImageResource(R.drawable.dot_circular_empy)
                            dot2.setImageResource(R.drawable.dot_circular_empy)
                            dot3.setImageResource(R.drawable.dot_circular_empy)
                            dot4.setImageResource(R.drawable.dot_circular_empy)
                            dot5.setImageResource(R.drawable.dot_circular)
                            dot6.setImageResource(R.drawable.dot_circular_empy)
                        }
                        6 -> {
                            dot1.setImageResource(R.drawable.dot_circular_empy)
                            dot2.setImageResource(R.drawable.dot_circular_empy)
                            dot3.setImageResource(R.drawable.dot_circular_empy)
                            dot4.setImageResource(R.drawable.dot_circular_empy)
                            dot5.setImageResource(R.drawable.dot_circular_empy)
                            dot6.setImageResource(R.drawable.dot_circular)
                        }
                    }
                }
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_products, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager, val type: Int) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {

            when (type) {
                type_parede -> return when(position+1){

                    1 -> Product1Fragment.newInstance(1)
                    2 -> Product1Fragment.newInstance(2)
                    3 -> Product1Fragment.newInstance(3)
                    else -> {
                        Product1Fragment.newInstance(0)
                    }
                }
                type_reboco -> return when(position+1){
                    1 -> Product1Fragment.newInstance(4)
                    2 -> Product1Fragment.newInstance(5)
                    3 -> Product1Fragment.newInstance(6)
                    else -> {
                        Product1Fragment.newInstance(0)
                    }
                }
                else -> return when(position+1){

                    1 -> Product1Fragment.newInstance(1)
                    2 -> Product1Fragment.newInstance(2)
                    3 -> Product1Fragment.newInstance(3)
                    4 -> Product1Fragment.newInstance(4)
                    5 -> Product1Fragment.newInstance(5)
                    6 -> Product1Fragment.newInstance(6)

                    else -> {
                        Product1Fragment.newInstance(0)
                    }
                }
            }
        }

        override fun getCount(): Int {
            return when (type) {
                type_parede -> 3
                type_reboco -> 3
                else -> 6
            }
        }
    }

}
