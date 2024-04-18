package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.HasOne;
import com.amplifyframework.core.model.ModelReference;
import com.amplifyframework.core.model.LoadedModelReferenceImpl;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.ModelList;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Game type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Games", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admin" }, provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
}, hasLazySupport = true)
public final class Game implements Model {
  public static final GamePath rootPath = new GamePath("root", false, null);
  public static final QueryField ID = field("Game", "id");
  public static final QueryField TIME = field("Game", "time");
  public static final QueryField LOCATION = field("Game", "location");
  public static final QueryField CONTENT = field("Game", "content");
  public static final QueryField HOME_SCORE = field("Game", "homeScore");
  public static final QueryField AWAY_SCORE = field("Game", "awayScore");
  public static final QueryField GAME_HOME_TEAM_ID = field("Game", "gameHomeTeamId");
  public static final QueryField GAME_AWAY_TEAM_ID = field("Game", "gameAwayTeamId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime time;
  private final @ModelField(targetType="String") String location;
  private final @ModelField(targetType="String") String content;
  private final @ModelField(targetType="Team") @HasOne(associatedWith = "id", targetNames = {"gameHomeTeamId"}, type = Team.class) ModelReference<Team> homeTeam = null;
  private final @ModelField(targetType="Team") @HasOne(associatedWith = "id", targetNames = {"gameAwayTeamId"}, type = Team.class) ModelReference<Team> awayTeam = null;
  private final @ModelField(targetType="Int", isRequired = true) Integer homeScore;
  private final @ModelField(targetType="Int", isRequired = true) Integer awayScore;
  private final @ModelField(targetType="Activity") @HasMany(associatedWith = "gameActivitiesId", type = Activity.class) ModelList<Activity> activities = null;
  private final @ModelField(targetType="ID") String gameHomeTeamId;
  private final @ModelField(targetType="ID") String gameAwayTeamId;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public Temporal.DateTime getTime() {
      return time;
  }
  
  public String getLocation() {
      return location;
  }
  
  public String getContent() {
      return content;
  }
  
  public ModelReference<Team> getHomeTeam() {
      return homeTeam;
  }
  
  public ModelReference<Team> getAwayTeam() {
      return awayTeam;
  }
  
  public Integer getHomeScore() {
      return homeScore;
  }
  
  public Integer getAwayScore() {
      return awayScore;
  }
  
  public ModelList<Activity> getActivities() {
      return activities;
  }
  
  public String getGameHomeTeamId() {
      return gameHomeTeamId;
  }
  
  public String getGameAwayTeamId() {
      return gameAwayTeamId;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Game(String id, Temporal.DateTime time, String location, String content, Integer homeScore, Integer awayScore, String gameHomeTeamId, String gameAwayTeamId) {
    this.id = id;
    this.time = time;
    this.location = location;
    this.content = content;
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    this.gameHomeTeamId = gameHomeTeamId;
    this.gameAwayTeamId = gameAwayTeamId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Game game = (Game) obj;
      return ObjectsCompat.equals(getId(), game.getId()) &&
              ObjectsCompat.equals(getTime(), game.getTime()) &&
              ObjectsCompat.equals(getLocation(), game.getLocation()) &&
              ObjectsCompat.equals(getContent(), game.getContent()) &&
              ObjectsCompat.equals(getHomeScore(), game.getHomeScore()) &&
              ObjectsCompat.equals(getAwayScore(), game.getAwayScore()) &&
              ObjectsCompat.equals(getGameHomeTeamId(), game.getGameHomeTeamId()) &&
              ObjectsCompat.equals(getGameAwayTeamId(), game.getGameAwayTeamId()) &&
              ObjectsCompat.equals(getCreatedAt(), game.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), game.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTime())
      .append(getLocation())
      .append(getContent())
      .append(getHomeScore())
      .append(getAwayScore())
      .append(getGameHomeTeamId())
      .append(getGameAwayTeamId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Game {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("time=" + String.valueOf(getTime()) + ", ")
      .append("location=" + String.valueOf(getLocation()) + ", ")
      .append("content=" + String.valueOf(getContent()) + ", ")
      .append("homeScore=" + String.valueOf(getHomeScore()) + ", ")
      .append("awayScore=" + String.valueOf(getAwayScore()) + ", ")
      .append("gameHomeTeamId=" + String.valueOf(getGameHomeTeamId()) + ", ")
      .append("gameAwayTeamId=" + String.valueOf(getGameAwayTeamId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static HomeScoreStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Game justId(String id) {
    return new Game(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      time,
      location,
      content,
      homeScore,
      awayScore,
      gameHomeTeamId,
      gameAwayTeamId);
  }
  public interface HomeScoreStep {
    AwayScoreStep homeScore(Integer homeScore);
  }
  

  public interface AwayScoreStep {
    BuildStep awayScore(Integer awayScore);
  }
  

  public interface BuildStep {
    Game build();
    BuildStep id(String id);
    BuildStep time(Temporal.DateTime time);
    BuildStep location(String location);
    BuildStep content(String content);
    BuildStep gameHomeTeamId(String gameHomeTeamId);
    BuildStep gameAwayTeamId(String gameAwayTeamId);
  }
  

  public static class Builder implements HomeScoreStep, AwayScoreStep, BuildStep {
    private String id;
    private Integer homeScore;
    private Integer awayScore;
    private Temporal.DateTime time;
    private String location;
    private String content;
    private String gameHomeTeamId;
    private String gameAwayTeamId;
    public Builder() {
      
    }
    
    private Builder(String id, Temporal.DateTime time, String location, String content, Integer homeScore, Integer awayScore, String gameHomeTeamId, String gameAwayTeamId) {
      this.id = id;
      this.time = time;
      this.location = location;
      this.content = content;
      this.homeScore = homeScore;
      this.awayScore = awayScore;
      this.gameHomeTeamId = gameHomeTeamId;
      this.gameAwayTeamId = gameAwayTeamId;
    }
    
    @Override
     public Game build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Game(
          id,
          time,
          location,
          content,
          homeScore,
          awayScore,
          gameHomeTeamId,
          gameAwayTeamId);
    }
    
    @Override
     public AwayScoreStep homeScore(Integer homeScore) {
        Objects.requireNonNull(homeScore);
        this.homeScore = homeScore;
        return this;
    }
    
    @Override
     public BuildStep awayScore(Integer awayScore) {
        Objects.requireNonNull(awayScore);
        this.awayScore = awayScore;
        return this;
    }
    
    @Override
     public BuildStep time(Temporal.DateTime time) {
        this.time = time;
        return this;
    }
    
    @Override
     public BuildStep location(String location) {
        this.location = location;
        return this;
    }
    
    @Override
     public BuildStep content(String content) {
        this.content = content;
        return this;
    }
    
    @Override
     public BuildStep gameHomeTeamId(String gameHomeTeamId) {
        this.gameHomeTeamId = gameHomeTeamId;
        return this;
    }
    
    @Override
     public BuildStep gameAwayTeamId(String gameAwayTeamId) {
        this.gameAwayTeamId = gameAwayTeamId;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Temporal.DateTime time, String location, String content, Integer homeScore, Integer awayScore, String gameHomeTeamId, String gameAwayTeamId) {
      super(id, time, location, content, homeScore, awayScore, gameHomeTeamId, gameAwayTeamId);
      Objects.requireNonNull(homeScore);
      Objects.requireNonNull(awayScore);
    }
    
    @Override
     public CopyOfBuilder homeScore(Integer homeScore) {
      return (CopyOfBuilder) super.homeScore(homeScore);
    }
    
    @Override
     public CopyOfBuilder awayScore(Integer awayScore) {
      return (CopyOfBuilder) super.awayScore(awayScore);
    }
    
    @Override
     public CopyOfBuilder time(Temporal.DateTime time) {
      return (CopyOfBuilder) super.time(time);
    }
    
    @Override
     public CopyOfBuilder location(String location) {
      return (CopyOfBuilder) super.location(location);
    }
    
    @Override
     public CopyOfBuilder content(String content) {
      return (CopyOfBuilder) super.content(content);
    }
    
    @Override
     public CopyOfBuilder gameHomeTeamId(String gameHomeTeamId) {
      return (CopyOfBuilder) super.gameHomeTeamId(gameHomeTeamId);
    }
    
    @Override
     public CopyOfBuilder gameAwayTeamId(String gameAwayTeamId) {
      return (CopyOfBuilder) super.gameAwayTeamId(gameAwayTeamId);
    }
  }
  

  public static class GameIdentifier extends ModelIdentifier<Game> {
    private static final long serialVersionUID = 1L;
    public GameIdentifier(String id) {
      super(id);
    }
  }
  
}
