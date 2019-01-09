package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class MiddleIntent implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("MittelIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.QUIZ_STATE_SELECT_DIFFICULTY) ));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        /* DIES SOLL WIEDER IMPLEMENTIERT WERDEN int score = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_KEY) */

        String responseText = "Du hast mittel gewählt.";


        return input.getResponseBuilder()
                    .withSpeech(responseText)
                    .withShouldEndSession(false)
                    .build();

    }



}
