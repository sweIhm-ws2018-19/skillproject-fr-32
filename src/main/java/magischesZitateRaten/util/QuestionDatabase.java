package com.amazon.ask.quiz.util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Constants;
import com.amazon.ask.quiz.model.StateProperty;
import com.amazon.ask.quiz.model.State;
import com.amazon.ask.quiz.util.Question;
import com.amazon.ask.quiz.util.QuestionPack;
import java.util.ArrayList;
import com.amazon.ask.quiz.util.QuestionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.amazon.ask.quiz.util.QuestionUtils.getPropertyOfState;
import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class QuestionDatabase
{
    public static ArrayList<Question> easyQuestions = new ArrayList<>();
    public static ArrayList<Question> middleQuestions = new ArrayList<>();
    public static ArrayList<Question> hardQuestions = new ArrayList<>();

    public static void initialize() {
        easyQuestions.add(new Question("Peter Pan", "Nimm mich mit nach Nimmerland."));
        easyQuestions.add(new Question("Schneewittchen", "Spieglein, Spieglein an der Wand, wer ist die Sch�nste im ganzen Land?"));
        easyQuestions.add(new Question("Findet Nemo", "Einfach Schwimmen, einfach schwimmen."));
        easyQuestions.add(new Question("Die Eisk�nigin", "Manche Menschen sind es wert, dass man f�r sie schmilzt."));
        easyQuestions.add(new Question("K�nig der L�wen", "Hakuna Matata. Das hei�t keine Sorgen!"));
        easyQuestions.add(new Question("Das Dschungelbuch", "Probiers mal mit Gem�tlichkeit!"));
        easyQuestions.add(new Question("Rapunzel Neu Verf�hnt", "Blume leuchtend sch�n, kann so m�chtig sein. Dreh die Zeit zur�ck, gib mir was einst was mein."));
        easyQuestions.add(new Question("Toy Story", "Bis zur Unendlichkeit und noch viel weiter!"));
        easyQuestions.add(new Question("Findet Nemo", "Fische sind Freunde, kein Futter."));
        easyQuestions.add(new Question("Winnieh Puuh", "Dummer alter B�r!"));


        middleQuestions.add(new Question("Winnieh Puuh", "Menschen sagen, nichts ist unm�glich, aber ich mache jeden Tag nichts."));
        middleQuestions.add(new Question("Die Eisk�nigin", "Ich liebe Umarmungen!"));
        middleQuestions.add(new Question("Pocahontas", "Lausche mit dem Herz und du wirst verstehen."));
        middleQuestions.add(new Question("Lilo und Sitch", "Ohana hei�t Familie. Familie hei�t, dass alle zusammenhalten und f�reinander da sind."));
        middleQuestions.add(new Question("K�nig der L�wen", "Schleimig, jedoch vitaminreich!"));
        middleQuestions.add(new Question("Die Sch�ne und das Biest", "Sie warnte ihn sich nicht t�uschen zu lassen, da man die Sch�nheit im Verborgenen findet."));
        middleQuestions.add(new Question("101 Dalmatiner", "Trottel werden nicht geboren, Pongo. H�bsche Frauen stellen sie in ihrer Freizeit her."));
        middleQuestions.add(new Question("Rapunzel Neu Verf�hnt", "Dann ist es Zeit f�r einen neuen Traum."));
        middleQuestions.add(new Question("Alice im Wunderland", "Ich wurde geschrumpft, gestreckt, gekratzt und in eine Teekanne gesteckt."));
        middleQuestions.add(new Question("Schneewittchen", "Wer hat in meinem Bettchen geschlafen?"));

        hardQuestions.add(new Question("Hercules", "Ein wahrer Held wird nicht durch die Gr��e seiner Kraft bestimmt, sondern durch die Gr��e seines Herzens!"));
        hardQuestions.add(new Question("Bambi", "Wenn man nichts Nettes zu sagen hat, soll man den Mund halten."));
        hardQuestions.add(new Question("Findet Nemo", "P Sherman 42 Wallaby Way Sydney."));
        hardQuestions.add(new Question("Pocahontas", "Der richtige Weg ist nun mal nicht immer der einfachste Weg."));
        hardQuestions.add(new Question("Cinderella", "Wo Freundlichkeit herrscht, gibt es G�te und wo es G�te gibt, da ist auch Magie."));
        hardQuestions.add(new Question("Mulan", "So sehr der Sturm auch tobt, den Berg wird er nie in die Knie zwingen."));
        hardQuestions.add(new Question("K�nig der L�wen", "Vergiss niemals, wer du bist."));
        hardQuestions.add(new Question("Aladdin", "Ich und Schwierigkeiten? Schwierigkeiten kriegst du, wenn sie dich erwischen!"));
        hardQuestions.add(new Question("Maleficent", "Die anderen Feen fliegen, warum du nicht?"));
        hardQuestions.add(new Question("Arielle", "Du musst mit den Wimpern klimpern, so wie ich. Du musst die Lippen spitzen, so wie ich."));

    }

    public static QuestionPack generateQuestionPack()
    {
        final int min = 0;
        final int max = 9;

        Random random = new Random();

        int randomNumberOne = random.nextInt(max - min + 1) + min;
        int randomNumberTwo = random.nextInt(max - min + 1) + min;
        int randomNumberThree = random.nextInt(max - min + 1) + min;

        while(randomNumberOne == randomNumberTwo || randomNumberOne == randomNumberThree || randomNumberTwo == randomNumberThree)
        {
            randomNumberTwo = random.nextInt(max - min + 1) + min;
            randomNumberThree = random.nextInt(max - min + 1) + min;
        }

        String randomMovieOne = easyQuestions.get(randomNumberOne).getMovie();
        String randomMovieTwo = easyQuestions.get(randomNumberTwo).getMovie();
        Question randomQuestion = easyQuestions.get(randomNumberThree);

        QuestionPack qp = new QuestionPack(randomQuestion, randomMovieOne, randomMovieTwo);
        return qp;
    }




}