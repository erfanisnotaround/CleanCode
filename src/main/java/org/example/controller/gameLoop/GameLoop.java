package org.example.controller.gameLoop;

import org.example.model.appModels.GameModel;

import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;

public class GameLoop {
    private final GameModel model;
    public final Timer timer;
    private final List<GameLoopListener> listeners = new ArrayList<>();

    public GameLoop(GameModel model, int delayMs) {
        this.model = model;
        this.timer = new Timer(delayMs, e -> tick());
    }
    public void start() {
        model.reset();
        timer.start();
    }
    public void resume(){
        timer.start();
    }
    public void stop() {
        timer.stop();
    }

    public void addListener(GameLoopListener listener) {
        listeners.add(listener);
    }

    private void tick() {
        boolean moved = model.step();
        if (!moved && model.isGameOver()) {
            timer.stop();
            listeners.forEach(GameLoopListener::onGameOver);
        } else {
            listeners.forEach(GameLoopListener::onTick);
        }
    }
}
