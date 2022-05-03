package com.example.nlpquiz

object Constants {
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    /**
     * getQuestions creates questions and returns a list of them
     */
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "The main idea of lemmatization is",
            "A) getting a synonym of the word",
            "B) getting a dictionary form of the word",
            "C) removing suffixes from the word",
            2)
        questionList.add(question1)

        val question2 = Question(
            2,
            "How many tokens are in the following sentence: \n" +
                    "One morning I shot an elephant in my pajamas",
            "A) 44",
            "B) 9",
            "C) 36",
            2)
        questionList.add(question2)

        val question3 = Question(
            3,
            "3.\tWho was in pajamas in this sentence: \n" +
                    "One morning I shot an elephant in my pajamas",
            "A) I",
            "B) elephant",
            "C) ghost",
            1)
        questionList.add(question3)

        val question4 = Question(
            4,
            "What is a lemma of a word 'taught'?",
            "A) teach",
            "B) think",
            "C) throw",
            1)
        questionList.add(question4)

        val question5 = Question(
            5,
            "What is the difference between supervised and unsupervised machine learning approaches?",
            "A) using similarity between two words",
            "B) using clustering, association, and dimensionality reduction for learning",
            "C) labeled dataset are known",
        3)
        questionList.add(question5)

        val question6 = Question(
            6,
            "If you represent each word in your document collection as a vector using the bag of words approach, how long will each of such word vectors be?",
            "A) the length of each word",
            "B) the amount of the individual words",
            "C) the amount of sequences of words",
        2)
        questionList.add(question6)

        val question7 = Question(
            7,
            "What are the assumptions the Naive Bayes algorithm makes about the documents that are being classified and about their words?",
            "A) Naive Bayes ranks words depending on their frequency in the text",
            "B) It's frequency-based probability is equal zero on the beginning",
            "C) It ignores dependencies between words, and treats each word as equally informative",
        3)
        questionList.add(question7)

        val question8 = Question(
            8,
            "Which of the following classifiers is discriminative?",
            "A) Naïve Bayes",
            "B) Hidden Markov Models",
            "C) Support Vector Machine",
        3)
        questionList.add(question8)

        val question9 = Question(
            9,
            "Which classifiers can help you to separate classes which are not linearly separable?",
            "A) Naive Bayes",
            "B) Convolutional neural networks",
            "C) Support Vector Machine",
        2)
        questionList.add(question9)

        val question10 = Question(
            10,
            "Which architecture variants of Recurrent neural networks should be used for image captioning",
            "A) One-to-Many",
            "B) Many-to-One",
            "C) Many-to-Many",
        1)
        questionList.add(question10)

        val question11 = Question(
            11,
            "What is a good balance between variance and bias when build-ing a supervised machine-learning algorithm",
            "A) high bias and high variance",
            "B) high bias and low variance",
            "C) low bias and variance",
        3)
        questionList.add(question11)

        val question12 = Question(
            12,
            "Which word is a meronym of “car”",
            "A) vehicle",
            "B) motor",
            "C) taxi",
        2)
        questionList.add(question12)

        val question13 = Question(
            13,
            "The Markov model assumes that the future states depend only on the",
            "A) sequence of events that preceded it",
            "B) current state",
            "C) future state",
        2)
        questionList.add(question13)

        val question14 = Question(
            14,
            "What can't you do with word ngrams with zero probability in your training data?",
            "A) Laplace Smoothing",
            "B) Backoff and Interpolation",
            "C) Compute perplexity",
        3)
        questionList.add(question14)

        val question15 = Question(
            15,
            "Minimizing perplexity is the same as",
            "A) maximizing probability",
            "B) minimizing probability",
            "C) perplexity does not affect probability",
            1)
        questionList.add(question15)

        return questionList
    }
}