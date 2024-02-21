package org.csystem.app.wikisearch.geonames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class WikiSearchInfo {
    public String summary;
    public int elevation;

    @JsonProperty("lng")
    public double longitude;
    public int rank;
    public String thumbnailImg;

    @JsonProperty("lang")
    public String language;
    public String title;

    @JsonProperty("lat")
    public double latitude;
    public String wikipediaUrl;
    public int geoNameId;
    public String countryCode;
    public String feature;
}