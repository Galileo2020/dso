package com.regionalit.dso.service;

import com.regionalit.dso.entity.Commodity;
import java.util.List;
import org.springframework.data.domain.Page;

public interface CommodityService {
  long count();
  Commodity save(Commodity commodity);
  void delete(Commodity commodity);
  Iterable<Commodity> getAll();
  List<Commodity> getByName(String name);
  Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw);
}
