package com.tema3.ricardo.fragmentsdinamicos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragEmpresa extends Fragment implements View.OnClickListener{
    private Comunicador comunicador;
    private Button cicleSuperior;
    private Comunicador mListener;

    public FragEmpresa() {
    }

    public static FragEmpresa newInstance(String param1, String param2) {
        FragEmpresa fragment = new FragEmpresa();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frag_empresa, container, false);
        cicleSuperior = v.findViewById(R.id.superiorEmpresa);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Comunicador) {
            comunicador = (Comunicador) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        comunicador = null;
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.superiorEmpresa)
        {
            mListener.mostrarEmpresas();
        }
    }

    public interface Comunicador {
        void mostrarEmpresas();
    }
}
