package cn.nwafulive.zq.client;
/**
* DataServiceOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��DataService.idl
* 2017��4��1�� ������ ����10ʱ43��43�� CST
*/

public interface DataServiceOperations 
{
  void insert(String sid, String sname, float score);
  String check(String sid);
} // interface DataServiceOperations
