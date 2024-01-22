package japan.untenmenkyou.controller;

//import ch.qos.logback.core.model.Model;
import japan.untenmenkyou.service.HomenQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import japan.untenmenkyou.entity.HomenQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomenController {

    @Autowired
    private HomenQuestionService homenQuestionService;

    @GetMapping("/homen")
    public String homen(Model model) {
        List<HomenQuestion> homenQuestions = homenQuestionService.getAllHomenQuestions();
        model.addAttribute("homenQuestions", homenQuestions);
        return "homen";
    }

    @PostMapping("/submitHomen")
    public String submitHomen(@ModelAttribute List<HomenQuestion> homenQuestions, Model model) {
        // Đánh giá câu trả lời và cập nhật điểm số
        List<HomenQuestion> evaluatedQuestions = homenQuestionService.evaluateAnswers(homenQuestions);
        // Thêm danh sách câu hỏi đã đánh giá vào model
        model.addAttribute("evaluatedQuestions", evaluatedQuestions);
        // Tính tổng điểm số
        int totalScore = evaluatedQuestions.stream().mapToInt(HomenQuestion::getUserScore).sum();
        // Thêm tổng điểm vào model
        model.addAttribute("totalScore", totalScore);
        // Chuyển hướng đến trang hiển thị kết quả
        return "redirect:/result";
    }


    @GetMapping("/result")
    public ModelAndView showResult() {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("allHomenQuestions", homenQuestionService.getAllHomenQuestions());
        return modelAndView;
    }
}



