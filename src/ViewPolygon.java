/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class ViewPolygon implements Pintar{

    private NovoJFrame mv;
    private CampoBotoes campoBotoes;
    private boolean isDrawed;
    private int oldX;
    private int oldY;
    private int oldWidth;
    private int oldHeight;
    private PolygonOp polygonOp;
    private PolygonOp polygonOpOriginal;
    private int[] xOriginal;
    private int[] yOriginal;
    private int nOriginal;
  
    
    
    public PolygonOp getPolygonOp(){
        return this.polygonOp;
    }
    public PolygonOp getPolygonOpOriginal(){
        return this.polygonOpOriginal;
    }
    
    public NovoJFrame getFrame(){
        return this.mv;
    }
    
    public void reset(){
        this.polygonOp.resetar(this.xOriginal, this.yOriginal, this.nOriginal);
    }
    public void startOriginal(PolygonOp p){
        this.xOriginal = new int[p.npoints];
        this.yOriginal = new int[p.npoints];
        for(int i = 0; i < p.npoints; i++){
            this.xOriginal[i] = p.xpoints[i];
            this.yOriginal[i] = p.ypoints[i];
        }
        this.nOriginal = p.npoints;
    }
    public ViewPolygon(PolygonOp polygonOp){
        this.polygonOp = polygonOp;
        this.startOriginal(polygonOp);
        this.isDrawed = false;
    }
    
    @Override
    public void draw(PolygonOp polygonOp) {
        if(!isDrawed){
            initiateView();
            isDrawed = true;
            this.atualizarCaixa(polygonOp);
	}
        
        this.mv.atualizar(oldX, oldY, oldWidth, oldHeight);
        this.atualizarCaixa(polygonOp);
        this.mv.pintarRetangulo(polygonOp);
    }
    
    private void initiateView(){
        this.mv = new NovoJFrame(this);
        this.campoBotoes = new CampoBotoes(this);
    }
    private void atualizarCaixa(PolygonOp polygonOp){
        this.oldX =polygonOp.getBounds().x;
        this.oldY = polygonOp.getBounds().y;
        this.oldWidth = polygonOp.getBounds().width;
        this.oldHeight = polygonOp.getBounds().height;
    }
    
}
