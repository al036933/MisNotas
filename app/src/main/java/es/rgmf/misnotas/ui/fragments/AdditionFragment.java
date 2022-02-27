package es.rgmf.misnotas.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.rgmf.misnotas.databinding.FragmentAdditionBinding;
import es.rgmf.misnotas.ui.viewmodels.DataViewModel;

public class AdditionFragment extends Fragment {

    private FragmentAdditionBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataViewModel viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        viewModel.getValue().observe(requireActivity(), grades -> {
            int[] notas = grades.get();
            int suma = 0;

            // TODO Sumar todas las notas que hay en el array notas.

            binding.value.setText(Integer.toString(suma));
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAdditionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
