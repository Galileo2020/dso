package com.regionalit.dso;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DsoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DsoApplication.class, args);
  }

  @GetMapping("")
  String hello() {
    return "hello, the time is 2020-02-24 17:18:30";
  }

  @GetMapping("/search")
  String search() throws IOException {
    RestClient client = RestClient.builder(
        new HttpHost("10.168.0.2", 9200, "http")).build();
    Request request = new Request("GET", "/");
    Response response = client.performRequest(request);
    client.close();
    return EntityUtils.toString(response.getEntity());
  }
}
