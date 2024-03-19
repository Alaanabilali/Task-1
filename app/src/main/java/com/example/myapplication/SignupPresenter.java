package com.example.myapplication.presenter;

import com.example.myapplication.contract.SignupContract;
import com.example.myapplication.model.SignupModel;

public class SignupPresenter implements SignupContract.Presenter {
    private SignupContract.View view;
    private SignupContract.Model model;

    public SignupPresenter(SignupContract.View view, SignupContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void signup(String username, String email, String password) {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            view.showSignupErrorMessage("Please fill in all fields.");
        } else {
            view.showSignupSuccessMessage("Signup successful!");
        }
    }

    public void onSignupSuccess(String message) {
        view.showSignupSuccessMessage(message);
    }

    public void onSignupError(String message) {
        view.showSignupErrorMessage(message);
    }
}
