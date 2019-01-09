package com.amazon.ask.quiz.util;



import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class QuestionPack
{
    private final Question question;
    private final String fakeMovieOne;
    private final String fakeMovieTwo;

    public QuestionPack(Question question, String fakeMovieOne, String fakeMovieTwo)
    {
        this.question = question;
        this.fakeMovieOne = fakeMovieOne;
        this.fakeMovieTwo = fakeMovieTwo;
    }

    public String getMovie() {
        return question.getMovie();
    }

    public String getQuote()
    {
        return question.getQuote();
    }

    public String getFakeMovieOne() {
        return fakeMovieOne;
    }

    public String getFakeMovieTwo() {
        return fakeMovieTwo;
    }


}