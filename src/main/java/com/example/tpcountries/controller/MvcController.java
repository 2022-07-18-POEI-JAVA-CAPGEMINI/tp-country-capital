package com.example.tpcountries.controller;

import com.example.tpcountries.business.Question;
import com.example.tpcountries.business.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MvcController {

    @Autowired
    QuizService quizService;

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String countryQuiz(Model model){

        Question question = quizService.getNewQuestion();
        session.setAttribute("question", question);

        model.addAttribute("win", "");
        model.addAttribute("question", question);
        return "quiz.html";
    }

    @PostMapping("play")
    public String play(@RequestParam String proposition, Model model){

        Question question = (Question)session.getAttribute("question");
        boolean win = question.play(proposition);

        question = quizService.getNewQuestion();
        session.setAttribute("question", question);
        model.addAttribute("question", question);
        model.addAttribute("win", ""+win);
        return "quiz.html";
    }
}
