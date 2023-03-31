package com.example.demo1.view;

import static com.example.demo1.utils.notification.NotificationUtils.deleteNotification;
import static com.example.demo1.utils.notification.NotificationUtils.scheduleNotificationForPlant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;
import com.example.demo1.core.myplants.MyPlantsContract;
import com.example.demo1.core.myplants.MyPlantsPresenter;
import com.example.demo1.databinding.FragmentMyPlantsBinding;
import com.example.demo1.model.UserPlant;
import com.example.demo1.view.adapter.MyPlantsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPlantsFragment extends BaseFragment implements MyPlantsContract.View {

    FragmentMyPlantsBinding binding;
    com.example.demo1.core.myplants.MyPlantsPresenter presenter;
    private LinearLayoutManager plantsLayoutManager;
    private MyPlantsAdapter myPlantsAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMyPlantsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter = new MyPlantsPresenter(this);
        recyclerView = view.findViewById(R.id.rv_my_plants);

        init();
        presenter.getMyPlantsList();
        super.onViewCreated(binding.getRoot(), savedInstanceState);
    }

    private void init() {
        binding.toolbar.btShowProfile.setOnClickListener(v -> {
                    MainActivity activity = (MainActivity) getActivity();
                    assert activity != null;
                    activity.openCloseNavigationDrawer(v);
                }
        );

        initAdapters();
    }

    private void initAdapters() {
        plantsLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(plantsLayoutManager);

        myPlantsAdapter = new MyPlantsAdapter(getContext(), presenter, new ArrayList<UserPlant>());
        recyclerView.setAdapter(myPlantsAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void updateMyPlants(List<UserPlant> plantList) {
        if (plantList != null) {
            myPlantsAdapter = new MyPlantsAdapter(getContext(), presenter, plantList);
            recyclerView.setAdapter(myPlantsAdapter);
        }
        if (myPlantsAdapter.getItemCount() == 0)
            binding.tvHint.setVisibility(View.VISIBLE);
    }

    @Override
    public void setNewNotificationForPlant(UserPlant plant) {
        if (plant != null) {
            scheduleNotificationForPlant(plant);
        }
    }

    @Override
    public void plantDeleted(String id) {
        deleteNotification(requireContext(), id);
    }
}