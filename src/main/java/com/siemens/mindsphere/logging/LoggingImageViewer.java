package com.siemens.mindsphere.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by da5wwf
 * on 7/28/2018 15:38.
 */
public class LoggingImageViewer {
    public static void main(String[] args){
        if(System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null){
            try {
                Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.horstmann.corejava").addHandler(handler);
            }catch (IOException e){
                Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "CON'T create log file handler", e);
            }
        }
    }
}
