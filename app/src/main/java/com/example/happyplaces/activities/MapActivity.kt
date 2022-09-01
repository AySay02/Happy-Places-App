package com.example.happyplaces.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happyplaces.R
import com.example.happyplaces.models.HappyPlaceModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mHappyPlaceDetail : HappyPlaceModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        if(intent.hasExtra(MainActivity.EXTRA_PLACE_DETAILS)){  // to get data from prevois activity
            mHappyPlaceDetail = intent.getSerializableExtra(MainActivity.EXTRA_PLACE_DETAILS)
                    as HappyPlaceModel

        }

        if(mHappyPlaceDetail!= null){
            setSupportActionBar(toolbar_map)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = mHappyPlaceDetail!!.title

            toolbar_map.setNavigationOnClickListener{
                onBackPressed()
            }

            val supportMapFragment: SupportMapFragment =    // to use the map frag from layout
                supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            supportMapFragment.getMapAsync(this)
        }
    }

    override fun onMapReady(p0: GoogleMap) {    // to get the loc on the google map
        val position = LatLng(mHappyPlaceDetail!!.latitude,mHappyPlaceDetail!!.longitude)
        p0.addMarker(MarkerOptions().position(position).title(mHappyPlaceDetail!!.location))
        val newLatLngZoom = CameraUpdateFactory.newLatLngZoom(position,10f) // to zoom in on the loc by 15 float val
        p0.animateCamera(newLatLngZoom) // for zoom animation
    }
}