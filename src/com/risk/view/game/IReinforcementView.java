package com.risk.view.game;

import com.risk.model.CountryModel;
import com.risk.view.IView;

import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

/**
 * Interface to add listeners
 * @author Shriyans
 */
public interface IReinforcementView extends IView {

    void addAddListener(BiConsumer<Object, CountryModel> listener);
}
