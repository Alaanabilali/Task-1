package com.example.myapplication.contract;

import com.example.myapplication.model.SignupModel;

public interface SignupContract {
    interface View {
        void showSignupSuccessMessage(String message);
        void showSignupErrorMessage(String message);
    }

    interface Presenter {
        void signup(String username, String email, String password);
        void onSignupSuccess(String message);
        void onSignupError(String message);
    }

    interface Model {
        void performSignup(SignupModel signupModel);
    }
}
