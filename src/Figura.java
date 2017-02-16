/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author aluno
 */
abstract class Figura
{
	protected int pontosx[];
	protected int pontosy[];
	protected int quantPontos;
	protected int cor[];
	protected int maxPontos;
	
	
	public abstract int[][] getPontos();
	public abstract void setCor(int cor[]);
	public abstract int[] getCor();
	public abstract void addPonto(int x,int y);
	public abstract void remPonto(int x,int y);
	
	
	public Figura(int maxPontos)
	{
		this.quantPontos = 0;
		this.maxPontos = maxPontos;
		this.pontosx = new int[maxPontos];
		this.pontosy = new int[maxPontos];
	}
	public int getQuantPontos()
	{
		return this.quantPontos;
	}
	public int getMaxPontos()
	{
		return this.maxPontos;
	}
	public void printPontos()
	{
		for (int i=0;i<this.quantPontos;i++)
		{
			System.out.println(this.pontosx[i]+","+this.pontosy[i]);
		}
		System.out.println();
	}
	protected boolean isFull()
	{
		return this.quantPontos==this.maxPontos;
	}
}