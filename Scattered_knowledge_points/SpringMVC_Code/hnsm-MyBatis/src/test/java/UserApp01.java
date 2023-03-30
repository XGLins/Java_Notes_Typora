import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huinong.mapper.UserInfoMapper;
import com.huinong.mapper.UserMapper;
import com.huinong.pojo.User;
import com.huinong.pojo.UserInfo;
import com.huinong.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class UserApp01 {

    /**
     * 添加用户
     * */
    @Test
    public void insertUserTest(){
        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.insertUser();
        System.out.println("共添加记录：" + i + "行");

        //关闭连接
        sqlSession.close();
    }


    /**
     * 修改用户
     * */
    @Test
    public void updateUserTest(){
        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updateUser();
        System.out.println("共修改记录：" + i + "行");

        //关闭连接
        sqlSession.close();
    }


    /**
     * 删除用户
     * */
    @Test
    public void deleteUserTest(){
        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser();
        System.out.println("共删除记录：" + i + "行");

        //关闭连接
        sqlSession.close();
    }


    /**
     * 查询单个用户
     * */
    @Test
    public void getUserByIdTest(){
        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserById();
        System.out.println(userById);

        //关闭连接
        sqlSession.close();
    }


    /**
     * 查询所有用户信息
     * */
    @Test
    public void getAllUserTest(){
        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allUser = mapper.getAllUser();
        System.out.println(allUser);
        for (User u : allUser){
            System.out.println(u);
        }

        //关闭连接
        sqlSession.close();
    }


    /**
     * 查询指定用户信息
     * */
    @Test
    public void getAppointUserName(){
        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.getAppointUserName(1001);
        System.out.println(user);

        //关闭连接
        sqlSession.close();
    }

    /**
     * 登录验证(以Map集合作为参数)
     * */
    @Test
    public void testCheckLoginByMap(){
        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String , Integer> map = new HashMap<String,Integer>();
        map.put("Id",1);
        map.put("password",123456);

        User user = mapper.checkLoginByMap(map);
        System.out.println(user);

        //关闭连接
        sqlSession.close();
    }

    /**
     * 新增用户信息2
     * */
    @Test
    public void testInsertUser2(){
        Date date = new Date();

        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(0,"1011","12",0, date);

        int i = mapper.insertUser2(user);

        System.out.println("已添加：" + i + "行记录");

        //关闭连接
        sqlSession.close();
    }

    /**
     * 登录验证（@Param）
     * */
    @Test
    public void testcheckLoginByParam(){

        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.checkLoginByParam("1008", "1234");
        System.out.println(user);

        //关闭连接
        sqlSession.close();
    }

    /**
     * 模糊查询like（@Param）
     * */
    @Test
    public void testgetUserByLike(){

        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        Map<String, Object> userByLike = mapper.getUserByLike("3");
//        System.out.println(userByLike);

        List<User> userByLike = mapper.getUserByLike("3");
        userByLike.forEach(System.out::println);

        //关闭连接
        sqlSession.close();
    }

    /**
     * 添加记录时获取自增主键,自动添加记录
     * */
    @Test
    public void testinsertUserAutoKey(){
        //创建User对象
        Date date = new Date();

        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(0,"admin","000000",1,date);

        mapper.insertUserAutoKey(user);
        System.out.println(user);

        //关闭连接
        sqlSession.close();
    }


    /**
     * 添加记录时获取自增主键,自动添加记录
     * */
    @Test
    public void testCustomMapping(){

        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        Map<String, Object> stringObjectMap = mapper.CustomMapping();
//        System.out.println(stringObjectMap);

        List<User> users = mapper.CustomMapping();
        users.forEach(System.out::println);

        //关闭连接
        sqlSession.close();
    }

    /**
     * 多对一，多表联查
     * */
    @Test
    public void testGetUserAndUserInfoByStep(){

        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserAndUserInfoByStepOne(1);
        System.out.println(user);

        //关闭连接
        sqlSession.close();
    }


    /**
     * 根据UserInfo中的用户名去查找表中的记录
     * */
    @Test
    public void test2(){

        //获取
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        UserInfo userAndUserInfoByStepTwo = mapper.getUserAndUserInfoByStepTwo("1000");
        System.out.println(userAndUserInfoByStepTwo);

        //关闭连接
        sqlSession.close();
    }

        @Test
        public void testPage(){
            //获取
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            //查询功能之前开启分页功能
            Page<Object> page = PageHelper.startPage(1, 3);

            List<User> list = mapper.getAllUser();
            //查询功能之后可以获取分页相关的所有数据
            PageInfo<User> pageInfo = new PageInfo<>(list,5);

            list.forEach(System.out::println);
            System.out.println(pageInfo);

            //关闭连接
            sqlSession.close();
        }

}
