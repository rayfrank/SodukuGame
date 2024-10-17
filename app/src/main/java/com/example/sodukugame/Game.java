package com.example.sodukugame;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    private SudokuGame game; // Your Sudoku game logic class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialize the game logic
        game = new SudokuGame();  // SudokuGame is the class handling game logic, which you need to implement

        // Set up the Validate button
        findViewById(R.id.validate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readInput(); // Get the user's input
                if (game.isGameComplete()) {
                    Toast.makeText(Game.this, "Congratulations! You've completed the puzzle.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Game.this, "There are still empty cells or mistakes.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Method to read user input from the grid and update the game board
    private void readInput() {
        TableLayout table = findViewById(R.id.sudoku_grid);

        for (int row = 0; row < 9; row++) {
            TableRow tableRow = (TableRow) table.getChildAt(row);
            for (int col = 0; col < 9; col++) {
                EditText cell = (EditText) tableRow.getChildAt(col);
                String input = cell.getText().toString();
                if (!input.isEmpty()) {
                    int value = Integer.parseInt(input);
                    game.updateBoard(row, col, value);  // Update the game logic with the user's input
                }
            }
        }
    }
}
