package com.daniel.camelcup;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daniel.camelcup.model.Board;
import com.daniel.camelcup.model.Camel;

public class MainActivity extends AppCompatActivity {
    private Board board;

    private TextView boardTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = new Board();

        boardTextView = findViewById(R.id.boardTextView);
        updateBoardDisplay();


    }

    private void updateBoardDisplay() {
        boardTextView.setText(board.displayBoard());
    }

    private void moveCamel(Camel camel) {
        board.moveCamel(camel);
        updateBoardDisplay();
    }

    public void whiteButton(View view) {
        moveCamel(Camel.WHITE);
    }

    public void yellowButton(View view) {
        moveCamel(Camel.YELLOW);
    }

    public void greenButton(View view) {
        moveCamel(Camel.GREEN);
    }

    public void orangeButton(View view) {
        moveCamel(Camel.ORANGE);
    }

    public void blueButton(View view) {
        moveCamel(Camel.BLUE);
    }

    public void resetBoard(View view) {
        AlertDialog.Builder resetDialog = new AlertDialog.Builder(this);
        resetDialog.setTitle("Reset Board")
                .setMessage("Are you sure you want to reset the board?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        board = new Board();
                        updateBoardDisplay();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                });
        resetDialog.create().show();
    }
}
