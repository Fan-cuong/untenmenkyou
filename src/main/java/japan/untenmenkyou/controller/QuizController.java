package japan.untenmenkyou.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import japan.untenmenkyou.entity.KarimenQuestion;
import japan.untenmenkyou.service.KarimenQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private KarimenQuestionService karimenQuestionService;

    @GetMapping("/learn")
    public String showQuiz(Model model) {
        List<KarimenQuestion> questions = karimenQuestionService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "quiz2"; // Tên của trang HTML của bạn
    }
}