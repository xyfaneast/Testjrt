/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java堆异常测试</p>
 * <code>VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError</code>
 * <p>以上参数的含义是：限制Java堆大小为20MB，不可扩展</p>
 * <p>通过此参数可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照</p>
 * @author fandong
 * @date 2018年11月16日 下午2:45:49 
 * @desc
 */
public class HeapOOM {

    static class OOMObject { }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        } /// while end
    } /// main

}
