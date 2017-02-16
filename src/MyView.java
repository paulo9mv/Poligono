/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyView extends JFrame
{
	private PolygonOp fig;
	private int flag;
	private boolean isDrawed = false;
	private int x;
	private int y;
	private int width;
	private int height;
	private final Color COLOR_WHITE = new Color(255, 255, 255);
       
	public MyView(String nome)
	{
		super();
		this.flag = 0;
		int width=500,height=500;
		this.setSize(width,height);
		this.setTitle(nome);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
    public void paint(Graphics g) 
    {
		Graphics2D g2 = (Graphics2D)g;
		if(isDrawed){
			g2.setColor(COLOR_WHITE);
			g2.clearRect(x, y, width, height);
			g2.fillRect(x, y, width, height);
		}
		
		int cor[] = this.fig.getCor();
		g2.setColor(new Color(cor[0],cor[1],cor[2]));
		int pontos[][]=this.fig.getPontos();
		if (flag==0)
		{
			Polygon p = new Polygon();
			for (int j=0;j<pontos.length;j++)
			{
				p.addPoint(pontos[j][1],pontos[j][0]);
			}
			p.addPoint(pontos[0][1],pontos[0][0]);
			g2.fillPolygon(p);
		}
		else
		{
			int width = Math.abs(pontos[0][0]-pontos[1][0]);
			int height = Math.abs(pontos[0][1]-pontos[1][1]);
			g2.fillOval(pontos[0][0],pontos[0][1],width,height);
		}
		isDrawed = true;
    }
	
	public void atualizar(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void pintarRetangulo(PolygonOp fig)
	{
		this.flag = 0;
		this.fig = fig;
		this.repaint();
	}
	
	public void pintarCirculo(PolygonOp fig)
	{
		this.flag = 1;
		this.fig = fig;
		this.repaint();
	}

    
}