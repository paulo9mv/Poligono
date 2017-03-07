import java.awt.Polygon;

/**Classe responsável por escalar (aumentar/diminuir) um objeto Polygon.
 * 
 * @author Paulo Vitor, Helio Junior
 * 
 */

@SuppressWarnings("serial")
public class PolygonOp extends Polygon{
	
	private int [] cor;
 
        /**
         * Construtor sem parâmetros, instancia o objeto por meio de super().
         */
	public PolygonOp(){
		super();
	}
        /**
         * Construtor que inicializa a cor.
         * @param cor Define uma cor para o PolygonOp, por meio de um vetor no formato RGB.
         */
        public PolygonOp(int [] cor){
            super();
            this.cor = cor;
        }
        /**
         * Reseta o PolygonOp para os parâmetros passados.
         * @param xPoints Altera o vetor de pontos X do objeto atual.
         * @param yPoints Altera o vetor de pontos Y do objeto atual.
         * @param nPoints Altera a quantidade de pontos.
         
         */
        public void resetar(int xPoints[], int yPoints[], int nPoints) throws ArrayIndexOutOfBoundsException, NegativeArraySizeException{
            for(int i = 0; i < nPoints; i++){
                this.xpoints[i] = xPoints[i];
                this.ypoints[i] = yPoints[i];
            }
            this.npoints = nPoints;            
            this.invalidate();
        }
        /**
         * Instancia o Polygon com todos seus atributos.
         * @param xPoints Vetor de X pontos.
         * @param yPoints Vetor de Y pontos.
         * @param nPoints Quantidade total de pontos.
         */
	public PolygonOp(int xPoints[], int yPoints[], int nPoints){
		super(xPoints, yPoints, nPoints);
	}    
        /**
         * Altera o PolygonOp na escala Y.
         * @param fatorEscala Fator multiplicador para a escala.
         */
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
        /**
         * Altera o PolygonOp na escala X.
         * @param fatorEscala Fator multiplicador para a escala.
         */
        public void alterarEscalaX(float fatorEscala){
            for(int i = 1; i < this.npoints; i++){
			alterarPontoX(i, fatorEscala);
		}
        }
        /**
         * Altera o PolygonOp em ambas as escalas.
         * @param fatorEscala Fator multiplicador para a escala.
         */
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
        /**
         * Retorna uma matriz de nPoints x 2.
         * @return Matriz contendo todos os pontos em formato de pares.
         */
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
        /**
         * Retorna a cor.
         * @return Vetor no formato RGB.
         */
	public int[] getCor(){
		return this.cor;
	}
        /**
         * Seta a cor do Polygon.
         * @param cor Vetor no formato RGB.
         */
	public void setCor(int []cor){
		this.cor = cor;
	}
	
}
