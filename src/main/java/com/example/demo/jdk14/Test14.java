package com.example.demo.jdk14;

import org.junit.Test;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.WEDNESDAY;


public class Test14 {

    @Test
    public void var() {
        var str = "helloworld d";
        System.out.println(str);
    }


    /* instanceof的模式匹配（预览）
     * Pattern Matching for instanceof (Preview)
     * */

    @Test
    public void instanceofTest() {
        Object obj = "java14";
        //测试一把
        if (obj instanceof String sss && sss.length() > 5) {
            System.out.println(sss.contains("b"));
            System.out.println("这是字符串!sss" + sss);
        } else {
            System.out.println("其他~");
        }
    }


    @Test
    public void npeTest() {
        String str = "1234567";
        String str2 = null;
        System.out.println(str2.equals(str));
    }


    public static void main(String[] args) {
        String str = "1234567";
        String str2 = null;
        System.out.println(str2.equals(str));
    }


    @Test
    public void switchTest() {
        DayOfWeek day = WEDNESDAY;
        int result = getSwitch(day);
        System.out.println(result);
    }

    public int getSwitch(DayOfWeek day) {
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                return 6;
            }
            case TUESDAY -> {
                return 7;
            }
            case THURSDAY, SATURDAY -> {
                return 8;
            }
            //case WEDNESDAY             ->{ return 9;}
            default -> {
                return 10086;
            }
        }
    }

    //Records (Preview)

    @Test
    public void recordTest() {
        Person person1 = new Person(10, "tom");
        System.out.println(person1.toString()); //Person[age=10, name=tom]
        System.out.println(person1.age()); //10
        System.out.println(person1.name()); //tom
    }


    @Test
    public void textBlockTest() {
        String html = """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                """;
        System.out.println(html);
    }

    /**/
}
