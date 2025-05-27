package org.example.view;

import javax.swing.*;
import java.awt.*;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.MenuView;       // your existing menu panel (refactored below)
import org.example.view.GameScreen;     // see below
public class AppFrame extends JFrame {
    private static final String MENU = "menu";
    private static final String GAME = "game";

    private final CardLayout cards    = new CardLayout();
    private final JPanel     container = new JPanel(cards);

    public AppFrame() {
        super("Tetris");
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int w = Constants.getInstance().getColumns() * Constants.getInstance().getThicknessOfSquares();
        int h = Constants.getInstance().getRows()    * Constants.getInstance().getThicknessOfSquares();
        setSize(w, h);
        setLocationRelativeTo(null);

        MenuView   menu   = new MenuView();
        GameScreen game   = new GameScreen();

        // wire menu buttons to swap cards
        menu.addLoadGameListener(e -> cards.show(container, GAME));
        menu.addSettingsListener(e -> { /* show settings dialog */ });
        menu.addExitListener(e -> { dispose(); System.exit(0); });

        // add to the CardLayout container
        container.add(menu, MENU);
//        container.add(game, GAME);

        setContentPane(container);
        cards.show(container, MENU);
    }

    /** Show the frame on the EDT **/
    public void showMenu() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
