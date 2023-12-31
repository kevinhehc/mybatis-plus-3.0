package com.baomidou.mybatisplus.test.toolkit;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * 测试 StringUtils工具类测试
 *
 * @author XiaoBingBy
 * @since 2019-08-30
 */
class StringUtilsTest {

    @Test
    void isBlankTest() {
        Assert.isTrue(StringUtils.isBlank(""), "error not empty");

        Assert.isTrue(StringUtils.isBlank(null), "error not empty");

        Assert.isTrue(StringUtils.isBlank("   "), "error not empty");
    }

    @Test
    void sqlInjectionBlackTest(){
        String originalStr = "(select*from(select sleep(if(length(database())=13,3,0))union/**/select+1)a)" ;
        Assert.isTrue("(selectfrom(selectsleep(if(length(database())13,3,0))union//select1)a)"
            .equals(StringUtils.sqlInjectionReplaceBlank(originalStr)),"error");
    }

    @Test
    void sqlInjectionBlackCharTest(){
        Assert.isTrue("".equals(StringUtils.sqlInjectionReplaceBlank("'\"<>&*+=#-;    \n\t")),"error");
    }

}
