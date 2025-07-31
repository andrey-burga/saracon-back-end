package com.andreyS.saracon.models.service;

import com.andreyS.saracon.models.results.AuthResult;

public interface AuthServiceIface {

    AuthResult authenticateUser(String email, String password);

    void registerUser(String username, String password, String email);

    boolean isUserAuthenticated();

}
