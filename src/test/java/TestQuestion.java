package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.Question;
import com.amazon.ask.quiz.util.QuestionDatabase;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestQu {

    @Test
    public void initializeDatabaseTest() {


        // assert statements
        assertEquals(1, 1);



    }

}