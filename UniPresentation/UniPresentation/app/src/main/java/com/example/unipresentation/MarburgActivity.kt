package com.example.unipresentation

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.`object`.conversation.Say
import com.aldebaran.qi.sdk.builder.SayBuilder
import com.aldebaran.qi.sdk.design.activity.RobotActivity
import com.aldebaran.qi.sdk.design.activity.conversationstatus.SpeechBarDisplayStrategy
import kotlinx.android.synthetic.main.activity_presentation.*


class MarburgActivity : RobotActivity(), RobotLifecycleCallbacks {
    private lateinit var qiContext: QiContext

    /**
     * Adds main activity layout and button implementation
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(ContentValues.TAG, "onCreate")
        QiSDK.register(this, this)
        setSpeechBarDisplayStrategy(SpeechBarDisplayStrategy.OVERLAY)
        setContentView(R.layout.activity_presentation)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    /**
     * Implementation by Pepper
     */
    override fun onRobotFocusGained(qiContext: QiContext) {
        this.qiContext = qiContext
        Log.i(ContentValues.TAG, "Robot focus gained, running.")
        runPresentation()
    }

    /**
     * the main function that implements the presentation about marburg
     */
    private fun runPresentation() {
        setImage(R.drawable.marburg1)
        Thread.sleep(200)
        makeSay("Marburg itself is the beautiful medieval town, along the German fairytale route, in the state of Hesse.").run()
        Thread.sleep(200)
        setImage(R.drawable.marburg2)
        makeSay("Here, the tradition and history of your surroundings will enchant and inspire you, and our friendly small-city spirit will make you feel at home, as soon as you’ve arrived.").run()
        Thread.sleep(200)
        setImage(R.drawable.marburg3)
        makeSay("Marburg is known for its narrow streets, and steep stairs.").run()
        Thread.sleep(200)
        makeSay("The Market Square is the starting point for numerous events, and popular attractions. The city is also famous, for its typical Hessian half-timbered houses, landgrave castle, venerable churches and wonderful views. ").run()
        Thread.sleep(200)
        setImage(R.drawable.marburg4)
        makeSay("Marburg also has a lively pub and cultural scene, as well as several sociocultural centers, with a wide range of concerts.").run()
        Thread.sleep(200)
        setImage(R.drawable.marburg5)
        makeSay("In, and around Marburg, you are very quickly in the countryside, you can relax best on the grasslands near the lahn, or in the old botanical garden right next to the new university library.").run()
        Thread.sleep(200)
        setImage(R.drawable.marburg6)
        makeSay("Whether you come to us as a student, a doctoral candidate, researcher, or as an exchange teacher or administrator, great opportunities await you in Marburg.").run()
        Thread.sleep(200)
        setImage(R.drawable.marburg7)
        makeSay("You’ll be walking in the footsteps of great minds like: Emil von Behring, the world’s first Nobel Prize winner; world-renowned chemist Robert Bunsen; and the Grimm brothers, whose stories have travelled from Hessen to the furthest corners of the globe. ").run()
        Thread.sleep(2000)
        startActivity(Intent(this, MainActivity::class.java))
    }

    // helpers
    /**
     * makeSay -> text-to-speech by Pepper
     */
    private fun makeSay(text : String) : Say {
        return SayBuilder.with(qiContext)
            .withText(text)
            .build()
    }

    /**
     * Displaying an Image on the Pepper Display
     */
    private fun setImage(resource : Int) {
        runOnUiThread {
            splashImageView.setImageResource(resource)
            splashImageView.visibility = View.VISIBLE
        }
    }

    /**
     * Clearing the screen from the image
     */
    private fun clearImage() {
        runOnUiThread {
            splashImageView.visibility = View.GONE
        }
    }

    // Class functions of Pepper
    override fun onDestroy() {
        super.onDestroy()
        QiSDK.unregister(this, this)
    }

    override fun onRobotFocusLost() {
        Log.i(ContentValues.TAG, "Focus lost")
    }

    override fun onRobotFocusRefused(reason: String?) {
        Log.i(ContentValues.TAG, "Focus refused because $reason")
    }

}