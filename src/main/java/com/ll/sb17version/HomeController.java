package com.ll.sb17version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")

    String showMain(){
        return "안녕하세요";
    }
    @GetMapping("/about")
    @ResponseBody //이 함수의 리턴값을 그대로 브라우저에 출력하라는 의미
    String showAbout(){
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc") //
    @ResponseBody //이 함수의 리턴값을 그대로 브라우저에 출력하라는 의미
    String showCalc(int a, int b){
        return "계산결과 : %d ".formatted(a+b);
    }
    @GetMapping("/calc2")
    @ResponseBody //이 함수의 리턴값을 그대로 브라우저에 출력하라는 의미
    String showCalc2(Integer a, Integer b){
        return "a: " + a + ", b: " + b ;
    }

    @GetMapping("/calc3")
    @ResponseBody //이 함수의 리턴값을 그대로 브라우저에 출력하라는 의미
    String showCalc3(
            @RequestParam (defaultValue = "0") int a,
            @RequestParam (defaultValue = "0") int b
    ){
        return "a: " + a + ", b: " + b ;
    }
    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산 결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "-") String a,
            @RequestParam(defaultValue = "-") String b
    ) {
        return "계산 결과 : %s".formatted(a + b);
    }
    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(
            int a, int b
    ) {
        return a +b;
    }

    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b
    ) {
        return a >b;
    }

    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ) {
        return new Person(name, age);
    }
    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) {
        return new Person2(name, age);
    }

    //Object 는 string 과 integer 다 들어감.
    //외우기
    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ){
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );
        return personMap;

    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Integer> showCalc11(
    ){
        List<Integer> nums = new ArrayList<>(){{
            add(10);
            add(-510);
            add(393);


        }};
        return nums;

    }
    @GetMapping("/calc12")
    @ResponseBody
    int[] showCalc12(){
        int [] nums_array= new int[]{10,294,304};
        return nums_array;
    }
    @GetMapping("/calc13")
    @ResponseBody
    List<Person2> showCalc13(String name, int age){
        List<Person2> persons = new ArrayList<>(){{
           add(new Person2(name, age));
           add(new Person2(name + "!", age +1));

        }};
        return persons;
    }
    @AllArgsConstructor
    class Person{
        public String name;
        public int age;
    }

    @AllArgsConstructor
    class Person2{
        @Getter
        private String name;
        @Getter
        private int age;
    }
    int num =0;
    @GetMapping("/calc22")
    @ResponseBody
    int showCalc22(
            @RequestParam(defaultValue = "0") int num
    ){
       num++;
       return num;
    }
}
