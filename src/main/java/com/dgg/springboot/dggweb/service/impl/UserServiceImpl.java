package com.dgg.springboot.dggweb.service.impl;

import com.dgg.springboot.dggweb.dao.UserMapper;
import com.dgg.springboot.dggweb.entity.User;
import com.dgg.springboot.dggweb.service.IUserService;
import com.dgg.springboot.dggweb.utils.PageData;
import com.dgg.springboot.dggweb.utils.RedisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userDao;

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public List<User> selectUser(User user) {
		return userDao.selectUser(user);
	}

	@Override
	public int insertUser(User user) {
		LocalDateTime date = LocalDateTime.now();
		user.setLatestLoginTime(date);
		user.setCreateTime(date);
		user.setUpdateTime(date);
		return userDao.insert(user);
	}

	@Override
	public PageData<User> selectUserPage(String content, Integer pageNo, Integer pageSize) {
		//这一行必须放在查询语句的上边
		Page<User> page = PageHelper.startPage(pageNo,pageSize,true);
		List<User> data = userDao.selectUserByContent(content);
		PageData<User> pageData = new PageData<>();
		pageData.setTotalCount(page.getTotal());
		pageData.setPageNo(page.getPageNum());
		pageData.setPageSize(page.getPageSize());
		pageData.setData(data);
		return pageData;

		/*
		*通用mapper条件查询（排序，输出字段...）
		*
		Example example = new Example(User.class);
		//模糊查询等
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("","");
		criteria.andLike("","");
		//排序是根据实体类的字段+空格+asc/desc
		example.orderBy("latestLoginTime desc");
		//需要输出的字段
		example.selectProperties("userId,userName,phone,realName,jobPosition,companyName,latestLoginTime");
		List<User> data = userDao.selectByExample(example);
*/

	}

	@Override
	public List<User> selectUserByContent(String content) {
		List<User> userDB = userDao.selectUserByContent(content);
		System.out.println("数据库中取出的数据"+userDB);
		System.out.println("======================================");
		redisUtil.setForValue("userInfos",userDB);
		List<User> redisUserDB = (List<User>)redisUtil.getKey("userInfos");
		System.out.println("Redis中取出的数据"+redisUserDB);
		return userDB;
	}

	@Override
	public Integer deleteUser(Integer userId) {
		return userDao.deleteByPrimaryKey(userId);
	}

	@Override
	public Integer updateUser(User user) {
		return userDao.updateByPrimaryKeySelective(user);//updateByPrimaryKeySelective 不会覆盖没有设置属性的值；updateByPrimaryKey会覆盖没有设置属性的值为 null
	}
}
