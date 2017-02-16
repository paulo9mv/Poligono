
public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.out.printf("Hello world!\n");
		PolygonOp polygonOp = new PolygonOp();
		
		polygonOp.addPoint(0, 0);
		polygonOp.addPoint(100, 0);
                polygonOp.addPoint(20,40);
		polygonOp.addPoint(0, 100);
                
                
		
		int [] cor = new int [3];
		cor[0] = 0;
		cor[1] = 20;
		cor[2] = 80;
		
		polygonOp.setCor(cor);
		polygonOp.translate(30, 30);
                
                ViewPolygon vp = new ViewPolygon(polygonOp);
                vp.draw(polygonOp);
                
        }
}

