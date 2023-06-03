package Ejercicios;

public class Baraja {

	private Cartas[] baraja;{
	baraja = new Cartas [40];
	for (int c=0;c<40;c++)
	{
		if (c<10) {
			baraja[c]=new Espadas (6> c && c < 9? (byte)(c+4):(byte)(c+1));
		} else if (c<20){
			baraja[c]=new Bastos (16> c && c < 19? (byte)(c-6):(byte)(c-9));
		} else if (c<30){
			baraja[c]=new Oros (26> c && c < 29? (byte)(c-16):(byte)(c-19));
		} else  {
			baraja[c]=new Bastos (36> c && c < 39? (byte)(c-26):(byte)(c-29));
		} 
	}
	
	private void siguienteCarta () {
		for (int c=0;c<40;c++) {
			c=+1;
		}
	}
	
  }
}
