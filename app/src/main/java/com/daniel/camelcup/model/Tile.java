package com.daniel.camelcup.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tile {
    private List<Camel> camels;

    public Tile() {
        camels = new ArrayList<>();
    }

    /**
     * Add a list of camels ontop of the existing camels
     * @param camelsToAdd - a list of camels to add
     */
    public void addCamel(List<Camel> camelsToAdd) {
        camels.addAll(camelsToAdd);
    }

    public void addCamel(Camel camel) {
        camels.add(camel);
    }

    /**
     * When retrieving camels, provide the camel that is moving and this method will return all the
     * camels above the desired camel
     * @param camel - the camel to move
     * @return a list of camels containing the desired camel and all the camels above it
     */
    public List<Camel> getCamels(Camel camel) {
        int index = camels.indexOf(camel);
        if (index == -1) {
            return Collections.emptyList();
        }
        List<Camel> camelsToReturn = new ArrayList<>(camels.subList(index, camels.size()));
        camels.subList(index, camels.size()).clear();
        return camelsToReturn;
    }

    public List<Camel> getCamelsOnTile() {
        return Collections.unmodifiableList(camels);
    }
}
