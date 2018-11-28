package com.amazon.ask.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Constants;
import com.amazon.ask.quiz.model.StateProperty;
import com.amazon.ask.quiz.model.State;
import com.amazon.ask.quiz.util.QuestionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ask.quiz.util.QuestionUtils;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.QuestionDatabase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.amazon.ask.quiz.util.QuestionUtils.getPropertyOfState;
import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestUninitializedDatabase {

    @Test
    public void initializeDatabaseTest() {
        ArrayList<String> testerEasy = QuestionDatabase.easyQuestions; // MyClass is tested
        ArrayList<String> testerMiddle = QuestionDatabase.middleQuestions; // MyClass is tested
        ArrayList<String> testerHard = QuestionDatabase.hardQuestions; // MyClass is tested

        ArrayList<String> actual = new ArrayList<>();

        // assert statements
        assertEquals(testerEasy, actual, "testerEasy not empty");
        assertEquals(testerMiddle, actual, "testerMiddle not empty");
        assertEquals(testerHard, actual, "testerHard not empty");
    }

}