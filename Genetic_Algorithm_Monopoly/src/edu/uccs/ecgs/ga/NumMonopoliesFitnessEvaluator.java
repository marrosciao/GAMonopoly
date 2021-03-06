package edu.uccs.ecgs.ga;

import java.util.Vector;

/**
 * Compute fitness based on the number of monopolies a player owns. This
 * evaluator is based solely on the number of monopolies owned, and does not
 * include any information about monopolies which may be more highly valued.
 */
// TODO Maybe have an evaluator that also includes property value or strength.
public class NumMonopoliesFitnessEvaluator extends AbstractFitnessEvaluator {
  @Override
  public void evaluate(Vector<AbstractPlayer> players)
  {
    for (AbstractPlayer player : players) {
      // Compute the score for the most recent game
      int gameScore = player.getNumMonopolies();

      // Store the new fitness value
      player.addToFitness(gameScore);
    }
  }

  @Override
  public String getDirName()
  {
    return "num_monopolies";
  }
}
