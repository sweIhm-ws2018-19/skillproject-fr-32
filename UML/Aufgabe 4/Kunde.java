public abstract class Kunde{
	
	private Konto[] konto;

	public Kunde(Konto Hauptkonto)
	{
		konto[0] = Hauptkonto; //Hauptkonto da gelten muss 1..*
	}
	

}