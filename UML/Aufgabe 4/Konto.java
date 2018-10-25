public class Konto{

	private String bezeichnung;
	private Kunde[] zeichnungsberechtigter;
	
	public GeldBetrag saldo(){
		return GeldBetrag;
	}

	public Konto(Kunde Hauptzeichnungsberechtigter)
	{
		zeichnungsberechtigter[0] = Hauptzeichnungsberechtigter; //Hauptbesitzer vom Konto da gelten muss 1..*

	}
	
	public void einzahlen(GeldBetrag betrag){
	
	}
	
}