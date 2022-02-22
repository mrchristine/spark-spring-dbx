package com.databricks.example.spring;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;
import scala.Tuple2;


@Component
public class Spark {

    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

    public SparkSession sparkSession;
    public SparkConf sparkConf;
    public SparkContext sparkContext;

    public void createSparkSession() {

        SparkSession.Builder builder = SparkSession.builder();

        sparkConf = new SparkConf().setAppName("JavaSpark-ExportAgent-Databricks");

        if (sparkConf.getOption("spark.master").isEmpty()) {
            sparkConf.setMaster("local[*]");
            builder.config(sparkConf);
        }

        sparkSession = builder.getOrCreate();

        logger.info("************************************************************************************************************");
        Tuple2<String, String> sc[] = sparkSession.sparkContext().getConf().getAll();
        for (int i = 0; i < sc.length; i++) {
            logger.info(sc[i]);
        }
        logger.info("************************************************************************************************************");

    }

    public SparkSession getSparkSession() { createSparkSession();  return sparkSession; }
}
