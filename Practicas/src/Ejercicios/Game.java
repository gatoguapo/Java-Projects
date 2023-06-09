package Ejercicios;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Game {
    ArrayList<Card> oro = new ArrayList<Card>();
    ArrayList<Card> copas = new ArrayList<Card>();
    ArrayList<Card> espadas = new ArrayList<Card>();
    ArrayList<Card> bastos = new ArrayList<Card>();
    int[] values = {2, 3, 4, 5, 6, 7, 10, 11, 12, 13};

    Player player1 = new Player("Jugador 1");
    Player player2 = new Player("Jugador 2");
    Player player3 = new Player("Jugador 3");
    Player player4 = new Player("Jugador 4");

    public Game() {
        System.out.println("generó");
    }

    public void distributeCards() {
        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player1.addCard(randomCard);
        }

        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player2.addCard(randomCard);
        }

        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player3.addCard(randomCard);
        }

        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player4.addCard(randomCard);
        }
    }

    public void generateCards() {
        // oro
        for(int i=0; i<10; i++) {
            String cardName = "O" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.oro.add(card);
        }

        // copas
        for(int i=0; i<10; i++) {
            String cardName = "C" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.copas.add(card);
        }

        // espadas
        for(int i=0; i<10; i++) {
            String cardName = "E" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.espadas.add(card);
        }

        // bastos
        for(int i=0; i<10; i++) {
            String cardName = "B" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.bastos.add(card);
        }
    }

    public Card getRandomCard() {
        double num1 = Math.random();
        double num2 = Math.random();

        if(num1 >= 0.0d && num1 < 0.25d) { // oro
            int cardValue = this.getCardValue(num2);
            String cardName = "O" + cardValue;
            Card cardToGive = this.getCardInArray(cardName, this.oro);
            return cardToGive;
        }

        if (num1 >= 0.25d && num1 < 0.50d) { // copas
            int cardValue = this.getCardValue(num2);
            String cardName = "C" + cardValue ;
            Card cardToGive = this.getCardInArray(cardName, this.copas);
            return cardToGive;
        }

        if (num1 >= 0.50d && num1 < 0.75d) { // espadas
            int cardValue = this.getCardValue(num2);
            String cardName = "E" + cardValue;
            Card cardToGive = this.getCardInArray(cardName, this.espadas);
            return cardToGive;
        }

        if (num1 >= 0.75d && num1 < 1.0d) { // bastos
            int cardValue = this.getCardValue(num2);
            String cardName = "B" + cardValue;
            Card cardToGive = this.getCardInArray(cardName, this.bastos);
            return cardToGive;
        }

        return null;

    }

    private int getCardValue(double num) {
        if (num > 0.0d && num < 0.1d) return 2;
        if (num >= 0.1d && num < 0.2d) return 3;
        if (num >= 0.2d && num < 0.3d) return 4;
        if (num >= 0.3d && num < 0.4d) return 5;
        if (num >= 0.4d && num < 0.5d) return 6;
        if (num >= 0.5d && num < 0.6d) return 7;
        if (num >= 0.6d && num < 0.7d) return 10;
        if (num >= 0.7d && num < 0.8d) return 11;
        if (num >= 0.8d && num < 0.9d) return 12;
        return 13;
    }

    private JLabel createCardImage(String cardName) {
        try {
            String currentPath = new java.io.File(".").getCanonicalPath() + "/src/barajita/";
            JLabel image = new JLabel(new ImageIcon(currentPath + "images/" + cardName + ".jpg"));

            return image;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    private Card getCardInArray(String cardName, ArrayList<Card> cards) {
        Card cardFound = null;
        for(int i=0; i<cards.size(); i++) {
            if (cards.get(i) == null) continue;

            String currentCardName = cards.get(i).getName();
            if (cardName.equals(currentCardName)) {
                cardFound = cards.get(i);
                cards.set(i, null);
            }
        }

        return cardFound;
    }

    public void recordWhoWins(ArrayList<Card> cardsInTable) {
//        ArrayList<Card> repeatedCards = getRepeatedValues(cardsInTable);
//        System.out.println("CARTAS REPETIDAS");
//        for (int i = 0; i < repeatedCards.size(); i++) {
//            System.out.println(repeatedCards.get(i).getValue());
//        }
//        System.out.println();

        int bigger = cardsInTable.get(0).getValue();
        int position = 0;


        for(int i=0; i<cardsInTable.size(); i++) {
            if (bigger < cardsInTable.get(i).getValue()) {
                bigger = cardsInTable.get(i).getValue();
                position = i;
            }
        }

        switch (position) {
            case 0:
                this.player1.upgradeVictoriesCount();
                break;
            case 1:
                this.player2.upgradeVictoriesCount();
                break;
            case 2:
                this.player3.upgradeVictoriesCount();
                break;
            case 3:
                this.player4.upgradeVictoriesCount();
                break;
        }
    }

    public Player getWinner() {
        int biggerNumOfVictories = 0;
        Player winner = null;

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        int victoryRepeated = this.isTie(players);

        for (int i = 0; i < 4; i++) {
            if (biggerNumOfVictories < players.get(i).getVictories()) {
                biggerNumOfVictories = players.get(i).getVictories();
                winner = players.get(i);
            }
        }

        if (victoryRepeated == winner.getVictories()) return null;

        return winner;
    }

    private int isTie(ArrayList<Player> players) {
        ArrayList<Integer> repeatedScores = new ArrayList<Integer>();

        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            for (int j = 0; j < players.size(); j++) {
                if (currentPlayer.getName().equals(players.get(j).getName())) continue;

                if (currentPlayer.getVictories() == players.get(j).getVictories()) {
                    repeatedScores.add(currentPlayer.getVictories());
                }
            }
        }

        Collections.sort(repeatedScores);

        return repeatedScores.size() == 0 ? -1 : repeatedScores.get(repeatedScores.size() - 1);
    }

    private ArrayList<Card> getRepeatedValues(ArrayList<Card> cards) {
        ArrayList<RepeatedCard> repeatedCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            repeatedCards.add(new RepeatedCard(cards.get(i)));
        }


        for (int i = 0; i < repeatedCards.size(); i++) {
            RepeatedCard currentCard = repeatedCards.get(i);

            if (i == cards.size()) break;

            for (int j = i + 1; j < cards.size(); j++) {
                if (currentCard.card.getValue() == repeatedCards.get(j).card.getValue()) {
                    currentCard.makeRepeated();
                    repeatedCards.get(j).makeRepeated();
                    break;
                }
            }
        }

        ArrayList<Card> repeatedCardsFounded = new ArrayList<>();

        for (int i = 0; i < repeatedCards.size(); i++) {
            if (repeatedCards.get(i).getIsRepeated()) {
                repeatedCardsFounded.add(repeatedCards.get(i).card);
            }
        }

        return repeatedCardsFounded;
    }

}

class RepeatedCard {
    Card card;
    private boolean isRepeated;

    public RepeatedCard(Card card) {
        this.card = card;
        this.isRepeated = false;
    }

    public void makeRepeated() {
        this.isRepeated = true;
    }

    public boolean getIsRepeated() {
        return this.isRepeated;
    }
}