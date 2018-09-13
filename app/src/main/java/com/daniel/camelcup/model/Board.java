package com.daniel.camelcup.model;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Board {
    private static final Locale locale = new Locale("en", "NZ");

    private static final int ROWS = 16;
    private static final int COLUMNS = 8;

    private SparseArray<Tile> tiles;
    private Map<Camel, Integer> camelPositions;

    public Board() {
        //Setup tiles map
        tiles = new SparseArray<>();
        for (int i=1; i<ROWS + 1; i++) {
            tiles.put(i, new Tile());
        }

        //Setup initial camel positions
        camelPositions = new HashMap<>();
        for (Camel camel : Camel.values()) {
            camelPositions.put(camel, 0);
        }
    }

    public void moveCamel(Camel camel) {
        int currentPosition = camelPositions.get(camel);
        if (currentPosition == 0) {
            tiles.get(1).addCamel(camel);
            camelPositions.put(camel, 1);
        } else {
            if (currentPosition + 1 <= ROWS) {
                List<Camel> camelsMoving = tiles.get(currentPosition).getCamels(camel);
                tiles.get(currentPosition + 1).addCamel(camelsMoving);

                for (Camel currentCamel : camelsMoving) {
                    camelPositions.put(currentCamel, currentPosition + 1);
                }
            }
        }
    }

    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game Board\n\n");

        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLUMNS; j++) {
                if (j == 0) {
                    sb.append(String.format(locale, "%02d", i + 1));
                } else if (j == 1) {
                    sb.append("|");
                } else {
                    List<Camel> camels = tiles.get(i + 1).getCamelsOnTile();
                    if (!camels.isEmpty()) {
                        for (Camel camel : camels) {
                            sb.append(camel.getCharacter());
                        }
                        break;
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
