package org.example.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.*;




@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)


public class Unicorn {
    private String name;
    private String tailColor;
    @SerializedName("_id")
    private String id;
}