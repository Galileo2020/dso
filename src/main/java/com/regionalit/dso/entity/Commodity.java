package com.regionalit.dso.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "commodity")
@Data
public class Commodity {
  @Id
  private String skuId;
  private String name;
  private String category;
  private Integer price;
  private String brand;
  private Integer stock;
}
