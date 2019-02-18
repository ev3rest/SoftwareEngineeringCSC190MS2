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
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

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
    
    //--------------------------------------
    //methods
    //--------------------------------------
   
    public FXCanvasDevice(Canvas canvas) {
        rand = canvas;
        gc = rand.getGraphicsContext2D();
    }

   
    @Override
    public void drawImg(String imgPath, int x, int y, int width, int height, int degree) {
       String iPath = "file:" + imgPath;
       bloc = new Image(iPath);
       iv1= new ImageView(bloc);
       iv1.setRotate(degree);
       //Rotate rot = new Rotate(degree);
       //iv1.getTransforms().addAll(rot);
       gc = rand.getGraphicsContext2D();
       gc.drawImage(iv1.getImage(), x, y, width, height);
    }

    @Override
    public int getWidth() {
        // System.out.print("Not implemented yet!");
         return (int) rand.getWidth();
    }

    @Override
    public int getHeight() {
         //System.out.print("Not implemented yet!");
         return (int) rand.getHeight();
    }

    @Override
    public IStopWatch createStopWatch(String name) {
        
        return new FXStockWatch(name);
    }

   

    @Override
    public void setupEventHandler(IGameEngine gameEngine) {
         System.out.println("Event Handler not used");
    }

    @Override
    public void clear() {
        gc.clearRect(0, 0, getHeight(), getWidth());
    }

}
