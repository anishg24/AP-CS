package Graphic;

import org.w3c.dom.css.Rect;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class ArrowKeys extends Canvas implements KeyListener
{
	public String message;
	int[] array;
	Rectangle rect;
	int x = 100;
	int y = 100;
	int change_by_x = 10;
	int change_by_y = 10;

	public ArrowKeys()
	{
		addKeyListener(this);
		message = "";
		
		array = new int[5];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = i;
			message += array[i] + "    ";
		}
	
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		int window_width = JFrame.getFrames()[0].getWidth();
		int window_height = JFrame.getFrames()[0].getHeight();

		g2.setColor(Color.black);
		g2.drawRect(x, y, 10 ,10);

		if (x > window_width) g2.drawRect((x - window_width), y, 10 , 10);
		else if (x < 0) g2.drawRect((x + window_width), y, 10 ,10);

		if (y > window_height) g2.drawRect(x, (y - window_height), 10 ,10);
		else if (y < 0) g2.drawRect(x, (y + window_height), 10 ,10);

//		else g2.drawRect(x, y, 10 ,10);
	}

	public static void main(String[] args)
	{
		JFrame win = new JFrame("Pressing Arrows");
		win.setSize(1000,800);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.add( new ArrowKeys() );
		win.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if ( e.getKeyCode() == 38) y -= change_by_y;
		else if (e.getKeyCode() == 40) y += change_by_y;
		else if (e.getKeyCode() == 37) x -= change_by_x;
		else if (e.getKeyCode() == 39) x += change_by_x;
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		if ( e.getKeyCode() == 38)
		{
//			message += "I pressed up in KeyReleased. ";
		}
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		if ( e.getKeyCode() == 38)
		{
//			message += "I pressed up in keyTyped";
		}
		repaint();
		
	}
}
