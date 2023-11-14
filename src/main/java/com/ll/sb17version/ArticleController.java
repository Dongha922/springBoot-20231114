package com.ll.sb17version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
    @GetMapping("/article/write")
    String showWrite(){

        return "article/write";
    }
    @GetMapping("/article/doWrite")
    @ResponseBody
    Article doWrite(
            String title,
            String body
    ) {
        //객체만들기 객체화
        Article article = new Article(1,title, body);
        return article;
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
