package com.creditease.zxh.cases;/**
 * Created by admin on 2020/8/26.
 */

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author
 * @createTime 2020/8/26 15:23
 * @description
 */
    public class DemoTest {
        @Parameters({"username","password"})
        @Test
        public void testPara(String username, String password){
            System.out.println(username);
            System.out.println(password);
        }

    }
 
    