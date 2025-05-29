package org.example.view.ui.configurers;

import org.example.controller.sceneControllers.GameController;
import org.example.model.GameModel;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.view.AppFrame;
import org.example.view.gameView.GameView;
import org.example.view.gameView.SideView;
import org.example.view.ui.painters.BlockPainter;
import org.example.view.ui.painters.GridPainter;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameConfigurer implements ScreenConfigurer {
    @Override
    public Screens getScreen() { return Screens.GAME; }


    @Override
    public void configure(AppFrame frame, JPanel container, CardLayout cards) {
        int rows = Constants.getInstance().getRows();
        int cols = Constants.getInstance().getColumns();
        int cell = Constants.getInstance().getThicknessOfSquares();

        BlockPainter blockPainter = new BlockPainter();
        GridPainter gridPainter = new GridPainter();
        GameModel model  = new GameModel(rows, cols , cards , container);
        GameView  view   = new GameView(rows, cols, cell ,Arrays.asList(gridPainter , blockPainter));
        SideView  side   = new SideView(4 , 1 , 0 , 5 , Color.gray , Color.WHITE);
        GameController ctrl = new GameController(model, view, side, 300);
//        ctrl.startGame();
        JPanel screen = new JPanel(new BorderLayout());
        screen.add(view, BorderLayout.CENTER);
        screen.add(side, BorderLayout.EAST);

        container.add(screen, Screens.GAME.getName());
    }
}
