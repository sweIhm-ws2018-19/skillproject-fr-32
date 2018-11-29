package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class QuizAndStartOverIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return //input.matches(intentName("QuizIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.SAY_GO_STATE)));
                 input.matches(intentName("AMAZON.StartOverIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        int playerNumber = (int) sessionAttributes.get(Attributes.PLAYER_NUMBER_KEY);

        if(playerNumber == 1) sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE_ONE_PLAYER);
        if(playerNumber == 2) sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE_TWO_PLAYER);

     //   sessionAttributes.put(Attributes.RESPONSE_KEY, "");
     //   sessionAttributes.put(Attributes.COUNTER_KEY, 0);
     //   sessionAttributes.put(Attributes.QUIZ_SCORE_KEY, 0);

        String responseText = "Wie bist du hierher gekommen. Error";
        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();
    }

}
