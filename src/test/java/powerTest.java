import com.lanqiao.bean.EmpAccount;
import com.lanqiao.bean.EmpPower;
import com.lanqiao.mapper.AccountMapper;
import com.lanqiao.mapper.PowerMapper;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class powerTest extends TestCase {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void setUp() {
        // Mybatis 配置文件
        String resource = "mybatis-config.xml";

        // 得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话工厂，传入 MyBatis 的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    public  void testgetpower() throws Exception {
        PowerMapper mapper = sqlSession.getMapper(PowerMapper.class);
        List<EmpPower> empAccount=  mapper.getEmpPower("M1000");
        for(EmpPower empPower:empAccount){
            System.out.println(empPower.getPower_name());
            System.out.println(empPower.getFather_id());
            System.out.println(empPower.getFather_name());

        }
    }
    @After
    public void tearDown(){
        sqlSession.close();
    }
}