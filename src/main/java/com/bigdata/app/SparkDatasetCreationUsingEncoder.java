package main.java.com.bigdata.app;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkDatasetCreationUsingEncoder {

    public static void main(String[] args){

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("Employee Operations")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        /*Dataset<Row> employeeRowDs = spark.read().json("D:\\SparkBasicsJavaAndScala\\src\\main\\resources\\employee.json");
        employeeRowDs.show();
        employeeRowDs.printSchema();*/
        Dataset<Employee> employeeDataset = spark.read().format("json").load("D:\\SparkBasicsJavaAndScala\\src\\main\\resources\\employee.json").as(Encoders.bean(Employee.class));
        employeeDataset.show();
        employeeDataset.printSchema();
    }
}
