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


class InfrastructureActivity : RobotActivity(), RobotLifecycleCallbacks {
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
     * the main function that implements the presentation about the infrastructure
     */
    private fun runPresentation() {
        setImage(R.drawable.infrastructure1)
        Thread.sleep(200)
        makeSay("There is no university in Marburg; Marburg itself is a university.").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure2)
        makeSay("This is noticed by everyone who comes to the city, as over 120 university buildings spread throughout the city").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure3)
        makeSay("In a city of about 76,000 people, about a third are students, which means that in everyday life you often meet fellow students and can quickly make contacts. ").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure4)
        makeSay("For students or employees prepared daycare centre for 70 babies and toddlers, hostel with room for 78 physically disabled students").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure5)
        makeSay("and also two canteens and 13 cafeterias, and of course rooms for up to 2200 students").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure6)
        makeSay("One of the popular places among students is the library, that was founded in 1527").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure7)
        makeSay("nowadays it includes stacks, lending desk, textbook collection, media center and over 140 PC workstations, a total of around 1250 reading places and in total, the university libraries inventory comprises around 4.2 million volumes.").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure8)
        makeSay("Library is supplemented by departmental libraries, which are spread over several locations throughout the city, including the Lahnberge.").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure9)
        makeSay("Sports at the university are also very developed. University Sports Center offers more than 60 kind of sport activities in wide range of categories").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure10)
        makeSay("In addition to 130 sports offers at the university sports center, an orchestra, the student big band and the university choir").run()
        Thread.sleep(200)
        setImage(R.drawable.infrastructure11)
        makeSay("you will find numerous student initiatives in which you can get involved.").run()
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
/*
private fun makeAnimate(animResource: Int) : Animate {
        val animation = AnimationBuilder.with(qiContext)
            .withResources(animResource)
            .build()

        return AnimateBuilder.with(qiContext)
            .withAnimation(animation)
            .build()
    }
        val sayMore = makeSay("Let me show you ! ...")
        val animFuture = makeAnimate(R.raw.yeah_b001).async().run()
        animFuture.thenConsume {
            setImage(R.drawable.scene4)
        }
        Future.waitAll(sayMore.async().run(),
            animFuture).value


        // Part 2: "Let me show you..."

        Thread.sleep(800)
        setImage(R.drawable.scene3)
        val sayMore = makeSay("But there's much more to do. Let me show you ! ...")
        val animFuture = makeAnimate(R.raw.dance_b001).async().run()
        animFuture.thenConsume {
            setImage(R.drawable.scene4)
        }
        Future.waitAll(sayMore.async().run(),
            animFuture).value

        // Part 3: "I can make sound"
        playMedia(R.raw.stone_breaks)
        setImage(R.drawable.scene5)
        makeSay("Like me, a rock can make sound.").run()
        setImage(R.drawable.scene6)
        Thread.sleep(1_000)
        setImage(R.drawable.scene7)
        makeSay("and light.").run()
        Thread.sleep(1_000)
        setImage(R.drawable.scene8)

        // Part 4: "And become beautiful"
        Timer("Diamond", false).schedule(2_000) {
            setImage(R.drawable.scene9)
            playMedia(R.raw.magic)
        }
        val sayBeautiful = makeSay("and become beautiful and precious! All this thanks to you")
        val animateYeah = makeAnimate(R.raw.dog_a001)
        Future.waitAll(sayBeautiful.async().run(), animateYeah.async().run()).value
        setImage(R.drawable.scene10)
        makeSay("I can't wait for what we are gonna do !").run()


 */

