package PracticaTopicos;

/*
Alumno: Jesus Manuel Gastelum Chaparro
Docente: Clemente Garcia Gerardo
Materia: Topicos avanzados de programacion
Trabajo: Juego de pares
Fecha: 15/09/22

NOTA: MIS IMAGENES SON EN PNG
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Card {

    private ArrayList<String> cards;

    public Card(String mode) {
        cards = new ArrayList<>();
        makeDeck( mode );
    }

    private void makeDeck(String mode) {

        int numberOfCards = switch ( mode ) {
            case "Medio": yield 6;
            case "Avanzado": yield 12;
            default: yield 4; // "basico"
        };

        Random random = new Random();
        String newCard;
        int i = 0;
        while( i < numberOfCards ) {
            newCard = random.nextInt(52 ) + 1 + ".png";
            if ( !cards.contains( newCard ) ) {
                for (int j = 0; j < 2; j++) {
                    cards.add( newCard );
                }
                i++;
            }
        }

        Collections.shuffle( cards );
        // cards.forEach( System.out::println );
    }
    public ArrayList<String> getCards() {
        return cards;
    }
}