package com.couples.couplescares.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.couples.couplescares.R
import com.couples.couplescares.controller.utills.AppPreferences
import com.couples.couplescares.controller.utills.Constants
import com.couples.couplescares.controller.utills.PermissionCheckUtil


class Splash_Actvity : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 3000L
    var user_id = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__actvity)
        initView()
    }
    private fun initView() {

        user_id = AppPreferences.init(this).getString(Constants.USER_ID)
        PermissionCheckUtil.create(this@Splash_Actvity, object :
            PermissionCheckUtil.onPermissionCheckCallback {
            override fun onPermissionSuccess() {
                splash()
            }
        })



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionCheckUtil.PERMISSION_REQUEST_CODE) {
            splash()
        }
    }


    private fun splash() {

        Handler().postDelayed(
            {
                if(user_id.isNullOrEmpty())

                {


                    val i = Intent(this, Welcome_Activity::class.java)
                    startActivity(i)
                    finish()
                }
//                else
//                {
//                    val i = Intent(this, MainActivity::class.java)
//                    startActivity(i)
//                    finish()
//                }

            }, SPLASH_TIME_OUT)
    }
}
