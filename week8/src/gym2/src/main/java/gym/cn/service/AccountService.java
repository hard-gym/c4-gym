package gym.cn.service;

import gym.cn.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface AccountService {
    // 1查询所有记录
    List<Account> findAll();
    // 2通过id删除记录
    void deleteByPrimaryKey(String id);
    // 3插入记录
    void insert(Account record);
    // 4通过id查找对象
    Account selectByPrimaryKey(String id);
    // 5更新Account
    void updateByPrimaryKey(Account record);
    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    void trans(@Param("id") String id,@Param("money") int money);
    default void transfer(String remitterId, String remitteeId, int money){
        trans(remitterId,-money);
        trans(remitteeId,money);
    };
}
