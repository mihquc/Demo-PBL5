package com.example.demo1.core.register;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.example.demo1.R;
import com.example.demo1.model.User;

import java.util.HashMap;

public class RegisterInteractor implements RegisterContract.Interactor {

    private RegisterContract.Listener registerListener;

    public RegisterInteractor(RegisterContract.Listener registerListener) {
        this.registerListener = registerListener;
    }

    @Override
    public void performRegister(String username, String email, String password) {
        registerListener.onStart();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(registerUser -> {
                    if (registerUser.isSuccessful()) {
                        addUserToDatabase(username, email);
                    } else {
                        registerListener.onEnd();
                        registerListener.onFailure(registerUser.getException().getMessage());
                    }
                });
    }

    private void addUserToDatabase(String username, String email) {

        String uid = FirebaseAuth.getInstance().getUid();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", uid);
        hashMap.put("email", email);
        hashMap.put("username", username);

        FirebaseDatabase.getInstance().getReference("Users")
                .child(uid)
                .setValue(hashMap)
                .addOnSuccessListener(task -> {
                    registerListener.onEnd();
                    registerListener.onSuccess(R.string.register_success);
                })
                .addOnFailureListener(error -> {
                    registerListener.onEnd();
                    registerListener.onFailure(error.getMessage());
                });
    }
}