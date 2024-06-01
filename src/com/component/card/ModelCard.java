package com.component.card;

import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author shakthi
 */
public class ModelCard {

    public Icon getCardIcon() {
        return cardIcon;
    }

    public void setCardIcon(Icon cardIcon) {
        this.cardIcon = cardIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Color getProgressBarColor() {
        return progressBarColor;
    }

    public void setProgressBarColor(Color progressBarColor) {
        this.progressBarColor = progressBarColor;
    }

    public ModelCard(String title, double values, int percentage, Color progressBarColor, Icon cardIcon) {
        this.title = title;
        this.values = values;
        this.percentage = percentage;
        this.progressBarColor = progressBarColor;
        this.cardIcon = cardIcon;
    }
    
    private String title;
    private double values;
    private int percentage;
    private Color progressBarColor;
    private Icon cardIcon;
}
