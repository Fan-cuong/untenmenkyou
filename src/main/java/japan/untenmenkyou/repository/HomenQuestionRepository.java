package japan.untenmenkyou.repository;

import japan.untenmenkyou.entity.HomenQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomenQuestionRepository extends JpaRepository<HomenQuestion, Long> {
    // Các phương thức tương tác với cơ sở dữ liệu...
}
