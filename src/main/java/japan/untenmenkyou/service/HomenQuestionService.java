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

    @Autowired
    private HomenQuestionRepository homenQuestionRepository;

    public List<HomenQuestion> getAllHomenQuestions() {
        return homenQuestionRepository.findAll();
    }

    // Trong HomenQuestionService
    public List<HomenQuestion> evaluateAnswers(List<HomenQuestion> homenQuestions) {
        for (HomenQuestion question : homenQuestions) {
            // So sánh câu trả lời của người dùng với đáp án và tính điểm số
            boolean isCorrect = question.isUserAnswer() == question.isAnswer();
            question.setUserScore(isCorrect ? 1 : 0);
        }
        // Lưu hoặc cập nhật câu hỏi trong cơ sở dữ liệu nếu cần
        // ...

        return homenQuestions;
    }


}