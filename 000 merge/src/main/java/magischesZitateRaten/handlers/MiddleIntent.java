package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.MethodUtils;

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

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        /* DIES SOLL WIEDER IMPLEMENTIERT WERDEN int score = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_KEY) */

        String responseText = "du hast mittel gew�hlt.";

        responseText += MethodUtils.startGame(1, (int) sessionAttributes.get(Attributes.PLAYERCOUNTER), input);


        return input.getResponseBuilder()
                    .withSpeech(responseText)
                    .withShouldEndSession(false)
                    .build();

    }



}
