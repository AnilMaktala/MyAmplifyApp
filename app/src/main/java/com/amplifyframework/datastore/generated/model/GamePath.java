package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the Game type in your schema. */
public final class GamePath extends ModelPath<Game> {
  private TeamPath homeTeam;
  private TeamPath awayTeam;
  private ActivityPath activities;
  GamePath(@NonNull String name, @NonNull Boolean isCollection, @Nullable PropertyPath parent) {
    super(name, isCollection, parent, Game.class);
  }
  
  public synchronized TeamPath getHomeTeam() {
    if (homeTeam == null) {
      homeTeam = new TeamPath("homeTeam", false, this);
    }
    return homeTeam;
  }
  
  public synchronized TeamPath getAwayTeam() {
    if (awayTeam == null) {
      awayTeam = new TeamPath("awayTeam", false, this);
    }
    return awayTeam;
  }
  
  public synchronized ActivityPath getActivities() {
    if (activities == null) {
      activities = new ActivityPath("activities", true, this);
    }
    return activities;
  }
}
