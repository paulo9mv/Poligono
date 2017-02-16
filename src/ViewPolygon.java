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
    private boolean isDrawed;
    private int oldX;
    private int oldY;
    private int oldWidth;
    private int oldHeight;
    private PolygonOp polygonOp;
    
    public PolygonOp getPolygonOp(){
        return polygonOp;
    }
    
    public NovoJFrame getFrame(){
        return mv;
    }
    
    public ViewPolygon(PolygonOp polygonOp){
        this.polygonOp = polygonOp;
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
    }
    private void atualizarCaixa(PolygonOp polygonOp){
        this.oldX =polygonOp.getBounds().x;
        this.oldY = polygonOp.getBounds().y;
        this.oldWidth = polygonOp.getBounds().width;
        this.oldHeight = polygonOp.getBounds().height;
    }
    
}
