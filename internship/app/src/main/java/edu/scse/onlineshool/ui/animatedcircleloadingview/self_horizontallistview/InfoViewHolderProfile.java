package edu.scse.onlineshool.ui.animatedcircleloadingview.self_horizontallistview;

import android.widget.Button;
import android.widget.TextView;

import edu.scse.onlineshool.selfwidget.RoundImageView;

public class InfoViewHolderProfile {
    private String name;
    private int imageId;

    public InfoViewHolderProfile(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
