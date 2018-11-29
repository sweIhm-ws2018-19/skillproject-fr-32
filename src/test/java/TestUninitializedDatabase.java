package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;

import com.amazon.ask.quiz.util.Question;
import com.amazon.ask.quiz.util.QuestionDatabase;
import java.util.ArrayList;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestUninitializedDatabase {

    @Test
    public void uninitializedDatabaseTest() {

        QuestionDatabase.clear();

        ArrayList<Question> testerEasy = QuestionDatabase.getEasyQuestions(); // MyClass is tested
        ArrayList<Question> testerMiddle = QuestionDatabase.getMiddleQuestions(); // MyClass is tested
        ArrayList<Question> testerHard = QuestionDatabase.getHardQuestions(); // MyClass is tested

        ArrayList<Question> compare = new ArrayList<>();

        // assert statements
        assertEquals(testerEasy, compare);
        assertEquals(testerMiddle, compare);
        assertEquals(testerHard, compare);
    }

}