package com.example.demo.jdk11;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;


public class Test1 {

    public static void main(String[] args) {
        System.out.println(1111);

        /*Error:Cannot run program "C:\Program Files\Java\jdk-11.0.6\bin\java.exe"
         (in directory "C:\Users\colo\.IntelliJIdea2019.3\system\compile-server"):
          Malformed argument has embedded quote: -Dkotlin.daemon.client.alive.path=
          \"C:\Users\colo\AppData\Local\Temp\kotlin-idea-8250180277424722164-is-running\"*/
    }

    /**
     * 局部类型推断
     * 必须立即赋值;
     * 在类中的成员变量(也叫属性)不可以使用var来定义;
     */
    @Test
    public void var() {
        var str = "helloworld";
        System.out.println(str);
    }

    /**
     * 集合中的新API
     */
    @Test
    public void listOf() {
        List<String> list = List.of("hello", "world", "java");
        System.out.println(list);
        //list.add("会出错~");
    }

    /**
     * 流中的新API
     */
    @Test
    public void streamOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream stream1 = Stream.of();
        Stream stream2 = Stream.ofNullable(null);
        //报错
        // Stream stream3 = Stream.of(null);
        System.out.println("stream :" + stream);
        System.out.println("stream1 :" + stream1);
        System.out.println("stream2 :" + stream2);
        // System.out.println("stream3 :" + stream3);
    }

    /**
     * 流中的新API
     */
    @Test
    public void stream2() {
        Stream<Integer> stream = Stream.of(1, 3, 2, 5, 6, 7);
        Stream stream2 = stream.takeWhile(t -> t % 2 != 0);
        stream2.forEach(System.out::println);
        //1 3
    }

    /**
     * 流中的新API
     */
    @Test
    public void stream3() {
        Stream<Integer> stream = Stream.of(1, 3, 2, 5, 6, 7);
        Stream stream2 = stream.dropWhile(t -> t % 2 != 0);
        stream2.forEach(System.out::println);
    }


    /**
     * 字符串中的新API
     */
    @Test
    public void string1() {
        String s2 = "";
        String s3 = "   ";
        String s4 = "哈,哈,哈哈-";
        System.out.println("s2.isBlank() :" + s2.isBlank()); //true
        System.out.println("s3.isBlank() :" + s3.isBlank()); //true
        System.out.println("s4.isBlank() :" + s4.isBlank()); //false
        //重复n次
        String repeat = s4.repeat(3);
        //去除字符串首尾的空白
        String strip = s3.strip();
        //去除字符串尾部的空白
        String strip1 = s3.stripTrailing();
        //去除字符串首部的空白
        String strip2 = s3.stripLeading();

    }


    /**
     * HttpAPI, HTTP请求的API，该API支持同步和异步
     */
    @Test
    public void httpAPI() throws ExecutionException, InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        //同步
        HttpResponse<String> response2 = client.send(request, responseBodyHandler);
        //异步
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
        HttpResponse<String> response = sendAsync.get();
        String body = response.body();
        System.out.println(body);
    }


    /**
     * Epsilon垃圾收集器
     */

}
