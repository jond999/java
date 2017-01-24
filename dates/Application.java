
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Application
{	
	public static void main(String[] args)
	{
		Date data = new Date();
		
		Calendar cal = Calendar.getInstance();
		
		data = cal.getTime();
	
		cal.add(Calendar.YEAR, 1);
		
		Date dataMaisUmAno = cal.getTime();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		String dataFormatada = dateFormat.format(data);
		String dataMaisUmAnoFormatada = dateFormat.format(dataMaisUmAno);
		
		System.out.println(dataFormatada);
		System.out.println(dataMaisUmAnoFormatada);
	}
}
