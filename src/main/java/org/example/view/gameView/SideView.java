package org.example.view.gameView;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.styling.GradientPanel;
import org.example.view.styling.StyleKit;
import org.example.view.styling.StyleUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SideView extends GradientPanel {
    private final JLabel scoreLbl = new JLabel("Score: 0");
    private final JButton start  = StyleUtils.createStyledButton("Start");
    private final JButton pause  = StyleUtils.createStyledButton("Pause");
    private final JButton back = StyleUtils.createStyledButton("Back");

    public SideView(int rows, int cols, int hgap, int vgap , Color StartColor, Color EndColor) {
        super(StartColor , EndColor);
        setLayout(new GridLayout(rows, cols, hgap, vgap));
        setPreferredSize(new Dimension(
                Constants.getInstance().getPrefersThicknessOfSidePanel(),
                Constants.getInstance().getPrefersThicknessOfSidePanel()
        ));
        scoreLbl.setHorizontalAlignment(SwingConstants.CENTER);

        StyleKit.applyLabel(scoreLbl , 18.5f , false , Color.black);
        StyleKit.applyButton(start , 6);
        StyleKit.applyButton(pause , 6);
        StyleKit.applyButton(back , 6);
        add(scoreLbl);
        add(start);
        add(pause);
        add(back);
    }

    public void setScore(int Score)        { scoreLbl.setText("Score: " + Score); }
    public void setPaused(boolean p)   { pause.setText(p ? "Resume" : "Pause"); }
    public void OnBack(ActionListener l){back.addActionListener(l);}
    public void onStart(ActionListener l) { start .addActionListener(l); }
    public void onPause(ActionListener l) { pause .addActionListener(l); }
}
