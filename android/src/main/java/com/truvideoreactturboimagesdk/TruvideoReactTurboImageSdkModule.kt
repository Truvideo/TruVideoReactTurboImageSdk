package com.truvideoreactturboimagesdk

import android.content.Intent
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import java.io.File

@ReactModule(name = TruvideoReactTurboImageSdkModule.NAME)
class TruvideoReactTurboImageSdkModule(reactContext: ReactApplicationContext) :
  NativeTruvideoReactTurboImageSdkSpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  override fun multiply(a: Double, b: Double): Double {
    return a * b
  }

  override fun launchImageEdit(inputPath: String?, outputPath: String?, promise: Promise?) {
    mainPromise = promise
    currentActivity!!.startActivity(Intent(reactApplicationContext, ImageActivity::class.java).putExtra("inputPath",inputPath).putExtra("outputPath",outputPath))
  }

  override fun getFilePath(fileName: String?, promise: Promise?) {
    // get result path with dynamic name
    val basePath  = reactApplicationContext.filesDir
    promise?.resolve( File("$basePath/camera/$fileName").path)
  }


  companion object {
    var mainPromise: Promise? = null
    const val NAME = "TruvideoReactTurboImageSdk"
  }
}
