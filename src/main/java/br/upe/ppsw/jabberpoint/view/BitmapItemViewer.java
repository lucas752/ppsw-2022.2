package br.upe.ppsw.jabberpoint.view;

import br.upe.ppsw.jabberpoint.model.BitmapItem;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class BitmapItemViewer implements ISlideItemViewer{
	private BitmapItem bitmapItem;
	
	public BitmapItemViewer(BitmapItem bitmapItem) {
		this.bitmapItem = bitmapItem;
	}

	@Override
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
		return new Rectangle((int) (style.indent * scale), 0,
	        (int) (bitmapItem.getBufferedImage().getWidth(observer) * scale),
	        ((int) (style.leading * scale)) + (int) (bitmapItem.getBufferedImage().getHeight(observer) * scale));
	}

	@Override
	public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
		int width = x + (int) (style.indent * scale);
		int height = y + (int) (style.leading * scale);
    
		BufferedImage bufferedImage = bitmapItem.getBufferedImage();
    
		g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
				(int) (bufferedImage.getHeight(observer) * scale), observer);
	}
}
