package xyz.agosh.flagsquiz

object Constants {


    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val questionOne = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.canada,
            "Argentina",
            "Canada",
            "Philippines",
            "Japan",
            2
        )
        val questionTwo = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.georgia,
            "Uzbekistan",
            "Nepal",
            "Georgia",
            "Uganda",
            3
        )
        val questionThree = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.kyrgyzystan,
            "Kyrgyzstan",
            "Canada",
            "Philippines",
            "Japan",
            1
        )

        val questionFour = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.lithuania,
            "Lithuania",
            "Canada",
            "Philippines",
            "Japan",
            1
        )

        val questionFive = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.timor_leste,
            "Argentina",
            "Canada",
            "Philippines",
            "Timor Leste",
            4
        )

        val questionSix = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.st_helena,
            "Argentina",
            "St. Helena",
            "Philippines",
            "Japan",
            2
        )

        val questionSeven = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.qatar,
            "Argentina",
            "Qatar",
            "Philippines",
            "Japan",
            2
        )

        val questionEight = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.norway,
            "Argentina",
            "Canada",
            "Norway",
            "Japan",
            3
        )
        val questionNine = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.solomon_islands,
            "Argentina",
            "Canada",
            "Philippines",
            "Solomon islands",
            4
        )
        val questionTen = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.japan,
            "Argentina",
            "Japan",
            "Philippines",
            "Columbia",
            2
        )
        questionsList.add(questionOne)
        questionsList.add(questionTwo)
        questionsList.add(questionThree)
        questionsList.add(questionFour)
        questionsList.add(questionFive)
        questionsList.add(questionSix)
        questionsList.add(questionSeven)
        questionsList.add(questionEight)
        questionsList.add(questionNine)
        questionsList.add(questionTen)

        return questionsList
    }
}