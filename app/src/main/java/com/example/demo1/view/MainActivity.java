package com.example.demo1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.demo1.R;
import com.example.demo1.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity implements MainContract.View {
    private AppBarConfiguration mAppBarConfiguration;
    private MainPresenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        presenter = new MainPresenter(this);

        if (isNetworkAvailable(getApplicationContext())) {
            initBottomNav();
            initDrawerNav();
            hideConnectionError();
            presenter.checkIfUserIsLoggedIn();
        } else {
            showConnectionError();
        }

        binding.mainLayout.content.btRefresh.setOnClickListener(v -> {
                    hideConnectionError();
                    init();
                }
        );
    }
}