package miinjung.study.toy_naver_map

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.naver.maps.map.LocationSource
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback

class MainActivity : FragmentActivity(),OnMapReadyCallback{
    private lateinit var locationSource : LocationSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeMap()
    }

    private fun makeMap(){
        val mapFragment = MapFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.map,mapFragment).commit()
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {
//        TODO("Not yet implemented")
    }

    private fun getPermission() : Boolean{
        if(ContextCompat.checkSelfPermission(applicationContext,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),0)
        }

    }
//    private fun getLocation() : Location? {
//        val locationProvider = LocationManager.GPS_PROVIDER
//        val locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//        return if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return null
//        }else
//            locationManager.getLastKnownLocation(locationProvider)
//    }


}