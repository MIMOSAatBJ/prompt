package com.mimosa.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ClientHandler extends ChannelHandlerAdapter {


    public ClientHandler() {

    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        for (int i = 0; i < 100; i++) {
            byte[] req = "QUERY TIME ORDER".getBytes();
            ByteBuf fm = Unpooled.buffer(req.length);
            fm.writeBytes(req);
            ctx.writeAndFlush(fm);
//        }
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//			super.channelRead(ctx, msg);
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("now is " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
