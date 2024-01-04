package japan.untenmenkyou.repository;

import japan.untenmenkyou.entity.KarimenQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KarimenQuestionRepository extends JpaRepository<KarimenQuestion, Long> {
    // Các phương thức truy vấn đặc biệt nếu cần
}