package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Constants;
import com.amazon.ask.quiz.model.StateProperty;
import com.amazon.ask.quiz.model.State;
import com.amazon.ask.quiz.util.QuestionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.amazon.ask.quiz.util.QuestionUtils.getPropertyOfState;
import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class SetTwoPlayerIntent implements RequestHandler {


    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetTwoPlayerIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String responseText = "Alles klar. Sie sind 2 spieler.";
        AnswerIntentHandler.PLAYERS = 2;
        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();

    }


}
