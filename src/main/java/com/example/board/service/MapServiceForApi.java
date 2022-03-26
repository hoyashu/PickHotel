package com.example.board.service;

import com.example.board.model.MapResponseForApi;
import com.example.board.model.MapVoForApi;
import com.example.board.persistent.ReviewDao;
import com.example.config.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("mapServiceForApi")
public class MapServiceForApi {
    private final String URI_MAPS = "http://01f0-180-224-208-18.ngrok.io:80/api/maps";
    private final String URI_MAP_ID = "http://01f0-180-224-208-18.ngrok.io:80/api/map/{id}";
    private final String URI_MAP = "http://01f0-180-224-208-18.ngrok.io:80/api/map";

    private final RestTemplate restTemplate;
    @Autowired
    private ReviewDao reviewDao;

    public MapServiceForApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
    }

    // 숙소 생성
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public String registerMap(MapVoForApi mapVoForApi) throws Exception {
        URI uri = restTemplate.postForLocation(URI_MAP, mapVoForApi);

        return uri.toString();
    }

    // 숙소id로 숙소 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public MapVoForApi retrieveMap(int id) throws Exception {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);

        ResponseEntity<MapVoForApi> responseEntity = restTemplate.getForEntity(URI_MAP_ID, MapVoForApi.class, params);
        MapVoForApi mapVoForApi = new MapVoForApi();

        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            mapVoForApi = responseEntity.getBody();
        }
        return mapVoForApi;
    }

    // 숙소 정보 모두 조회 (리뷰 갯수와 평첨, 한줄평까지)
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public MapResponseForApi retrieveAllMaps() {

        ResponseEntity<MapResponseForApi> responseEntity = restTemplate.getForEntity(URI_MAPS, MapResponseForApi.class);
        MapResponseForApi MapResponseForApi = responseEntity.getBody();

        List<MapVoForApi> content = MapResponseForApi.getContent();
        for (MapVoForApi map : content) {
            map.setReviewRate(reviewDao.selectReviewRateByRoom(map.getId()));
            map.setReviewCount(reviewDao.selectReviewCountByRoom(map.getId()));
            //map.setReviewComment(reviewDao.s);

            System.out.println("x " + map.getX());
            System.out.println("y " + map.getY());
        }

        return MapResponseForApi;
    }

    //숙소 업데이트
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void modifyMap(MapVoForApi mapVoForApi) {
        restTemplate.put(URI_MAP, mapVoForApi, MapVoForApi.class);
    }

    // 숙소 삭제
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void removeMap(int id) throws Exception {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);

        restTemplate.delete(URI_MAP_ID, params);
    }


}
