package br.com.bruno.goiascola

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class WhereAreWeActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, WhereAreWeActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_where_are_we)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val locationGoiasCola = LatLng(-16.625235, -49.290016)
        mMap.addMarker(MarkerOptions().position(locationGoiasCola).title("Goiás Cola"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationGoiasCola))
        mMap.setMinZoomPreference(17F)
        mMap.setOnCameraMoveListener {
            mMap.resetMinMaxZoomPreference()
        }
    }
}
