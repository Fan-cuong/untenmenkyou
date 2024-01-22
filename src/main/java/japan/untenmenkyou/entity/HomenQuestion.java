package japan.untenmenkyou.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "homen_question")
public class HomenQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private boolean answer;  // Đáp án sẽ được lưu dưới dạng boolean

    private boolean userAnswer;  // Đáp án của người dùng

    // Trong class HomenQuestion
    private int userScore;  // Trường này sẽ lưu điểm số của người dùng

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
    // Getter và Setter cho userScore


    // Các getter và setter...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}
