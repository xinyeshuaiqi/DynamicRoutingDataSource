package pers.wmx.db;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 上下文信息存储与传递
 * 后面可以按需扩展，不仅仅存储动态数据源信息
 *
 * @author wangmingxin03
 * Created on 2021-12-08
 */
public class AppCustomContext {
    private static final TransmittableThreadLocal<String> CONTEXT_HOLDER = new TransmittableThreadLocal<>();

    public static void setDataSource(String dataSource) { CONTEXT_HOLDER.set(dataSource); }

    public static String getDataSource() { return CONTEXT_HOLDER.get(); }

    public static void clearDataSource() { CONTEXT_HOLDER.remove(); }
}
