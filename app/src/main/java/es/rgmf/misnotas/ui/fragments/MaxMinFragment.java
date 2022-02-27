package es.rgmf.misnotas.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.rgmf.misnotas.databinding.FragmentMaxminBinding;
import es.rgmf.misnotas.ui.viewmodels.DataViewModel;

public class MaxMinFragment extends Fragment {

    private FragmentMaxminBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataViewModel viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        viewModel.getValue().observe(requireActivity(), grades -> {
            int[] notas = grades.get();
            int max = 0;
            int min = 0;

            // TODO Calcula la nota máxima y la nota mínima de las notas que hay en el array notas.

            binding.maxValue.setText(Integer.toString(max));
            binding.minValue.setText(Integer.toString(min));
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMaxminBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
