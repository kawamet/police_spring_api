
package uk.wanat.policespring.model.policedata;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "category",
    "location_type",
    "location",
    "context",
    "outcome_status",
    "persistent_id",
    "id",
    "location_subtype",
    "month"
})
public class PoliceData {

    @JsonProperty("category")
    private String category;
    @JsonProperty("location_type")
    private Object locationType;
    @JsonProperty("location")
    private Object location;
    @JsonProperty("context")
    private String context;
    @JsonProperty("outcome_status")
    private OutcomeStatus outcomeStatus;
    @JsonProperty("persistent_id")
    private String persistentId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("location_subtype")
    private String locationSubtype;
    @JsonProperty("month")
    private String month;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("location_type")
    public Object getLocationType() {
        return locationType;
    }

    @JsonProperty("location_type")
    public void setLocationType(Object locationType) {
        this.locationType = locationType;
    }

    @JsonProperty("location")
    public Object getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Object location) {
        this.location = location;
    }

    @JsonProperty("context")
    public String getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(String context) {
        this.context = context;
    }

    @JsonProperty("outcome_status")
    public OutcomeStatus getOutcomeStatus() {
        return outcomeStatus;
    }

    @JsonProperty("outcome_status")
    public void setOutcomeStatus(OutcomeStatus outcomeStatus) {
        this.outcomeStatus = outcomeStatus;
    }

    @JsonProperty("persistent_id")
    public String getPersistentId() {
        return persistentId;
    }

    @JsonProperty("persistent_id")
    public void setPersistentId(String persistentId) {
        this.persistentId = persistentId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("location_subtype")
    public String getLocationSubtype() {
        return locationSubtype;
    }

    @JsonProperty("location_subtype")
    public void setLocationSubtype(String locationSubtype) {
        this.locationSubtype = locationSubtype;
    }

    @JsonProperty("month")
    public String getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(String month) {
        this.month = month;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
