package japan.untenmenkyou.repository;

import japan.untenmenkyou.entity.HomenQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomenQuestionRepository extends JpaRepository<HomenQuestion, Long> {
    // Bổ sung các phương thức truy vấn nếu cần
}
