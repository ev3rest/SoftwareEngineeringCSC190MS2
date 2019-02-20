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

import BridgePattern.IStopWatch;

/**
 * FX implementation of IStopWatch
 * @author csc190
 */
public class FXStockWatch implements IStopWatch{
    //--- DATA MEMBERS -------------
    boolean started;
    String name;
    long startTime;
    long endTime;
    long elapsedTime;
    long totalTime;
    
    // ----------------- METHODS ----------------------------
    
    //--- OPERATOINS----------------
    public FXStockWatch(String name){
         this.name = name;
         started = false;
         startTime=0;
         endTime=0;
         elapsedTime=0;
         totalTime=0;
    }

    @Override
    public void start() {
         if(started){
             System.out.println("You have to stop first");
             return;
         }
         started = true;
         startTime = System.nanoTime();
        
    }

    @Override
    public void stop() {
         if(!started){
             System.out.println("You have to start first");
             return;
         }
         started =false;
         endTime = System.nanoTime();
         elapsedTime = (endTime - startTime)/1000000;
         totalTime+=elapsedTime;
         
    }

    @Override
    public long getElapsed() {
        return elapsedTime;
    }

    @Override
    public long getTotalElapsed() {
         return totalTime;
    }

    @Override
    public void clear() {
         totalTime=0;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
