package com.dearho.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * tcp服务配置
 * @author Administrator
 * 
 * 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。
 * PostConstruct在构造函数之后执行,init()方法之前执行。
 * PreDestroy（）方法在destroy()方法执行执行之后执行
 * 
 * 
 * bind(int)方法将服务端Channel绑定到本地端口，成功后将accept客户端的连接，从而是整个框架运行起来。
 * 使用sync()方法是由于Netty中的事件都是异步的，所以需要同步等待结果。准确的说，这个方法在这里使用是有问题的，
 * sync()完成后只能表明绑定事件运行完毕，但并不能说明绑定成功，虽然失败的可能性微乎其微。
 *
 */
@Component
public class TCPServer {

	@Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap b;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private ChannelFuture serverChannelFuture;

    @PostConstruct
    public void start() throws Exception {
        System.out.println("Starting server at " + tcpPort);
        
        //绑定到本地端口等待客户端连接,使用sync()方法是由于Netty中的事件都是异步的，所以需要同步等待结果。
        serverChannelFuture = b.bind(tcpPort).sync();
    }

    /**
     * f.channel().closeFuture().sync()方法仅仅是为了使当前main线程阻塞而不立即执行之后的各种shutdown()方法，
     * 其语义是等到服务端接受客户端连接的Channel被关闭时，才执行后面代码的操作。
     * 在实际应用中，这样的代码并不实用，我们可能需要接受诸如kill命令后，优雅关闭线程组。
     * @throws Exception
     */
    @PreDestroy
    public void stop() throws Exception {
        serverChannelFuture.channel().closeFuture().sync();
    }

    public ServerBootstrap getB() {
        return b;
    }

    public void setB(ServerBootstrap b) {
        this.b = b;
    }

    public InetSocketAddress getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(InetSocketAddress tcpPort) {
        this.tcpPort = tcpPort;
    }

}
