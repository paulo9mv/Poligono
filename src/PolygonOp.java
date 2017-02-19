import java.awt.Polygon;


@SuppressWarnings("serial")
public class PolygonOp extends Polygon{
	
	private int [] cor;

	public PolygonOp(){
		super();
	}
        public void resetar(int xPoints[], int yPoints[], int nPoints){
            for(int i = 0; i < nPoints; i++){
            this.xpoints[i] = xPoints[i];
            this.ypoints[i] = yPoints[i];
        }
        this.npoints = nPoints;
            
            this.invalidate();
        }
        
	public PolygonOp(int xPoints[], int yPoints[], int nPoints){
		super(xPoints, yPoints, nPoints);
	}
        
        public void alterarEscalaY(float fatorEscala){
		for(int i = 1; i < this.npoints; i++){
			alterarPontoY(i, fatorEscala);
		}
	}
        private void alterarPontoY(int ponto, float fatorEscala){
		this.ypoints[ponto] -= this.ypoints[0];			
		this.ypoints[ponto] *= fatorEscala;			
		this.ypoints[ponto] += this.ypoints[0];		
		this.invalidate();
	}
        
        public void alterarEscalaX(float fatorEscala){
            for(int i = 1; i < this.npoints; i++){
			alterarPontoX(i, fatorEscala);
		}
        }
	public void alterarEscala(float fatorEscala){
		for(int i = 1; i < this.npoints; i++){
			alterarPonto(i, fatorEscala);
		}
	}
        private void alterarPontoX(int ponto, float fatorEscala){
		this.xpoints[ponto] -= this.xpoints[0];
		
		
		this.xpoints[ponto] *= fatorEscala;
		
		
		this.xpoints[ponto] += this.xpoints[0];
		
		this.invalidate();
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
