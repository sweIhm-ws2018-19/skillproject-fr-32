package com.amazon.ask.quiz.util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.util.Question;
import com.amazon.ask.quiz.util.QuestionDatabase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ask.quiz.model.Constants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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