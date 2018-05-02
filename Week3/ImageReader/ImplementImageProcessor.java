// MyImageProcessor.java
import imagereader.IImageProcessor;

import java.awt.image.*;
import java.awt.Image;
import java.awt.Toolkit;

public class ImplementImageProcessor implements IImageProcessor{

	public Image showChanelR(Image srcImg){
		ColorFilter rFilter = new ColorFilter(1);
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(srcImg.getSource(), rFilter));
	}

	public Image showChanelG(Image srcImg){
		ColorFilter gFilter = new ColorFilter(2);
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(srcImg.getSource(), gFilter));
	}

	public Image showChanelB(Image srcImg){		
		ColorFilter bFilter = new ColorFilter(3);
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(srcImg.getSource(), bFilter));
	}

	public Image showGray(Image srcImg){
		ColorFilter greyFilter = new ColorFilter(4);
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(srcImg.getSource(), greyFilter));

	}
}

class ColorFilter extends RGBImageFilter{
	private int signal;

	public ColorFilter(int sig){
		signal = sig;
		canFilterIndexColorModel = true;
	}

	public int filterRGB(int x, int y, int rgb){
		switch (signal){
			case 1:
				return (rgb & 0xffff0000);
			case 2:
				return (rgb & 0xff00ff00);
			case 3:
				return (rgb & 0xff0000ff);
			case 4:
				int r, g, b, grey;
				r = rgb & 0x00ff0000;
				g = rgb & 0x0000ff00;
				b = rgb & 0x000000ff;
				grey = (int)((r >> 16) * 0.299 + (g  >> 8) * 0.587 + b * 0.114);
				return (rgb & 0xff000000) + grey << 16 + grey << 8 + grey;
		}
	}
}