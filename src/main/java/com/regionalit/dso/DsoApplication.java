package com.regionalit.dso;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regionalit.dso.entity.Commodity;
import com.regionalit.dso.service.CommodityService;
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
  private final CommodityService commodityService;

  public DsoApplication(CommodityService commodityService) {
    this.commodityService = commodityService;
    Commodity commodity = new Commodity();
    commodity.setSkuId("1501009001");
    commodity.setName("原味切片面包（10片装）");
    commodity.setCategory("101");
    commodity.setPrice(880);
    commodity.setBrand("良品铺子");
    commodityService.save(commodity);
    commodity = new Commodity();
    commodity.setSkuId("1501009002");
    commodity.setName("原味切片面包（6片装）");
    commodity.setCategory("101");
    commodity.setPrice(680);
    commodity.setBrand("良品铺子");
    commodityService.save(commodity);
    commodity = new Commodity();
    commodity.setSkuId("1501009004");
    commodity.setName("元气吐司850g");
    commodity.setCategory("101");
    commodity.setPrice(120);
    commodity.setBrand("百草味");
    commodityService.save(commodity);
  }

  public static void main(String[] args) {
    SpringApplication.run(DsoApplication.class, args);
  }

  @GetMapping("")
  String hello() {
    return "hello, the time is 2020-02-24 17:18:30";
  }

  @GetMapping("/search_with_rest_client")
  String search() throws IOException {
    RestClient client = RestClient.builder(
        new HttpHost("10.128.15.205", 9200, "http")).build();
    Request request = new Request("GET", "/commodity/commodity/1501009004?pretty=true");
    Response response = client.performRequest(request);
    client.close();
    return EntityUtils.toString(response.getEntity());
  }

  @GetMapping("/search_with_spring_data")
  String search_with_spring_data() throws JsonProcessingException {
    Commodity obj = commodityService.getByName("元气吐司850g").get(0);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(obj);
  }
}
