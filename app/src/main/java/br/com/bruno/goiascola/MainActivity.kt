package br.com.bruno.goiascola

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        createListeners()
    }

    private fun createListeners(){
        ll3.setOnClickListener { startActivity(UnknowUseActivity.getInstance(applicationContext)) }
        ll2.setOnClickListener { startActivity(ProductsActivity.getInstance(applicationContext)) }
        imgFacebook.setOnClickListener {startIntent("https://www.facebook.com/goias.cola/")}
        imgInstagram.setOnClickListener { startIntent("https://www.instagram.com/goiascolaoficial/") }
        imgYoutube.setOnClickListener { startIntent("https://www.youtube.com/channel/UCbZpTfqrWCkftdvs4ibRzkw") }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_comparativo -> {
                startActivity(Intent(this, ComparativeActivity::class.java))
            }

            R.id.nav_nossa_empresa -> {
                startActivity(Intent(this, OurCompanyActivity::class.java))
            }
            R.id.nav_nosso_site -> {
                startIntent("http://www.goiascola.com.br/")
            }
            R.id.nav_onde_estamos -> {
                //startActivity(WhereAreWeActivity.getInstance(this))
                startIntent("https://www.google.com/maps/place/Goi%C3%A1s+Cola+-+Argamassa+Polim%C3%A9rica/@-16.6264538,-49.2915189,16.44z/data=!4m5!3m4!1s0x935ef498a4d26187:0xd2e71d8a87d1996e!8m2!3d-16.6251132!4d-49.2898939")
            }
            R.id.nav_contact -> {
                var intent = Intent(Intent.ACTION_VIEW)
                val phone = "6299579433"
                val mensagem = "Olá, Gostaria de conhecer os produtos da Goias Cola."
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=55$phone&text=$mensagem")
                intent.setPackage("com.whatsapp")
                startActivity(intent)

                /*
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val text = " message you want to share.."
                // change with required  application package

                intent.setPackage("com.whatsapp")
                if (intent != null) {
                    intent.putExtra(Intent.EXTRA_TEXT, text)
                    startActivity(Intent.createChooser(intent, text))
                } else {

                    Toast.makeText(this, "Whatsapp não está instalado", Toast.LENGTH_SHORT).show()
                }
                */
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun startIntent(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
