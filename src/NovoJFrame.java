
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class NovoJFrame extends javax.swing.JFrame {

    private PolygonOp fig;
    
	private int flag;
	private boolean isDrawed = false;
	private int x;
	private int y;
	private int width;
	private int height;
	private final Color COLOR_WHITE = new Color(255, 255, 255);
        private float escala;
        private ViewPolygon viewPolygon;
        private int transladoX;
        private int transladoY;
        
        @Override
    public void paint(Graphics g) 
    {
		Graphics2D g2 = (Graphics2D)g;
		if(isDrawed){
			g2.setColor(COLOR_WHITE);
                        g2.clearRect(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);
                        g2.fillRect(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);
			//g2.clearRect(x, y, width, height);
			//g2.fillRect(x, y, width, height);
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
    
    /**
     * Creates new form NovoJFrame
     */
    public NovoJFrame(ViewPolygon vp) {
        this.fig = vp.getPolygonOp();
        this.viewPolygon = vp;
        this.setName("Poligono");
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
          
    private String text; 
    public float getEscala(){
        
        return escala;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
