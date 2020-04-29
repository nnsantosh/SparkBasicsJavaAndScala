package com.bigdata.app

import org.apache.spark.sql.SparkSession

object SparkScalaDataSetOperationsForCsv {

  def main(args: Array[String]): Unit ={
    //Use SparkSession to create Dataset<Row> which is DataFrame
    val spark = SparkSession.builder.master("local").appName("Apple Stock Operations").config("spark.some.config.option", "some-value").getOrCreate;
    val applDataSet = spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load("D:\\SparkBasicsJavaAndScala\\src\\main\\resources\\appl_stock.csv")

    applDataSet.show()
    applDataSet.printSchema()
  }

}
