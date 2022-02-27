package es.rgmf.misnotas.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;

public class DataViewModel extends ViewModel {

    private final MutableLiveData<Grades> grades = new MutableLiveData<>();

    public void setGrades(Grades grades) {
        this.grades.setValue(grades);
    }

    public LiveData<Grades> getValue() {
        return grades;
    }

    public static class Grades {
        int[] grades = new int[] {0, 0, 0, 0};

        public Grades(int g1, int g2, int g3, int g4) {
            grades[0] = g1;
            grades[1] = g2;
            grades[2] = g3;
            grades[3] = g4;
        }

        public int get(int i) {
            return grades[i];
        }

        public void set(int i, int v) {
            grades[i] = v;
        }

        public int[] get() {
            return grades;
        }

        @Override
        public String toString() {
            return "Grades{" +
                    "grades=" + Arrays.toString(grades) +
                    '}';
        }
    }
}
