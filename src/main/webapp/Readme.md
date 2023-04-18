## vscode jsp template
- vscode 좌측 하단에 톱니바퀴 모양 클릭
- 사용자 코드 조각 클릭 후 html입력
- html.json 파일에 기존내용 전부 지우고 아래 코드 붙여넣고 저장
- .jsp 파일 생성 후 !jsp 입력 시 아래 템플릿 적용가능

```
{
   "JSP template": {
      "prefix": "!jsp",
      "body": [
         "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>",
         "<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>",
         "<!DOCTYPE html>",
         "<html>",
         "<head>",
         "<meta charset=\"UTF-8\">",
         "<title>Insert title here</title>",
         "</head>",
         "<body>",
         "</body>",
         "</html>",
      ],
      "description": "make jsp template"
   }
}