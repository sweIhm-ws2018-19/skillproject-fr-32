package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.util.QuestionDatabase;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class SetOnePlayerIntent implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetOnePlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.SELECT_STATE)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE_ONE_PLAYER);
        sessionAttributes.put(Attributes.COUNTER_KEY, 1);
        sessionAttributes.put(Attributes.QUIZ_SCORE_KEY, 0);

        QuestionDatabase.initialize();

        String responseText = "Alles klar. Sie sind ein Spieler. Sag los um mit dem Spiel zu beginnen.";
        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();

    }


}
