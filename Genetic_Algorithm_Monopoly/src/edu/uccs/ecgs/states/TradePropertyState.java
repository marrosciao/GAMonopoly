package edu.uccs.ecgs.states;

import edu.uccs.ecgs.Actions;
import edu.uccs.ecgs.Monopoly;

public class TradePropertyState extends PlayerState {

  @Override
  protected void enter() {
    super.enter();
  }

  @Override
  public PlayerState processEvent (Events event, Monopoly game) {
    logger.info("Player " + player.playerIndex + "; state " + this.getClass().getSimpleName() +
        "; event " + event.name());
    switch (event) {
    
    case TRADE_DECISION_EVENT:
      player.nextAction = Actions.DONE;
      inactiveState.enter();
      return inactiveState;
      
    default:
      String msg = "Unexpected event " + event;
      throw new IllegalArgumentException(msg);
    }
  }

}
