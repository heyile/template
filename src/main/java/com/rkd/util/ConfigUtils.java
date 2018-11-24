package com.rkd.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class ConfigUtils {
  public static Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);

  private ConfigUtils() throws IOException {

  }

  public static Configuration getConfiguration() {
    try {
      configuration.setDirectoryForTemplateLoading(new File("E:\\project\\template\\src\\main\\resources\\ftl"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    configuration.setDefaultEncoding("UTF-8");

    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    configuration.setLogTemplateExceptions(false);

    configuration.setWrapUncheckedExceptions(true);
    return configuration;
  }

  public static void generate(Object mapOrModel, String fileName) {

    Configuration configuration = getConfiguration();

    try {
      Template template = configuration.getTemplate(fileName + ".ftl");
      String filePath = "E:\\project\\template\\src\\main\\resources\\result\\" + fileName + ".rkd";
      File file = new File(filePath);
      if (file.exists()) {
        System.out.println(filePath + " is exist and will be deleted");
        boolean delete = file.delete();
        if (delete) {
          System.out.println("delete : " + delete);
        }
      }
      template.process(mapOrModel,
          new FileWriter(file));
      System.out.println("finished ...");
    } catch (TemplateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
