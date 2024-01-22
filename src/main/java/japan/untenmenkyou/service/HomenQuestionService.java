package japan.untenmenkyou.service;

import japan.untenmenkyou.entity.HomenQuestion;
import japan.untenmenkyou.repository.HomenQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomenQuestionService {

    // Các phương thức và trường khác của service...

    public List<HomenQuestion> evaluateAnswers(List<HomenQuestion> homenQuestions) {
        int correctAnswers = 0;

        for (HomenQuestion question : homenQuestions) {
            // Kiểm tra xem đáp án của người dùng có đúng không và cập nhật điểm
            question.setUserScore(question.isUserAnswer() == question.isAnswer() ? 1 : 0);
            correctAnswers += question.getUserScore();
        }

        // Cập nhật trạng thái "pass" hoặc "fail" dựa trên số câu trả lời đúng
        boolean pass = correctAnswers >= 18;

        // Cập nhật trạng thái và điểm số của từng câu hỏi
        for (HomenQuestion question : homenQuestions) {
            question.setPass(pass);
        }

        return homenQuestions;
    }
}