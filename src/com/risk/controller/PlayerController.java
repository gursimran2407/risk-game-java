package com.risk.controller;

import com.risk.gameplayrequirements.MapValidation;
import com.risk.model.GamePlayModel;
import com.risk.model.PlayerModel;
import com.risk.view.FortificationView;
import com.risk.view.ReinforcementView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * The player class in the controller package will facilitate the data flow into the
 * model object and update the view whenever the data is changed.
 *
 * @author Karan
 */

/* testing the change*/
public class PlayerController implements ActionListener, ItemListener {
    /**
     * the game play model
     */
    private GamePlayModel gamePlayModel;

    /**
     * The ReinforcementController view
     */
    private ReinforcementView reinforcementViewObj;

    /**
     * The Fortication view
     */
    private FortificationView forticationviewObj;

    /** The list of players */
    private ArrayList<PlayerModel> listOfPlayers = new ArrayList<>();

    /** The number of players */
    private int noOfPlayers;

    /** For validation */
    private MapValidation val = new MapValidation();


    /**
     * This is the method that is required if we implement the Action Listener. This method will perform the action
     * after listening to the action event set in the view.
     *
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public void itemStateChanged(ItemEvent itemEvent) {

    }

    /**
     * Constructor for initializing values and setting the screen visibility
     * @param gamePlayModel
     */
    public PlayerController(GamePlayModel gamePlayModel)
    {
        this.gamePlayModel = gamePlayModel;
        this.gamePlayModel.getConsoleText()
                .append("Initiating reinforcement for" + gamePlayModel.getGameMap().getPlayerTurn().getPlayerName());
        reinforcement();
    }

    /**
     * This method will call the reinforcement phase
     */
    private void reinforcement()
    {
        this.gamePlayModel.getConsoleText().setLength(0);
       //this.gamePlayModel.callObservers(); callObserver method to be declared in GamePlayModel
        this.gamePlayModel.getConsoleText().
        append("Initiating reinforcement for" + gamePlayModel.getGameMap().getPlayerTurn().getPlayerName());

        this.gamePlayModel.getGameMap().getPlayerTurn().setRemainingNumberOfArmies(this.gamePlayModel.numberOfCountries()
        + this.gamePlayModel.continentCovered(gamePlayModel.getGameMap().getPlayerTurn()));

        if(gamePlayModel.getGameMap().getPlayerTurn().getPlayerCards().size() > 0)
        {
            this.gamePlayModel.getConsoleText().append("Please fond the list of Cards: Reinforcement View \n");
            for(int i = 0; i< gamePlayModel.getGameMap().getPlayerTurn().getPlayerCards().size();i++)
            {
               this.gamePlayModel.getConsoleText().append(gamePlayModel.getGameMap().getPlayerTurn().getPlayerCards().get(i).getCardId()+ "\n");
            }
            this.gamePlayModel.getGameMap().getPlayerTurn().setShowReinforcementCard(true);
        }
        theReinforcementView = new ReinforcementView(this.gamePlayModel);
        theReinforcementView.setActionListener(this);
        theReinforcementView.setVisible(true);

        this.gamePlayModel.getGameMap().addObserver(theReinforcementView);
        this.gamePlayModel.addObserver(theReinforcementView);
        for(int i = 0; i< noOfPlayers; i++)
        {
            this.listOfPlayers.get(i).addObserver(this.theReinforcementView);
        }
    }

    /**
     * This method is called for fortification view
     */
}
