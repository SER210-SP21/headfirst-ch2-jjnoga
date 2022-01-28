package edu.quinnipiac.ser210.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private BeerExpert beerExpert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void OnClickFindBeer(View view)
    {
        //reference to textview
        TextView brands = (TextView) findViewById(R.id.brands);
        //reference to spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        //reference to selected value in spinner
        String beerType = String.valueOf(color.getSelectedItem());

        List<String> brandsList = beerExpert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();

        for(String brand : brandsList)
        {
            brandsFormatted.append(brand).append("\n");
        }

        //change text of the textview
        brands.setText(brandsFormatted);
    }
}