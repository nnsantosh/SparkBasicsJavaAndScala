package com.bigdata.app;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkDataSetOperationsForCsv {

    public static void main(String[] args){
        //Use SparkSession to create Dataset<Row>
        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("Apple Stock Operations")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        Dataset<Row>  appleStockDataSet = spark.read().format("csv").option("header",true).option("inferSchema",true).load("D:\\SparkBasicsJavaAndScala\\src\\main\\resources\\appl_stock.csv");
        appleStockDataSet.show();
    }
}
