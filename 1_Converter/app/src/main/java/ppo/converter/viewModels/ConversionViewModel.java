package ppo.converter.viewModels;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.sql.Array;
import java.util.Arrays;
import java.util.Objects;

import ppo.converter.R;

public class ConversionViewModel extends ViewModel {
    static String[] units;
    static double[] coeffs;
    MutableLiveData<String> input = new MutableLiveData<String>("");

    public MutableLiveData<String> getInputValue(){
        return input;
    }
    public String[] getUnits() { return units; }

    public String getUnitShort(String s) { return s.substring(s.lastIndexOf(" ") + 1); }
    public String getUnitFull(String s) { return s.substring(0, s.lastIndexOf(" ")); }

    public ConversionViewModel(Resources res, String title){
        if (title.equals("Length converter"))
            units = res.getStringArray(R.array.length);
        else if (title.equals("Area converter"))
            units = res.getStringArray(R.array.area);
        else units = res.getStringArray(R.array.volume);
        coeffs = new double[units.length];
        for (int i = 0; i < units.length; i++) {
            String num = units[i].substring(units[i].lastIndexOf(" ") + 1);
            coeffs[i] = Double.parseDouble(num);
            units[i] = units[i].substring(0, units[i].lastIndexOf(" "));
        }
    }

    public void inputValue(View view){
        if (view instanceof Button) {
            String number = ((Button) view).getText().toString();
            String val = input.getValue();
            boolean dotCheckOK = !(number.equals(".") && (val.equals("") || val.contains(".")));
            if (val.length() < 15 && dotCheckOK)
                if (val.equals("0") && !number.equals("."))
                    input.setValue(number);
                else
                    input.setValue(val + number);
        }
        else {
            input.setValue(((TextView) view).getText().toString());
        }
    }

    public String convert(double val, String from, String to) {
        int i = Arrays.asList(units).indexOf(from), j = Arrays.asList(units).indexOf(to);
        return String.valueOf(val * coeffs[i] / coeffs[j]);
    }

    public void AC(){
        input.setValue("0");
    }

    public void delete() {
        if (input.getValue().equals("") || input.getValue().length() == 1)
            input.setValue("0");
        else
            input.setValue(input.getValue().substring(0, input.getValue().length() - 1));
    }

    public void setValueEnabled(View v) {

    }
}
