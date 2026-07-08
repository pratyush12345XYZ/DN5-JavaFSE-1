package com.cognizant.quizhql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.quizhql.model.Attempt;
import com.cognizant.quizhql.model.AttemptOption;
import com.cognizant.quizhql.model.AttemptQuestion;
import com.cognizant.quizhql.model.Options;
import com.cognizant.quizhql.service.AttemptService;

@SpringBootApplication
public class QuizHqlApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(QuizHqlApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {

        System.out.println("------------------------------------------------");
        System.out.println("Quiz Attempt Details");
        System.out.println("------------------------------------------------");

        Attempt attempt = attemptService.getAttempt(1, 1);

        System.out.println("User : " + attempt.getUser().getName());
        System.out.println("Date : " + attempt.getDate());
        System.out.println();

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {

            System.out.println(aq.getQuestion().getText());

            for (Options option : aq.getQuestion().getOptions()) {

                boolean selected = false;

                for (AttemptOption ao : aq.getAttemptOptions()) {

                    if (ao.getOption().getId() == option.getId()) {
                        selected = ao.isSelected();
                        break;
                    }

                }

                System.out.printf("%-35s %.1f   %b%n",
                        option.getText(),
                        option.getScore(),
                        selected);
            }

            System.out.println();
        }
    }
}