package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.bindingmodels.UserLoginBindingModel;
import com.dictionaryapp.model.bindingmodels.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if(userRegisterBindingModel == null){
            return false;
        }
        if(userRegisterBindingModel.getUsername().isBlank() ||userRegisterBindingModel.getPassword().isBlank()
                ||  this.userRepository.findByUsername(userRegisterBindingModel.getUsername()) != null
            || this.userRepository.findByEmail(userRegisterBindingModel.getEmail()) != null
            || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){

            return false;
        }
        User user = new User();

        user.setUsername(userRegisterBindingModel.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        user.setEmail(userRegisterBindingModel.getEmail());
        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
//
//        String username = userLoginBindingModel.getUsername();
//        String password = userLoginBindingModel.getPassword();
//        User user = this.userRepository.findByUsername(username);
//
//        if(user == null){
//            return false;
//        }
//        if(!user.getUsername().equals(username)
//        || !passwordEncoder.matches(password,user.getPassword())){
//            return false;
//        }
//        loggedUser.setUsername(username);
//        loggedUser.setLogged(true);
//        return true;

        User user = this.userRepository.findByUsername(userLoginBindingModel.getUsername());
        if(user != null && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())){
            loggedUser.setUsername(user.getUsername());
            loggedUser.setLogged(true);

            return true;
        }

        return false;

    }

    @Override
    public void logout() {
        loggedUser.setUsername(null);
        loggedUser.setLogged(false);
    }
}
