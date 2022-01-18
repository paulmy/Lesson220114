package ru.myitschool.lesson220114;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class RemoteFragment extends Fragment {
    FragmentA fragmentA = new FragmentA();
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_remote, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editText = view.findViewById(R.id.name);
        view.findViewById(R.id.button1).setOnClickListener(v -> addFragment());
        view.findViewById(R.id.button2).setOnClickListener(v -> replaceFragment());
        view.findViewById(R.id.button3).setOnClickListener(v -> removeFragment());


    }

    private void removeFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("value", editText.getText().toString());
        getParentFragmentManager().setFragmentResult("MY_KEY", bundle);
    }

    private void replaceFragment() {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, FragmentB.class, null)
                .setReorderingAllowed(true)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                )
                // .addToBackStack("name1") // name can be null
                .commit();
    }

    private void addFragment() {

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, FragmentA.class, null)
                .setReorderingAllowed(true)
                // .addToBackStack("name") // name can be null
                .commit();


    }
}
