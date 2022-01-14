package ru.myitschool.lesson220114;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class RemoteFragment extends Fragment {
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_remote,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.button1).setOnClickListener(v ->addFragment());
        view.findViewById(R.id.button2).setOnClickListener(v ->replaceFragment());
        view.findViewById(R.id.button3).setOnClickListener(v ->removeFragment());
        
        
    }

    private void removeFragment() {
    }

    private void replaceFragment() {
    }

    private void addFragment() {

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, FragmentA.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name") // name can be null
                .commit();

    }
}
