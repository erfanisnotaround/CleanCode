package org.example.controller.sceneControllers;

import org.example.model.appModels.GameModel;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.gameView.GameView;
import org.example.view.gameView.SideView;
import org.example.controller.gameLoop.GameLoop;
import org.example.controller.gameLoop.GameLoopListener;

import javax.swing.*;
import java.awt.event.*;

public class GameController implements KeyListener {
    private final GameModel model;
    private final GameView  view;
    private final SideView  side;
    private final GameLoop loop;


    public GameController(GameModel model, GameView view, SideView sideView, int delayMs) {
        this.model = model;
        this.view  = view;
        this.side  = sideView;
        this.loop = new GameLoop(model, delayMs);


        loop.addListener(new GameLoopListener() {
            @Override
            public void onTick() {
                repaintAll();
            }

            @Override
            public void onGameOver() {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(view, "Game Over")
                );
            }
        });
        side.onStart(evt -> {
            loop.start();
            side.setPaused(false);
            repaintAll();
            SwingUtilities.invokeLater(() -> this.view.requestFocusInWindow());
        });

        side.onPause(evt -> {
            if (!sideIsPaused()) {
                loop.stop();
                side.setPaused(true);
            } else {
                loop.resume();
                side.setPaused(false);
                SwingUtilities.invokeLater(() -> this.view.requestFocusInWindow());
            }
        });
        side.OnBack(e -> {
            loop.stop();
            model.Back();
        });

        view.addKeyListener(this);
        Constants.getInstance().getMainFrame().addWindowListener(new WindowAdapter() {
            @Override public void windowOpened(WindowEvent e) {
                GameController.this.view.requestFocusInWindow();
            }
        });
    }
    private boolean sideIsPaused() {
        return !loop.timer.isRunning();
    }

    private void repaintAll() {
        view.render(
                model.getBoard(),
                model.getShapeXs(), model.getShapeYs(),
                model.getX(), model.getY(),
                model.getAngle()
        );
        side.setScore(model.getScore());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                model.moveLeft();
                repaintAll();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                model.moveRight();
                repaintAll();
                break;
            case KeyEvent.VK_UP:
                System.out.println("UP");
                model.rotate();
                repaintAll();
                break;
            case KeyEvent.VK_Z:
                model.rotateCCW();
                repaintAll();
                break;
            case KeyEvent.VK_DOWN:
                model.step();
                repaintAll();
                break;
        }
    }
    @Override public void keyReleased(KeyEvent e) { }
    @Override public void keyTyped(KeyEvent e)    { }
}
