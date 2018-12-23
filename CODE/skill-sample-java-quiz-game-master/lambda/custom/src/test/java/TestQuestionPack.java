package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.quiz.util.Question;
import com.amazon.ask.quiz.util.QuestionPack;
import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestQuestionPack {

    @Test
    public void doTestQuestionPack() {


        Question q = new Question("one", "two");

        QuestionPack qp = new QuestionPack(q, "String1", "String2");

        // assert statements
        assertEquals(qp.getMovie(), "one");

        assertEquals(qp.getQuote(), "two");

        assertEquals(qp.getFakeMovieOne(), "String1");

        assertEquals(qp.getFakeMovieTwo(), "String2");
    }

}