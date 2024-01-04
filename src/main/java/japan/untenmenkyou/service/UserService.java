package japan.untenmenkyou.service;

import japan.untenmenkyou.entity.User;
import japan.untenmenkyou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean checkPasswordUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user != null; // Kiểm tra xem user có tồn tại hay không
    }

    // Phương thức không được đặt trong phương thức save
    void save(User user) {
        // Các logic lưu user
    }

}
