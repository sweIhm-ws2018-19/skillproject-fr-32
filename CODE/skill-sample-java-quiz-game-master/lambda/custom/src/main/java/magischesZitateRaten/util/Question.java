package com.amazon.ask.quiz.util;



import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class Question
{
    private final String movie;
    private final String quote;

    public Question(String movie, String quote)
    {
        this.movie = movie;
        this.quote = quote;
    }

    public String getMovie() {
        return movie;
    }

    public String getQuote()
    {
        return quote;
    }



}