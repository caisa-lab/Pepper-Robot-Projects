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

class AboutUniversity : RobotActivity(), RobotLifecycleCallbacks {
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
     * the main function that implements the presentation about the university
     */
    private fun runPresentation() {
        setImage(R.drawable.aboutuni1)
        Thread.sleep(200)
        makeSay("Philipps University of Marburg is not only a German university steeped in tradition").run()
        Thread.sleep(200)
        setImage(R.drawable.aboutuni2)
        makeSay("it is also the oldest university in the world that was founded as a Protestant institution in 1527 by Philip the first, Landgrave of Hesse").run()
        Thread.sleep(200)
        setImage(R.drawable.aboutuni3)
        makeSay("It has been a place of research and teaching for nearly five centuries.").run()
        Thread.sleep(200)
        makeSay("Eleven Nobel prize winners who are associated to Philipps University by study or teaching and thirteen Leibniz Prize winners make the university one of the leading research institutes in Hesse.").run()
        Thread.sleep(200)
        setImage(R.drawable.aboutuni4)
        makeSay("The University of Marburg has over 22,000 students. about 15.5 per cent of them are international").run()
        Thread.sleep(100)
        makeSay("and has 7,500 employees. ").run()
        Thread.sleep(200)
        setImage(R.drawable.aboutuni5)
        makeSay("Nowadays almost all scientific disciplines, with the exception of the engineering sciences, are represented at the University ").run()
        Thread.sleep(200)
        makeSay("The different disciplines are assigned to 16 different departments. Each of the them has its own very diverse research focus.").run()
        Thread.sleep(200)
        setImage(R.drawable.aboutuni6)
        makeSay("Already while studying in Marburg, you can deal with current research issues").run()
        Thread.sleep(200)
        setImage(R.drawable.aboutuni7)
        makeSay("work independently on topics and test your knowledge in practice, for example, during an internship, or a semester abroad").run()
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