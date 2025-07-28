package com.andreyS.saracon.models.service;

public interface AuthServiceIface {

    boolean authenticateUser(String email, String password);

    void registerUser(String username, String password, String email);

    boolean isUserAuthenticated();
}
