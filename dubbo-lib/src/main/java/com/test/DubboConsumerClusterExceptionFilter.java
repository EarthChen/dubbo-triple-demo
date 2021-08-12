package com.test;

import com.test.exception.DubboBizException;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.filter.ClusterFilter;

import java.util.Map;

/**
 * @author earthchen
 * @date 2021/7/28
 **/
@Activate(group = {CommonConstants.CONSUMER})
public class DubboConsumerClusterExceptionFilter implements ClusterFilter, ClusterFilter.Listener {
    private static Logger log = LoggerFactory.getLogger(DubboConsumerClusterExceptionFilter.class);
    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        Map<String, String> attach = appResponse.getAttachments();
        String code = attach.get(DubboConstant.CODE);
        String msg = attach.get(DubboConstant.MSG);
        if (!StringUtils.isBlank(code)) {
            appResponse.setException(new DubboBizException(Integer.parseInt(code), msg));
        }
    }

    @Override
    public void onError(Throwable e, Invoker<?> invoker, Invocation invocation) {
        log.error("Got unchecked and undeclared exception which called by " + RpcContext.getServiceContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }
}

