package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.QuestionDatabase;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class GamePlayIntent implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("PseudoOnePlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.QUIZ_STATE_ONE_PLAYER) ));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        /* DIES SOLL WIEDER IMPLEMENTIERT WERDEN int score = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_KEY) */
        int counter = (int) sessionAttributes.get(Attributes.COUNTER_KEY);

        String responseText = "";

        if(counter > 1)
        {
            String rightmovie = (String) sessionAttributes.get(Attributes.RIGHT_MOVIE);
            responseText += rightmovie + " ist richtig! Sie haben " + (counter - 1) + " von " + (counter - 1) + " Fragen richtig beantwortet. ";

            if((counter) > 10) {

                responseText += " 10 Fragen wurden gestellt. Das Spiel ist somit beendet. Ich freue mich auf ein baldiges wiedersehen bei Magisches Zitate Raten.";

                return input.getResponseBuilder()
                        .withSpeech(responseText)
                        .withShouldEndSession(true)
                        .build();
            }
        }

        QuestionPack qp = QuestionDatabase.generateQuestionPack();

        String quote = qp.getQuote();
        String movie = qp.getMovie();
        String fakeOne = qp.getFakeMovieOne();
        String fakeTwo = qp.getFakeMovieTwo();

        responseText += "Das " + counter + "te Zitat lautet gefolgt. " + quote + " Möglichkeit 1 " + fakeOne + ". Möglichkeit 2 " + movie + ". Möglichkeit 3 " + fakeTwo + ".";
        responseText += " Dies ist eine Beta. Antworte mit Test um fortzufahren.";

        counter++;

        sessionAttributes.put(Attributes.COUNTER_KEY, counter);
        sessionAttributes.put(Attributes.RIGHT_MOVIE, Movie);


            return input.getResponseBuilder()
                    .withSpeech(responseText)
                    .withShouldEndSession(false)
                    .build();

    }



}
