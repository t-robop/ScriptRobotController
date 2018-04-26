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

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.layout_dialog, null);

        int currentImageRightSpeed = getArguments().getInt("currentImageRightSpeed");
        int currentImageLeftSpeed = getArguments().getInt("currentImageLeftSpeed");
        int currentImageTime = getArguments().getInt("currentImageTime");
        final int listItemPosition = getArguments().getInt("listItemPosition");

        final EditText editSpeed = view.findViewById(R.id.edit_speed);
        final EditText editTime = view.findViewById(R.id.edit_time);

        //TODO ここ治して！View足りない！
        editSpeed.setText(Integer.toString(currentImageRightSpeed));
        editSpeed.setText(Integer.toString(currentImageLeftSpeed));

        editTime.setText(Integer.toString(currentImageTime));

        builder.setView(view)
                .setPositiveButton("決定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //TODO ここ治して！View足りない！
                        int rightSpeedParam = Integer.valueOf(editSpeed.getText().toString());
                        int leftSpeedParam = Integer.valueOf(editSpeed.getText().toString());
                        int timeParam = Integer.valueOf(editTime.getText().toString());

                        if (!editSpeed.toString().equals("") || !editTime.toString().equals("")){
                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.resetItemParam(listItemPosition, rightSpeedParam, leftSpeedParam, timeParam);
                        }

                    }
                })
                .setNegativeButton("キャンセル", null);

        return builder.create();

    }

}
