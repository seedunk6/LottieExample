package com.android.lottieexample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.android.lottieexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pressStar = false
        binding.ivStar.setOnClickListener {
            pressStar = animationLottieStar(binding.ivStar, R.raw.lottiefile, pressStar)
        }

       var pressEmoticon = false
        binding.ivEmoticon.setOnClickListener {
            pressEmoticon = animationLottieEmoticon(binding.ivEmoticon, R.raw.animation2, pressEmoticon)
        }
    }

    fun animationLottieStar(ivStar:LottieAnimationView, animation:Int, pressStar:Boolean):Boolean {

        if(!pressStar){
            ivStar.setAnimation(animation)
            ivStar.playAnimation()
        }else{
            ivStar.setImageResource(R.drawable.ic_star)
            ivStar.alpha = 1F
        }
        return !pressStar
    }

    fun animationLottieEmoticon(ivEmoticon:LottieAnimationView, animation:Int, pressEmoticon:Boolean):Boolean {

        if(!pressEmoticon){
            ivEmoticon.setAnimation(animation)
            ivEmoticon.playAnimation()
        }else{
            ivEmoticon.animate()
                .alpha(0F)
                .setDuration(200)
                .setListener(object: AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        ivEmoticon.setImageResource(R.drawable.ic_emoticon)
                        ivEmoticon.alpha = 1F
                    }
                })
        }
        return !pressEmoticon
    }
}