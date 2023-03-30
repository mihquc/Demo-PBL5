package com.example.demo1.core.main;

import com.example.demo1.base.BaseListenerContract;
import com.example.demo1.base.BasePresenterContract;
import com.example.demo1.base.BaseViewContract;
import com.example.demo1.model.User;

public interface MainContract {
    interface View extends BaseViewContract {
        void requireLogin();

        void setUser(User username);

        void setEmail(String email);
    }

    interface Presenter extends BasePresenterContract {
        void checkIfUserIsLoggedIn();
        void onDrawerOptionLogoutClick();
    }

    interface Interactor {
        void performGetUserData();

        void performLogout();
    }

    interface Listener extends BaseListenerContract {
        void onSuccess(User user);

        void onFailure();
    }
}
