import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class runMain {
    public static void main(String[] args) throws Exception {
        // String name, int age, long income, String incomeType
//        People p1 = new People("Alex", 29, 100, "weekly");
//        People p2 = new People("Bob", 24, 300, "Annually");
//        GroupUpImpl group1 = new GroupUpImpl();
//        List<People> l1 = new LinkedList<>();
//        l1.add(p1);
//        l1.add(p2);
//        Group buddy = group1.mergeGroupMembers(l1, "Buddy");
//        System.out.println(buddy.getGroupSize());
//        System.out.println(group1.getAllowedOrigins().size());
//        group1.modifyAllowedOrigins("www.google.com,www.cisco.com,www.webex.cisco.com");
//        System.out.println(group1.getAllowedOrigins().size());
//        group1.modifyAllowedOrigins("*");
//        System.out.println(group1.getAllowedOrigins().size());
//        GroupUpImpl group2 = new GroupUpImpl();
//        Group test = group2.mergeGroupMembers("test");
//        System.out.println(test.getGroupSize());
//
//        Person person = XMLtoPersonExample("person.xml");
//        personToXMLExample("person-output.xml", person);

        // use Quartz to have a job scheduled periodically to read newest allowedOrigins from database.
        // And it will save into cache.
        // Another method to call updateAllowedOrigins in CORSFilter to update the allowedOrigin with new cache
        // this will be put in main of xmlproxy.



        //Quartz: 需要调度任务 先得到一个Schedule的实例
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = schedulerFactory.getScheduler();
//
//        JobDetail jobDetail = new JobDetail("helloQuartzJob", Scheduler.DEFAULT_GROUP, HelloQuartzJob.class);
//
//        SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger", Scheduler.DEFAULT_GROUP);
//
//        simpleTrigger.setStartTime(new Date(System.currentTimeMillis()));
//        simpleTrigger.setRepeatInterval(5000);
//        simpleTrigger.setRepeatCount(10);
//
//        scheduler.scheduleJob(jobDetail, simpleTrigger);
//
//        scheduler.start();

        // Quartz test:
        // 简单任务调度， 每个多少时间执行一次，执行n次
        // SchedulerUtil.handleSimpleTrigger("Test1","Group1", "TrigTest1", "TrigGroup1", MyJob.class, 1, 8);


        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://127.0.0.1:3306/CorsTest";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "Tearose1184?";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from WBXSITECONF";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("SITEID" + "\t" + "ITEMNAME " + "\t" + "ITEMVALUE " + "\t" + "LASTMODIFIEDTIME");
            System.out.println("-------------------------------------------------------------------------------------");
            String SITEID = null;
            String ITEMNAME = null;
            String ITEMVALUE = null;
            String LASTMODIFIEDTIME = null;
            while(rs.next()){
                //获取SITEID这列数据
                SITEID = rs.getString("SITEID");
                //获取ITEMNAME这列数据
                ITEMNAME = rs.getString("ITEMNAME");
                //
                ITEMVALUE = rs.getString("ITEMVALUE");
                //
                LASTMODIFIEDTIME = rs.getString("LASTMODIFIEDTIME");
                //输出结果
                System.out.println(SITEID + "\t" + ITEMNAME + "\t" + ITEMVALUE + "\t" + LASTMODIFIEDTIME);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(Exception e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }




    }

//    private static Person XMLtoPersonExample(String filename) throws Exception {
//        File file = new File(filename);
//        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
//
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        return (Person) jaxbUnmarshaller.unmarshal(file);
//    }
//
//    private static void personToXMLExample(String filename, Person person) throws Exception {
//        File file = new File(filename);
//        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
//
//        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jaxbMarshaller.marshal(person, file);
//        jaxbMarshaller.marshal(person, System.out);
//    }
}
