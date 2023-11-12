package com.dictionaryapp.service;

import com.dictionaryapp.model.bindingmodels.UserLoginBindingModel;
import com.dictionaryapp.model.bindingmodels.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
