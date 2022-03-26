package com.example.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapVoForApi {
    String addressName;
    String categoryGroupCode;
    String categoryGroupName;
    String categoryName;
    String distance;
    int id;
    String phone;
    String placeName;
    String placeUrl;
    String road_addressName;
    String x;
    String y;
    String placeImg;
    float reviewRate;
    int reviewCount;
    String reviewComment;
    List<Link> links;
}
