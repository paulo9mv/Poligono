import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class GravaTexto {
	
	private String quebraLinha = System.getProperty("line.separator");
	private Date data = new Date();
	
	public void grava(String text) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("C:\\Users\\Paulo Vitor\\Desktop\\meutextaotrabalhado.txt", true);
			text = calendario()+ quebraLinha  + text + quebraLinha;
			fw.write(text);
		} catch (IOException e) {
			System.out.printf("Erro no arquivo.");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Texto vazio.");
		} catch(NullPointerException e){
			System.out.println("Texto vazio nulo.");
		}
		
		finally{
			try {
				fw.write(quebraLinha);
				fw.close();
				System.out.printf("Fechou");
			} catch (IOException e) {
				System.out.println("Nao existe texto BRTT.");
				e.printStackTrace();
			}
		}
	}
	public String calendario(){
		/*Calendar calendar = Calendar.getInstance();
		int dia = Calendar.DAY_OF_MONTH;
		int mes = Calendar.MONTH;
		int ano = Calendar.YEAR;
		int hora = Calendar.HOUR_OF_DAY;
		int min = Calendar.MINUTE;
		int seg = Calendar.SECOND;
		int mil = Calendar.MILLISECOND;
		System.out.printf("%d\n\n", dia);
		String saida = "- "+dia+"/"+mes+"/"+ano+" "+hora+":"+min+":"+seg+":"+mil;
		return saida;*/
		return this.data.toString();
	}
}

