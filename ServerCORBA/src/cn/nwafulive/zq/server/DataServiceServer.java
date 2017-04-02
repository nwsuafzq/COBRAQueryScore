package cn.nwafulive.zq.server;

import cn.nwafulive.zq.db.DBmanager;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 * @Author ZhangQiong nwsuafzq@hotmail.com
 * @Date 2017/4/1
 * @Time 22:02.
 */

class DataServiceImpl extends DataServicePOA {  //具体的服务实现
    private ORB orb;

    public void setOrb(ORB orb_val) {

        this.orb = orb_val;
    }

    @Override
    public void insert(String sid, String sname, float score) {
        /**
         * @methodName insert
         * @param [sid, sname, score]
         * @return void
         * 2017/4/1 23:13
         */
        
        DBmanager.insert(sid,sname,score);
    }

    @Override
    public String check(String sid) {
        /**
         * @methodName check
         * @param [sid]
         * @return java.lang.String
         * 2017/4/1 23:13
         */
        
        String checkResult;
        checkResult = DBmanager.check(sid);
        return checkResult;
    }


}
public class DataServiceServer { 
    public static void main(String args[]) {
        try{
            System.out.println("创建和初始化 ORB ");

            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            rootpoa.the_POAManager().activate();

            System.out.println("创建服务对象并将其向 ORB 注册 ");
            DataServiceImpl dataServiceImpl = new DataServiceImpl();

            dataServiceImpl.setOrb(orb);

            //System.out.println(orb.object_to_string(sysProImpl));

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent[] path = {new NameComponent("SysProp", "")};

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(dataServiceImpl);
            DataService href = DataServiceHelper.narrow(ref);
            System.out.println(orb.object_to_string(href));

            System.out.println(ncRef.getClass().toString());
            ncRef.rebind(path, href);

            System.out.println("DataServiceServer ready and waiting ...");

            orb.run();

        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}
