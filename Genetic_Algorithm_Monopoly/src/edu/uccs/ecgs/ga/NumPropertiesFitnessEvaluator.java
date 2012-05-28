package edu.uccs.ecgs.ga;

/**
 * Compute fitness based on the number of properties a player owns. This
 * evaluator is based solely on the number of properties owned, and does not
 * include any information about properties which may be more highly valued.
 */
// TODO Maybe have an evaluator that also includes property value or strength.
public class NumPropertiesFitnessEvaluator extends AbstractFitnessEvaluator {
  @Override
  public void evaluate(AbstractPlayer player) {
    // Compute the score for the most recent game
    int gameScore = player.getNumProperties();

    // Store the new fitness value
    player.addToFitness(gameScore);
  }
}
