package japan.untenmenkyou.service;

import japan.untenmenkyou.entity.KarimenQuestion;
import japan.untenmenkyou.repository.KarimenQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KarimenQuestionService {

    @Autowired
    private KarimenQuestionRepository karimenQuestionRepository;

    public List<KarimenQuestion> getAllQuestions() {
        return karimenQuestionRepository.findAll();
    }
}