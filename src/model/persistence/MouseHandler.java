package model.persistence;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Iterator;

import collections.ShapeList;
import collections.ShapesSelected;
import commands.MoveCommand;
import commands.ShapeCommand;
import model.StartAndEndPointMode;
import model.interfaces.ICommand;
import model.interfaces.IShape;

public class MouseHandler implements MouseListener {
	private Point startPoint;
	private Point endPoint;
	private ApplicationState appState;
	private ShapeList shapeList;
	private ShapesSelected shapesSelected;

	public MouseHandler(ApplicationState appState, ShapeList shapeList, ShapesSelected shapesSelected) {
		this.appState = appState;
		this.shapeList = shapeList;
		this.shapesSelected = shapesSelected;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.startPoint = e.getPoint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.endPoint = e.getPoint();
		if (appState.getActiveStartAndEndPointMode() == StartAndEndPointMode.DRAW) {
			ShapeCommand create = new ShapeCommand(startPoint, endPoint, appState, shapeList);
			try {
				create.run();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (appState.getActiveStartAndEndPointMode() == StartAndEndPointMode.SELECT) {
			this.shapesSelected.clear();
			for (IShape shape : this.shapeList) {
				if (shape.getStartPoint().getX() >= this.startPoint.getX()
						&& shape.getStartPoint().getY() >= this.startPoint.getY()
						&& shape.getEndPoint().getX() <= this.endPoint.getX()
						&& shape.getEndPoint().getY() <= this.endPoint.getY()) {
					shapesSelected.add(shape);
				}
			}
		} else {
			ICommand move = new MoveCommand(this.shapeList, this.shapesSelected, this.startPoint, this.endPoint);
			try {
				move.run();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

}
