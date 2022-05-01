package xyz.agosh.flagsquiz

object Constants {


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
            R.drawable.canada,
            "Turkmenistan",
            "Canada",
            "Philippines",
            "Japan",
            2
        )
        val questionThree = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.canada,
            "Argentina",
            "Canada",
            "Philippines",
            "Japan",
            2
        )
        questionsList.add(questionOne)
        questionsList.add(questionTwo)
        questionsList.add(questionThree)

        return questionsList
    }
}