package br.com.viniciusls.fragmentsproject.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import br.com.viniciusls.fragmentsproject.R;
import br.com.viniciusls.fragmentsproject.activities.MainActivity;

/**
 * Created by Vinicius Luiz on 16/09/2016.
 */
public class BlueFragment extends Fragment {
    boolean isWinner = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_blue, container, false);

        Bundle result = getArguments();

        if(result.getInt("blue") == 1) isWinner = true;

        RelativeLayout layoutContainer = (RelativeLayout) view.findViewById(R.id.fragment_blue);
        layoutContainer.setOnClickListener(selecionarClickListener);

        return view;
    }

    private View.OnClickListener selecionarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            BlueFragment blueFragment = (BlueFragment) fragmentManager.findFragmentByTag("blueFragment");
            fragmentTransaction.remove(blueFragment);

            if(isWinner) {
                WinFragment winFragment = new WinFragment();

                fragmentTransaction.add(R.id.fragment_blue_container, winFragment, "winFragment");

                new AlertDialog.Builder(getActivity())
                    .setTitle("Você venceu!")
                    .setMessage("Parabéns :D Deseja jogar novamente?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);

                            getActivity().finish();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            }else{
                DefeatFragment defeatFragment = new DefeatFragment();

                fragmentTransaction.add(R.id.fragment_blue_container, defeatFragment, "defeatFragment");
            }

            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    };
}
