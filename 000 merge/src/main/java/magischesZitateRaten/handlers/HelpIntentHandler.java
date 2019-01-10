package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Constants;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(Constants.HELP_MESSAGE)
                .withReprompt(Constants.HELP_MESSAGE)
                .withShouldEndSession(false)
                .build();
    }

}

/*

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.QuestionDatabase;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;
*/
/*

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.QuestionDatabase;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Map;
import java.util.Optional;
hdhdhd
hdhdhd
dhdh
import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;
*/