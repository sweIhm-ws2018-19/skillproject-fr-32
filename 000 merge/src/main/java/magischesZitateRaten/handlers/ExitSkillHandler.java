package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Constants;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;


public class ExitSkillHandler implements RequestHandler {

    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent")
                .or(intentName("AMAZON.PauseIntent")
                .or(intentName("AMAZON.CancelIntent"))));
    }

    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder().withSpeech(Constants.EXIT_SKILL_MESSAGE).build();
    }

}

/*
int b = 0;

for (int x = 0; x >= int t = 10; x++){
	
	if ( x == 8)
		System.out.println( "x  = 8")
	else 
		x = 9;
}

return 0;

*/