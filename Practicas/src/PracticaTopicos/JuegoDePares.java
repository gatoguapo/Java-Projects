package PracticaTopicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;


public class JuegoDePares extends JFrame implements ActionListener {

    private JPanel panelComboButton;
    private JPanel panelGrid;
    private JComboBox<String> comboLevels;
    private JButton startButton;
    private ArrayList<String> cards;
    private JButton [] cardButtons;
    private String firstCard;
    private int totalClicks;
    private JButton prevButton;

    private final int PUT_BACK_CARD = 2;
    private final int FLIP_CARD = 1;
    
    public static void main (String [] args) {
    	new JuegoDePares();
    }
    
    public JuegoDePares() {
        initAll();
        makeInterface();
        makeListeners();
    }

    private void makeInterface() {
        setSize( 1200, 800 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setResizable( false );

        panelComboButton.add( comboLevels );
        panelComboButton.add( startButton );

        panelGrid.setLayout(new GridLayout(0, 4, 5, 5));

        add( panelComboButton, BorderLayout.NORTH );
        setVisible( true );
    }

    private void makeListeners() {
        if ( cardButtons == null ) {
            startButton.addActionListener( this );
            return;
        }

        for(JButton cardButton: cardButtons) {
            cardButton.addActionListener( this );
        }

    }

    private void addButtonsToGrid() {
        JButton newButton;
        for (int i = 0; i < cards.size(); i++) {
            newButton = new JButton(cards.get(i));
            cardButtons[i] = newButton;
            panelGrid.add( newButton );
        }
        add( panelGrid );
        validate();

        for (JButton cardButton : cardButtons) {
            changeButtonImage( cardButton, PUT_BACK_CARD );
        }
        makeListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentBotton = (JButton) e.getSource();

        if ( currentBotton == prevButton ) return; // Si le doy click a la misma carta

        if ( currentBotton == startButton ) {

            if ( !Objects.equals(comboLevels.getSelectedItem(), "Seleccione")) {
                cards = new Card(comboLevels.getSelectedItem().toString()).getCards();
                cardButtons = new JButton[cards.size()];
                addButtonsToGrid();
                comboLevels.setEnabled( false );
                startButton.setEnabled( false );
            }
            return;
        }

        changeButtonImage( currentBotton, FLIP_CARD );

        currentBotton.update( currentBotton.getGraphics() );
        if ( totalClicks == 1 ) {

            String secondCard = currentBotton.getText();
            if ( firstCard.equals(secondCard) && currentBotton != prevButton ) {
                currentBotton.setEnabled( false );
                prevButton.setEnabled( false );
                keepImageVisibility( currentBotton );
                keepImageVisibility( prevButton );
            } else {
                sleepThread();
                changeButtonImage( currentBotton, PUT_BACK_CARD );
                changeButtonImage( prevButton, PUT_BACK_CARD );
            }
            prevButton = null;
            totalClicks = 0;
            if ( checkButtons() ) {
                Rutinas.Mensaje("EL JUEGO HA TERMINADO");
            }
            return;

        }
        prevButton = currentBotton;
        firstCard = currentBotton.getText();
        totalClicks++;

    }

    private void changeButtonImage(JButton buttonToChange, int operation) {
        String iconImagePath = ( operation == 1 )
                               ? "images/" + buttonToChange.getText()
                               : "images/0.png";

        buttonToChange.setIcon(
                Rutinas.AjustarImagen(
                        iconImagePath,
                        buttonToChange.getWidth(),
                        buttonToChange.getHeight()
                )
        );

    }

    private void keepImageVisibility(JButton buttonToChange) {
        buttonToChange.setDisabledIcon(
                Rutinas.AjustarImagen(
                        "images/" + buttonToChange.getText(),
                        buttonToChange.getWidth(),
                        buttonToChange.getHeight()
                )
        );
    }
    private boolean checkButtons() {
        int cantidadDeshabilitados = 0;
        for (JButton cardButton: cardButtons) {
            if (  !cardButton.isEnabled() ) {
                cantidadDeshabilitados++;
            }
        }

        return cantidadDeshabilitados == cardButtons.length;
    }

    private void initAll() {
        panelComboButton  = new JPanel();
        panelGrid   = new JPanel();
        startButton = new JButton("Start");
        comboLevels = new JComboBox<>(
                new String[]{"Seleccione", "Basico", "Medio", "Avanzado"}
        );
        totalClicks = 0;
    }

    private void sleepThread() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {

        }
    }

}
