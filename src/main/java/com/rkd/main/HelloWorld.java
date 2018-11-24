package com.rkd.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.rkd.model.Product;
import com.rkd.util.ConfigUtils;

import freemarker.template.TemplateException;

public class HelloWorld {
  public static void main(String[] args) throws IOException, TemplateException {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("user", "BigJoe");
    map.put("latestProduct", new Product("rkkk rl", "heyile"));
    ConfigUtils.generate(map, "hello");

  }
}
