package com.amazon.ask.quiz.util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.util.QuestionPack;
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