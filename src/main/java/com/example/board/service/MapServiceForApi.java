package com.example.board.service;

import com.example.board.model.Link;
import com.example.board.model.MapResponseForApi;
import com.example.board.model.MapVoForApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mapServiceForApi")
public class MapServiceForApi {
    private final String URI_MAPS = "http://localhost:15000/api/maps";
    private final String URI_MAPS_MAPNO = "http://localhost:15000/api/maps/{map_no}";
    private final String URI_MAP = "http://localhost:15000/api/map";

    @Autowired
    private RestTemplate restTemplate;

    // 숙소 생성
    public String registerMap(MapVoForApi mapVoForApi){
        URI uri = restTemplate.postForLocation(URI_MAP, mapVoForApi);

        return uri.toString();
    }

    // 숙소 1개 조회
    public MapVoForApi retrieveMap(int map_no) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("map_no", map_no);

        ResponseEntity<MapVoForApi> responseEntity = restTemplate.getForEntity(URI_MAPS_MAPNO, MapVoForApi.class, params);
        MapVoForApi mapVoForApi = new MapVoForApi();

        int statusCode = responseEntity.getStatusCodeValue();
        if(statusCode == 200){
            mapVoForApi = responseEntity.getBody();
            System.out.println("주소 이름 : " + mapVoForApi.getAddress_name());
        }
        return mapVoForApi;
    }

    // 숙소 모두 조회
    public MapResponseForApi retrieveAllMaps(){
        ResponseEntity<MapResponseForApi> responseEntity = restTemplate.getForEntity(URI_MAPS, MapResponseForApi.class);
        MapResponseForApi mapResponseForApi = responseEntity.getBody();

        List<Link> links = mapResponseForApi.getLinks();

        return mapResponseForApi;
    }

    //숙소 업데이트
    public void modifyMap(MapVoForApi mapVoForApi) {
        restTemplate.put(URI_MAP,mapVoForApi, MapVoForApi.class);
    }

    // 숙소 삭제
    public void removeMap(int map_no){

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("map_no", map_no);

        restTemplate.delete(URI_MAPS_MAPNO, params);
    }


}
