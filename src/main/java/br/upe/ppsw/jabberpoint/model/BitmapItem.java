package br.upe.ppsw.jabberpoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.view.Style;

public class BitmapItem extends SlideItem {

  private BufferedImage bufferedImage;
  private String imageName;

  protected static final String FILE = "Arquivo ";
  protected static final String NOTFOUND = " não encontrado";

  public BitmapItem(int level, String name) {
    super(level);

    imageName = name;

    try {
      bufferedImage = ImageIO.read(ResourceUtils.getFile(imageName).getAbsoluteFile());
    } catch (IOException e) {
      System.err.println(FILE + imageName + NOTFOUND);
    }

  }

  public BitmapItem() {
    this(0, null);
  }
  
  public BufferedImage getBufferedImage() {
	return bufferedImage;
}

public void setBufferedImage(BufferedImage bufferedImage) {
	this.bufferedImage = bufferedImage;
}

public String getName() {
    return imageName;
  }

  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }
}
