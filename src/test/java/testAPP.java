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

public class testAPP extends TestCase {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void setUp(){
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
        sqlSession=sqlSessionFactory.openSession();
    }

    // 新增用戶
    public void testInsertUser() {
        // 通过工厂得到 SqlSession

    }

    // 更新用戶
    public void testUpdateUser() {

    }

    // 删除用戶
    public void testDeleteUser() {

    }

    // 根据 id 查询用户信息
    public void testSelectUserById() {

    }

    // 查询所有的用户信息
    public void testSelectAllUser() throws Exception{
       AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        EmpAccount empAccount=mapper.checkEmpInfo("M1000");
        System.out.println(empAccount.getEmp_id());
        System.out.println(empAccount.getEmp_password());
        System.out.println(empAccount.getPost_id());

    }
    @After
    public void tearDown(){
        sqlSession.close();
    }
}