import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;



public class TesteJava8 implements Moveable {

	public static void main(String[] args) {
		
		System.out.println("Site de tutorial , varios exemplos:");
		System.out.println("https://howtodoinjava.com/java-8-tutorial/");
		

		//java 7		
//		System.out.println("################  Java 7     #####################\n");		
//		Comparator<String> c7 =new Comparator<String>() {
//		     @Override
//		     public int compare(String o1, String o2){
//		           return o1.compareTo(o2);
//		      }
//		};
//		
//		Collections.sort(cidades, c7);


//		for (String cidade : cidades) {
//			System.out.println(cidade);
//		}
//
//		Runnable r = new Runnable() {
//		     public void run() {
//		          System.out.println("JAVA 7 : Thread execuntado!");
//		     }
//		};
//		new Thread(r).start();		

		
		//java 8
		System.out.println("################  Java 8     #####################\n");
		imprimeDefault();
		
		TesteJava8.printDates();
		System.out.println("\n");
		
		System.out.println("Agora da pra chamar metodos staticos da classe diretamente");
		printDates();
		System.out.println("\n");

		imprimiListas();
		System.out.println("\n");

		
		base64();
		System.out.println("\n");
		
//		Runnable r = () -> System.out.println("Thread com função lambda!");
//		new Thread(r).start();

		new Thread( () -> System.out.println("JAVA 8 : Thread execuntado!") ).start();
		
	}
	
	private static void base64() {
		System.out.println("Base 64");
		
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = "username:password";
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		
		System.out.println("encodedString = "+encodedString);
	}

	 
	
	private static void imprimiListas() {

		List<String> cidades = new ArrayList<String>();
		cidades.add("São Paulo");
		cidades.add("Rio de Janeiro");
		cidades.add("Uberlandia");
		cidades.add("Ubatuba");
		cidades.add("Rio Claro");
		cidades.add("Araçatuba");		
		
		Comparator<String> c8 = (s1, s2) -> s1.compareTo(s2);
		cidades.sort(c8);
		cidades.forEach(cidade -> System.out.println(cidade));
		

		System.out.println("Usando o Stream para rodar a lista, filtrar cidades com tamanho <10 e imprimi-las.");
		cidades.stream().filter(s -> s.length() < 10).forEach(s -> System.out.println(s));
		System.out.println("\n");
		//ou
		System.out.println("Imprimi tamanho maior q 10");
		cidades.stream().filter(s -> s.length() > 10).forEach(System.out::println);
		System.out.println("\n");		
	}
	
	private static void imprimeDefault(){
		System.out.println("executando metodo default move da interface");
		new TesteJava8().move();
		System.out.println("\n");		
	}
	
	private static void printDates() {
		System.out.println("Exemplos de data nova java.time");
		LocalDate localDate = LocalDate.now();
		System.out.println("offsetDateTime= "+localDate);
		
		LocalTime localTime = LocalTime.of(12, 20);
		System.out.println("offsetDateTime= "+localTime);

		LocalDateTime localDateTime = LocalDateTime.now(); 
		System.out.println("offsetDateTime= "+localDateTime);		

		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println("offsetDateTime= "+offsetDateTime);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));		
		System.out.println("zonedDateTime= "+zonedDateTime);
		
	}

}


