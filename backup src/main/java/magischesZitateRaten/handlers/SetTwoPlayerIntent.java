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

public class SetTwoPlayerIntent implements RequestHandler {


    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetTwoPlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.SELECT_STATE)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        sessionAttributes.put(Attributes.PLAYERCOUNTER, 2);
        sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE_SELECT_DIFFICULTY);

        QuestionDatabase.initialize();

        String responseText = "Toll, ein Duell! Möge der Bessere gewinnen. Sage Leicht, Mittel, oder Schwer um den Schwierigkeitsgrad auszuwählen.";
        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();

    }


}
