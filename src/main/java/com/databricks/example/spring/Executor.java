package com.databricks.example.spring;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.*;

@Component
public class Executor implements CommandLineRunner {

    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

    @Autowired
    Spark spark;

    @Override
    public void run(String... args) throws Exception {

    	SparkSession sparkSession =  spark.getSparkSession();

    	Dataset<Row> df0 = sparkSession
    	        .read()
    	        .format("csv")
    	        .option("delimiter",",")
    	        .option("header","true")
    	        .load("dbfs:/home/mwc/files/trace-2021.csv");

    	df0.select("Series_reference", "Period","Data_value","Suppressed").show(false);
    	logger.info("Completed!");
    }
}
