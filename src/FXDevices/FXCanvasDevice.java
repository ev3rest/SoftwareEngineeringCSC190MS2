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
    
    //--------------------------------------
    //methods
    //--------------------------------------
   
    public FXCanvasDevice(Canvas canvas) {
        rand = canvas;
    }

   
    @Override
    public void drawImg(String imgPath, int x, int y, int width, int height, int degree) {
         System.out.print("Not implemented yet!");
    }

    @Override
    public int getWidth() {
         System.out.print("Not implemented yet!");
         return 0;
    }

    @Override
    public int getHeight() {
         System.out.print("Not implemented yet!");
         return 0;
    }

    @Override
    public IStopWatch createStopWatch(String name) {
         System.out.print("Not implemented yet!");
        return null;
    }

   

    @Override
    public void setupEventHandler(IGameEngine gameEngine) {
         System.out.print("Not implemented yet!");
    }

    @Override
    public void clear() {
         System.out.print("Not implemented yet!");
    }

}
