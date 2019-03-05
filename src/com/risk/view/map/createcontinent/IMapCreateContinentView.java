package com.risk.view.map.createcontinent;

import com.risk.view.IView;

import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

public interface IMapCreateContinentView extends IView {

    void addContinentListener(final BiConsumer<String, String> listener);

    void addShowMapCreateCountryListener(final ActionListener listener);

}