/*
 *  Developed by MBCRAFT. Copyright © 2014-2015. All rights reserved.
 *  This file of source code is property of MBCRAFT (http://www.mbcraft.it). 
 *  Do not sell, do not remove this license note even if you edit this file.
 *  Do not use this source code to develop your own file manager application.
 *  You can reuse part or full files for your own project (eg javafx ui classes)
 *  but keep copyright in files, and please link http://www.mbcraft.it on your
 *  project website.
 *
 *  Thanks
 *
 *  - Marco Bagnaresi
 */

package it.mbcraft.fileplaza.ui.common.helpers;

import it.mbcraft.fileplaza.Main;
import java.io.InputStream;
import javafx.scene.image.Image;

/**
 * Returns an image from the images folder embedded in the software.
 * 
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
public class ImageFactory {
    public static final Image getImage(String name) {
        InputStream is = Main.class.getResourceAsStream("graphics/official/images/"+name+".png");
        if (is==null)
            is = Main.class.getResourceAsStream("graphics/stub/images/"+name+".png");
        return new Image(is);
    }
}
