package com.robop.scriptrobotcontroller;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class EditImageParamDialog extends DialogFragment{

    @SuppressLint("InflateParams")
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.layout_dialog, null);
        final int currentImagePosition = getArguments().getInt("currentImagePosition");

        builder.setView(view)
                .setPositiveButton("決定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editSpeed = view.findViewById(R.id.edit_speed);
                        EditText editTime = view.findViewById(R.id.edit_time);

                        int speedParam = Integer.valueOf(editSpeed.getText().toString());
                        int timeParam = Integer.valueOf(editTime.getText().toString());

                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.resetItemParam(speedParam, timeParam, currentImagePosition);

                    }
                })
                .setNegativeButton("キャンセル", null);

        return builder.create();

    }

}