package com.mimosa.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
    public void connet(int port, String host) {
        EventLoopGroup groop = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(groop)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(
                        new ChannelInitializer<Channel>() {
                            protected void initChannel(Channel ch) throws Exception {
                                ch.pipeline().addLast(new ClientHandler());
                            }
                        });
        try {
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            groop.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new Client().connet(8888, "127.0.0.1");
    }

}
