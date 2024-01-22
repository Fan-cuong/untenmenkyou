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

    // Đây là một ví dụ, bạn cần điều chỉnh tùy thuộc vào logic của bạn
    private List<HomenQuestion> someListOfQuestions;

    // Các phương thức và trường khác của service...

    public List<HomenQuestion> evaluateAnswers(List<HomenQuestion> homenQuestions) {
        for (HomenQuestion question : homenQuestions) {
            // Kiểm tra xem đáp án của người dùng có đúng không và cập nhật điểm
            question.setUserScore(question.isUserAnswer() == question.isAnswer() ? 1 : 0);
        }
        return homenQuestions;
    }

    public List<HomenQuestion> getAllHomenQuestions() {
        // Thực hiện logic để lấy danh sách câu hỏi từ cơ sở dữ liệu
        // Ví dụ: return someListOfQuestions;
        return someListOfQuestions;
    }
}