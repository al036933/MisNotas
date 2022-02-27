package es.rgmf.misnotas.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.rgmf.misnotas.databinding.FragmentAverageBinding;
import es.rgmf.misnotas.ui.viewmodels.DataViewModel;

public class AverageFragment extends Fragment {

    private FragmentAverageBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataViewModel viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        viewModel.getValue().observe(requireActivity(), grades -> {
            int[] notas = grades.get();
            int promedio = 0;

            // TODO Calcula la media de las notas que hay en el array notas.

            binding.value.setText(Integer.toString(promedio));
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAverageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
