/*
 * Copyright (C) 2019 csc190
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package FXDevices;

import BridgePattern.ICanvasDevice;
import BridgePattern.IGameEngine;
import BridgePattern.IStopWatch;

import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;
import java.util.*;

/**
 * FXVersion Implementation of ICanvasDevice
 *
 * @author csc190
 */
public class FXCanvasDevice implements ICanvasDevice {

    //--------------------------------------
    //data members
    //--------------------------------------
    Canvas rand;
    GraphicsContext gc;
    Image bloc;
    ImageView iv1;
    Map<String,Image> imgLoad;
    //--------------------------------------
    //methods
    //--------------------------------------
   
    public FXCanvasDevice(Canvas canvas) {
        rand = canvas;
        gc = rand.getGraphicsContext2D();
        imgLoad = new HashMap<String,Image>();
    }
    
    private void rotate(GraphicsContext gc, int width, int height, double degree){
        Rotate r = new Rotate(degree, width, height);
        gc.setTransform(r.getMxx(), r.getMyx(),r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

   
    @Override
    public void drawImg(String imgPath, int x, int y, int width, int height, int degree) {
       String iPath = "file:" + imgPath;
       if(!imgLoad.containsKey(iPath)){
            bloc = new Image(iPath);
            imgLoad.put(iPath,bloc);
            System.out.println("Image Queued");
       }
       Image Hbloc = imgLoad.get(iPath);
       gc.save();
       rotate(gc, x+((int)Hbloc.getWidth()/2), y+((int)Hbloc.getHeight()/2), degree);
       gc.drawImage(Hbloc, x, y);
       gc.restore();
    }

    @Override
    public int getWidth() {
         return (int) rand.getWidth();
    }

    @Override
    public int getHeight() {
         return (int) rand.getHeight();
    }

    @Override
    public IStopWatch createStopWatch(String name) {
        return new FXStockWatch(name);
    }


    @Override
    public void setupEventHandler(IGameEngine gameEngine) {
        rand.setOnMousePressed((MouseEvent event) -> {
            double x = event.getSceneX();
            double y = event.getSceneY();
            if (event.getButton() == MouseButton.PRIMARY){
                gameEngine.onRightClick(this, (int) x, (int) y);
            }
            else{
                gameEngine.onLeftClick(this, (int) x, (int) y);
            }
                    
        });
    }

    @Override
    public void clear() {
        gc.clearRect(0, 0, getHeight(), getWidth());
    }

}
