package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;

import com.amazon.ask.quiz.util.Question;
import com.amazon.ask.quiz.util.QuestionDatabase;
import java.util.ArrayList;


import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestInitializedDatabase {

    @Test
    public void initializeDatabaseTest() {
        QuestionDatabase.initialize();

        ArrayList<Question> testerEasy = QuestionDatabase.getEasyQuestions(); // MyClass is tested
        ArrayList<Question> testerMiddle = QuestionDatabase.getMiddleQuestions(); // MyClass is tested
        ArrayList<Question> testerHard = QuestionDatabase.getHardQuestions(); // MyClass is tested

        ArrayList<Question> easyQuestions = new ArrayList<>();

        String nemo = "Findet Nemo";
        String kdl = "König der Löwen";

        easyQuestions.add(new Question("Peter Pan", "Nimm mich mit nach Nimmerland."));
        easyQuestions.add(new Question("Schneewittchen", "Spieglein, Spieglein an der Wand, wer ist die Schönste im ganzen Land?"));
        easyQuestions.add(new Question(nemo, "Einfach Schwimmen, einfach schwimmen."));
        easyQuestions.add(new Question("Die Eiskönigin", "Manche Menschen sind es wert, dass man für sie schmilzt."));
        easyQuestions.add(new Question(kdl, "Hakuna Matata. Das heißt keine Sorgen!"));
        easyQuestions.add(new Question("Das Dschungelbuch", "Probiers mal mit Gemütlichkeit!"));
        easyQuestions.add(new Question("Rapunzel Neu Verföhnt", "Blume leuchtend schön, kann so mächtig sein. Dreh die Zeit zurück, gib mir was einst war mein."));
        easyQuestions.add(new Question("Toy Story", "Bis zur Unendlichkeit und noch viel weiter!"));
        easyQuestions.add(new Question("Alice im Wunderland", "Ich wurde geschrumpft, gestreckt, gekratzt und in eine Teekanne gesteckt."));
        easyQuestions.add(new Question("Winnieh Puuh", "Dummer alter Bär!"));

        ArrayList<Question> middleQuestions = new ArrayList<>();
        middleQuestions.add(new Question("Winnieh Puu", "Menschen sagen, nichts ist unmöglich, aber ich mache jeden Tag nichts."));
        middleQuestions.add(new Question("Die Eiskönigin", "Ich liebe Umarmungen!"));
        middleQuestions.add(new Question("Pocahontas", "Lausche mit dem Herz und du wirst verstehen."));
        middleQuestions.add(new Question("Lilo und Sitch", "Ohana heißt Familie. Familie heißt, dass alle zusammenhalten und füreinander da sind."));
        middleQuestions.add(new Question(kdl, "Schleimig, jedoch vitaminreich!"));
        middleQuestions.add(new Question("Die Schöne und das Biest", "Sie warnte ihn sich nicht täuschen zu lassen, da man die Schönheit im Verborgenen findet."));
        middleQuestions.add(new Question("101 Dalmatiner", "Trottel werden nicht geboren, Pongo. Hübsche Frauen stellen sie in ihrer Freizeit her."));
        middleQuestions.add(new Question("Rapunzel Neu Verföhnt", "Dann ist es Zeit für einen neuen Traum."));
        middleQuestions.add(new Question(nemo, "Fische sind Freunde, kein Futter."));
        middleQuestions.add(new Question("Schneewittchen", "Wer hat in meinem Bettchen geschlafen?"));

        ArrayList<Question> hardQuestions = new ArrayList<>();
        hardQuestions.add(new Question("Hercules", "Ein wahrer Held wird nicht durch die Größe seiner Kraft bestimmt, sondern durch die Größe seines Herzens!"));
        hardQuestions.add(new Question("Bambi", "Wenn man nichts Nettes zu sagen hat, soll man den Mund halten."));
        hardQuestions.add(new Question(nemo, "P Sherman 42 Wallaby Way Sydney."));
        hardQuestions.add(new Question("Pocahontas", "Der richtige Weg ist nun mal nicht immer der einfachste Weg."));
        hardQuestions.add(new Question("Cinderella", "Wo Freundlichkeit herrscht, gibt es Güte und wo es Güte gibt, da ist auch Magie."));
        hardQuestions.add(new Question("Mulan", "So sehr der Sturm auch tobt, den Berg wird er nie in die Knie zwingen."));
        hardQuestions.add(new Question(kdl, "Vergiss niemals, wer du bist."));
        hardQuestions.add(new Question("Aladdin", "Ich und Schwierigkeiten? Schwierigkeiten kriegst du, wenn sie dich erwischen!"));
        hardQuestions.add(new Question("Maleficent", "Die anderen Feen fliegen, warum du nicht?"));
        hardQuestions.add(new Question("Arielle", "Du musst mit den Wimpern klimpern, so wie ich. Du musst die Lippen spitzen, so wie ich."));

        // assert statements
        for(int i = 0; i < 10; i++)
        {

            assertEquals(testerEasy.get(i).getMovie(), easyQuestions.get(i).getMovie());
            assertEquals(testerEasy.get(i).getQuote(), easyQuestions.get(i).getQuote());


            assertEquals(testerMiddle.get(i).getMovie(), middleQuestions.get(i).getMovie());
            assertEquals(testerMiddle.get(i).getQuote(), middleQuestions.get(i).getQuote());

            assertEquals(testerHard.get(i).getMovie(), hardQuestions.get(i).getMovie());
            assertEquals(testerHard.get(i).getQuote(), hardQuestions.get(i).getQuote());
        }


    }

}