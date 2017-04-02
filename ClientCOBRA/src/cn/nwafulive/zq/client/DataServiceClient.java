package cn.nwafulive.zq.client;

import cn.nwafulive.zq.bean.Student;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

/**
 * @Author ZhangQiong nwsuafzq@hotmail.com
 * @Date 2017/4/2
 * @Time 15:18.
 */
public class DataServiceClient {
    public static void main(String[] args) {
        try {
            String SetInfo, ReturnInfo, ref;
            org.omg.CORBA.Object objRef;
            DataService dataServiceRef;
            ORB orb = ORB.init(args, null);
            if (args.length>=1){
                ref=args[0];
            }
            else{
                System.out.println("aaaaaaaaa");
                return ;
            }
            //下面一条语句得到的是一个NamingContext对象，并非DataService对象
            objRef = orb.string_to_object(ref);
            dataServiceRef = DataServiceHelper.narrow(objRef);
            /*objRef = orb.resolve_initial_references("NameService");
            System.out.println(orb.object_to_string(objRef));
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc =new NameComponent("DataService","");
            NameComponent path[] = {nc};
            dataServiceRef = DataServiceHelper.narrow(ncRef.resolve(path));*/
            if (args.length>1)
            {
                SetInfo=args[1];
            }
            else
            {
                SetInfo="java.home";
            }

            System.out.println("开始调用");

            Student student1 = new Student();
            student1.setSid("2");
            student1.setSname("loveu");
            student1.setScore(200.0f);

            dataServiceRef.insert(student1.getSid(),student1.getSname(),student1.getScore()); //插入
            System.out.println("Data Inserted！");

            student1.setSid("2");
            System.out.println("查的是："+student1.getSid()+"号");

            String ckresult;
            ckresult=dataServiceRef.check(student1.getSid()); //查询
            System.out.println(ckresult);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
