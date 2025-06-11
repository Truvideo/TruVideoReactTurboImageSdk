package com.truvideoreactturboimagesdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import com.truvideo.sdk.image.ui.edit.activities.edit.TruvideoSdkImageEditContract
import com.truvideo.sdk.image.ui.edit.activities.edit.TruvideoSdkImageEditParams
import com.truvideoreactturboimagesdk.TruvideoReactTurboImageSdkModule.Companion.mainPromise

class ImageActivity :  ComponentActivity(){
  var launcher : ActivityResultLauncher<TruvideoSdkImageEditParams>? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_image)
    val inputPath = intent.getStringExtra("inputPath")
    val outputPath = intent.getStringExtra("outputPath")

    launcher = registerForActivityResult(TruvideoSdkImageEditContract()){ resultPath: String? ->
      mainPromise!!.resolve(resultPath ?: "")
      finish()
    }
    launcher!!.launch(TruvideoSdkImageEditParams(inputPath!!,outputPath!!))
  }
}
