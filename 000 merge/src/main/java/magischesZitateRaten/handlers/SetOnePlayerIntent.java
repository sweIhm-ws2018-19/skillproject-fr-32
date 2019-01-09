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

        QuestionDatabase.initialize();



        sessionAttributes.put(Attributes.PLAYERCOUNTER, 1);
        sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE_SELECT_DIFFICULTY);



        String responseText = "Alles klar, wir werden viel Spaﬂ zusammen haben. Sage Leicht, Mittel, oder Schwer um den Schwierigkeitsgrad auszuw‰hlen.";
        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();

    }


}
