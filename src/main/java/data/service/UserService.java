package data.service;

import data.entity.User;
import data.model.UserRequestModel;
import data.model.UserResponse;
import data.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper mapper;

    public UserResponse createUser(UserRequestModel model) {

        //model kullanarak save işlemi
        User user = new User();
        user.setEmail(model.getEmail());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setDestination(model.getDestination());
        user.setPhoneNumber(model.getPhoneNumber());
        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setSuccess(true);
        return userResponse;
    }

    public User create(User user) {
        //direk dbye kaydetme
        return userRepository.save(user);
    }

    public List<User> getUser() {

        List<User> user = userRepository.findAll();
        List<User> model = new ArrayList<>();

        for (User mod : user) {
            User userModel = mapper.map(mod, User.class);
            model.add(userModel);
        }
        return model;
    }

    public Optional<data.model.User> getById(Long id) {
        return Optional.ofNullable(mapper.map(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found" + id)), data.model.User.class));
    }

    public UserResponse deleteUser(Long id) {
        userRepository.deleteById(id);
        UserResponse userResponse = new UserResponse();
        return userResponse;
    }
}
