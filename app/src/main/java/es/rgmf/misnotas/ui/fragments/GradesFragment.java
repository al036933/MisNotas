package es.rgmf.misnotas.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.rgmf.misnotas.databinding.FragmentGradesBinding;
import es.rgmf.misnotas.ui.viewmodels.DataViewModel;

public class GradesFragment extends Fragment {

    private FragmentGradesBinding binding;
    private DataViewModel.Grades grades;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataViewModel viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        viewModel.getValue().observe(requireActivity(), value -> {
            grades = value;
            binding.cbMaths.setText(Integer.toString(value.get(0)), false);
            binding.cbPhilo.setText(Integer.toString(value.get(1)), false);
            binding.cbHistory.setText(Integer.toString(value.get(2)), false);
            binding.cbCs.setText(Integer.toString(value.get(3)), false);
        });

        ArrayAdapter<Integer> mathsAdapter = new ArrayAdapter<Integer>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        );
        ArrayAdapter<Integer> philoAdapter = new ArrayAdapter<Integer>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        );
        ArrayAdapter<Integer> historyAdapter = new ArrayAdapter<Integer>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        );
        ArrayAdapter<Integer> csAdapter = new ArrayAdapter<Integer>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        );

        binding.cbMaths.setAdapter(mathsAdapter);
        binding.cbMaths.setOnItemClickListener((parent, viewMaths, position, id) -> {
            viewModel.setGrades(
                    new DataViewModel.Grades(
                            mathsAdapter.getItem(position),
                            grades != null ? grades.get(1) : 0,
                            grades != null ? grades.get(2) : 0,
                            grades != null ? grades.get(3) : 0
                    )
            );
        });
        binding.cbPhilo.setAdapter(philoAdapter);
        binding.cbPhilo.setOnItemClickListener((parent, viewPhilo, position, id) -> {
            viewModel.setGrades(
                    new DataViewModel.Grades(
                            grades != null ? grades.get(0) : 0,
                            mathsAdapter.getItem(position),
                            grades != null ? grades.get(2) : 0,
                            grades != null ? grades.get(3) : 0
                    )
            );
        });
        binding.cbHistory.setAdapter(historyAdapter);
        binding.cbHistory.setOnItemClickListener((parent, viewHistory, position, id) -> {
            viewModel.setGrades(
                    new DataViewModel.Grades(
                            grades != null ? grades.get(0) : 0,
                            grades != null ? grades.get(1) : 0,
                            mathsAdapter.getItem(position),
                            grades != null ? grades.get(3) : 0
                    )
            );
        });
        binding.cbCs.setAdapter(csAdapter);
        binding.cbCs.setOnItemClickListener((parent, viewCs, position, id) -> {
            viewModel.setGrades(
                    new DataViewModel.Grades(
                            grades != null ? grades.get(0) : 0,
                            grades != null ? grades.get(1) : 0,
                            grades != null ? grades.get(2) : 0,
                            mathsAdapter.getItem(position)
                    )
            );
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGradesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}