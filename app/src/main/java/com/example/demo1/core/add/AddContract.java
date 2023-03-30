package com.example.demo1.core.add;

import com.example.demo1.base.BaseListenerContract;
import com.example.demo1.base.BasePresenterContract;
import com.example.demo1.base.BaseViewContract;
import com.example.demo1.model.UserPlant;

public interface AddContract {
    interface View extends BaseViewContract {
        void setNameError(int error);

        void plantAdded(int message, UserPlant plant);
    }

    interface Presenter extends BasePresenterContract {
        void addPlant(UserPlant plant);
    }

    interface Interactor {
        void performAddPlant(UserPlant plant);
    }

    interface Listener extends BaseListenerContract {
        void onSuccess(int message, UserPlant plant);
        void onFailure(String message);
    }
}