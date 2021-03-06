package com.amazon.ask.quiz.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class QuestionDatabase
{
    private static final ArrayList<Question> easyQuestions = new ArrayList<>();
    private static final ArrayList<Question> middleQuestions = new ArrayList<>();
    private static final ArrayList<Question> hardQuestions = new ArrayList<>();
    private static Random random;
    private static final ArrayList<Integer> askOrder = new ArrayList<>();
    private static int currentQuestion;
    private static int difficulty = 0;

    public static void setDifficulty(int d)
    {
        difficulty = d;
    }


    private QuestionDatabase() { }

    public static void clear()
    {
        easyQuestions.clear();
        middleQuestions.clear();
        hardQuestions.clear();

        random = new Random();
        askOrder.clear();
        currentQuestion = 0;
        difficulty = 0;

    }

    public static void initialize() {

        clear();

        for(int i = 0; i < 10; i++)
        {
            askOrder.add(i);
        }

        Collections.shuffle(askOrder);

        String nemo = "Findet Nemo";
        String kdl = "K�nig der L�wen";

        easyQuestions.add(new Question("Peter Pan", "Nimm mich mit nach Nimmerland."));
        easyQuestions.add(new Question("Schneewittchen", "Spieglein, Spieglein an der Wand, wer ist die Sch�nste im ganzen Land?"));
        easyQuestions.add(new Question(nemo, "Einfach Schwimmen, einfach schwimmen."));
        easyQuestions.add(new Question("Die Eisk�nigin", "Manche Menschen sind es wert, dass man f�r sie schmilzt."));
        easyQuestions.add(new Question(kdl, "Hakuna Matata. Das hei�t keine Sorgen!"));
        easyQuestions.add(new Question("Das Dschungelbuch", "Probiers mal mit Gem�tlichkeit!"));
        easyQuestions.add(new Question("Rapunzel Neu Verf�hnt", "Blume leuchtend sch�n, kann so m�chtig sein. Dreh die Zeit zur�ck, gib mir was einst war mein."));
        easyQuestions.add(new Question("Toy Story", "Bis zur Unendlichkeit und noch viel weiter!"));
        easyQuestions.add(new Question("Alice im Wunderland", "Ich wurde geschrumpft, gestreckt, gekratzt und in eine Teekanne gesteckt."));
        easyQuestions.add(new Question("Winnie Puu", "Dummer alter B�r!"));


        middleQuestions.add(new Question("Winnie Puu", "Menschen sagen, nichts ist unm�glich, aber ich mache jeden Tag nichts."));
        middleQuestions.add(new Question("Die Eisk�nigin", "Ich liebe Umarmungen!"));
        middleQuestions.add(new Question("Pocahontas", "Lausche mit dem Herz und du wirst verstehen."));
        middleQuestions.add(new Question("Lilo und Sitch", "Ohana hei�t Familie. Familie hei�t, dass alle zusammenhalten und f�reinander da sind."));
        middleQuestions.add(new Question(kdl, "Schleimig, jedoch vitaminreich!"));
        middleQuestions.add(new Question("Die Sch�ne und das Biest", "Sie warnte ihn sich nicht t�uschen zu lassen, da man die Sch�nheit im Verborgenen findet."));
        middleQuestions.add(new Question("101 Dalmatiner", "Trottel werden nicht geboren, Pongo. H�bsche Frauen stellen sie in ihrer Freizeit her."));
        middleQuestions.add(new Question("Rapunzel Neu Verf�hnt", "Dann ist es Zeit f�r einen neuen Traum."));
        middleQuestions.add(new Question(nemo, "Fische sind Freunde, kein Futter."));
        middleQuestions.add(new Question("Schneewittchen", "Wer hat in meinem Bettchen geschlafen?"));

        hardQuestions.add(new Question("Hercules", "Ein wahrer Held wird nicht durch die Gr��e seiner Kraft bestimmt, sondern durch die Gr��e seines Herzens!"));
        hardQuestions.add(new Question("Bambi", "Wenn man nichts Nettes zu sagen hat, soll man den Mund halten."));
        hardQuestions.add(new Question(nemo, "P Sherman 42 Wallaby Way Sydney."));
        hardQuestions.add(new Question("Pocahontas", "Der richtige Weg ist nun mal nicht immer der einfachste Weg."));
        hardQuestions.add(new Question("Cinderella", "Wo Freundlichkeit herrscht, gibt es G�te und wo es G�te gibt, da ist auch Magie."));
        hardQuestions.add(new Question("Mulan", "So sehr der Sturm auch tobt, den Berg wird er nie in die Knie zwingen."));
        hardQuestions.add(new Question(kdl, "Vergiss niemals, wer du bist."));
        hardQuestions.add(new Question("Aladdin", "Ich und Schwierigkeiten? Schwierigkeiten kriegst du, wenn sie dich erwischen!"));
        hardQuestions.add(new Question("Maleficent", "Die anderen Feen fliegen, warum du nicht?"));
        hardQuestions.add(new Question("Arielle", "Du musst mit den Wimpern klimpern, so wie ich. Du musst die Lippen spitzen, so wie ich."));

    }


    public static QuestionPack generateQuestionPack()
    {
        final int min = 0;
        final int max = 9;



        int randomNumberOne = random.nextInt(max - min + 1) + min;
        int randomNumberTwo = random.nextInt(max - min + 1) + min;

        int currentQuestionSelect = askOrder.get(currentQuestion);

        while(randomNumberOne == randomNumberTwo || randomNumberOne == currentQuestionSelect || randomNumberTwo == currentQuestionSelect)
        {
            randomNumberOne = random.nextInt(max - min + 1) + min;
            randomNumberTwo = random.nextInt(max - min + 1) + min;
        }

        ArrayList<Question> selectedQuestions;

        if(difficulty == 0)
        {
            selectedQuestions = easyQuestions;
        } else if(difficulty == 1)
        {
            selectedQuestions = middleQuestions;
        } else if(difficulty == 2)
        {
            selectedQuestions = hardQuestions;
        } else
        {
            selectedQuestions = easyQuestions;
        }

        String randomMovieOne = selectedQuestions.get(randomNumberOne).getMovie();
        String randomMovieTwo = selectedQuestions.get(randomNumberTwo).getMovie();
        Question randomQuestion = selectedQuestions.get(currentQuestionSelect);

        currentQuestion++;

        return new QuestionPack(randomQuestion, randomMovieOne, randomMovieTwo);
    }


    public static ArrayList<Integer> getAskOrder() {
        return askOrder;
    }

    public static ArrayList<Question> getEasyQuestions() {
        return easyQuestions;
    }

    public static ArrayList<Question> getHardQuestions() {
        return hardQuestions;
    }

    public static ArrayList<Question> getMiddleQuestions() {
        return middleQuestions;
    }


}