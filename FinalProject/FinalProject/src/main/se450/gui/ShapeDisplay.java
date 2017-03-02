package main.se450.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import main.se450.interfaces.IObservable;
import main.se450.interfaces.IShape;
import main.se450.singletons.DisplayManager;
import main.se450.singletons.ShapeList;

/*
 * Name     : 
 * Depaul#  : 
 * Class    : SE 450
 * Project  : Final
 * Due Date : 03/13/2017
 *
 * class ShapeDisplay
 *
 */

public class ShapeDisplay extends JPanel implements IObservable
{
  	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ShapeDisplay()
	{
	}
	
	@Override
	public void validateTree()
	{
		super.validateTree();

		Dimension dimension = getSize();
		
		DisplayManager.getDisplayManager().setDisplaySize(dimension.width, dimension.height);
	}
	

	public void paint(Graphics graphics) 
  	{
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, DisplayManager.getDisplayManager().getWidth(), DisplayManager.getDisplayManager().getHeight());
		
		final ArrayList<IShape> iShapeList = ShapeList.getShapeList().getShapes();
		if (iShapeList != null)
		{
			Iterator<IShape> iiShapes = iShapeList.iterator();
			while (iiShapes.hasNext())
			{
				IShape iShape = iiShapes.next();
				if (iShape != null)
				{
					iShape.update();
					iShape.draw(graphics);
				}
			}
		}
    }  	

	@Override
	public void update() 
	{
		repaint();
	}
}
      