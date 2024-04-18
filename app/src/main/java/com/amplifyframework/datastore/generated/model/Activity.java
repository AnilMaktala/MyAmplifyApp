package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
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

/** This is an auto generated class representing the Activity type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Activities", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admin" }, provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
}, hasLazySupport = true)
public final class Activity implements Model {
  public static final ActivityPath rootPath = new ActivityPath("root", false, null);
  public static final QueryField ID = field("Activity", "id");
  public static final QueryField TIME = field("Activity", "time");
  public static final QueryField EVENT = field("Activity", "event");
  public static final QueryField GAME_ACTIVITIES_ID = field("Activity", "gameActivitiesId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime time;
  private final @ModelField(targetType="String") String event;
  private final @ModelField(targetType="ID") String gameActivitiesId;
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
  
  public String getEvent() {
      return event;
  }
  
  public String getGameActivitiesId() {
      return gameActivitiesId;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Activity(String id, Temporal.DateTime time, String event, String gameActivitiesId) {
    this.id = id;
    this.time = time;
    this.event = event;
    this.gameActivitiesId = gameActivitiesId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Activity activity = (Activity) obj;
      return ObjectsCompat.equals(getId(), activity.getId()) &&
              ObjectsCompat.equals(getTime(), activity.getTime()) &&
              ObjectsCompat.equals(getEvent(), activity.getEvent()) &&
              ObjectsCompat.equals(getGameActivitiesId(), activity.getGameActivitiesId()) &&
              ObjectsCompat.equals(getCreatedAt(), activity.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), activity.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTime())
      .append(getEvent())
      .append(getGameActivitiesId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Activity {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("time=" + String.valueOf(getTime()) + ", ")
      .append("event=" + String.valueOf(getEvent()) + ", ")
      .append("gameActivitiesId=" + String.valueOf(getGameActivitiesId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
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
  public static Activity justId(String id) {
    return new Activity(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      time,
      event,
      gameActivitiesId);
  }
  public interface BuildStep {
    Activity build();
    BuildStep id(String id);
    BuildStep time(Temporal.DateTime time);
    BuildStep event(String event);
    BuildStep gameActivitiesId(String gameActivitiesId);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private Temporal.DateTime time;
    private String event;
    private String gameActivitiesId;
    public Builder() {
      
    }
    
    private Builder(String id, Temporal.DateTime time, String event, String gameActivitiesId) {
      this.id = id;
      this.time = time;
      this.event = event;
      this.gameActivitiesId = gameActivitiesId;
    }
    
    @Override
     public Activity build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Activity(
          id,
          time,
          event,
          gameActivitiesId);
    }
    
    @Override
     public BuildStep time(Temporal.DateTime time) {
        this.time = time;
        return this;
    }
    
    @Override
     public BuildStep event(String event) {
        this.event = event;
        return this;
    }
    
    @Override
     public BuildStep gameActivitiesId(String gameActivitiesId) {
        this.gameActivitiesId = gameActivitiesId;
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
    private CopyOfBuilder(String id, Temporal.DateTime time, String event, String gameActivitiesId) {
      super(id, time, event, gameActivitiesId);
      
    }
    
    @Override
     public CopyOfBuilder time(Temporal.DateTime time) {
      return (CopyOfBuilder) super.time(time);
    }
    
    @Override
     public CopyOfBuilder event(String event) {
      return (CopyOfBuilder) super.event(event);
    }
    
    @Override
     public CopyOfBuilder gameActivitiesId(String gameActivitiesId) {
      return (CopyOfBuilder) super.gameActivitiesId(gameActivitiesId);
    }
  }
  

  public static class ActivityIdentifier extends ModelIdentifier<Activity> {
    private static final long serialVersionUID = 1L;
    public ActivityIdentifier(String id) {
      super(id);
    }
  }
  
}
