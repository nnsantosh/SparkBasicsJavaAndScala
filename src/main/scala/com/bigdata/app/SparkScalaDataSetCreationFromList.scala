package main.scala.com.bigdata.app

import org.apache.spark.sql.types.{DataTypes, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object SparkScalaDataSetCreationFromList {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local").appName("Dataset creation").config("spark.some.config.option", "some-value").getOrCreate
    val data = Seq(Row("Jon", 1, "CTS"), Row("Michael", 2, "Accenture"))
    val inputFields = List(StructField("name", DataTypes.StringType, false), StructField("id", DataTypes.IntegerType, false), StructField("company", DataTypes.StringType, false))
    val inputDataSetSchema = StructType(inputFields)
    val dataRDD = spark.sparkContext.parallelize(data)
    val inputDataSet = spark.createDataFrame(dataRDD, inputDataSetSchema)
    inputDataSet.show()
    inputDataSet.printSchema()
  }

}
