package com.truvideoreactturboimagesdk

import android.content.Intent
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.google.gson.Gson
import com.truvideo.sdk.image.TruvideoSdkImage
import com.truvideo.sdk.image.interfaces.TruvideoSdkImageCallback
import com.truvideo.sdk.image.model.TruvideoSdkImageCropInformation
import com.truvideo.sdk.image.model.TruvideoSdkImageInformation
import com.truvideo.sdk.image.model.TruvideoSdkImageOutputFormat
import com.truvideo.sdk.image.model.TruvideoSdkImageRotation
import kotlinx.serialization.json.JsonObject
import org.json.JSONObject
import truvideo.sdk.common.exceptions.TruvideoSdkException
import java.io.File

@ReactModule(name = TruvideoReactTurboImageSdkModule.NAME)
class TruvideoReactTurboImageSdkModule(reactContext: ReactApplicationContext) :
  NativeTruvideoReactTurboImageSdkSpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

  override fun launchImageEdit(inputPath: String?, outputPath: String?, promise: Promise?) {
    mainPromise = promise
    currentActivity!!.startActivity(Intent(currentActivity, ImageActivity::class.java).putExtra("inputPath",inputPath).putExtra("outputPath",outputPath))
  }

  override fun getFilePath(fileName: String?, promise: Promise?) {
    // get result path with dynamic name
    val basePath  = currentActivity!!.filesDir
    promise?.resolve( File("$basePath/camera/$fileName").path)
  }

  override fun edit(imagePath: String?,
                    resultPath: String?,
                    rotation: String?,
                    cropInformation: String?,
                    horizontalFlip: Boolean,
                    verticalFlip: Boolean,
                    width: Double,
                    height: Double,
                    outputFormat: String?,
                    compressionQuality: Double,
                    promise: Promise?){
    val mainRotation = if(rotation == null) null else TruvideoSdkImageRotation.valueOf(rotation)
    val jsonObject = JSONObject(cropInformation)
    val mainCrop = TruvideoSdkImageCropInformation(jsonObject.getString("left").toFloat(),
      jsonObject.getString("top").toFloat(),
        jsonObject.getString("width").toFloat(),
        jsonObject.getString("height").toFloat())
    val mainOutputFormat = if(outputFormat == "JPG") TruvideoSdkImageOutputFormat.JPG else TruvideoSdkImageOutputFormat.PNG

    TruvideoSdkImage.edit(imagePath!!,resultPath!!,mainRotation,mainCrop,horizontalFlip,verticalFlip,width.toInt(),height.toInt(),mainOutputFormat,compressionQuality.toInt(),object : TruvideoSdkImageCallback<String>{
      override fun onError(exception: TruvideoSdkException) {
        promise!!.reject(exception)
      }

      override fun onComplete(result: String) {
        promise!!.resolve(result)
      }
    })
  }

  fun editBitmap (){
    //TruvideoSdkImage.editBitmap()
  }
  override fun getInfo(imagePath : String, promise: Promise){
    TruvideoSdkImage.getInfo(imagePath,object : TruvideoSdkImageCallback<TruvideoSdkImageInformation>{
      override fun onComplete(result: TruvideoSdkImageInformation) {
        promise.resolve(result)
      }
      override fun onError(exception: TruvideoSdkException) {
        promise.reject(exception)
      }
    })
  }


  companion object {
    var mainPromise: Promise? = null
    const val NAME = "TruvideoReactTurboImageSdk"
  }
}
