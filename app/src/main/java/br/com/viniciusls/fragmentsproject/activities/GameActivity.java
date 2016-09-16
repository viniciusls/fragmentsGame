package br.com.viniciusls.fragmentsproject.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import br.com.viniciusls.fragmentsproject.R;
import br.com.viniciusls.fragmentsproject.fragments.BlueFragment;
import br.com.viniciusls.fragmentsproject.fragments.GreenFragment;
import br.com.viniciusls.fragmentsproject.fragments.RedFragment;
import br.com.viniciusls.fragmentsproject.fragments.YellowFragment;

/**
 * Created by Vinicius Luiz on 16/09/2016.
 */
public class GameActivity extends Activity {
    private int winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        RedFragment redFragment = new RedFragment();
        BlueFragment blueFragment = new BlueFragment();
        YellowFragment yellowFragment = new YellowFragment();
        GreenFragment greenFragment = new GreenFragment();

        winner = (int) ((Math.random() * 4) + 1);
        Log.i("winner", String.valueOf(winner));
        Bundle result = new Bundle();

        result.putInt("red", 0);
        result.putInt("blue", 0);
        result.putInt("yellow", 0);
        result.putInt("green", 0);

        switch (winner){
            case 1:
                result.putInt("red", 1);
                break;
            case 2:
                result.putInt("blue", 1);
                break;
            case 3:
                result.putInt("yellow", 1);
                break;
            case 4:
                result.putInt("green", 1);
                break;
        }

        redFragment.setArguments(result);
        blueFragment.setArguments(result);
        yellowFragment.setArguments(result);
        greenFragment.setArguments(result);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_red_container, redFragment, "redFragment");
        fragmentTransaction.add(R.id.fragment_blue_container, blueFragment, "blueFragment");
        fragmentTransaction.add(R.id.fragment_yellow_container, yellowFragment, "yellowFragment");
        fragmentTransaction.add(R.id.fragment_green_container, greenFragment, "greenFragment");

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
}
