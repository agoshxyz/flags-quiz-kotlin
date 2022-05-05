package xyz.agosh.flagsquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0

    private var progressBar: ProgressBar? = null
    private var textProgressBar: TextView? = null
    private var questionText: TextView? = null
    private var imageView: ImageView? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null

    private var btnSubmit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)


        progressBar = findViewById(R.id.progressBar)
        textProgressBar = findViewById(R.id.textProgressBar)

        questionText = findViewById(R.id.questionText)
        imageView = findViewById(R.id.imageView)

        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)

        btnSubmit = findViewById(R.id.btnSubmit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
        defaultOptionsView()
    }

    private fun setQuestion() {


//        Log.i("QuestionsList size is", "${mQuestionsList!!.size}")
//        for (i in mQuestionsList!!) {
//            Log.e("Questions: ", i.question)
//        }
        defaultOptionsView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]

        imageView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        textProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        questionText?.text = question.question


        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        optionOne?.let {
            options.add(0, it)
        }

        optionTwo?.let {
            options.add(1, it)
        }

        optionThree?.let {
            options.add(2, it)
        }

        optionFour?.let {
            options.add(3, it)
        }


        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }


    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#005bbb"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.optionOne -> {
                optionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.optionTwo -> {
                optionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.optionThree -> {
                optionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.optionFour -> {
                optionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers  )
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()

                            Toast.makeText(this, "Congrats! You made it", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(
                            mSelectedOptionPosition, R.drawable.wrong_option_border_bg
                        )
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "Go to next question"
                    }

                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}