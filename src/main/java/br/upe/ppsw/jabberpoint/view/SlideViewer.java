package br.upe.ppsw.jabberpoint.view;

import br.upe.ppsw.jabberpoint.model.BitmapItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.model.TextItem;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class SlideViewer {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	private Slide slide;
	
	public SlideViewer(Slide slide) {
		this.slide = slide;
	}
	
	public static ISlideItemViewer getViewer(SlideItem slideItem) {
		if (slideItem instanceof TextItem) {
			return new TextItemViewer((TextItem) slideItem);
		} else if (slideItem instanceof BitmapItem) {
			return new BitmapItemViewer((BitmapItem) slideItem);
		} else {
			return null;
		}
	}
	
	public static SlideViewer getViewer(Slide slide) {
		return new SlideViewer(slide);
	}
	
	public void draw(Graphics g, Rectangle area, ImageObserver view) {
	    float scale = getScale(area);

	    int y = area.y;

	    SlideItem slideItem = new TextItem(0, slide.getTitle());
	    Style style = Style.getStyle(slideItem.getLevel());
	    ISlideItemViewer slideItemViewer = getViewer(slideItem);
	    slideItemViewer.draw(area.x, y, scale, g, style, view);

	    y += slideItemViewer.getBoundingBox(g, view, scale, style).height;

	    for (int number = 0; number < slide.getSize(); number++) {
	      slideItem = (SlideItem) slide.getSlideItems().elementAt(number);
	      slideItemViewer = getViewer(slideItem);
	      style = Style.getStyle(slideItem.getLevel());
	      slideItemViewer.draw(area.x, y, scale, g, style, view);

	      y += slideItemViewer.getBoundingBox(g, view, scale, style).height;
	    }
	  }

	  private float getScale(Rectangle area) {
	    return Math.min(((float) area.width) / ((float) WIDTH),
	        ((float) area.height) / ((float) HEIGHT));
	  }
}
