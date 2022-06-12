package com.geektech.repeat52.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.repeat52.App;
import com.geektech.repeat52.R;
import com.geektech.repeat52.databinding.FragmentMainBinding;
import com.geektech.repeat52.network.LoveModel;
import com.geektech.repeat52.viewModal.MainViewModal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    MainViewModal viewModal;

    private final String HOST = "love-calculator.p.rapidapi.com";
    private final String KEY = "2611949ba1msha3bd1bac2be828cp1e93bejsn05be3f998e60";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModal = new ViewModelProvider(this).get(MainViewModal.class);

        binding.btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromLoveApi();
            }
        });

    }

    private void getDataFromLoveApi() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        String firstName = binding.firstName.getText().toString();
        String secondName = binding.secondName.getText().toString();
        viewModal.getLoveModelLiveData(firstName, secondName).observe(this, loveModel -> {
            Toast.makeText(requireContext(), loveModel.percentage, Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putSerializable("key", loveModel);
            navController.navigate(R.id.resultFragment,bundle);
        });
    }
}