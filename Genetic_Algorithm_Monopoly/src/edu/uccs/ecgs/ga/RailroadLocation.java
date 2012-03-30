package edu.uccs.ecgs.ga;

import java.util.Properties;

/**
 * Represents a railroad in the game of monopoly.
 */
public class RailroadLocation extends Location {

  final private PropertyGroups group = PropertyGroups.RAILROADS;
  final private int rent;
  private int cost;

  public RailroadLocation(String key2, Properties properties) {
    super(key2, properties);

    cost = getInteger(key + ".cost", properties);
    rent = getInteger(key + ".rent.one_railroad", properties);

    _string = "Name              : " + name + "\n  index           : " + index
        + "\n  group           : " + group + "\n  type            : " + type
        + "\n  cost            : " + cost + "\n  rent with 1 railroad: " + rent
        + "\n  rent with 2 railroads: " + (2 * rent) + "\n  rent with 3 railroads: "
        + (4 * rent) + "\n  rent with 4 railroads: " + (8 * rent);
  }

  @Override
  public int getCost() {
    return cost;
  }

  @Override
  public int getRent(int diceRoll) {
    assert !isMortgaged() : "Location is mortgaged in getRent";
    int result = 0;
    double multiplier = Math.pow(2.0, owner.getNumRailroads() - 1);
    this.setRentMultiple((int) multiplier);

    result = rent * multiple;

    resetMultiple();
    return result;
  }
  
  @Override
  public PropertyGroups getGroup() {
    return group;
  }

  @Override
  public void setMortgaged() {
    setMortgaged(true);
  }

  @Override
  public void setMortgaged(boolean b) {
    isMortgaged = b;
  }

  @Override
  public String toString() {
    return super.toString() + (isMortgaged() ? " (mortgaged)" : "");
  }
}
