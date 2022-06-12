package com.geektech.repeat52.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.repeat52.R;
import com.geektech.repeat52.databinding.FragmentResultBinding;
import com.geektech.repeat52.network.LoveModel;


public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentResultBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);



        Bundle bundle = getArguments();
        if (bundle != null){
            LoveModel model = (LoveModel) bundle.getSerializable("key");
            binding.fName.setText(model.firstName);
            binding.sName.setText(model.secondName);
            binding.tvResult.setText(model.result);
            binding.tvPercentage.setText(model.percentage);
            initClickers();
        }

    }

    private void initClickers() {
        binding.btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.mainFragment);
            }
        });
    }


}