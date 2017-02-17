import java.awt.Polygon;


@SuppressWarnings("serial")
public class PolygonOp extends Polygon{
	
	private int [] cor;
      

	public PolygonOp(){
		super();
	}
	public PolygonOp(int xPoints[], int yPoints[], int nPoints){
		super(xPoints, yPoints, nPoints);
	}
	public void alterarEscala(float fatorEscala){
		for(int i = 1; i < this.npoints; i++){
			alterarPonto(i, fatorEscala);
		}
	}
	private void alterarPonto(int ponto, float fatorEscala){
		this.xpoints[ponto] -= this.xpoints[0];
		this.ypoints[ponto] -= this.xpoints[0];
		
		this.xpoints[ponto] *= fatorEscala;
		this.ypoints[ponto] *= fatorEscala;
		
		this.xpoints[ponto] += this.xpoints[0];
		this.ypoints[ponto] += this.xpoints[0];
		this.invalidate();
	}
	
	public int[][] getPontos(){
		int pontos[][] = new int[this.npoints][2];
		int j = 0;
		
		for(int i = 0; i < this.npoints ; i++){
			pontos[i][j] = this.xpoints[i];
			j = 1;
			pontos[i][j] = this.ypoints[i];
			j = 0;
		}
		return pontos;
	}
	public int[] getCor(){
		return this.cor;
	}
	public void setCor(int []cor){
		this.cor = cor;
	}
	
}
