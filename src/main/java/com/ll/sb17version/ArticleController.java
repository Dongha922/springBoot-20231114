package com.ll.sb17version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleController {
    //전역변수 선언
    private Article lastArticle;
    @GetMapping("/article/write")
    String showWrite(){

        return "article/write";
    }
    @GetMapping("/article/doWrite")
    @ResponseBody

    Map<String, Object> doWrite(
            String title,
            String body
    ) {
        //객체만들기 객체화
        lastArticle = new Article(1,title, body);

        Map<String, Object> rs= new HashMap<>();
        rs.put("msg", "1번 게시물작성됨");
        rs.put("data", lastArticle);
         return rs;
    }
    @GetMapping("/article/getLastArticles")
    @ResponseBody
    Article getLastArticle(){
        return lastArticle;
    }
}
@AllArgsConstructor
//getter 은 getid ,gettitle, getBody 함수 자동완성
@Getter

class Article{
    private long id;
    private String title;
    private String body;

}
