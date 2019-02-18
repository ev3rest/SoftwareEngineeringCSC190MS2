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

import BridgePattern.ISoundDevice;
import java.io.File;
import java.lang.Object.*;

import java.util.Hashtable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * FX Implementation of ISoundDevice
 *
 * @author csc190
 */

public class FXSoundDevice implements ISoundDevice {

    // ---- DATA MEMBERS ----------------
   // private String musicFile = "../resources/sound/drama.wav";
    //private String okFile = "../resources/sound/ok.wav";
    //private Duration duration;
    private static MediaPlayer mediaPlayer;
    
    
    // ---- OPERATIONS
    
    @Override
    public void playRepeated(String resourcePath) {
        Media backgroundMusic = new Media(new File(resourcePath).toURI().toString());
        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setOnEndOfMedia(new Runnable()
        {
            @Override 
            public void run()
            {
                System.out.print("New Runnable Created");
                mediaPlayer.seek(Duration.ZERO);
                mediaPlayer.play();            }
        });
        /*mediaPlayer.seek(Duration.ZERO);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);*/
        
        mediaPlayer.seek(Duration.ZERO);
        mediaPlayer.play();
       
       
        
        // throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void playOnce(String resourcePath) {
        Media okSound = new Media(new File(resourcePath).toURI().toString());
        MediaPlayer oneTick = new MediaPlayer(okSound);
        oneTick.seek(Duration.ZERO);
        oneTick.play();
       /* oneTick.setOnEndOfMedia(new Runnable()
        {
            public void run()
            {
                oneTick.stop();
            }
        });*/
        // throw new UnsupportedOperationException("Not implemented yet!");
    }

}
