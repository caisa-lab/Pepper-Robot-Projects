package com.example.nlpquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedPosition : Int = 0
    private var mCorrectAnswer : Int = 0

    /**
     * onCreate is used for:
     * add the activity_quiz_questions
     * write an implementation for the button btn_submit
     * add three options
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")

    /**
     * setQuestion takes a question from the list and display it with three different answer options.
     */
    private fun setQuestion(){

        val question = mQuestionsList!!.get(mCurrentPosition-1)

        defaultOptionsView()
        if(mCurrentPosition==mQuestionsList!!.size){
            btn_submit.text = "Finish"
        } else {
            btn_submit.text = "Submit"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
    }

    /**
     * defaultOptionsView is responsible for displaying answer options on the screen by default
     */
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1, tv_option_two)
        options.add(2,tv_option_three)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    /**
     * The main function that is responsible for the correct operation of the program
     * and the appropriate response to the selected option
     */
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three,3)
            }
            R.id.btn_submit -> {
                if(mSelectedPosition == 0){
                    mCurrentPosition += 1 // Go to the next Question

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        } else ->{
                        val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedPosition){
                        answerView(mSelectedPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer += 1
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestionsList!!.size){
                        btn_submit.text = "Finish"
                    }else{
                        btn_submit.text = "Next question"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    /**
     * answerView defines the view of answers (correct or wrong)
     */
    private fun answerView(answer : Int, drawableView: Int){
        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                this, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    /**
     * selectedOptionView
     * defines the view of option that has been selected
     */
    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}