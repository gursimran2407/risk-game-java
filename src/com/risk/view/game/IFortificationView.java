package com.risk.view.game;

import com.risk.view.IView;

import java.awt.event.ActionListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface IFortificationView extends IView {

    void addMoveListener(Consumer<MoveData> listener);

    void addFromChangeListener(Consumer<Integer> listener);
}
