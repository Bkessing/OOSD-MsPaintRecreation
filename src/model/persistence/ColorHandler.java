package model.persistence;

import java.awt.Color;

import color.BlackConvert;
import color.BlueConvert;
import color.CyanConvert;
import color.DarkGreyConvert;
import color.GreenConvert;
import color.GreyConvert;
import color.LightGreyConvert;
import color.MagentaConvert;
import color.OrangeConvert;
import color.PinkConvert;
import color.RedConvert;
import color.WhiteConvert;
import color.YellowConvert;
import model.ShapeColor;
import model.interfaces.IStrategy;

public class ColorHandler {
	private ShapeColor shapeColor;
	private IStrategy strategy;
	public ColorHandler(ShapeColor shapeColor) {
		this.shapeColor = shapeColor;
		this.strategy = new BlueConvert();
		if (this.shapeColor == ShapeColor.BLACK)
			this.strategy = new BlackConvert();
		else if (this.shapeColor == ShapeColor.CYAN)
			this.strategy = new CyanConvert();
		else if (this.shapeColor == ShapeColor.DARK_GRAY)
			this.strategy = new DarkGreyConvert();
		else if (this.shapeColor == ShapeColor.GRAY)
			this.strategy = new GreyConvert();
		else if (this.shapeColor == ShapeColor.GREEN)
			this.strategy = new GreenConvert();
		else if (this.shapeColor == ShapeColor.LIGHT_GRAY)
			this.strategy = new LightGreyConvert();
		else if (this.shapeColor == ShapeColor.MAGENTA)
			this.strategy = new MagentaConvert();
		else if (this.shapeColor == ShapeColor.ORANGE)
			this.strategy = new OrangeConvert();
		else if (this.shapeColor == ShapeColor.PINK)
			this.strategy = new PinkConvert();
		else if (this.shapeColor == ShapeColor.RED)
			this.strategy = new RedConvert();
		else if (this.shapeColor == ShapeColor.WHITE)
			this.strategy = new WhiteConvert();
		else if (this.shapeColor == ShapeColor.YELLOW)
			this.strategy = new YellowConvert();
	}
	
	public Color convert(){
		return this.strategy.convert();
	}

}
