package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;



@WebServlet("/dancer/process")
public class ProcessServlet extends HttpServlet {

    // 댄서 저장소를 의존해야 한다.
    private final DancerRepository repository = new DancerRepository();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // form에서 넘어온 데이터 읽기 (클라이언트 데이터 처리 : controller)
        // form에서 전송한 데이터 한글 처리
        req.setCharacterEncoding("UTF-8");
        // Dancer 객체를 생성, 입력값 세팅 (business logic : model(자바객체))
        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genresArray = req.getParameterValues("genres");
        // 데이터베이스에 저장 (business logic : model(자바객체)) -> 위임
        repository.save(name, crewName, danceLevel, genresArray);

        // 댄서 목록을 브라우저에 출력 (jsp : view) - 뷰 포워딩
        // 저장소에 있는 댄서 목록을 jsp파일로 전달할 수 있는 방법이 필요

        List<Dancer> dancerList = repository.findAll();

        // request 객체는 하나의 요청간에 데이터 수송을 할 수 있음.
        // session 객체는 여러 요청간에 데이터 수송 가능
        req.setAttribute("dl", dancerList);
        RequestDispatcher dp = req.getRequestDispatcher("/WEB-INF/chap04/dancer/list.jsp");
        dp.forward(req, resp);



    }
}
