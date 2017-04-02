package cn.nwafulive.zq.server;
/**
* DataServicePOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从DataService.idl
* 2017年4月1日 星期六 下午10时43分43秒 CST
*/

public abstract class DataServicePOA extends org.omg.PortableServer.Servant
 implements DataServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insert", new java.lang.Integer (0));
    _methods.put ("check", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // DataService/insert
       {
         String sid = in.read_string ();
         String sname = in.read_string ();
         float score = in.read_float ();
         this.insert (sid, sname, score);
         out = $rh.createReply();
         break;
       }

       case 1:  // DataService/check
       {
         String sid = in.read_string ();
         String $result = null;
         $result = this.check (sid);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:DataService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public DataService _this() 
  {
    return DataServiceHelper.narrow(
    super._this_object());
  }

  public DataService _this(org.omg.CORBA.ORB orb) 
  {
    return DataServiceHelper.narrow(
    super._this_object(orb));
  }


} // class DataServicePOA
