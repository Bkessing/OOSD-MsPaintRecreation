package color;

import java.awt.Color;

import model.interfaces.IStrategy;

public class YellowConvert implements IStrategy {


	@Override
	public Color convert() {
		
		return Color.yellow;
	}

}
