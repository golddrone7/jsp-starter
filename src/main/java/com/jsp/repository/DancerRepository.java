package com.jsp.repository;


import com.jsp.entity.Dancer;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

// DAO , VO 다오, 부오라 읽지 말기
// 댄서 정보 저장소
public class DancerRepository {

    private static final Map<String, Dancer> dancerMap = new HashMap<>();

    // 댄서 저장 기능

    public void save(String name, String crewName, String dancerLevel, String[] genresArray){
        // Dancer 객체로 포장
        Dancer dancer = new Dancer();
        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(Dancer.DanceLevel.valueOf(dancerLevel));

        List<Dancer.Genre> genres = new ArrayList<>();
        if(genresArray != null){
            for(String g : genresArray){
                genres.add(Dancer.Genre.valueOf(g));
            }
        }
        dancer.setGenres(genres);
        System.out.println("dancer=" + dancer);

        // dancerList에 저장
        dancerMap.put(name, dancer);
    }

    // 댄서 맵을 리스트로 변환해서 리턴하는 메서드
    public List<Dancer> findAll(){
          return new ArrayList<>(dancerMap.values());
        //        List<Dancer> dancerList = new ArrayList<>();
//        return dancerMap.values().stream()
//                .collect(Collectors.toList());
//        for (Dancer dancer : dancerMap.values()) {
//            dancerList.add(dancer);
//        }
//        return dancerList;
    }


    // 댄서 맵에서 댄서 객체를 삭제하는 기능
    public void delete(String name){
        dancerMap.remove(name);
    }

}
