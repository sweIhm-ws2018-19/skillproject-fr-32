package main.java.colorpicker.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class PlayerAmountIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("PlayerAmountIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = handlerInput.toString();

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("ColorSession", speechText)
                .build();
    }
}
