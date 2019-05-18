package org.firespeed.cameraxtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.pm.PackageManager
import android.util.Size
import android.graphics.Matrix
import android.view.TextureView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.TimeUnit

private const val REQUEST_CODE_PERMISSION = 10
private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)

class MainActivity : AppCompatActivity(), LifecycleOwner {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private lateinit var viewFinder: TextureView

    private fun startCamera(){

    }

    private fun updateTransform(){

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == REQUEST_CODE_PERMISSION){
            if(allPermissionsGranted()){
                viewFinder.post{ startCamera()}
            }else{
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show()
                finish()
            }

        }
    }

    private fun allPermissionsGranted():Boolean{
        return REQUIRED_PERMISSIONS.all{
            ContextCompat.checkSelfPermission(this,it) == PackageManager.PERMISSION_GRANTED
        }
    }
}




