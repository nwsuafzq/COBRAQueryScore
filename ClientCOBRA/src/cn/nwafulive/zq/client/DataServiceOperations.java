package cn.nwafulive.zq.client;
/**
* DataServiceOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从DataService.idl
* 2017年4月1日 星期六 下午10时43分43秒 CST
*/

public interface DataServiceOperations 
{
  void insert(String sid, String sname, float score);
  String check(String sid);
} // interface DataServiceOperations
