package com.dearho.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * netty配置
 * @author Administrator
 * 
 * 为了帮助用户快速构建基于Netty的服务，Netty提供了两个启动器ServerBootstrap和Bootstrap，分别用于启动服务器端和客户端程序。
 * group(EventLoopGroup...)方法用于指定一个或两个Reactor，本例中指定为两个。
 * channel(Channel)方法本质用来指定一个Channel工厂，本例中该工厂生产服务端用于accept客户端连接的Channel，将默认使用Channel的无参构造方法。
 * 如果用户需要自定义有参数的Channel，可自定义所需的工厂实现。
 * option(Key, Value)用于指定TCP相关的参数以及一些Netty自定义的参数。
 * childHandler()用于指定subReactor中的处理器，类似的，handler()用于指定mainReactor的处理器，只是默认情况下mainReactor中已经添加了acceptor处理器，所以无需再指定。
 * 需要注意的是：这两个方法并不能累积调用而达到增加多个处理器的目的，所以引入了 ChannelInitializer，它是一个特殊的Handler，功能是初始化多个Handler，如本例中的DecoderHandler，ComputeHandler，EncoderHandler。
 * 完成初始化工作后，ChannelInitializer会从Handler链中删除。至此，框架已经构建完毕。
 *
 *
 * 最最后，bind(port)方法将服务端Channel绑定到本地端口，成功后将accept客户端的连接，从而是整个框架运行起来
 * 
 * 
 * 
 * Channeloption.SO_KEEPALIVE参数对应于套接字选项中的SO_KEEPALIVE，该参数用于设置TCP连接，当设置该选项以后，连接会测试链接的状态，这个选项用于可能长时间没有数据交流的
      连接。当设置该选项以后，如果在两小时内没有数据的通信时，TCP会自动发送一个活动探测数据报文。
 * 
 * ChannelOption.SO_BACKLOG对应的是tcp/ip协议listen函数中的backlog参数，函数listen(int socketfd,int backlog)用来初始化服务端可连接队列，
    服务端处理客户端连接请求是顺序处理的，所以同一时间只能处理一个客户端连接，多个客户端来的时候，服务端将不能处理的客户端连接请求放在队列中等待处理，backlog参数指定了队列的大小

 */
@Configuration
public class NettyConfig {

	//读取yml中配置 
    @Value("${boss.thread.count}")
    private int bossCount;

    @Value("${worker.thread.count}")
    private int workerCount;

    @Value("${tcp.port}")
    private int tcpPort;

    @Autowired
    @Qualifier("springProtocolInitializer")
    private StringProtocolInitalizer protocolInitalizer;
    
    
    //bootstrap配置
    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {
    	//ServerBootstrap负责初始化netty服务器，并且开始监听端口的socket请求。
        ServerBootstrap b = new ServerBootstrap();
        
        //group(EventLoopGroup...)方法用于指定一个或两个Reactor，本例中指定为两个
        b.group(bossGroup(), workerGroup())//加入线程池
        .channel(NioServerSocketChannel.class)//channel(Channel)方法本质用来指定一个Channel工厂
        .option(ChannelOption.SO_BACKLOG, 20000)//backlog参数指定了队列的大小
        .option(ChannelOption.SO_KEEPALIVE, true)//长连接
        .childHandler(protocolInitalizer);//childHandler()用于指定subReactor中的处理器,ChannelInitializer，它是一个特殊的Handler，功能是初始化多个Handler
        return b;
    }

    /**
     * boss线程池
     * boss专门用于接受客户端连接,对应mainReactor
     * @return
     */
    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(bossCount);
    }

    /**
     * worker线程池
     * worker也就是常说的IO线程专门用于处理IO事件,对应subReactor
     * @return
     */
    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(workerCount);
    }

    @Bean(name = "tcpSocketAddress")
    public InetSocketAddress tcpPort() {
        return new InetSocketAddress(tcpPort);
    }

    @Bean(name = "stringEncoder")
    public StringEncoder stringEncoder() {
        return new StringEncoder();
    }

    @Bean(name = "stringDecoder")
    public StringDecoder stringDecoder() {
        return new StringDecoder();
    }

//    /**
//     * Necessary to make the Value annotations work.
//     *
//     * @return
//     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
